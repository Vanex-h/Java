package rw.ac.rca.nesa_2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.ac.rca.nesa_2024.entity.Withdraw;
@Repository
public interface WithdrawRepository extends JpaRepository<Withdraw, Integer> {
}