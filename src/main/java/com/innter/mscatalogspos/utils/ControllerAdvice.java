package com.innter.mscatalogspos.utils;

import com.innter.mscatalogspos.exceptions.BadRequestCatalog;
import com.innter.mscatalogspos.exceptions.InternalServerErrorCatalog;
import com.innter.mscatalogspos.exceptions.NoSuchFileExceptionCatalog;
import com.innter.mscatalogspos.exceptions.NotFoundCatalog;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = BadRequestCatalog.class)//Error 400
    public ResponseEntity<ErrorDto> badRequestCatalog(BadRequestCatalog er) {
        ErrorDto error = ErrorDto.builder().code(er.getCode()).message(er.getMessage()).build();
        return new ResponseEntity<>(error, er.getStatus());
    }

    @ExceptionHandler(value = {NotFoundCatalog.class, NoSuchFileExceptionCatalog.class})//Error 404
    public ResponseEntity<ErrorDto> notFoundCatalog(NotFoundCatalog er) {
        ErrorDto error = ErrorDto.builder().code(er.getCode()).message(er.getMessage()).build();
        return new ResponseEntity<>(error, er.getStatus());
    }

    @ExceptionHandler(value = InternalServerErrorCatalog.class)//Error 500
    public ResponseEntity<ErrorDto> InternalServerErrorCatalog(InternalServerErrorCatalog er) {
        ErrorDto error = ErrorDto.builder().code(er.getCode()).message(er.getMessage()).build();
        return new ResponseEntity<>(error, er.getStatus());
    }
}
