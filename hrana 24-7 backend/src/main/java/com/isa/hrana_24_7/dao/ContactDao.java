package com.isa.hrana_24_7.dao;

import com.isa.hrana_24_7.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact,Integer> {
}
