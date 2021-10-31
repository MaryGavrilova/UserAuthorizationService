package ru.netology.userauthorizationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Validated
@Data
@AllArgsConstructor
public class User {
    @NotNull(message = "User name is empty")
    @Size(min = 1, max = 8, message = "User name word length is not more then 1 and less than 8")
    protected final String login;

    @NotNull(message = "User password is empty")
    @Size(min = 6, message = "User password combination length is not more then 6")
    protected String password;
}
