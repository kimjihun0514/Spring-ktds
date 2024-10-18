$().ready(function() {
	$(".send-chat-message-btn").on("click", function() {
		// 채팅 전송을 눌렀을 때
		var groupId = $(".chat-dialog").data("group-id");
		var chatMessage = $(".chat-message").val();
		
		$(".chat-message").val("");
		
		sendChat(groupId, chatMessage);
	});
	
	$(".close-dialog-btn").on("click", function() {
		// 채팅창 닫기를 눌렀을 때
		var groupId = $(".chat-dialog").data("group-id");
		$(".chat-dialog").removeData("group-id");
		
		$(".chat-dialog")[0].close();
		
		quitChat(groupId);
		alert("채팅을 종료하였습니다.");
	});
});