package com.ruhuna.project.supermarketcore.service.impl;

import com.ruhuna.project.supermarketcore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruhuna.project.supermarketcore.repository.UsersRepository;
import com.ruhuna.project.supermarketcore.service.requestmodel.UsersModel;
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
    public List<UsersModel> getAllUsers() {
        return usersRepository.findAll().stream().map(UsersModelMapper::UserToUserModel).collect(Collectors.toList());
    }
}
