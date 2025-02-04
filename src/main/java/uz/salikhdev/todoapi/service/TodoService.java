package uz.salikhdev.todoapi.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.salikhdev.todoapi.entity.Todo;
import uz.salikhdev.todoapi.repository.TodoRepository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public void saveTodo(Todo todo) {
        try {
            todo.setCreateAt(LocalDateTime.now());
            todo.setIscomplated(false);
            repository.saveTodo(todo);
        } catch (Exception e) {
            log.error("ERROR !!!!!!!! {}", e.getMessage());
        }
    }

    public List<Todo> getAllTodos() {
        try {
            return repository.findAllTodos();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
