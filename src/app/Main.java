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
                case "2" -> deposit(scanner, bankServiece);
                case "3" -> withdraw(scanner, bankServiece);
                case "4" -> transfer(scanner, bankServiece);
                case "5" -> statement(scanner, bankServiece);
                case "6" -> listAccounts(scanner, bankServiece);
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
        String accountNumber = bankServiece.openAccount(name, email, type);
        if( initial > 0)
            bankServiece.deposit(accountNumber, initial, "Initial deposit");
        System.out.println("Account opened: " + accountNumber);


    }

    private static void deposit(Scanner scanner, BankServiece bankServiece){
        System.out.println("Account Number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankServiece.deposit(accountNumber, amount, "Deposit");
        System.out.println("Amount Deposited!!");

    }

    private static void withdraw(Scanner scanner, BankServiece bankServiece){
        System.out.println("Account Number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankServiece.withdraw(accountNumber, amount, "Withdrawal");
        System.out.println("Amount Withdrawn!!");
    }

    private static void transfer(Scanner scanner, BankServiece bankServiece){
        System.out.println("From Account: ");
        String fromAccount = scanner.nextLine().trim();
        System.out.println("To Account: ");
        String toAccount = scanner.nextLine().trim();
        System.out.println("how many Account: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankServiece.transfer(fromAccount, toAccount, amount, "Money was Transfered!!!");
        System.out.println("Amount Withdrawn!!");
    }

    private static void statement(Scanner scanner, BankServiece bankServiece){
        System.out.println("Account number: ");
        String account = scanner.nextLine().trim();
        bankServiece.getStatement(account).forEach( t -> {
            System.out.println(t.getTimestamp() + " | " + t.getType() + " | " + t.getAmount() + " | " + t.getNote());
        });
    }

    private static void listAccounts(Scanner scanner, BankServiece bankServiece){
         bankServiece.listAccounts().forEach(a -> {
             System.out.println(a.getAccountNumber() + " | " + a.getAccountType() + " | " + a.getBalance());
         });

    }

    private static void searchAccounts(Scanner scanner, BankServiece bankServiece){
        System.out.println("Customer Name Contains: ");
        String q = scanner.nextLine().trim();
        bankServiece.searchAccountByCustomerName(q);
    }



}
