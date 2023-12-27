package com.example.todo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.entity.Todo;
import com.example.todo.entity.User;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer>{
	public User getById(Integer id);
}
