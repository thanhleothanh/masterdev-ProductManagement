package com.ghtk.thanhnh157.models.responses;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "error")
public class ErrorResponse {
    private boolean success;
    private String message;
    private String data;
    private List<String> errors;

    public ErrorResponse(String message, List<String> errors) {
        this.success = false;
        this.message = message;
        this.data = null;
        this.errors = errors;
    }
}
