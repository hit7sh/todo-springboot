package com.example.todo.service;

import java.util.List;

import com.example.todo.dto.TodoDTO;
import com.example.todo.dto.UserDTO;

public interface TodoService {
	UserDTO getUserById(Integer id);
	void addUser(UserDTO userDTO);
	List<UserDTO> getAll();
	void addTodo(Integer id, TodoDTO todoDTO);
}
