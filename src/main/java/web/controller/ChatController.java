package web.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component // 해당 클래스를 스프링 컨테이너 빈 등록
public class ChatController extends TextWebSocketHandler {
    //1. 클라이언트가 서버 웹소켓 접속 요청 , 성공 했을때

    @Override //재정의
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("session = " + session);
        System.out.println("[서버웹소켓 측] JS웹소켓이 들어옴");
    }

    //2. 클라이언트가 서버 웹소켓에 접속을 끊었을때


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("session = " + session);
        System.out.println("[서버웹소켓 측] JS 웹소켓이 나감");
    }
}
