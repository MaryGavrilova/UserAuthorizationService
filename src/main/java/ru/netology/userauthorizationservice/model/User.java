package ru.netology.userauthorizationservice.model;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class User {
    @NonNull
    protected final String login;
    @NonNull
    protected String password;
    @NonNull
    protected List<Authorities> authorities;
}
