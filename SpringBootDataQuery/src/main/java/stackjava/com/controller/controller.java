package stackjava.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stackjava.com.sbdataquery.entities.Customer;
import stackjava.com.sbdataquery.repository.CustomerRepository;

import java.util.List;

@RestController
public class controller {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/")
    public ResponseEntity<List<Customer>> home() {
        return new ResponseEntity<List<Customer>>(customerRepository.findAllOrderByNameDesc(), HttpStatus.OK);
    }
}
