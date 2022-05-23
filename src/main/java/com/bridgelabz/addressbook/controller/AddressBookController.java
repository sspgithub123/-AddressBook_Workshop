package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    @Autowired
    AddressBookRepository repository;

    /**
     * Print welcome message
     */
    @GetMapping("/hello")
    public String getMessage() {
        return "Welcome the Address Book App";
    }

    @PostMapping("/add-data")
    public AddressBook PostAddress(@RequestBody AddressBook addressBook){
        AddressBook newAddressBook = new AddressBook(addressBook);
        repository.save(newAddressBook);
        return newAddressBook;
    }

    /**
     * Get all data to repository
     */
    @GetMapping("/get-all")
    public List<AddressBook> getAddress(){
        List<AddressBook> addressBook = repository.findAll();
        return addressBook;
    }

    /**
     * To get data by id to repository
     */
    @GetMapping("/get-by/{id}")
    public AddressBook getAddressById(@PathVariable Integer id){
        Optional<AddressBook> addressBook = repository.findById(id);
        return addressBook.get();
    }

    /**
     * Update  data in the repository by id
     */
    @PutMapping("/update-by/{id}")
    public AddressBook updateById(@PathVariable Integer id, @RequestBody AddressBook addressBook){
        AddressBook newAddressBook = new AddressBook(addressBook, id);
        repository.save(newAddressBook);
        return newAddressBook;
    }

    /**
     * Delete  data by id in the repository
     */
    @DeleteMapping("/delete-by/{id}")
    public String deleteAddress(@PathVariable Integer id){
        repository.deleteById(id);
        return "Address of id:" + id + " has been deleted";
    }
}
