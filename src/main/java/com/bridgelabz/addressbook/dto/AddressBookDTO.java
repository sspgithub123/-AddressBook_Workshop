package com.bridgelabz.addressbook.dto;

import lombok.Data;

@Data
public class AddressBookDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private String city;
    private String state;
    private Integer zip;

    public AddressBookDTO() {
        super();
    }
}
