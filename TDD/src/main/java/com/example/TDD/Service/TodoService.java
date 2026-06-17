package com.example.TDD.Service;

import com.example.TDD.DTO.TodoRequestDTO;
import com.example.TDD.DTO.TodoResponseDTO;
import com.example.TDD.Entity.Todo;
import com.example.TDD.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<TodoResponseDTO> getAll(){
        return repository.findAll().stream().map(
                todo -> new TodoResponseDTO(todo.getId(), todo.getTitle(), todo.isCompleted())
        ).toList();
    }

    public TodoResponseDTO create(TodoRequestDTO request){
        Todo todo = new Todo(request.getId(), request.getTitle(), request.isCompleted());
        Todo saved = repository.save(todo);
        return new TodoResponseDTO(saved.getId(), saved.getTitle(), saved.isCompleted());
    }
}
