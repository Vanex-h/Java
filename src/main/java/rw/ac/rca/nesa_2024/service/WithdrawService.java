package rw.ac.rca.nesa_2024.service;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;
import rw.ac.rca.nesa_2024.entity.Withdraw;
import rw.ac.rca.nesa_2024.repository.SavingRepository;
import rw.ac.rca.nesa_2024.repository.WithdrawRepository;
@Service
public class WithdrawService {
    private final CustomerService customerService;
    private final WithdrawRepository withdrawRepository;

    public WithdrawService(CustomerService customerService, WithdrawRepository withdrawRepository) {
        this.customerService = customerService;
        this.withdrawRepository = withdrawRepository;
    }
    public void addWithdraw(Withdraw withdraw){
        withdrawRepository.save(withdraw);
    }
}
