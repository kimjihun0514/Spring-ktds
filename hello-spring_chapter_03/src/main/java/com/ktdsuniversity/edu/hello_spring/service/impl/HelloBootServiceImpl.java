package com.ktdsuniversity.edu.hello_spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.hello_spring.dao.HelloBootDao;
import com.ktdsuniversity.edu.hello_spring.service.HelloBootService;

// 트랜젝션을 처리해주는 Annotation
// Annotation 이 없으면 Bean Container 에 담지 않음
@Service
public class HelloBootServiceImpl implements HelloBootService{

	@Autowired
	private HelloBootDao helloBootDao;
	
	public HelloBootServiceImpl() {
		System.out.println("HelloBootServiceImpl 인스턴스 생성함");
	}
	
	@Override
	public String getGreetingMessage() {
		
		String message = this.helloBootDao.selectMessage();
		
		return "안녕하세요, 서비스 클래스 입니다." + message;
	}

	
	
}
