package uz.salikhdev.todoapi.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.salikhdev.todoapi.entity.Todo;
import uz.salikhdev.todoapi.util.TodoRowMapper;

import java.sql.Timestamp;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    private final JdbcTemplate jdbcTemplate;


    public void saveTodo(Todo todo) {
        String query = """
                INSERT INTO todo (title, description, createat , iscomplated) VALUES (?, ?, ?, ?);
                """;

        jdbcTemplate.update(query,
                todo.getTitle(),
                todo.getDescription(),
                Timestamp.valueOf(todo.getCreateAt()),
                todo.getIscomplated()
        );
    }


    public List<Todo> findAllTodos() {
        String query = """
                SELECT id, title, description, iscomplated, createat, deleteat FROM todo
                """;
        return jdbcTemplate.query(query, new TodoRowMapper());
    }
}
