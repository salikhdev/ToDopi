package uz.salikhdev.todoapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.salikhdev.todoapi.dto.MessageDto;
import uz.salikhdev.todoapi.entity.Todo;
import uz.salikhdev.todoapi.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @PostMapping
    public ResponseEntity<MessageDto> createTodo(@RequestBody Todo todo) {
        service.saveTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDto("Todo added successfully!"));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        var todos = service.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {
        return ResponseEntity.ok(service.findTodoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> editTodo(@PathVariable Long id, @RequestBody Todo todo) {
        service.updateTodo(id, todo);
        return ResponseEntity.ok(new MessageDto("Update is success !!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deleteTodo(@PathVariable Long id) {
        service.deleteTodo(id);
        return ResponseEntity.ok(new MessageDto("Delete is success !!"));
    }
}
