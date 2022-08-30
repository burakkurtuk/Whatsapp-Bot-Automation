package org.example;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Please write here name or number : ");
        String toWhom = scanner.nextLine();
        System.out.println("Please write your message : ");
        String text = scanner.nextLine();



        App app = new App();
        app.findPerson(toWhom);
        app.sendMessage(text);

    }
}

