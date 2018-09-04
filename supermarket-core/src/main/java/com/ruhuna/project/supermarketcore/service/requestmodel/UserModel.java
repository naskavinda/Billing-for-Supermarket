package com.ruhuna.project.supermarketcore.service.requestmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
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
public class UserModel {
    private int id;

    private String firstName;

    private String lastName;

    private String userName;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
}
