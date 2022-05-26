package com.bridgelabz.addressbook.model;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 *Created Model class AddressBook with different fields
 */
@Entity
@Data
public class AddressBook {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    @ElementCollection
    @CollectionTable(name = "city",joinColumns = @JoinColumn(name = "id"))
    private List<String> city;
    private String state;
    private Integer zip;

    public AddressBook() {
        super();
    }

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.firstName=addressBookDTO.getFirstName();
        this.lastName=addressBookDTO.getLastName();
        this.email=addressBookDTO.getEmail();
        this.phoneNumber=addressBookDTO.getPhoneNumber();
        this.city=addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.zip=addressBookDTO.getZip();
    }
    public AddressBook(Integer id,AddressBookDTO addressBookDTO) {
        this.id = id;
        this.firstName=addressBookDTO.getFirstName();
        this.lastName=addressBookDTO.getLastName();
        this.email=addressBookDTO.getEmail();
        this.phoneNumber=addressBookDTO.getPhoneNumber();
        this.city=addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.zip=addressBookDTO.getZip();
    }
}
