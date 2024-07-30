package com.isa.hrana_24_7.repository;

import com.isa.hrana_24_7.model.Cart;
import com.isa.hrana_24_7.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
