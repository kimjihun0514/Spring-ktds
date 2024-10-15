package com.ktdsuniversity.edu.homework.bbs.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.homework.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.homework.bbs.vo.BoardVO;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(BoardDaoImpl.class)
public class BoardDaoImplTest {

	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void increaseViewCount() {
		int count = this.boardDao.updateViewCount(5);
		
		assertTrue(count == 1);
	}
	
	@Test
	public void getOneBoard() {
		BoardVO a = this.boardDao.selectOneBoard(5);
		
		int id = a.getId();
		
		assertEquals(5, id);
	}
	
}
