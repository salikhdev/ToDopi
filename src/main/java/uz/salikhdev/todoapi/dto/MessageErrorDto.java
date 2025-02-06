package uz.salikhdev.todoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageErrorDto {
    private Boolean status;
    private String message;
    private Integer code;
}
