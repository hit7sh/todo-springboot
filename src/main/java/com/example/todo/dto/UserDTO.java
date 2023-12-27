package com.example.todo.dto;


import java.util.ArrayList;
import java.util.List;

import com.example.todo.entity.Todo;
import com.example.todo.entity.User;

public class UserDTO {
	private Integer id;
	private String name;
	private List<TodoDTO> todosDTO;
	public UserDTO() {
		todosDTO = new ArrayList<>();
	}
	

	public List<TodoDTO> getTodos() {
		return todosDTO;
	}


	public void setTodos(List<TodoDTO> todos) {
		this.todosDTO = todos;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User toUser() {
		User user = new User();
		user.setId(this.id);
		user.setName(this.name);
		List<Todo> todos = new ArrayList<>();
		todosDTO.forEach(x -> todos.add(x.toTodo()));
		user.setTodos(todos);
		return user;
	}
}
