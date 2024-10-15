package com.ktdsuniversity.edu.hello_spring.bbs.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.dao.impl.BoardDaoImpl;
import com.ktdsuniversity.edu.hello_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;

// Spring Appication의 Bean을 생성해주는 Annotation
@SpringBootTest
// JUNIT5를 사용하기 위한 설정
//@ExtendWith(SpringExtension.class)
// Test하고자 하는 클래스와 Test에 필요한 클래스들을 임포트
// BoardServiceImpl.class : BoardServiceImpl을 테스트 하기 위해 임포트
// BoardDaoImpl.class : BoardServiceImpl에 BoardDaoImpl을 Autowired하기 위해 임포트
// 여러 개를 가져오려면 배열 기호를 사용
@Import({BoardServiceImpl.class, BoardDaoImpl.class})
public class BoardServiceImplTest {

	@Autowired
	private BoardService boardService;
	
	// MockBean : 가짜 인스턴스 
	// 실제 인스턴스로 하면 오류가 생길 수 있기 때문
	// 실제로 DB에 데이터가 생기거나 삭제가 되면 오류가 발생함
	/**
	 * JUNIT5 테스트를 위해 BoardServiceImpl에 가짜 인스턴스를 DI 
	 */
	@MockBean
	private BoardDao boardDao;
	
	@Test
	public void testGetAllBoard() {
		
		// given - when - then pattern
		System.out.println("전 : " + boardDao.selectBoardAllCount()); // 0
		// 1. boardDao.selectBoardAllCount()가 반환시킬 값을 명시
		BDDMockito.given( boardDao.selectBoardAllCount() ).willReturn( 3 );
		System.out.println("후 : " + boardDao.selectBoardAllCount()); // 3
		
		// 2. boardDao.selectAllBoard()가 반환시킬 값을 명시
		List<BoardVO> mockList = new ArrayList<>();
		// count가 3이기 때문에 타입에 맞는 아이템을 넣어줌
		mockList.add(new BoardVO());
		mockList.add(new BoardVO());
		mockList.add(new BoardVO());
		
		System.out.println("전 : " + boardDao.selectAllBoard()); // []
		BDDMockito.given( boardDao.selectAllBoard() ).willReturn( mockList );
		System.out.println("후 : " + boardDao.selectAllBoard()); // [boardVO, boardVO, boardVO]
		
		// when
		// 3. BoardServiceImpl의 getAllBoard()를 호출
		BoardListVO boardListVO = boardService.getAllBoard();
		
		// then
		// 4. given 데이터와 실행데이터(boardListVO)가 일치하는지 검사
		assertEquals(3, boardListVO.getBoardCnt());
		assertEquals(3, boardListVO.getBoardList().size());
		
		
	}
	
}
