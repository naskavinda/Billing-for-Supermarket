package com.ruhuna.project.supermarketcore.service.util;

import com.ruhuna.project.supermarketcore.manager.model.Users;
import com.ruhuna.project.supermarketcore.service.requestmodel.UsersModel;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/3/2018
 */
public final class UsersModelMapper {
    public static UsersModel UserToUserModel(Users users) {
        return UsersModel.builder()
                .id(users.getId())
                .firstName(users.getFirstName())
                .lastName(users.getLastName())
                .userName(users.getUserName())
                .status(users.getStatus())
                .build();

    }
}
