package com.ktdsuniversity.edu.todo_list.common.beans;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ktdsuniversity.edu.todo_list.member.vo.MemberVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CheckSessionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request
						, HttpServletResponse response
						, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("_LOGIN_USER_");
		
		if(memberVO != null) {
			return true;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/memberlogin.jsp");
		rd.forward(request, response);
		
		return false;
	}
	
}
