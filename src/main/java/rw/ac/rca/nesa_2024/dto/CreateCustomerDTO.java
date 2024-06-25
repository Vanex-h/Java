package rw.ac.rca.nesa_2024.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CreateCustomerDTO {
//    @NotEmpty(message = "First Name is required!")
//    @Size(min = 3, max = 100, message = "First Name must be between 3 and 100 characters")
    private String firstName;
//    @NotNull(message = "Last Name is required!")
//    @Size(min = 3, max = 100, message = "Last Name must be between 3 and 100 characters")
    private String lastName;
//    @Email(message = "Email must be a valid email non address")
    private String email;
//    @NotNull(message = "Mobile is required!")
//    @Size(min = 10, max = 13, message = " Mobile must be between 3 and 100 characters")
    private String mobile;
//    @NotNull(message = "Date of Birth is required!")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
}
