package com.innter.mscatalogspos.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class NoSuchFileExceptionCatalog extends NotFoundCatalog {
    private String code;
    private HttpStatus status;

    public NoSuchFileExceptionCatalog(String code, HttpStatus status, String message) {

        super(code, status, message);
        this.code = code;
        this.status = status;
    }
}
