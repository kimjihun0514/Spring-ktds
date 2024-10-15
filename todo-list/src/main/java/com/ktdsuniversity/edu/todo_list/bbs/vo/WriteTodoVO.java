package com.ktdsuniversity.edu.todo_list.bbs.vo;

public class WriteTodoVO {

	private String ctt;
	private String deadline;
	private String email;
	
	private String ip;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCtt() {
		return ctt;
	}
	public void setCtt(String ctt) {
		this.ctt = ctt;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	
}
