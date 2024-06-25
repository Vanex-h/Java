package rw.ac.rca.nesa_2024.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.nesa_2024.dto.CreateSavingDTO;
import rw.ac.rca.nesa_2024.dto.CreateWithDrawDTO;
import rw.ac.rca.nesa_2024.entity.Customer;
import rw.ac.rca.nesa_2024.entity.Saving;
import rw.ac.rca.nesa_2024.entity.Withdraw;
import rw.ac.rca.nesa_2024.service.CustomerService;
import rw.ac.rca.nesa_2024.service.SavingService;
import rw.ac.rca.nesa_2024.service.WithdrawService;
@RestController
@RequestMapping("/saving")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class SavingController {
    private final SavingService savingService;

    private final CustomerService customerService;

    public SavingController(SavingService savingService, CustomerService customerService) {
        this.savingService = savingService;
        this.customerService = customerService;
    }

    @PostMapping("/addNewSaving")
    private String addWithdraw(@RequestBody CreateSavingDTO createSavingDTO) {
        try {
            Customer customer= customerService.getCustomerById(createSavingDTO.getCustomerId());

            Saving s= new Saving();
            s.setCustomer(customer);
            s.setAmount(createSavingDTO.getAmount());
            s.setBankingDateTime(createSavingDTO.getBankingDateTime());
            savingService.addSaving(s);
            return "Withdraw added successfully";

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
