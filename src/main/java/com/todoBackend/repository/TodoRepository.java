package com.todoBackend.repository;

import com.todoBackend.model.Todo;
import com.todoBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findByUser(User user);
}
