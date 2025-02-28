package com.sonu.springaddressbookapp.entity;
import javax.persistence.*;

@Entity
@Table(name = "address_book")  // Custom table name
public class AddressEntity {

    @Id
    @Column(name="id")
    private Long id;

    @Column(name = "full_name")  // Custom column name
    private String name;

    @Column(name = "email_address")  // Custom column name
    private String emailId;

    @Column(name = "address")  // Custom column name (optional, as it matches the field name)
    private String address;

    @Column(name = "mobile_number")  // Custom column name
    private String mobileNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
