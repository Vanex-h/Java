package rw.ac.rca.nesa_2024.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.nesa_2024.dto.CreateWithDrawDTO;
import rw.ac.rca.nesa_2024.entity.Customer;
import rw.ac.rca.nesa_2024.entity.Withdraw;
import rw.ac.rca.nesa_2024.service.CustomerService;
import rw.ac.rca.nesa_2024.service.WithdrawService;

@RestController
@RequestMapping("/withdraw")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class WithDrawController {
    private final WithdrawService withDrawService;

    private final CustomerService customerService;

    public WithDrawController(WithdrawService withDrawService, CustomerService customerService) {
        this.withDrawService = withDrawService;
        this.customerService = customerService;
    }

    @PostMapping("/addNewWithdraw")
    private String addWithdraw(@RequestBody CreateWithDrawDTO createWithdrawDTO) {
        try {
            Customer customer= customerService.getCustomerById(createWithdrawDTO.getCustomerId());

            Withdraw w= new Withdraw();
            w.setCustomer(customer);
            w.setAmount(createWithdrawDTO.getAmount());
            w.setBankingDateTime(createWithdrawDTO.getBankingDateTime());


            withDrawService.addWithdraw(w);
            return "Withdraw added successfully";

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
