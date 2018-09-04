package com.ruhuna.project.supermarketcore.controller;

import com.ruhuna.project.supermarketcore.service.UserService;
import com.ruhuna.project.supermarketcore.service.requestmodel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/3/2018
 */
@RestController
@Api( value = "User", tags = "users" )
@Consumes( MediaType.APPLICATION_JSON_UTF8_VALUE )
@Produces( MediaType.APPLICATION_JSON_UTF8_VALUE )
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "user/all")
    @ApiOperation(value = "Find All User")
    public ResponseEntity<List<UserModel>> getAllUsers(){
        List<UserModel> userModels = userService.getAllUsers();
        if ( userModels.isEmpty() ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userModels, HttpStatus.OK);
    }

    @GetMapping( value = "user/")
    @ApiOperation( value = "Find given user", response = UserModel.class, responseContainer = "List" )
    public ResponseEntity<UserModel> getUserById(@RequestParam int id) {
        if ( id <= 0 ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserModel userModel = userService.getUserById(id);
        if ( userModel == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }

    @PostMapping( value = "user/" )
    @ApiOperation( value = "Save User details", response = UserModel.class )
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel userModel, @RequestParam String password) {
        UserModel userModelResponse = userService.saveOrUpdateUser(userModel, password);
        return new ResponseEntity<>(userModelResponse, HttpStatus.CREATED);
    }
}
