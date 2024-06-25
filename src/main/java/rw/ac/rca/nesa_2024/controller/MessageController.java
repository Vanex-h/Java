package rw.ac.rca.nesa_2024.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.nesa_2024.dto.CreateMessageDTO;
import rw.ac.rca.nesa_2024.entity.Customer;
import rw.ac.rca.nesa_2024.entity.Message;
import rw.ac.rca.nesa_2024.service.CustomerService;
import rw.ac.rca.nesa_2024.service.MessageService;
@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private  CustomerService customerService;
    @Autowired
    private  MessageService messageService;

//    public MessageController(CustomerService cs, MessageService messageService) {
//        this.cs = cs;
//        this.messageService = messageService;
//    }
    @PostMapping("/addNewMessage")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    private String addMessage(@RequestBody CreateMessageDTO dto) {
        try {
            System.out.println(dto.getCustomerId());
            Customer customer= customerService.getCustomerById(dto.getCustomerId());
            System.out.println("The customer======>"+customer);
            Message message= new Message();
            message.setCustomer(customer);
            message.setMessage(dto.getMessage());
            messageService.addMessage(message);
            return "Message added successfully";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
