package com.ruhuna.project.supermarketcore.service.impl;

import com.ruhuna.project.supermarketcore.controller.dto.CustomerDTO;
import com.ruhuna.project.supermarketcore.entity.Customer;
import com.ruhuna.project.supermarketcore.exception.InvalidPropertyException;
import com.ruhuna.project.supermarketcore.repository.CustomerRepository;
import com.ruhuna.project.supermarketcore.service.CustomerService;
import com.ruhuna.project.supermarketcore.service.util.CustomerModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/5/2018
 */
@Service( "customerService" )
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerById(int id) {
        Optional<Customer> customer = customerRepository.findByCustomerId(id);
        if (!customer.isPresent())
            throw new InvalidPropertyException("provided Customer ID is not exist.");
        return customer.get();
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return CustomerModelMapper.customerToCustomerDTO(customerRepository.save(CustomerModelMapper.customerDTOToCustomer(customerDTO,true)));
    }
}
