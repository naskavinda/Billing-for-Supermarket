package com.ruhuna.project.supermarketcore.service.util;

import com.ruhuna.project.supermarketcore.manager.model.Users;
import com.ruhuna.project.supermarketcore.service.requestmodel.UserModel;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/3/2018
 */
public final class UsersModelMapper {

    private UsersModelMapper() {

    }

    public static UserModel userToUserModel(Users users) {
//        return UserModel.builder()
//                .id(users.getId())
//                .firstName(users.getFirstName())
//                .lastName(users.getLastName())
//                .userName(users.getUserName())
//                .status(users.getStatus())
//                .build();
        UserModel userModel = new UserModel();
        userModel.setFirstName(users.getFirstName());
        userModel.setLastName(users.getLastName());
        userModel.setId(users.getId());
        userModel.setUserName(users.getUserName());
        return userModel;
    }

    public static Users userModelToUser(UserModel userModel, String password) {
        Users users = new Users();
        users.setFirstName(userModel.getFirstName());
        users.setLastName(userModel.getLastName());
        users.setUserName(userModel.getUserName());
        users.setPassword(password);
        return users;
    }
}
