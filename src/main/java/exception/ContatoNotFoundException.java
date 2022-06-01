package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ContatoNotFoundException extends Exception {
    public ContatoNotFoundException(String msg) {
        super(msg);
    }
}