package com.homeworks.n_7.menu;

import java.util.Scanner;

public abstract class Menu {
    protected boolean isActive;
    protected Scanner scanner;
    protected String message;

    public Menu(String message){
        this.message = message;
    }

    public void start() {
        isActive = true;
        scanner = new Scanner(System.in);

        repeat();

//        scanner.close();
    }

    protected abstract void repeat();
}
