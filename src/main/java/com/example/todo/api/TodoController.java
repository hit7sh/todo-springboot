package com.example.todo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dto.TodoDTO;
import com.example.todo.dto.UserDTO;
import com.example.todo.service.TodoService;

@RestController
@RequestMapping("/api")
public class TodoController {
	@Autowired
	private TodoService service;
	
	@GetMapping("/getall")
	public ResponseEntity<List<UserDTO>> getAll() {
		List<UserDTO> list = service.getAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
		service.addUser(userDTO);
		return new ResponseEntity<String>("ADDED!", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/add-todo/{id}")
	public ResponseEntity<String> addTodo(@PathVariable Integer id, @RequestBody TodoDTO todoDTO) {
		
		service.addTodo(id, todoDTO);
		return new ResponseEntity<String>("ADDED!", HttpStatus.ACCEPTED);
	}
	
	
}
