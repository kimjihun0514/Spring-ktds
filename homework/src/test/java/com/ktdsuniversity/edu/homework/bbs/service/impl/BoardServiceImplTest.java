package com.ktdsuniversity.edu.homework.bbs.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.homework.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.homework.bbs.dao.impl.BoardDaoImpl;
import com.ktdsuniversity.edu.homework.bbs.service.BoardService;
import com.ktdsuniversity.edu.homework.bbs.vo.BoardVO;


@SpringBootTest
@Import({BoardServiceImpl.class, BoardDaoImpl.class})
public class BoardServiceImplTest {
	
	@Autowired
	private BoardService boardService;
	
	@MockBean
	private BoardDao boardDao;
	
	@Test
	public void getOneBoard() {
		BoardVO boardVO = new BoardVO();
		boardVO.setViewCnt(1);
		BDDMockito.given(boardDao.updateViewCount(5)).willReturn(1);
		BDDMockito.given(boardDao.selectOneBoard(5)).willReturn(boardVO);
		
		int viewCount = boardService.getOneBoard(5).getViewCnt();
		BoardVO newBoard = boardService.getOneBoard(5);
		
		assertEquals(1, viewCount);
		assertEquals(boardVO, newBoard);
	}
	
}
