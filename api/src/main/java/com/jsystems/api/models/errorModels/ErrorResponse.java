package com.jsystems.api.models.errorModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ErrorResponse {
    public ErrorObject Error;

    public class ErrorObject {
        @JsonProperty(value = "error.code")
        public int errorCode;

        @JsonProperty(value = "validation_erro")
        public String validationError;

        public String message;

    }
}
