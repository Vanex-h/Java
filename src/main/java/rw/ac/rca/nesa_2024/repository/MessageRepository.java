package rw.ac.rca.nesa_2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.ac.rca.nesa_2024.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
}
