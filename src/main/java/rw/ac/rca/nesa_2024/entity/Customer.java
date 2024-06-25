package rw.ac.rca.nesa_2024.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import rw.ac.rca.nesa_2024.audits.TimeStampAudit;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customers")
public class Customer extends TimeStampAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(nullable = false, length = 100)
    private String mobile;
    private Date dob;

    private Date lastUpdateTime;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BankAccount> bankAccounts;

    public Customer(String firstName, String lastName, String email, String mobile, Date dob, Date lastUpdateTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
        this.lastUpdateTime = lastUpdateTime;
    }
}
