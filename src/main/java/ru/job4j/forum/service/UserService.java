package ru.job4j.forum.service;

import org.postgresql.util.PSQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.job4j.forum.exception.UsernameAlreadyExistsException;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserRepository;

@Service
public class UserService {

    private UserRepository store;

    public UserService(UserRepository store) {
        this.store = store;
    }

    public void save(User user) {
        try {
            store.save(user);
        } catch (DataAccessException err) {
            if (err.getMostSpecificCause() instanceof PSQLException
                    && "23505".equals(((PSQLException) err.getMostSpecificCause()).getSQLState())) {
                throw new UsernameAlreadyExistsException("Username already exists");
            }
        }
    }
}
