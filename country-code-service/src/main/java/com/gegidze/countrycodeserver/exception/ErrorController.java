package com.gegidze.countrycodeserver.exception;

import com.gegidze.countrycodeserver.entity.ErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(
            ConstraintViolationException ex, WebRequest request) {

        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        List<String> errorMessages = constraintViolations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return new ResponseEntity<>(
                new ErrorResponseModel(
                        errorMessages.toString(),
                        LocalDateTime.now(),
                        request.getDescription(false)
                ),
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }
}
