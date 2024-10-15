package com.ktdsuniversity.edu.todo_list.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ktdsuniversity.edu.todo_list.bbs.service.TodoService;
import com.ktdsuniversity.edu.todo_list.bbs.vo.TodoListVO;
import com.ktdsuniversity.edu.todo_list.bbs.vo.UpdateAndDeleteTodoVO;
import com.ktdsuniversity.edu.todo_list.bbs.vo.WriteTodoVO;
import com.ktdsuniversity.edu.todo_list.common.utils.RequestUtil;
import com.ktdsuniversity.edu.todo_list.member.vo.MemberVO;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todo/list") // http://localhost:8080/todo/list
	public String viewTodoList(@SessionAttribute(value = "_LOGIN_USER_", required = false) MemberVO loginMemberVO , Model model) {
		if (loginMemberVO == null) {
			return "redirect:/member/login";
		}
		TodoListVO todoListVO = this.todoService.getAllTodo(loginMemberVO.getEmail());
		model.addAttribute("todoListVO", todoListVO);
		return "todo/todolist";
	}
	
	@GetMapping("/todo/write") // http://localhost:8080/todo/write
	public String addTodo() {
		return "todo/todowrite";
	}
	
	@PostMapping("/todo/write")
	public String doCreateTodo(WriteTodoVO writeTodoVO
			                 , Model model
			                 , @SessionAttribute(value = "_LOGIN_USER_", required = false) MemberVO loginMemberVO) {
		writeTodoVO.setIp(RequestUtil.getIp());
		if (loginMemberVO == null) {
			return "redirect:/member/login";
		}
		writeTodoVO.setEmail(loginMemberVO.getEmail());
		boolean isCreate = this.todoService.creatNewTodo(writeTodoVO);
		if (isCreate) {
			return "redirect:/todo/list";
		}
		else {
			model.addAttribute("todoVO", writeTodoVO);
			return "todo/todowrite";
		}
	}
	
	@GetMapping("/todo/complete{id}")
	public String doChangeIsComplete(@PathVariable int id
								    , @SessionAttribute("_LOGIN_USER_") MemberVO loginMemberVO) {
		UpdateAndDeleteTodoVO updateAndDeleteTodoVO = new UpdateAndDeleteTodoVO();
		updateAndDeleteTodoVO.setId(id);
		updateAndDeleteTodoVO.setEmail(loginMemberVO.getEmail());
		
		boolean isComplete = this.todoService.changeIsComplete(updateAndDeleteTodoVO);
		// 성공하면 list로
		if (isComplete) {
			return "redirect:/todo/list";
		}
		return "redirect:/todo/list";
	}
	
	@GetMapping("/todo/delete{id}")
	public String deleteTodo(@PathVariable int id
							, @SessionAttribute("_LOGIN_USER_") MemberVO loginMemberVO) {
		UpdateAndDeleteTodoVO updateAndDeleteTodoVO = new UpdateAndDeleteTodoVO();
		updateAndDeleteTodoVO.setId(id);
		updateAndDeleteTodoVO.setEmail(loginMemberVO.getEmail());
		
		boolean isDeleted = this.todoService.deleteTodo(updateAndDeleteTodoVO);
		if(isDeleted) {
			return "redirect:/todo/list";
		}
		return "redirect:/todo/list";
	}
	
}
