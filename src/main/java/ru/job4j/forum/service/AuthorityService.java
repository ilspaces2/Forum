package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.repository.AuthorityRepository;

@Service
public class AuthorityService {

    private AuthorityRepository store;

    public AuthorityService(AuthorityRepository store) {
        this.store = store;
    }

    public Authority findByAuthority(String authority) {
        return store.findByAuthority(authority);
    }
}
