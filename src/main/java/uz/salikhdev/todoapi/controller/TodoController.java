package uz.salikhdev.todoapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.salikhdev.todoapi.dto.MessageDto;
import uz.salikhdev.todoapi.entity.Todo;
import uz.salikhdev.todoapi.service.TodoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<MessageDto> createTodo(@RequestBody Todo todo) {
        service.saveTodo(todo);
        return ResponseEntity.ok(new MessageDto("Todo added successfully!"));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        var todos = service.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {
        // var todo = service.findTodoById(id);
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> editTodo(@PathVariable Long id) {
        // TODO Edit
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable Long id) {
        // TODO Delete
        return null;
    }
}
