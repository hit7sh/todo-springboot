package com.example.todo.entity;

import com.example.todo.dto.TodoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Transactional
@Table(name="todo")
public class Todo {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer id;
	
	private Integer userId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	private String title;
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public TodoDTO toTodoDTO() {
		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setId(id);
		todoDTO.setUserId(userId);
		todoDTO.setDescription(description);
		todoDTO.setTitle(title);
		return todoDTO;
	}
}
