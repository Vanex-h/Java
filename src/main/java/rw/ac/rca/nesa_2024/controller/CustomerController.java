package rw.ac.rca.nesa_2024.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.nesa_2024.dto.CreateCustomerDTO;
import rw.ac.rca.nesa_2024.entity.Customer;
import rw.ac.rca.nesa_2024.error.CustomException;
import rw.ac.rca.nesa_2024.service.CustomerService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/customers")
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class CustomerController {
    @Autowired
    private  CustomerService customerService;


    @PostMapping("/addNewCustomer")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addCustomer(@RequestBody CreateCustomerDTO dto) {
        try {

            Customer c= new Customer();
            c.setFirstName(dto.getFirstName());
            c.setLastName(dto.getLastName());
            c.setEmail(dto.getEmail());
            c.setMobile(dto.getMobile());
            c.setDob(dto.getDob());
            c.setAccount(dto.getAccount());
            c.setBalance(dto.getBalance());
            c.setLastUpdateTime(dto.getLastUpdateTime());
            System.out.println(c);
            customerService.addCustomer(c);
            return "Customer added successfully";

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
