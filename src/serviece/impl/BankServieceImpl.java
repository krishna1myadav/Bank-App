package serviece.impl;

import domain.Account;
import repository.AccountRepository;
import serviece.BankServiece;

import java.util.UUID;

public class BankServieceImpl implements BankServiece {

    private final AccountRepository accountRepository = new AccountRepository();
    @Override
    public String openAccount(String name, String email, String accountType) {

        String customerId = UUID.randomUUID().toString();


        //String accountNumber = UUID.randomUUID().toString();
        String temp = accountRepository.findAll().size() + 1;
        String accountNumber = String.format("AC%06d", temp);
        Account account = new Account(accountNumber, customerId, (double) 0 , accountType );
        accountRepository.save(account);
        return accountNumber;
    }


}
