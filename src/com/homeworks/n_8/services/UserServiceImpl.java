package com.homeworks.n_8.services;

import com.homeworks.n_8.models.User;
import com.homeworks.n_8.repo.UserRepo;
import com.homeworks.n_8.repo.UserRepoImpl;
import com.homeworks.n_8.validate.UserValidateException;
import com.homeworks.n_8.validate.UserValidator;

import java.security.MessageDigest;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private UserValidator userValidator;
    private MessageDigest md;

    public UserServiceImpl(UserRepo userRepo, UserValidator userValidator, MessageDigest md) {
        this.userRepo = userRepo;
        this.userValidator = userValidator;
        this.md = md;
    }

    @Override
    public void registration(User user) {
        userValidator.validateUser(user);

        // Generate password to an MD5 hash
        md.update(user.getPassword().getBytes());
        byte[] digest = md.digest();
        user.setPassword(new String(digest));

        userRepo.saveUser(user);
    }

    @Override
    public String login(String username, String password) {
        // checking user
        User userByUsername = userRepo.getUserByUsername(username);
        if (userByUsername == null) {
            return "Invalid input data";
        }


        // checking user password
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String md5Password = new String(digest);
        if (!userByUsername.getPassword().equals(md5Password)) {
            return "Invalid input data";
        }


        // login
        return "Login success";
    }

    @Override
    public User inputUser(Scanner scanner) {
        User user = new User();
        boolean canContinue = true;
        System.out.print("input full name: ");
        user.setFullName(scanner.nextLine());

        do {
            System.out.print("input username: ");
            user.setUsername(scanner.nextLine());
            try {
                userValidator.validateUsername(user);
                canContinue = true;
            } catch (UserValidateException e) {
                System.out.println(e.getMessage());
                canContinue = false;
            }
        } while (!canContinue);

        do {
            System.out.print("input email: ");
            user.setEmail(scanner.nextLine());
            try {
                userValidator.validateEmail(user);
                canContinue = true;
            } catch (UserValidateException e) {
                System.out.println(e.getMessage());
                canContinue = false;
            }
        } while (!canContinue);

        do {
            System.out.print("input password: ");
            user.setPassword(scanner.nextLine());
            try {
                userValidator.validatePassword(user);
                canContinue = true;
            } catch (UserValidateException e) {
                System.out.println(e.getMessage());
                canContinue = false;
            }
        } while (!canContinue);


        return user;
    }


    public UserValidator getUserValidator() {
        return userValidator;
    }

    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

}
