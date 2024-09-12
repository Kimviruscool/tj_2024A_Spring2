package web.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Vector;

@Component // 해당 클래스를 스프링 컨테이너 빈 등록
public class ChatController extends TextWebSocketHandler {

    // - 클라리언트 소켓들의 접속 명단을 저장하는 컬렉션 프레임워크 (리스트) // ArrayList(비동기) vs Vector(동기)
    private List<WebSocketSession> 접속된클라이언트소켓  = new Vector<>();
    

    //1. 클라이언트가 서버 웹소켓 접속 요청 , 성공 했을때

    @Override //재정의
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("session = " + session);
        System.out.println("[서버웹소켓 측] JS웹소켓이 들어옴");
        //- 접속된 클라이언트 소켓을 접속명단에 저장
        접속된클라이언트소켓.add(session);
        //현재 접속된 인원수
        System.out.println("서버소켓의 접속 인원 : " + 접속된클라이언트소켓.size());
    }

    //2. 클라이언트가 서버 웹소켓에 접속을 끊었을때


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("session = " + session);
        System.out.println("[서버웹소켓 측] JS 웹소켓이 나감");
        접속된클라이언트소켓.remove(session);
        //현재 접속된 인원수
        System.out.println("서버소켓의 접속 인원 : " + 접속된클라이언트소켓.size());
        //퇴장/제거 한 세션을 제외한 다른 클라이언트소켓(세션) 들에게 메시지 전송
        // 클라이언트 소켓의 정보를 세션 에서 저장하고 있다.
        TextMessage textMessage = new TextMessage("Hello, ClientSocket");
        handleTextMessage(null, textMessage);

    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("session = " + session + ", message = " + message);
        System.out.println(message.getPayload());

        //특정한 세션으로 받은 메세지 내용을 현재 접속된 다른 세션에게도 전달
            //1. 모든 접속된 클라이언트소켓 하나씩 꺼내기
        for(int i=0; i < 접속된클라이언트소켓.size(); i++){
            //2. 목록에 저장된 하나의 세션 호출
            WebSocketSession s = 접속된클라이언트소켓.get(i);
            //3. 세션 클라이언트 소켓 정보에 메세지를 보내기
            s.sendMessage(message);
        }
    }
}
