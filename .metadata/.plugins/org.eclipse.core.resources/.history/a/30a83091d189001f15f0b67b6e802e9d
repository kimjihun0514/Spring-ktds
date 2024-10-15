package com.ktdsuniversity.edu.todo_list.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.todo_list.bbs.dao.TodoDao;
import com.ktdsuniversity.edu.todo_list.bbs.service.TodoService;
import com.ktdsuniversity.edu.todo_list.bbs.vo.TodoListVO;
import com.ktdsuniversity.edu.todo_list.bbs.vo.TodoVO;
import com.ktdsuniversity.edu.todo_list.bbs.vo.UpdateAndDeleteTodoVO;
import com.ktdsuniversity.edu.todo_list.bbs.vo.WriteTodoVO;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoDao todoDao;
	
	@Override
	public TodoListVO getAllTodo(String email) {
		List<TodoVO> todoList = this.todoDao.selectAllTodo(email);
		
		TodoListVO todoListVO = new TodoListVO();
		todoListVO.setTodoList(todoList);
		
		return todoListVO;
	}
	
	@Override
	public boolean creatNewTodo(WriteTodoVO writeTodoVO) {
		
		int createCount = this.todoDao.insertNewTodo(writeTodoVO);
		return createCount > 0;
	}

	@Override
	public boolean changeIsComplete(UpdateAndDeleteTodoVO updateAndDeleteTodoVO) {
		int updateCount = this.todoDao.updateTodo(updateAndDeleteTodoVO);
		return updateCount > 0;
	}

	@Override
	public boolean deleteTodo(UpdateAndDeleteTodoVO updateAndDeleteTodoVO) {
		int deleteCount = this.todoDao.deleteTodo(updateAndDeleteTodoVO);
		return deleteCount > 0;
	}

}
