package rw.ac.rca.nesa_2024.service;

import rw.ac.rca.nesa_2024.entity.Banking;
import rw.ac.rca.nesa_2024.entity.Message;
import rw.ac.rca.nesa_2024.repository.BankingRepository;
import rw.ac.rca.nesa_2024.repository.MessageRepository;

public class BankingService {
    private final BankingRepository bankingRepository;
    private final CustomerService customerService;

    public BankingService(BankingRepository bankingRepository, CustomerService customerService) {
        this.bankingRepository = bankingRepository;
        this.customerService = customerService;
    }
    public void addBanking(Banking bank){
        bankingRepository.save(bank);
    }
}
