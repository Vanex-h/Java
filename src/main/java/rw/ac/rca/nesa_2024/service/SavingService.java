package rw.ac.rca.nesa_2024.service;

import org.springframework.stereotype.Service;
import rw.ac.rca.nesa_2024.entity.Saving;
import rw.ac.rca.nesa_2024.repository.SavingRepository;
@Service
public class SavingService {
    private final CustomerService customerService;
    private final SavingRepository savingRepository;

    public SavingService(CustomerService customerService, SavingRepository savingRepository) {
        this.customerService = customerService;
        this.savingRepository = savingRepository;
    }

    public void addSaving(Saving saving){
        savingRepository.save(saving);
    }
}
