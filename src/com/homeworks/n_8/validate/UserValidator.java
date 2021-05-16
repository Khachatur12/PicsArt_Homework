package com.homeworks.n_8.validate;

import com.homeworks.n_8.models.User;

public interface UserValidator {
    void validateUsername(User user);

    void validateEmail(User user);

    void validatePassword(User user);

    void validateUser(User user);
}
