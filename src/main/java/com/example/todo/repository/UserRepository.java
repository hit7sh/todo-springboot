package com.example.todo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	public User getById(Integer id);
}
