package com.ktdsuniversity.edu.hello_spring.member.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao;
import com.ktdsuniversity.edu.hello_spring.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.RegistMemberVO;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertNewMember(RegistMemberVO registMemberVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewMember", registMemberVO);
	}
	
	@Override
	public int selectEmailCount(String Email) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectEmailCount", Email);
	}

	@Override
	public String selectSalt(String email) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectSalt", email);
	}

	@Override
	public MemberVO selectOneMember(LoginMemberVO loginMemberVO) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOneMember", loginMemberVO);
	}
	
}
