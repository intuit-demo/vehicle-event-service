package com.intuit.vehicleeventservice.common.exceptions.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Builder
@Data
public class Error implements Serializable {

    private String message;
    private String statusCode;
}
