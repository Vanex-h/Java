package rw.ac.rca.nesa_2024.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Banking {
    @Id
    @GeneratedValue
    private int id;
    private String account;
    private Long amount;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    private String type;

    private Date bankingDateTime;

    public void setType() {
        this.type = "transfer";
    }
}
