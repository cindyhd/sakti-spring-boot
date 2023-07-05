package com.example.session.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CommonResponse<T> implements Serializable {
    private boolean status;
    private String message;
    private T object;
}
