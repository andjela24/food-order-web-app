package com.isa.hrana_24_7.controller;

import com.isa.hrana_24_7.model.Contact;
import com.isa.hrana_24_7.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public boolean contactUs(@RequestBody Contact contact, Model model){
        return contactService.saveMessage(contact);
    }
}
