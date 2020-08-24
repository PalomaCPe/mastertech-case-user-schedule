package com.mastertech.schedule.repository;

import com.mastertech.schedule.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

    Iterable<Contact> findAllByUserId(Integer userId);

}
