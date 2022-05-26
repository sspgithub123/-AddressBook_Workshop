package com.bridgelabz.addressbook.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressBookDTO {
    @NotEmpty(message="First name cant be empty")
    @Pattern(regexp="^[A-Z]{1}[a-zAZ\\s]{2,}$",message="Employee firstName is Invalid")
    private String firstName;

    @NotEmpty(message="Last name cant be empty")
    @Pattern(regexp="^^[A-Z]{1}[a-zAZ\\s]{2,}$",message="Employee lastName is Invalid")
    private String lastName;

    @NotEmpty(message="Email cant be empty")
    private String email;

    @NotNull(message="Phone number cant be empty")
    private Long phoneNumber;

    @NotEmpty(message="city cant be empty")
    private String city;

    @NotEmpty(message="State cant be empty")
    private String state;

    @NotNull(message="Zip code cant be empty")
    private Integer zip;

    public AddressBookDTO() {
        super();
    }
}