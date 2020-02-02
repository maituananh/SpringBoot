package com.example.controller;

import com.example.entity.*;
import com.example.model.CustomerDTO;
import com.example.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<CustomerDTO> home() {
        for (int i = 0; i < userService.findAll().size(); i++) {
            String json = new Gson().toJson(userService.findAll().get(i));
            System.out.println(json);
        }
        return userService.findAll();
    }

    @DeleteMapping(path ={"/{id}"})
    @ResponseStatus(value = HttpStatus.OK)
    public int deleteCustomerById(@PathVariable("id") int id) {
        return userService.removeCustomerById(id);
    }

    @PostMapping(path ={"/{name}"})
    @ResponseStatus(value = HttpStatus.OK)
    public List findCustomerByName(@PathVariable("name") String name) {
        return userService.findCustomerByName(name);
    }

    @PostMapping(path ={"/{name}/{address}"})
    @ResponseStatus(value = HttpStatus.OK)
    public CustomerDTO findCustomerByNameAndAddress(@PathVariable("name") String name, @PathVariable("address") String address) {
        return userService.findCustomerByNameAndAddress(name, address);
    }

}
