package com.mastertech.schedule.security;

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import java.util.Map;

public class ContactPrincipalExtractor implements PrincipalExtractor{
    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        AuthContact authContact = new AuthContact();

        authContact.setId((Integer) map.get("id"));
        authContact.setName((String) map.get("name"));

        return authContact;
    }
}
