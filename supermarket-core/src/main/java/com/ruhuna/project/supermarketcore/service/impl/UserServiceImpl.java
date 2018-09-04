package com.ruhuna.project.supermarketcore.service.impl;

import com.ruhuna.project.supermarketcore.manager.model.Users;
import com.ruhuna.project.supermarketcore.service.UserService;
import com.ruhuna.project.supermarketcore.service.requestmodel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruhuna.project.supermarketcore.repository.UsersRepository;
import com.ruhuna.project.supermarketcore.service.util.UsersModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/3/2018
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<UserModel> getAllUsers() {
        return usersRepository.findAll().stream().map(UsersModelMapper::userToUserModel).collect(Collectors.toList());
    }

    @Override
    public UserModel getUserById(int id) {
        Users user = usersRepository.findUsersById(id);
        return user == null ? null : UsersModelMapper.userToUserModel(user);
    }

    @Override
    public UserModel saveOrUpdateUser(UserModel userModel, String password) {
        Users user = usersRepository.saveAndFlush(UsersModelMapper.userModelToUser(userModel,password));
        return user == null ? null : UsersModelMapper.userToUserModel(user);
    }
}
