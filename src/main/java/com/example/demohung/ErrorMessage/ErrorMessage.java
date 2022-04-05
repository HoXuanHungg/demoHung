package com.example.demohung.ErrorMessage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private String statusCode;
    private String message;
    private Object data;
}
