package com.homeworks.n_8.validate;

import com.homeworks.n_8.models.User;

public interface UserValidator {
    void validateUsername(String username);

    void validateEmail(String email);

    void validatePassword(String password);

    void validateUser(User user);
}
