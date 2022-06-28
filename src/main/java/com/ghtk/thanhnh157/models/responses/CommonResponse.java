package com.ghtk.thanhnh157.models.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommonResponse {
    private boolean success;
    private String message;
    private Object data;
    private List<String> errors;

    public CommonResponse(String message, Object data) {
        this.success = true;
        this.message = message;
        this.data = data;
        this.errors = null;
    }
}
