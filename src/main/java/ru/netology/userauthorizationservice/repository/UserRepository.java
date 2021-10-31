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

    protected final Map<User, List<Authorities>> database = new ConcurrentHashMap<>();

    public List<Authorities> getUserAuthorities(User user) {
        if (database.containsKey(user)) {
            return database.get(user);
        } else {
            return Collections.emptyList();
        }
    }
}
