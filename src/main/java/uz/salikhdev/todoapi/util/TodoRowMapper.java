package uz.salikhdev.todoapi.util;

import org.springframework.jdbc.core.RowMapper;
import uz.salikhdev.todoapi.entity.Todo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoRowMapper implements RowMapper<Todo> {
    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Todo(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getBoolean("iscomplated"),
                rs.getTimestamp("createat").toLocalDateTime() ,
                rs.getTimestamp("deleteat") != null ? rs.getTimestamp("deleteat").toLocalDateTime() : null
        );
    }
}