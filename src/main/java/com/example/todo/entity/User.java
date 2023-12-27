package com.example.todo.entity;




import java.util.ArrayList;
import java.util.List;

import com.example.todo.dto.TodoDTO;
import com.example.todo.dto.UserDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="myusers")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private List<Todo> todos;
	
	private String name;
	
	public User() {
		todos = new ArrayList<>();
	}
	public Integer getId() {
		return id;
	}
	
	public List<Todo> getTodos() {
		return todos;
	}
	public void setTodos(List<Todo> todos) {
		this.todos = todos;
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
	public UserDTO toUserDTO() {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(this.id);
		userDTO.setName(this.name);
		List<TodoDTO> todosDTO = new ArrayList<>();
		todos.forEach(x -> todosDTO.add(x.toTodoDTO()));
		userDTO.setTodos(todosDTO);
		return userDTO;
	}
}
