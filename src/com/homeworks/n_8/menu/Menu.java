package com.homeworks.n_8.menu;


import com.homeworks.n_8.models.User;
import com.homeworks.n_8.services.UserService;
import com.homeworks.n_8.validate.UserValidateException;

import java.util.Scanner;

public class Menu {
    private final String message;
    private final Scanner scanner;
    private final UserService userService;

    public Menu(UserService userService, Scanner scanner) {
        this.message = "\n0: exit\n1: Log In\n2: Sing Up\n\nCommand number: ";
        this.scanner = scanner;
        this.userService = userService;
    }

    public void start() {
        boolean isActive = true;

        while (isActive) {
            System.out.println("_______________________________________________________________________");
            System.out.print(message);
            String comm = scanner.next();

            switch (comm) {
                case "0":
                    isActive = false;
                    break;
                case "1":
                    System.out.print("input username: ");
                    String username = scanner.next();
                    System.out.print("input password: ");
                    String password = scanner.next();

                    System.out.println(userService.login(username, password));
                    break;
                case "2":
                    User user = userService.inputUser(new Scanner(System.in));
                    try {
                        userService.registration(user);
                    } catch (UserValidateException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Something went wrong");
                    }
                    break;
                default:
                    System.out.println("Invalid command: " + comm);
            }
        }
    }

}
