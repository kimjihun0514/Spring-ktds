package com.ktdsuniversity.edu.todo_list.bbs.service;

import com.ktdsuniversity.edu.todo_list.bbs.vo.TodoListVO;
import com.ktdsuniversity.edu.todo_list.bbs.vo.UpdateAndDeleteTodoVO;
import com.ktdsuniversity.edu.todo_list.bbs.vo.WriteTodoVO;

public interface TodoService {
	
	
	public TodoListVO getAllTodo(String email);
	
	public boolean creatNewTodo(WriteTodoVO writeTodoVO);
	
	public boolean changeIsComplete(UpdateAndDeleteTodoVO updateAndDeleteTodoVO);
	
	public boolean deleteTodo(UpdateAndDeleteTodoVO updateAndDeleteTodoVO);
	
}
