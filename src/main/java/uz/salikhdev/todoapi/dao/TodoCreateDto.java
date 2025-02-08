package uz.salikhdev.todoapi.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TodoCreateDto {
    private String title;
    private String description;
    private boolean completed;
}
