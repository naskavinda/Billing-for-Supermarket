package com.ruhuna.project.supermarketcore.service.util;

import com.ruhuna.project.supermarketcore.controller.dto.CustomerDTO;
import com.ruhuna.project.supermarketcore.entity.Customer;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/5/2018
 */
public final class CustomerModelMapper {

    private CustomerModelMapper() {
    }

    public static Customer customerDTOToCustomer(CustomerDTO customerDTO,boolean status) {
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setCustomerId(customerDTO.getId());
        customer.setLastName(customerDTO.getLastName());
        customer.setStatus(status);
        customer.setTp(customerDTO.getTp());

        return customer;
    }

    public static CustomerDTO customerToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setId(customer.getCustomerId());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setTp(customer.getTp());
        return customerDTO;
    }
}
