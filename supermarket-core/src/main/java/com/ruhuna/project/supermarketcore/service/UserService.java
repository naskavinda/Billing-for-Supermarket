package com.ruhuna.project.supermarketcore.service;

import com.ruhuna.project.supermarketcore.controller.dto.UserDTO;

import java.util.List;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/3/2018
 */
public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(int id);

    UserDTO saveOrUpdateUser(UserDTO userDTO);
}
