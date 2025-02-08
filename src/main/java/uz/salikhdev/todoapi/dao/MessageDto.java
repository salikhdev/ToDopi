package uz.salikhdev.todoapi.dao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MessageDto {
    private String message;
    private Boolean status;
    private Integer code;
}
