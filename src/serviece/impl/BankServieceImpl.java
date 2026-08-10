package serviece.impl;

import serviece.BankServiece;

import java.util.UUID;

public class BankServieceImpl implements BankServiece {
    @Override
    public String opentAccount(String name, String email, String accountType) {

        String customerId = UUID.randomUUID().toString();
        String accountNumber = UUID.randomUUID().toString();

        return "";
    }

}
