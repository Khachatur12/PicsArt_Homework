package com.homeworks.n_8.repo;

import com.homeworks.n_8.models.User;

import java.util.List;

public interface UserRepo {
    void saveUser(User user);

    User getUserByUsername(String name);

    List<User> getUsers();
}
