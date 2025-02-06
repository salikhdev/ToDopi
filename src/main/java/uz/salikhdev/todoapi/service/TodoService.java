package uz.salikhdev.todoapi.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.salikhdev.todoapi.entity.Todo;
import uz.salikhdev.todoapi.exception.DeleteException;
import uz.salikhdev.todoapi.exception.TodoNotFound;
import uz.salikhdev.todoapi.exception.UpdateException;
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

    public Todo findTodoById(Long id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new TodoNotFound("Todo id=%s Not Found !!!".formatted(id));
        }
    }

    public void deleteTodo(Long id)  {
        try {
            findTodoById(id);
            repository.deleteById(id, LocalDateTime.now());
        } catch (Exception e) {
            throw new DeleteException("Error with delete !!!");
        }
    }

    public void updateTodo(Long id, Todo todo) {
        try {
            findTodoById(id);
            repository.updateTodo(id, todo);
        } catch (Exception e) {
            throw new UpdateException("Error with update !!!");
        }
    }
}
