package com.codecool_mjs.view;

import java.util.Scanner;

public class LoginView {

    private static Scanner scanner;

    public static String getEmail() {

        scanner = new Scanner(System.in);
        String email;

        System.out.print("Enter email: ");
        email = scanner.next();
        return email;
    }

    public static String getPassword() {

        scanner = new Scanner(System.in);
        String password;

        System.out.print("Enter password: ");
        password = scanner.next();
        return password;
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
