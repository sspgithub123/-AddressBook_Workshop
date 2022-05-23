package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
}
