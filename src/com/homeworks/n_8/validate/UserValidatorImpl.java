package com.homeworks.n_8.validate;

import com.homeworks.n_8.models.User;
import com.homeworks.n_8.repo.UserRepo;
import com.homeworks.n_8.repo.UserRepoImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidatorImpl implements UserValidator {
    private UserRepo userRepo;

    public UserValidatorImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void validateUsername(User user) {
        // checking username duplicate
        User userByUsername = userRepo.getUserByUsername(user.getUsername());
        if (userByUsername != null) {
            throw new UserValidateException("Username is already taken: " + user.getUsername());
        }

        // checking username length
        if (user.getUsername().length() < 11) {
            throw new UserValidateException("Username length must be more than 10 characters");
        }

    }

    @Override
    public void validateEmail(User user) {
        // checking email
        Pattern pattern = Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[\\w]{2,6}$");
        Matcher matcher = pattern.matcher(user.getEmail());

        if (!matcher.find()) {
            throw new UserValidateException("Invalid email: " + user.getEmail());
        }
    }

    @Override
    public void validatePassword(User user) {
        // checking password length
        if (user.getPassword().length() < 9) {
            throw new UserValidateException("Password length must be more than 8 characters");
        }


        // checking 2 uppercase letters
        Pattern pattern = Pattern.compile("[A-Z].*[A-Z]");
        Matcher matcher = pattern.matcher(user.getPassword());
        if (!matcher.find()) {
            throw new UserValidateException("Password must contain at least 2 uppercase letters: " + user.getPassword());
        }

        // checking 3 numbers
        pattern = Pattern.compile("([0-9].*){3,}");
        matcher = pattern.matcher(user.getPassword());
        if (!matcher.find()) {
            throw new UserValidateException("Invalid email: " + user.getPassword());
        }
    }

    @Override
    public void validateUser(User user) {
        validateUsername(user);
        validateEmail(user);
        validatePassword(user);
    }

}
