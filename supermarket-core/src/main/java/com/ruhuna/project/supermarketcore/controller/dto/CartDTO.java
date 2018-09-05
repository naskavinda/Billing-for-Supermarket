package com.ruhuna.project.supermarketcore.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/5/2018
 */
@Getter
@Setter
public class CartDTO {
    private int id;
    private int itemId;
    private int customerId;

    @JsonProperty(access = Access.READ_ONLY)
    private Date addDate;

    private double qty;
}
