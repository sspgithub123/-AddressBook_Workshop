package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * In Controller class we write the APIs here
 */
@RestController
@RequestMapping("/address-book")
public class AddressBookController {

    /**
     * @Autowired annotation act as a dependency injection we can inject object of another class
     */
    @Autowired
    AddressBookService service;

    @GetMapping("/hello")
    public String getMessage() {
        return "Welcome to Address-book App";
    }

    @GetMapping("/get-all")
    public ResponseEntity<String> getAllData() {
        List<AddressBook> listOfContacts = service.getListOfAddresses();
        ResponseDTO response = new ResponseDTO("Address-book :", listOfContacts);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> postData(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBook newContact = service.saveAddress(addressBookDTO);
        ResponseDTO response = new ResponseDTO("New Contact Added in Address-book : ", newContact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @GetMapping("/get-by/{id}")
    public ResponseEntity<AddressBook> getAddressById(@PathVariable Integer id) {
        ResponseDTO response = new ResponseDTO("Address-book of given id: ", service.getAddressbyId(id));
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("/update-by/{id}")
    public ResponseEntity<ResponseDTO> updateById(@PathVariable Integer id, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook newContact = service.updateDateById(id, addressBookDTO);
        ResponseDTO response = new ResponseDTO("Address-book updated : ", newContact);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete-by/{id}")
    public ResponseEntity<String> deleteDataById(@PathVariable Integer id) {
        service.deleteContact(id);
        return new ResponseEntity<String>("Contact deleted successfully", HttpStatus.OK);
    }
}