package app;

import serviece.BankServiece;
import serviece.impl.BankServieceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        BankServiece bankServiece = new BankServieceImpl();
        System.out.println("Welcome to Console Bank!!");
        boolean running = true;
        while(running){
            System.out.println("""
                1. Open Account
                2. Deposit
                3. Withdraw
                4. Transfer
                5. Account Statement
                6. List Accounts
                7. Search Accounts by Customer Name
                0. Exit
                """);
            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine().trim();
            System.out.println("Your choice: " + choice);
            System.out.println();

            switch(choice){
                case "1" -> openAccount(scanner, bankServiece);
                case "2" -> deposit(scanner);
                case "3" -> withdraw(scanner);
                case "4" -> transfer(scanner);
                case "5" -> statement(scanner);
                case "6" -> listAccounts(scanner);
                case "7" -> searchAccounts(scanner);
                case "0" -> running = false;

            }
        }

    }
    private static void openAccount(Scanner scanner, BankServiece bankServiece){
        System.out.println("Customer Name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Customer email: ");
        String email = scanner.nextLine().trim();
        System.out.println("Account Type (SAVINGS/CURRENT): ");
        String type = scanner.nextLine().trim();
        System.out.println("Initial deposit (Optional): ");
        String amountStr = scanner.nextLine().trim();
        Double initial = Double.valueOf(amountStr);
        bankServiece.openAccount(name, email, type);


    }

    private static void deposit(Scanner scanner){

    }

    private static void withdraw(Scanner scanner){

    }

    private static void transfer(Scanner scanner){

    }

    private static void statement(Scanner scanner){

    }

    private static void listAccounts(Scanner scanner){

    }

    private static void searchAccounts(Scanner scanner){

    }



}
