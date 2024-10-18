function receiveHandler(socket) {

	if (socket) {

		// 웹소켓 서버에서 메시지가 전달되었을 때 동작되는 이벤트
		socket.onmessage = function(message) {
			console.log(message);
			var receiveData = message.data;

			// JSON -> Object Literal변경
			var receiveMessage = JSON.parse(receiveData);

			if (receiveMessage.action === "LOGIN") {
				alert(receiveMessage.message);
			}
			else if (receiveMessage.action === "REPLY_ALARM") {
				if (confirm(receiveMessage.message)) {
					location.href = receiveMessage.url;
				}
			}
			else if (receiveMessage.action === "REQUEST_CHAT") {
				if (confirm(receiveMessage.message)) {
					// 1. dialog를 띄운다.
					$(".chat-dialog").data("group-id", receiveMessage.groupId);
					$(".chat-dialog")[0].show();
					
					// 2. 요청을 수락하는 메시지를 대화 요청자에게 보낸다.
					sendResponseForChat(receiveMessage.to
										, receiveMessage.from
										, receiveMessage.groupId
										, true);
					
				}
				else {
					// 요청을 거부하는 메시지를 대화 요청자에게 보냄
					sendResponseForChat(receiveMessage.to
										, receiveMessage.from
										, receiveMessage.groupId
										, false);
				}
			}
			else if (receiveMessage.action === "RESPONSE_CHAT") {
				console.log(receiveMessage.isConnect);
				if (receiveMessage.isConnect === "true") {
					$(".chat-dialog").data("group-id", receiveMessage.groupId);
					$(".chat-dialog")[0].show();
				}
				else {
					alert("상대방이 대화를 거절했습니다.");
				}
			}
			else if (receiveMessage.action === "SEND_CHAT") {
				var userEmail = $(".member-menu").data("email");
				// 페이지를 옮길 때 사라지면 다시 띄워야 함
				$(".chat-dialog").data("group-id", receiveMessage.groupId);
				$(".chat-dialog")[0].show();
				
				var chat = $(`<div class="chat"></div>`);
				
				if (userEmail === receiveMessage.sender) {
					chat.css("text-align", "right");
					chat.append( `<p>${receiveMessage.chatMessage}</p>` );					
				}
				else {
					chat.css("text-align", "left");
					chat.append( `<p>${receiveMessage.sender} : ${receiveMessage.chatMessage}</p>` );
				}
				
				$(".chat-history").append(chat);
				
			}
			else if (receiveMessage.action === "QUIT_CHAT") {
				$(".chat-dialog").data("group-id", receiveMessage.groupId);
				$(".chat-dialog")[0].show();
				
				var chat = $(`<div class="chat"></div>`);
				chat.append( `<div>${receiveMessage.sender} : 퇴장하였습니다.</div>` );
				
				$(".chat-history").append(chat);
			}
		};
	}

}