package com.ruhuna.project.supermarketcore.controller;

import com.ruhuna.project.supermarketcore.controller.dto.CustomerDTO;
import com.ruhuna.project.supermarketcore.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/5/2018
 */
@RestController
@Api(value = "Customer", tags = "customer")
@Consumes(MediaType.APPLICATION_JSON_UTF8_VALUE)
@Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "customer/")
    @ApiOperation(value = "Save Customer", response = CustomerDTO.class)
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO customerResonce = customerService.saveCustomer(customerDTO);
        return new ResponseEntity<>(customerResonce, HttpStatus.CREATED);
    }
}
