package com.example.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.dto.TodoDTO;
import com.example.todo.dto.UserDTO;
import com.example.todo.entity.Todo;
import com.example.todo.entity.User;
import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.UserRepository;

@Service
public class ServiceImpl implements TodoService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public UserDTO getUserById(Integer id) {
		return repository.getById(id).toUserDTO();
	}

	

	@Override
	public List<UserDTO> getAll() {
		Iterable<User> it = repository.findAll();
		List<UserDTO> list = new ArrayList<UserDTO>();
		it.forEach(x -> list.add(x.toUserDTO()));
		return list;
	}

	@Override
	public void addTodo(Integer id, TodoDTO todoDTO) {
		Optional<User> optionalUser = repository.findById(id);
		if (optionalUser.isEmpty()) return;
		User user = optionalUser.get();
		List<Todo> listTodo = user.getTodos();
		Todo newTodo = todoDTO.toTodo();
		todoRepository.save(newTodo);
		listTodo.add(newTodo);
		user.setTodos(listTodo);
	}



	@Override
	public void addUser(UserDTO userDTO) {
		User user = userDTO.toUser();
		repository.save(user);
	}
	
}
