package rw.ac.rca.nesa_2024.service;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.ac.rca.nesa_2024.entity.Customer;
import rw.ac.rca.nesa_2024.error.CustomException;
import rw.ac.rca.nesa_2024.repository.CustomerRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer){
        String email= customer.getEmail();
        Date date= customer.getDob();
        if (email == null || !email.contains("@") || !email.endsWith(".com")) {
            throw new CustomException("Email must be a valid email address");
        }

        if (customerRepository.findCustomerByEmail(email).isPresent()) {
            throw new CustomException("Email already in use");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false); // Ensure strict parsing
        try {
            String dobStr = sdf.format(date);
            sdf.parse(dobStr);
        } catch (Exception e) {
            throw new CustomException("DOB is not in the appropriate format (yyyy-MM-dd)");
        }

        customerRepository.save(customer);
    }
    public Customer getCustomerById(Integer Id){
        System.out.println("The id is "+Id);
        return customerRepository.findById(Id)
                .orElseThrow(() -> new CustomException("User not found with id: " + Id));
    }
    public void deleteCustomer(Integer id){
        customerRepository.deleteById(id);
    }
}
