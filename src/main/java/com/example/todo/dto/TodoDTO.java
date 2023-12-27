package com.example.todo.dto;

import com.example.todo.entity.Todo;

public class TodoDTO {
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
	public Todo toTodo() {
		Todo todo = new Todo();
		todo.setId(id);
		todo.setUserId(userId);
		todo.setTitle(title);
		todo.setDescription(description);
		return todo;
	}
}
