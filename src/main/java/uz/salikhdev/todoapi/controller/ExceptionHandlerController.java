package uz.salikhdev.todoapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.salikhdev.todoapi.dto.MessageErrorDto;
import uz.salikhdev.todoapi.exception.DeleteException;
import uz.salikhdev.todoapi.exception.TodoNotFound;
import uz.salikhdev.todoapi.exception.UpdateException;

@RestControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(TodoNotFound.class)
    public ResponseEntity<MessageErrorDto> handlerTodoNotFoundException(TodoNotFound e) {
        MessageErrorDto message = new MessageErrorDto(
                false,
                e.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler({UpdateException.class, DeleteException.class})
    public ResponseEntity<MessageErrorDto> handlerServerErrors(Exception e) {
        MessageErrorDto message = new MessageErrorDto(
                false,
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }


}
