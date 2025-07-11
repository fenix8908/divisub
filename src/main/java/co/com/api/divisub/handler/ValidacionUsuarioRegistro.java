package co.com.api.divisub.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidacionUsuarioRegistro {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validarRegistroUsuarios(MethodArgumentNotValidException ex) {
        Map<String, String> errores = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        error -> error.getField(),
                        error -> error.getDefaultMessage(),
                        (mensaje1, mensaje2) -> mensaje1 // En caso de campos repetidos, toma el primero
                ));
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}
