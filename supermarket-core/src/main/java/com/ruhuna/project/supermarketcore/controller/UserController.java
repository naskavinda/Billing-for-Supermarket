package com.ruhuna.project.supermarketcore.controller;

import com.ruhuna.project.supermarketcore.service.UserService;
import com.ruhuna.project.supermarketcore.controller.dto.UserDTO;
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
    @ApiOperation(value = "Find All User", response = UserDTO.class, responseContainer = "List")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userDTOS = userService.getAllUsers();
        if ( userDTOS.isEmpty() ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    @GetMapping( value = "user/")
    @ApiOperation( value = "Find given user", response = UserDTO.class, responseContainer = "List" )
    public ResponseEntity<UserDTO> getUserById(@RequestParam int id) {
        if ( id <= 0 ) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserDTO userDTO = userService.getUserById(id);
        if ( userDTO == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping( value = "user/" )
    @ApiOperation( value = "Save User details", response = UserDTO.class )
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        UserDTO userDTOResponse = userService.saveOrUpdateUser(userDTO);
        return new ResponseEntity<>(userDTOResponse, HttpStatus.CREATED);
    }
}
