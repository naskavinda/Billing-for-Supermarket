package com.ruhuna.project.supermarketcore.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/3/2018
 */
//@Builder
@Getter
@Setter
public class UserDTO {
    private int id;

    private String firstName;

    private String lastName;

    private String userName;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
}
