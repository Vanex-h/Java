package rw.ac.rca.nesa_2024.service;

import org.springframework.stereotype.Service;
import rw.ac.rca.nesa_2024.entity.Message;
import rw.ac.rca.nesa_2024.entity.Withdraw;
import rw.ac.rca.nesa_2024.repository.MessageRepository;
@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final CustomerService customerService;

    public MessageService(MessageRepository messageRepository, CustomerService customerService) {
        this.messageRepository = messageRepository;
        this.customerService = customerService;
    }
    public void addMessage(Message message){
        messageRepository.save(message);
    }
}
