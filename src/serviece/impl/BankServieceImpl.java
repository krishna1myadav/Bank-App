package serviece.impl;

import domain.Account;
import serviece.BankServiece;

import java.util.UUID;

public class BankServieceImpl implements BankServiece {
    @Override
    public String openAccount(String name, String email, String accountType) {

        String customerId = UUID.randomUUID().toString();
        String accountNumber = UUID.randomUUID().toString();
        Account a = new Account(accountNumber, customerId, (double) 0 , accountType );

        return "";
    }


}
