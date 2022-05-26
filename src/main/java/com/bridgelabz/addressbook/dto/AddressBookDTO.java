package com.bridgelabz.addressbook.dto;

import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.validation.constraints.*;
import java.util.List;

@Data
public class AddressBookDTO {
    @NotEmpty(message="First name cant be empty")
    @Pattern(regexp="^[A-Z]{1}[a-zAZ\\s]{2,}$",message="Employee firstName is Invalid")
    private String firstName;

    @NotEmpty(message="Last name cant be empty")
    @Pattern(regexp="^[A-Z]{1}[a-zAZ\\s]{2,}$",message="Employee lastName is Invalid")
    private String lastName;

    @NotEmpty(message="Email cant be empty")
    private String email;

    @NotNull(message="Phone number cant be empty")
    private Long phoneNumber;

    @ElementCollection
    @CollectionTable(name = "city", joinColumns = @JoinColumn(name = "id"))
    private List<String> city;

    @NotEmpty(message="State cant be empty")
    private String state;

    @NotNull(message="Zip code cant be empty")
    private Integer zip;

    public AddressBookDTO() {
        super();
    }
}