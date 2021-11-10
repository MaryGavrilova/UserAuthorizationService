package ru.netology.userauthorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.userauthorizationservice.model.Authorities;
import ru.netology.userauthorizationservice.model.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ru.netology.userauthorizationservice.model.Authorities.*;


@Repository
public class UserRepository {

    protected final Map<User, List<Authorities>> database = new ConcurrentHashMap<>(Map.of(
            new User ("login", "password"), List.of(READ, WRITE, DELETE)
    ));

    public List<Authorities> getUserAuthorities(User user) {
        return database.getOrDefault(user, Collections.emptyList());
    }
}
