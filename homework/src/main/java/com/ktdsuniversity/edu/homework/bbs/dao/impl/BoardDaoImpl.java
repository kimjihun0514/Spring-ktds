package com.ktdsuniversity.edu.homework.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.homework.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.homework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.homework.bbs.vo.WriteBoardVO;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		System.out.println("Autowiring sqlSessionTemplate: " + sqlSessionTemplate);
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int selectBoardAllCount() {
		return this.getSqlSession().selectOne("com.ktdsuniversity.edu.homework.bbs.dao.BoardDao.selectBoardAllCount");
	}
	
	@Override
	public List<BoardVO> selectAllBoard() {
		return this.getSqlSession().selectList("com.ktdsuniversity.edu.homework.bbs.dao.BoardDao.selectAllBoard");
	}
	
	@Override
	public int insertNewBoard(WriteBoardVO writeBoardVO) {
		return this.getSqlSession().insert("com.ktdsuniversity.edu.homework.bbs.dao.BoardDao.insertNewBoard", writeBoardVO);
	}
	
	@Override
	public int updateViewCount(int id) {
		return this.getSqlSession().update("com.ktdsuniversity.edu.homework.bbs.dao.BoardDao.increaseViewCount", id);
	}
	
	@Override
	public BoardVO selectOneBoard(int id) {
		return this.getSqlSession().selectOne("com.ktdsuniversity.edu.homework.bbs.dao.BoardDao.getOneBoard", id);
	}
	
}
