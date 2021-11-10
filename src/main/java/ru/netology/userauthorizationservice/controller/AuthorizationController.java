package ru.netology.userauthorizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.userauthorizationservice.exception.UnauthorizedUser;
import ru.netology.userauthorizationservice.model.Authorities;
import ru.netology.userauthorizationservice.model.User;
import ru.netology.userauthorizationservice.service.AuthorizationService;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity<String> handleUnauthorizedUserException(UnauthorizedUser e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
