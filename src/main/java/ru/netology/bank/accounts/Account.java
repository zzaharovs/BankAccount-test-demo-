package ru.netology.bank.accounts;

public abstract class Account {

    protected int balance;
    protected String name;

    Account(int balance, String name) {

        this.balance = balance;
        this.name = name;

    }

    Account(String name) {

        this.name = name;
        this.balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    abstract public boolean pay(int amount);

    abstract public boolean transfer(Account account, int amount);

    abstract public boolean addMoney(int amount);

    @Override
    public String toString() {
        return name;
    }
}
