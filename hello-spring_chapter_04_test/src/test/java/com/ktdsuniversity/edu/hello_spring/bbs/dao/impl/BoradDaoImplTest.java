package com.ktdsuniversity.edu.hello_spring.bbs.dao.impl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;

@MybatisTest
// 실제 데이터베이스를 가지고 테스트해라
@AutoConfigureTestDatabase(replace = Replace.NONE)
// 테스트 하고자 하는 클래스 임포트
@Import(BoardDaoImpl.class)
public class BoradDaoImplTest {

	@Autowired
	private BoardDao boardDao;
	
	@Test // org.junit.jupiter.api.Test
	public void testSelectBoardAllCount() {
		int count = this.boardDao.selectBoardAllCount();
		
		System.out.println("BoardCount : " + count);
	}
	
	@Test
	public void testSelectAllBoard() {
		List<BoardVO> boardList = this.boardDao.selectAllBoard();
		System.out.println("boardList : " + boardList);
	}
	
}
