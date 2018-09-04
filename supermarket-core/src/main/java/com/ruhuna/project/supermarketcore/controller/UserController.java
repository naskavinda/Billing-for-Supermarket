package com.ruhuna.project.supermarketcore.controller;

import com.ruhuna.project.supermarketcore.service.UserService;
import org.springframework.http.HttpStatus;
import com.ruhuna.project.supermarketcore.service.requestmodel.UsersModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "user/all")
    @ApiOperation(value = "Find All User")
    public ResponseEntity<List<UsersModel>> getAllUsers(){
        List<UsersModel> usersModels = userService.getAllUsers();
        if ( usersModels.isEmpty() ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usersModels, HttpStatus.OK);
    }
}
