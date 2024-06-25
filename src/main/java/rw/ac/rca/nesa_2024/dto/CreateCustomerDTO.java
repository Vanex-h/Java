package rw.ac.rca.nesa_2024.dto;

import lombok.Data;

import java.util.Date;
@Data
public class CreateCustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private Date dob;
    private String account;
    private Long balance;
    private Date lastUpdateTime;
    public CreateCustomerDTO(){

    }

    public CreateCustomerDTO(String firstName, String lastName, String email, String mobile, Date dob, String account, Long balance, Date lastUpdateTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.dob = dob;
        this.account = account;
        this.balance = balance;
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public Date getDob() {
        return dob;
    }

    public String getAccount() {
        return account;
    }

    public Long getBalance() {
        return balance;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
