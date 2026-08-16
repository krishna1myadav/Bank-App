package serviece;

import domain.Account;
import domain.Transaction;

import java.util.List;

public interface BankServiece {
    String openAccount(String name, String email, String accountType);
    List<Account> listAccounts();

    void deposit(String accountNumber, Double amount, String note);
    void withdraw(String accountNumber, Double amount, String withdrawal);
    void transfer(String fromAccount, String toAccount, Double amount, String s);

    List<Transaction> getStatement(String account);

    List<Account> searchAccountByCustomerName(String q);
}
