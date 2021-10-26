package ru.netology.userauthorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.userauthorizationservice.model.Authorities;
import ru.netology.userauthorizationservice.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Repository
public class UserRepository {

    protected final Map<String, User> database = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (database.containsKey(user)) {
            if (database.get(user).getPassword().equals(password)) {
                return database.get(user).getAuthorities();
            } else {
                return Collections.emptyList();
            }
        } else {
            return Collections.emptyList();
        }
    }
}
