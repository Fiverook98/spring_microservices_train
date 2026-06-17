package com.example.TDD;

import com.example.TDD.DTO.TodoRequestDTO;
import com.example.TDD.DTO.TodoResponseDTO;
import com.example.TDD.Entity.Todo;
import com.example.TDD.Repository.TodoRepository;
import com.example.TDD.Service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void getAll_ShouldMapEntitiesToResponse(){
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setTitle("Test Todo");
        todo.setCompleted(false);

        when(todoRepository.findAll()).thenReturn(List.of(todo));

        List<TodoResponseDTO> result = todoService.getAll();

        assertThat(result).hasSize(1);
        assertThat(result.getFirst().getId()).isEqualTo(1L);
        assertThat(result.getFirst().getTitle()).isEqualTo("Test Todo");
        assertThat(result.getFirst().isCompleted()).isFalse();
    }

    @Test
    void create_shouldPersistAndReturnResponse() {
        TodoRequestDTO request = new TodoRequestDTO(10L, "Test TDD", false);

        Todo saved = new Todo(request.getId(), request.getTitle(), request.isCompleted());

        when(todoRepository.save(any(Todo.class))).thenReturn(saved);

        TodoResponseDTO response = todoService.create(request);

        assertThat(response.getId()).isEqualTo(10L);
        assertThat(response.getTitle()).isEqualTo("Test TDD");
        assertThat(response.isCompleted()).isFalse();

        verify(todoRepository).save(any(Todo.class));
    }
}
