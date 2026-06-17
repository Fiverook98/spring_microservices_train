package com.example.TDD.Repository;

import com.example.TDD.Entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTodoRepository implements TodoRepository {

    private final Map<Long, Todo> store = new ConcurrentHashMap<>();
    private final AtomicLong idSequence = new AtomicLong(0);

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Todo save(Todo todo){
        if (todo.getId() == null) {
            todo.setId(idSequence.incrementAndGet());
        }
        todo.setCompleted(false);
        store.put(todo.getId(), todo);
        return todo;
    }
}
