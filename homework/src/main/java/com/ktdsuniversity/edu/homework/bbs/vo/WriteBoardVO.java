package com.ktdsuniversity.edu.homework.bbs.vo;

/**
 * 파라미터만 받아오는 VO
 */
public class WriteBoardVO {

	private String subject;
	private String email;
	private String content;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
