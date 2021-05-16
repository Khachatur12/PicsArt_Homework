package com.homeworks.n_8.validate;

import com.homeworks.n_8.models.User;
import com.homeworks.n_8.repo.UserRepo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidatorImpl implements UserValidator {
    private UserRepo userRepo;

    public UserValidatorImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void validateUsername(String username) {
        // checking username duplicate
        User userByUsername = userRepo.getUserByUsername(username);
        if (userByUsername != null) {
            throw new UserValidateException("Username is already taken: " + username);
        }

        // checking username length
        if (username.length() < 11) {
            throw new UserValidateException("Username length must be more than 10 characters");
        }

    }

    @Override
    public void validateEmail(String email) {
        // checking email
        Pattern pattern = Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[\\w]{2,6}$");
        Matcher matcher = pattern.matcher(email);

        if (!matcher.find()) {
            throw new UserValidateException("Invalid email: " + email);
        }
    }

    @Override
    public void validatePassword(String password) {
        // checking password length
        if (password.length() < 9) {
            throw new UserValidateException("Password length must be more than 8 characters");
        }


        // checking 2 uppercase letters
        Pattern pattern = Pattern.compile("[A-Z].*[A-Z]");
        Matcher matcher = pattern.matcher(password);
        if (!matcher.find()) {
            throw new UserValidateException("Password must contain at least 2 uppercase letters: " + password);
        }

        // checking 3 numbers
        pattern = Pattern.compile("([0-9].*){3,}");
        matcher = pattern.matcher(password);
        if (!matcher.find()) {
            throw new UserValidateException("Invalid email: " + password);
        }
    }

    @Override
    public void validateUser(User user) {
        validateUsername(user.getUsername());
        validateEmail(user.getEmail());
        validatePassword(user.getPassword());
    }

}
