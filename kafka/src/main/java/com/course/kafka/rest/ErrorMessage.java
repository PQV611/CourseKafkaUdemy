package com.course.kafka.rest;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ErrorMessage {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorMessage(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
