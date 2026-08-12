package serviece;

import domain.Account;

import java.util.List;

public interface BankServiece {
    String openAccount(String name, String email, String accountType);
    List<Account> listAccounts();

}
