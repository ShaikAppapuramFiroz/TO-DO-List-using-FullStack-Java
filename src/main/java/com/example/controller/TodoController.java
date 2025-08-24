package com.example.controller;

import com.example.model.Todo;
import com.example.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/todos")
    public String listTodos(Model model) {
        model.addAttribute("todos", service.findAll());
        model.addAttribute("newTodo", new Todo());
        return "todo";
    }

    @PostMapping("/todos")
    public String addTodo(@ModelAttribute Todo todo) {
        service.save(todo);
        return "redirect:/todos";
    }

    @PostMapping("/todos/update/{id}")
    public String updateTodo(@PathVariable Long id, @ModelAttribute Todo todo) {
        service.update(id, todo);
        return "redirect:/todos";
    }

    @GetMapping("/todos/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/todos";
    }

    @GetMapping("/todos/toggle/{id}")
    public String toggleTodo(@PathVariable Long id) {
        service.toggle(id);
        return "redirect:/todos";
    }
}
