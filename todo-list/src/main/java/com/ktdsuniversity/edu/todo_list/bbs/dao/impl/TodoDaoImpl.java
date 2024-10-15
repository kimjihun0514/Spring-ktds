package com.ktdsuniversity.edu.todo_list.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.todo_list.bbs.dao.TodoDao;
import com.ktdsuniversity.edu.todo_list.bbs.vo.TodoVO;
import com.ktdsuniversity.edu.todo_list.bbs.vo.UpdateAndDeleteTodoVO;
import com.ktdsuniversity.edu.todo_list.bbs.vo.WriteTodoVO;

@Repository
public class TodoDaoImpl extends SqlSessionDaoSupport implements TodoDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertNewTodo(WriteTodoVO writeTodoVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewTodo", writeTodoVO);
	}

	@Override
	public int updateTodo(UpdateAndDeleteTodoVO updateAndDeleteTodoVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateTodo", updateAndDeleteTodoVO);
	}

	@Override
	public int deleteTodo(UpdateAndDeleteTodoVO updateAndDeleteTodoVO) {
		return this.getSqlSession().delete(NAMESPACE + ".deleteTodo", updateAndDeleteTodoVO);
	}

	@Override
	public List<TodoVO> selectAllTodo(String email) {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllTodo", email);
	}
	
}
