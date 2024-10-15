package com.ktdsuniversity.edu.homework.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.homework.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.homework.bbs.service.BoardService;
import com.ktdsuniversity.edu.homework.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.homework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.homework.bbs.vo.WriteBoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public BoardListVO getAllBoard() {
		// 게시글 목록 화면에 데이터를 전송해주기 위해서 
		// 게시글의 건수와 게시글의 목록을 조회해 반환시킨다.
		
		// 1. 게시글의 건수를 조회
		int boardCount = this.boardDao.selectBoardAllCount();
		
		// 2. 게시글의 목록을 조회
		List<BoardVO> boardList = this.boardDao.selectAllBoard();
		
		// 3. BoardListVO를 만들어서 게시글의 건수와 목록을 할당한다
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardCnt(boardCount);
		boardListVO.setBoardList(boardList);
		
		// 4. BoardListVO인스턴스를 반환
		return boardListVO;
	}
	
	@Override
	public boolean creatNewBoard(WriteBoardVO writeBoardVO) {
		// DB에 등록한 게시글의 개수
		int createCount = boardDao.insertNewBoard(writeBoardVO);
		// 0보다 크면 true 작다면 false
		return createCount > 0;
	}

	@Override
	public BoardVO getOneBoard(int id) {
		int updateCount = this.boardDao.updateViewCount(id);
		
		if (updateCount == 0) {
			throw new IllegalArgumentException("잘못된 접근입니다.");
		}
		
		BoardVO boardVO = this.boardDao.selectOneBoard(id);
		
		return boardVO;
	}
	
}
