var socket = undefined;

$().ready(function() {

	var userEmail = $(".member-menu").data("email");

	// 브라우저 렌더링이 끝나면 웹소켓에 연결
	// socket 변수 => 소켓과 연결되어있는 파이프
	socket = new SockJS("/ws");

	// 소켓 연결이 정상적으로 이루어 졌을 때 동작을 작성
	socket.onopen = function() {
		receiveHandler(socket);

		// 연결 된 이후에 웹소켓 서버로 메시지를 전송
		var sendMessage = {
			email: userEmail,
			action: "LOGIN",
			message: userEmail + "님이 접속했습니다!"
		};

		socket.send(JSON.stringify(sendMessage));
	}

});

function sendAlarmWriteReply(boardId) {
	
	var userEmail = $(".member-menu").data("email");
	
	var sendMessage = {
		email: userEmail,
		action: "REPLY_ALARM",
		boardId: `${boardId}`,
		url: "/board/view?id=" + boardId,
		message: boardId+ "번 게시글에 새로운 댓글이 등록되었습니다. 확인하러 가시겠습니까?"
	};
	
	socket.send(JSON.stringify(sendMessage));
}

function requestChat(to, me) {
	
	var sendMessage = {
		email: me,
		action: "REQUEST_CHAT",
		to: to,
		message: me + "회원이 대화를 요청했습니다. 수락하시겠습니까?"
	};
	
	socket.send(JSON.stringify(sendMessage));
}

function sendResponseForChat(from, to, groupId, isConnect) {
	
	var sendMessage = {
		email: from,
		action: "RESPONSE_CHAT",
		to: to,
		groupId : groupId,
		isConnect: `${isConnect}`
	};

	socket.send(JSON.stringify(sendMessage));
	
}

function sendChat(groupId, chatMessage) {
	var userEmail = $(".member-menu").data("email");
	
	var sendMessage = {
		sender: userEmail,
		action: "SEND_CHAT",
		groupId: groupId,
		chatMessage: chatMessage
	};

	socket.send(JSON.stringify(sendMessage));
}

function quitChat(groupId) {
	var userEmail = $(".member-menu").data("email");

	var sendMessage = {
		sender: userEmail,
		action: "QUIT_CHAT",
		groupId: groupId,
	};

	socket.send(JSON.stringify(sendMessage));
}