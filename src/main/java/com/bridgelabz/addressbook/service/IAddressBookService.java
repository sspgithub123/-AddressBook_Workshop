package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;

import java.util.List;
import java.util.Optional;

/**
 * Created IAddressBookService interface to achieve abstraction
 */

// Created IAddressBookService interface to achieve abstraction
public interface IAddressBookService {

    AddressBook saveAddress(AddressBookDTO addressBookDTO);

    List<AddressBook> getListOfAddresses();

    AddressBook updateDateById(Integer id, AddressBookDTO addressBookDTO);

    void deleteContact(Integer id);

    Object getAddressById(Integer id);
}
