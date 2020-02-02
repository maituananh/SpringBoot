package com.example.service;

import com.example.entity.Customer;
import com.example.model.CustomerDTO;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List findAll() {
        List<CustomerDTO> customerDTOS = userRepository.findAll();
        return customerDTOS;
    }

    public int removeCustomerById(int id) {
        Customer customer = userRepository.findCustomerById(id);
        if (customer == null) {
            return 0;
        } else {
            return userRepository.removeCustomerById(customer);
        }
    }

    public List findCustomerByName(String name) {
        List<CustomerDTO> customerDTOS = userRepository.findCustomerByName(name);
        return customerDTOS;
    }

    public CustomerDTO findCustomerByNameAndAddress(String name, String address) {
        Customer customer = userRepository.findNameAndAddress(name, address);
        if (customer == null) {
            return null;
        } else {
            CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
            return customerDTO;
        }
    }
}
