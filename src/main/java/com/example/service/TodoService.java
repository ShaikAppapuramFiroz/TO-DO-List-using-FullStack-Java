package com.example.service;

import com.example.model.Todo;
import com.example.repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Todo update(Long id, Todo updated) {
        return repository.findById(id).map(todo -> {
            todo.setTask(updated.getTask());
            todo.setDate(updated.getDate());
            todo.setTime(updated.getTime());
            todo.setCompleted(updated.isCompleted());
            return repository.save(todo);
        }).orElseThrow();
    }

    public void toggle(Long id) {
        repository.findById(id).ifPresent(todo -> {
            todo.setCompleted(!todo.isCompleted());
            repository.save(todo);
        });
    }
}
