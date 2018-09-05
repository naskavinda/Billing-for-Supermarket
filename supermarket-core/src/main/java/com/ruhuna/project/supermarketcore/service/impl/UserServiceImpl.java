package com.ruhuna.project.supermarketcore.service.impl;

import com.ruhuna.project.supermarketcore.entity.Users;
import com.ruhuna.project.supermarketcore.service.UserService;
import com.ruhuna.project.supermarketcore.service.dto.UserDTO;
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
    public List<UserDTO> getAllUsers() {
        return usersRepository.findAll().stream().map(UsersModelMapper::userToUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(int id) {
        Users user = usersRepository.findUsersById(id);
        return user == null ? null : UsersModelMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO saveOrUpdateUser(UserDTO userDTO) {
        Users user = UsersModelMapper.userDTOToUser(userDTO);
        user.setStatus(true);
        Users userResponse = usersRepository.saveAndFlush(user);
        return userResponse == null ? null : UsersModelMapper.userToUserDTO(userResponse);
    }
}
