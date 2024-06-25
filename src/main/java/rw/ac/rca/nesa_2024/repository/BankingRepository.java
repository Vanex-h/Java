package rw.ac.rca.nesa_2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.ac.rca.nesa_2024.entity.Banking;
import rw.ac.rca.nesa_2024.entity.Message;

@Repository
public interface BankingRepository extends JpaRepository<Banking, Integer> {
}
