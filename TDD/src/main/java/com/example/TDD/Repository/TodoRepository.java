package com.example.TDD.Repository;

import com.example.TDD.Entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TodoRepository {
    List<Todo> findAll();
    Todo save(Todo todo);
}
