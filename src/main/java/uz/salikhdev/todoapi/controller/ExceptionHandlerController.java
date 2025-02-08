package uz.salikhdev.todoapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.salikhdev.todoapi.dao.MessageDto;
import uz.salikhdev.todoapi.exception.ArgumentException;
import uz.salikhdev.todoapi.exception.TodoNotFound;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({TodoNotFound.class})
    public ResponseEntity<MessageDto> handleTodoNotFound(Exception e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(MessageDto
                        .builder()
                        .message(e.getMessage())
                        .code(HttpStatus.NOT_FOUND.value())
                        .status(false)
                        .build()
                );
    }

    @ExceptionHandler({ArgumentException.class})
    public ResponseEntity<MessageDto> handleArgumentException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(MessageDto
                        .builder()
                        .message(e.getMessage())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .status(false)
                        .build()
                );
    }

}
