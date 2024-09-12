console.log('chat.js')
//JS : 클라이언트 웹소켓 (사용자) # new WebSocket("ws://localhost:8080/ws매핑주소")
let clientSocket = new WebSocket("ws://192.168.30.202:8080/chat/conn")
//Math.random() : 0~1 사이의 난수수 생성
//Math.random() : * 끝값(미만) : 0 ~ 끝값 사이의 난수
//Math.random() : * 끝값(미만) + 시작값 : 시작값 ~ 끝값 사이의 난수

let randomNo = Math.floor(Math.random() * 1001) + 1
let nickname = `익명${randomNo}`
console.log(`nickname : ${nickname}`)

//[1] clientsocket 의 onclose,onerror, onmessage, onopen 정의 해야한다.
//function 크라이언트소켓이서버와접속성공(){
//    alert('Connected to Server')
//}

//(1) WebSocket 객체내 onopen 속성은 서버소켓과 접속을 성공했을때 발동되는 함수 정의해서 대입
clientSocket.onclose = (e)=> {
    let msg = {
        'type' : 'out',
        'message' : `${nickname}님이 퇴장 하셨습니다.`
    }
    clientSocket.send(JSON.stringify(msg))
}

clientSocket.onopen = (e)=> {
    //1. 클라이언트 서버와 접속을 성공했을때 알림 메세지
    let msg = {
        'type' : 'alarm',
        'message' : `${nickname}님이 입장 했습니다.`
    }
    clientSocket.send(JSON.stringify(msg))
}

//(2) WebSocket 객체내 onmessage 속성은 서버소켓이 메세지를 보내왔을때 발동되는 함수 정의해서 대입
clientSocket.onmessage = (messageEvent)=> { //e : 매개변수
//    console.log(messageEvent.data)
    //2. 받은 메세지의 내용물 출력
    let msgbox = document.querySelector('.msgbox')
    msg = JSON.parse(messageEvent.data)
    //JSON.parse() : JSON > js객체타입 변환
    //2.1 알람 메세지
    if (msg.type == 'alarm') {
        msgbox.innerHTML += `<div class="alarm"> <span> ${msg.message} </span> </div>`
        return
    }
    //2.2 일반 메세지
    if(msg.from == nickname) {
        msgbox.innerHTML += `<div class="frommsg">
                                <div> ${msg.from} </dvi>
                                <div>
                                    <span> ${msg.date.split(' ')[4]} </span>
                                    <span> ${msg.message} </span>
                                </div>
                            </div>`
    } else {
        msgbox.innerHTML += `<div class="tomsgbox">
                                <div> ${msg.from} </dvi>
                                <div>
                                    <span> ${msg.message} </span>
                                    <span> ${msg.date.split(' ')[4]} </span>
                                </div>
                            </div>`
    }
}


//[2] 메세지 전송 이벤트
function onMsgSend(){
    console.log('onMsgSend() Called')
    // - 현재 클라이언트 소켓과 연결 유지된 서버 소켓에게 메시지를 전송
    let msgInput = document.querySelector('#text').value
    let msg = {
        'type' : 'msg',
        'message' : msgInput,
        'from' : nickname,
        'date' : new Date().toLocaleString()
    }
    clientSocket.send(JSON.stringify(msg))
    //JSON.stringfy(js객체) : js객체타입(JSON형식) > 문자열타입(JSON)으로 변환하여 전송
    //- "3"(문자열 타입 숫자형식) vs 3(정수타입 숫자형식)
    // - {key:value} (객체타입 이면서 JSON형식 ) vs "{key:value}" (문자열타입의 JSON 형식)
    //GetMapping() : 자동으로 JSON > DTO [x]
    //http는 contentType : application/json 존재한다.
    //ws 는 contentType : text/plai
    msgInput.msgInput = "";

}