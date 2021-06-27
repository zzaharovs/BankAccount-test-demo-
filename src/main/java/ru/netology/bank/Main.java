package ru.netology.bank;

import ru.netology.bank.accounts.CheckingAccount;
import ru.netology.bank.accounts.CreditAccount;
import ru.netology.bank.accounts.SavingAccount;

public class Main {

    public static void main(String[] args) {


        CheckingAccount checkSber = new CheckingAccount(1000, "Сбербанк");
        CreditAccount credAlpha = new CreditAccount ("Альфа-банк");
        SavingAccount savingUbrr = new SavingAccount("УБРиР");

        System.out.println("________________________________");
        checkSber.pay(1000);

        System.out.println("________________________________");
        credAlpha.pay(10000);

        System.out.println("________________________________");
        checkSber.addMoney(100);

        System.out.println("________________________________");
        credAlpha.transfer(checkSber, 300);

        System.out.println("________________________________");
        credAlpha.addMoney(5000);

        System.out.println("________________________________");
        credAlpha.addMoney(10000);

        System.out.println("________________________________");
        savingUbrr.pay(100);

        System.out.println("________________________________");
        savingUbrr.addMoney(10000);

        System.out.println("________________________________");
        savingUbrr.transfer(checkSber, 1000);

        System.out.println("________________________________");
        savingUbrr.transfer(credAlpha, 5500);

        System.out.println("________________________________");


    }
}
