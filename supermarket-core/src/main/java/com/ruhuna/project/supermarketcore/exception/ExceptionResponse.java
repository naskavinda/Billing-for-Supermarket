package com.ruhuna.project.supermarketcore.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/5/2018
 */
@Getter
@Setter
@AllArgsConstructor
class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;
}
