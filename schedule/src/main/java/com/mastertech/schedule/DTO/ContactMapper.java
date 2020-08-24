package com.mastertech.schedule.DTO;

import com.mastertech.schedule.model.Contact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactMapper {

    public Contact toContact(ContactRequest contactRequest, Integer userId) {
        Contact contact = new Contact();
        contact.setName(contactRequest.getName());
        contact.setPhone(contactRequest.getPhone());
        contact.setUserId(userId);
        return contact;
    }

    public ContactResponse toContactResponse(Contact contact) {
        ContactResponse contactResponse = new ContactResponse();
        contactResponse.setName(contact.getName());
        contactResponse.setPhone(contact.getPhone());
        return contactResponse;
    }

    public List<ContactResponse> toListContactResponse(List<Contact> listContact) {
        List<ContactResponse> listContactResponse = new ArrayList<ContactResponse>();

        listContact.forEach(n -> listContactResponse.add(
                new ContactResponse(n.getName(),n.getPhone())));

        return listContactResponse;
    }

}
