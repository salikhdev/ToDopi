package uz.salikhdev.todoapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.salikhdev.todoapi.dao.MessageDto;
import uz.salikhdev.todoapi.dao.TodoCreateDto;
import uz.salikhdev.todoapi.entity.Todo;
import uz.salikhdev.todoapi.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;


    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@RequestBody TodoCreateDto todo) {
        todoService.createTodo(todo);
        return ResponseEntity.ok(
                MessageDto.builder()
                        .message("Todo is created")
                        .status(true)
                        .code(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.ok(todoService.getAll());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.ok(
                MessageDto.builder()
                        .message("Todo is deleted")
                        .status(true)
                        .code(HttpStatus.NO_CONTENT.value())
                        .build()
        );
    }

}
