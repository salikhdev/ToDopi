package uz.salikhdev.todoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private String description;
    private Boolean iscomplated;
    private LocalDateTime createAt;
    private LocalDateTime deleteAt;
}
