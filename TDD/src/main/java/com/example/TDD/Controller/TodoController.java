package com.example.TDD.Controller;

import com.example.TDD.DTO.TodoRequestDTO;
import com.example.TDD.DTO.TodoResponseDTO;
import com.example.TDD.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public List<TodoResponseDTO> getAll(){
        return todoService.getAll();
    }

    @PostMapping("/todos")
    public ResponseEntity<TodoResponseDTO> create(@RequestBody TodoRequestDTO request) {
        TodoResponseDTO created = todoService.create(request);
        URI location = URI.create("/todos/" + created.getId());
        return ResponseEntity.created(location).body(created);
    }
}
