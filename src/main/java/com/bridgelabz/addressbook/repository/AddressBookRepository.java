package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
    @Query(value = "SELECT * FROM address_book a, city ac WHERE a.id = ac.id AND ac.city = :city", nativeQuery = true)
    List<AddressBook> findByCity(@Param("city") String city);
}
