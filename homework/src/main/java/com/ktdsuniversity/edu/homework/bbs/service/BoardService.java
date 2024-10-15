package com.ktdsuniversity.edu.homework.bbs.service;

import com.ktdsuniversity.edu.homework.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.homework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.homework.bbs.vo.WriteBoardVO;

public interface BoardService {

	public BoardListVO getAllBoard();
	
	public boolean creatNewBoard(WriteBoardVO writeBoardVO);
	
	/**
	 * 파라미터로 전달 받은 ID의 게시물을 조회하고 조회수 1 증가
	 * @param id 게시글 ID
	 * @return
	 */
	public BoardVO getOneBoard(int id);
	
}
