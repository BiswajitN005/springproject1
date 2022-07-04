package com.spring.project1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeExeptions extends RuntimeException{

private static final long serialVersionUID =1L;
    private String resourceName;

    private String fieldName;
    private Object fieldValue;

    public EmployeeExeptions(String resourceName, String fieldName, Object fieldValue) {
            super(String.format("%s not found with %s : %s", resourceName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFiledName() {
        return fieldName;
    }

    public Object getFindValue() {
        return fieldValue;
    }
}
