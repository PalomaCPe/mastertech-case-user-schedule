package com.mastertech.schedule.service;

import com.mastertech.schedule.model.Contact;
import com.mastertech.schedule.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Contact save(Contact contact) {
        contact = contactRepository.save(contact);
        return contact;
    }

    public List<Contact> getContact(Integer userId) {
        Iterable<Contact> contacts = contactRepository.findAllByUserId(userId);

        return (List<Contact>) contacts;
    }
}