package com.mastertech.schedule.controller;

import com.mastertech.schedule.DTO.ContactMapper;
import com.mastertech.schedule.DTO.ContactRequest;
import com.mastertech.schedule.DTO.ContactResponse;
import com.mastertech.schedule.model.Contact;
import com.mastertech.schedule.security.AuthContact;
import com.mastertech.schedule.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ContactController {

    Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    ContactMapper contactMapper;

    @Autowired
    ContactService contactService;

    @PostMapping("/{contact}")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactResponse saveContact(@RequestBody ContactRequest contactRequest, @AuthenticationPrincipal AuthContact authContact) {

        logger.info("Salvando contact " + contactRequest.getName() );

        Contact contact = contactMapper.toContact(contactRequest, authContact.getId());
        contact = contactService.save(contact);
        return contactMapper.toContactResponse(contact);
    }

    @GetMapping("/{contacts}")
    public List<ContactResponse> listContact(@AuthenticationPrincipal AuthContact authContact) {

        logger.info("Buscando lista de contact do usuario : " + authContact.getName());

        List<Contact> contacts = contactService.getContact(authContact.getId());
        return contactMapper.toListContactResponse(contacts);

    }

}