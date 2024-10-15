package com.ktdsuniversity.edu.homework.bbs.dao;

import java.util.List;

import com.ktdsuniversity.edu.homework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.homework.bbs.vo.WriteBoardVO;

public interface BoardDao {

	public int selectBoardAllCount();
	
	public List<BoardVO> selectAllBoard();
	
	public int insertNewBoard(WriteBoardVO writeBoardVO);
	
	/**
	 * 파라미터로 받은 게시글의 아이디의 게시글의 조회수가 1증가
	 * @param id 게시글의 아이디
	 * @return
	 */
	public int updateViewCount(int id);

	/**
	 * 파라미터로 받은 게시글의 아이디와 같은 게시글만 가져옴
	 * @param id 게시글의 아이디
	 * @return
	 */
	public BoardVO selectOneBoard(int id);
	
}
