package com.codecool_mjs.view;

import java.util.Scanner;

public class LoginView {

    private static Scanner scanner = new Scanner()

    public static String getEmail() {

        String email;

        System.out.print("Enter email: ");
        email = scanner.next();
        return email;
    }

    public static String getPassword() {

        String password;

        System.out.print("Enter password: ");
        password = scanner.next();
        return password;
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
