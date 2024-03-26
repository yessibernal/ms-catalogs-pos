package com.innter.mscatalogspos.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class NotFoundCatalog extends RuntimeException {
    private String code;
    private HttpStatus status;

    public NotFoundCatalog(String code, HttpStatus status, String message) {

        super(message);
        this.code = code;
        this.status = status;
    }
}
