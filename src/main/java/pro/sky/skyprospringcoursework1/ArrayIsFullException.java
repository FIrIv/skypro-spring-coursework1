package pro.sky.skyprospringcoursework1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ArrayIsFullException extends RuntimeException {
    public ArrayIsFullException() {
    }
}
