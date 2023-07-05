package com.example.session.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateSessionLoginRequest {
    private String sessionId;
    private String token;
    private String timestamp;

}
