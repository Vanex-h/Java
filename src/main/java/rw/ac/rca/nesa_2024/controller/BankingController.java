package rw.ac.rca.nesa_2024.controller;

import rw.ac.rca.nesa_2024.dto.CreateBankDTO;
import rw.ac.rca.nesa_2024.entity.Banking;
import rw.ac.rca.nesa_2024.entity.Customer;
import rw.ac.rca.nesa_2024.service.BankingService;
import rw.ac.rca.nesa_2024.service.CustomerService;

public class BankingController {
    private final CustomerService customerService;
    private final BankingService bankService;

    public BankingController(CustomerService customerService, BankingService bankService) {
        this.customerService = customerService;
        this.bankService = bankService;
    }

    public void addBank(CreateBankDTO createBankDTO){
        Banking bank = new Banking();
        Customer customer = customerService.getCustomerById(createBankDTO.getCustomerId());
        bank.setCustomer(customer);
        bank.setAccount(createBankDTO.getAccount());
        bank.setAmount(createBankDTO.getAmount());
        bank.setBankingDateTime(createBankDTO.getBankingDateTime());
        bank.setCustomer(customerService.getCustomerById(createBankDTO.getCustomerId()));
        bankService.addBanking(bank);
    }


}
