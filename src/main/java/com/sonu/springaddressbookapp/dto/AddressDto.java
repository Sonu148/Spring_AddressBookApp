package com.sonu.springaddressbookapp.dto;

public class AddressDto {
    private Long id;
    private String name;
    private String emailId;
    private String address;
    private String mobileNumber;

    public AddressDto(Long id, String name, String emailId, String address, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }

    // Getters and Setters
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
