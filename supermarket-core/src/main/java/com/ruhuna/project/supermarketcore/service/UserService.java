package com.ruhuna.project.supermarketcore.service;

import com.ruhuna.project.supermarketcore.service.requestmodel.UserModel;

import java.util.List;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/3/2018
 */
public interface UserService {

    List<UserModel> getAllUsers();

    UserModel getUserById(int id);

    UserModel saveOrUpdateUser(UserModel userModel, String password);
}
