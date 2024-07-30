package com.isa.hrana_24_7.service;

import com.isa.hrana_24_7.model.Contact;
import com.isa.hrana_24_7.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessage(Contact contact){
        contactRepository.save(contact);
        return true;
    }
}
