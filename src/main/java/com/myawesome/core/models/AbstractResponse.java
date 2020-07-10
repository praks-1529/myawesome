package com.myawesome.core.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class AbstractResponse {
    public HttpStatus httpStatus;
    public int code;
}
