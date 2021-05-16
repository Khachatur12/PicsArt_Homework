package com.homeworks.n_8;

import com.homeworks.n_8.menu.Menu;
import com.homeworks.n_8.repo.UserRepo;
import com.homeworks.n_8.repo.UserRepoImpl;
import com.homeworks.n_8.services.FileService;
import com.homeworks.n_8.services.UserService;
import com.homeworks.n_8.services.UserServiceImpl;
import com.homeworks.n_8.validate.UserValidator;
import com.homeworks.n_8.validate.UserValidatorImpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class ProjectInitializer {
    private  static Menu menu;
    private static FileService fileService;
    private static UserRepo userRepo;
    private static UserValidator userValidator;
    private static UserService userService;
    private static Path users_data_path;
    public static final String USER_DATA_SEPARATION = "~_~";


    static {
        fileService = new FileService();
        users_data_path = Paths.get("src/com/homeworks/n_8/data/database.txt");
        userRepo = new UserRepoImpl(fileService, users_data_path, USER_DATA_SEPARATION);
        userValidator = new UserValidatorImpl(userRepo);
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (md == null)
            throw new RuntimeException("Cant create MD5 object");

        userService = new UserServiceImpl(userRepo, userValidator, md);
        menu = new Menu(userService, new Scanner(System.in));
    }


    public static FileService getFileService() {
        return fileService;
    }
    public static UserRepo getUserRepo() {
        return userRepo;
    }
    public static UserValidator getUserValidator() {
        return userValidator;
    }
    public static UserService getUserService() {
        return userService;
    }
    public static Menu getMenu() {
        return menu;
    }
}
