package com.homeworks.n_8.services;

import com.homeworks.n_8.models.User;
import com.homeworks.n_8.validate.UserValidator;

import java.util.Scanner;

public interface UserService {
    void registration(User user);

    String login(String username, String password);

    User inputUser(Scanner scanner);
}
