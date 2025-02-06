package uz.salikhdev.todoapi.exception;

public class TodoNotFound extends RuntimeException {

    public TodoNotFound(String message) {
        super(message);
    }
}
