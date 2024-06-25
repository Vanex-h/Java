package rw.ac.rca.nesa_2024.dto;

import lombok.Data;

import java.util.Date;
@Data
public class CreateMessageDTO {
    Integer customerId;
    String message;
    Date dateTime;
}
