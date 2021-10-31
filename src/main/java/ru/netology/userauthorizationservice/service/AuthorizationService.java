package ru.netology.userauthorizationservice.service;

import org.springframework.stereotype.Service;
import ru.netology.userauthorizationservice.exception.UnauthorizedUser;
import ru.netology.userauthorizationservice.model.Authorities;
import ru.netology.userauthorizationservice.model.User;
import ru.netology.userauthorizationservice.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}


