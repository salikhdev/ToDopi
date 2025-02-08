package uz.salikhdev.todoapi.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.salikhdev.todoapi.dao.TodoCreateDto;
import uz.salikhdev.todoapi.entity.Todo;
import uz.salikhdev.todoapi.exception.ArgumentException;
import uz.salikhdev.todoapi.exception.TodoNotFound;
import uz.salikhdev.todoapi.repository.TodoRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public Todo getTodoById(Long id) {
        return repository.findByIdAndDeleteAtIsNull(id).orElseThrow(
                () -> {
                    log.error("Todo not found by: {}", id);
                    return new TodoNotFound("Todo not found by: " + id);
                }
        );
    }

    public void createTodo(TodoCreateDto dto) {

        if (dto.getTitle() == null || dto.getTitle().isBlank()) {
            throw new ArgumentException("Title is required");
        }

        if (dto.getDescription() == null || dto.getDescription().isBlank()) {
            throw new ArgumentException("Description is required");
        }

        Todo entity = Todo.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();

        repository.save(entity);
    }

    public List<Todo> getAll() {
        return repository.findAllByDeleteAtIsNull();
    }


    public void delete(Long id) {
        Todo todo = getTodoById(id);
        todo.setDeleteAt(LocalDateTime.now());

        repository.save(todo);
    }
}
