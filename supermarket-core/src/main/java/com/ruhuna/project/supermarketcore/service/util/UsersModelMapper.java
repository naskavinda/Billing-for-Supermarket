package com.ruhuna.project.supermarketcore.service.util;

import com.ruhuna.project.supermarketcore.entity.Users;
import com.ruhuna.project.supermarketcore.controller.dto.UserDTO;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/3/2018
 */
public final class UsersModelMapper {

    private UsersModelMapper() {

    }

    public static UserDTO userToUserDTO(Users users) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(users.getFirstName());
        userDTO.setLastName(users.getLastName());
        userDTO.setId(users.getId());
        userDTO.setUserName(users.getUserName());
        return userDTO;
    }

    public static Users userDTOToUser(UserDTO userDTO) {
        Users users = new Users();
        users.setFirstName(userDTO.getFirstName());
        users.setLastName(userDTO.getLastName());
        users.setUserName(userDTO.getUserName());
        users.setPassword(userDTO.getPassword());
        return users;
    }
}
