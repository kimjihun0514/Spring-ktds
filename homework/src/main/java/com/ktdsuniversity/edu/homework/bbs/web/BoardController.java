package com.ktdsuniversity.edu.homework.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktdsuniversity.edu.homework.bbs.service.BoardService;
import com.ktdsuniversity.edu.homework.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.homework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.homework.bbs.vo.WriteBoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list") // http://localhost:8080/board/list
	public String viewBoardList(Model model) {
		BoardListVO boardListVO = this.boardService.getAllBoard();
		model.addAttribute("boardListVO", boardListVO);
		return "board/boardlist";
	}
	
	@GetMapping("/board/write") // http://localhost:8080/board/write
	public String viewBoardWritePage() {
		return "board/boardwrite";
	}
	
	@PostMapping("/board/write")
	public String doCreatNewBoard(WriteBoardVO writeBoardVO) {
		boolean isCreate = this.boardService.creatNewBoard(writeBoardVO);
		System.out.println("게시글 등록 결과 : " + isCreate);
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/viewpost") // http://localhost:8080/board/viewpost?id=1
	public String viewOneBoard(Model model, @RequestParam int id) {
		BoardVO boardVO = this.boardService.getOneBoard(id);
		model.addAttribute("boardVO", boardVO);
		return "board/viewpost";
	}
	
}
