package com.ruhuna.project.supermarketcore.service.requestmodel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/3/2018
 */
@Builder
@Getter
public class UsersModel {
    private int id;

    private String firstName;

    private String lastName;

    private String userName;

    private Boolean status;

}
