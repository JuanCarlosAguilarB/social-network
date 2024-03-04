package com.example.socialnetwork.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler  {



//    @ExceptionHandler(UserNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ErrorResponse handleUserNotFoundException(UserNotFoundException ex) {
//        return new ErrorResponse(true, ex.getMessage());
//    }
//
    @ExceptionHandler(DuplicateEmailException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ApiExceptionResponse handleDuplicateEmailException(DuplicateEmailException ex) {
        return new ApiExceptionResponse.ApiExceptionResponseBuilder()
                .status(HttpStatus.CONFLICT.value())
                .error(HttpStatus.CONFLICT.getReasonPhrase())
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(InvalidRequestArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiExceptionResponse  handleInvalidRequestArgumentException(InvalidRequestArgumentException ex) {
        return new ApiExceptionResponse.ApiExceptionResponseBuilder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getMessage())
                .build();
    }


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiExceptionResponse handleUsernameNotFoundException(UserNotFoundException ex) {
        return new ApiExceptionResponse.ApiExceptionResponseBuilder()
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(JwtTokenException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ApiExceptionResponse handleJwtTokenException(JwtTokenException ex) {
        return new ApiExceptionResponse.ApiExceptionResponseBuilder()
                .status(HttpStatus.UNAUTHORIZED.value())
                .error(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .message(ex.getMessage())
                .build();
    }


    @ExceptionHandler(ResourceNotCreatedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ApiExceptionResponse handleResourceNotCreatedException(ResourceNotCreatedException ex) {
        return new ApiExceptionResponse.ApiExceptionResponseBuilder()
                .status(HttpStatus.CONFLICT.value())
                .error(HttpStatus.CONFLICT.getReasonPhrase())
                .message(ex.getMessage())
                .build();
    }


    @ExceptionHandler(BoardNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiExceptionResponse handleBoardNotFound(BoardNotFound ex) {
        return new ApiExceptionResponse.ApiExceptionResponseBuilder()
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(ex.getMessage())
                .build();
    }
}
