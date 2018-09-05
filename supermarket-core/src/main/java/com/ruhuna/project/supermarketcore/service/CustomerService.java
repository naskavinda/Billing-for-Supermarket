package com.ruhuna.project.supermarketcore.service;

import com.ruhuna.project.supermarketcore.controller.dto.CustomerDTO;
import com.ruhuna.project.supermarketcore.entity.Customer;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/5/2018
 */
public interface CustomerService {
    Customer getCustomerById(int id);

    CustomerDTO saveCustomer(CustomerDTO customerDTO);
}
