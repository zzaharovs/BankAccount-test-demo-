package ru.netology.bank.accounts;

public class CreditAccount extends Account {


    public CreditAccount(String name) {
        super(name);
    }

    @Override
    public boolean pay(int amount) {

        if (amount <= 0) {
            System.out.println("Введите корректную сумму");
            return false;
        }

        this.balance -= amount;
        System.out.printf("Платеж со счета %s выполнен. Сумма платежа составила %d. Баланс счета: %d \n",
                this, amount, this.balance);
        return true;
    }

    @Override
    public boolean transfer(Account account, int amount) {

        if (amount <= 0) {
            System.out.println("Введите корректную сумму");
            return false;
        }
        //Делаем запись об отправке перевода, проводим транзакцию и записываем ее результат в переменную
        System.out.printf("Перевод со счета %s на счет %s отправлен. Сумма перевода составила %d \n",
                this, account, amount);
        boolean transactionSuccess = account.addMoney(amount);
        //Проверяем успешно ли прошла транзакция. Если нет - деньги со счета не списываем
        if (transactionSuccess == false) {
            System.out.printf("Перевод на сумму %d возвращен на счет %s \n", amount, this);
            return false;
        }
        ;
        //списываем деньги со счета
        this.balance -= amount;
        // account.addMoney(amount);
        return true;


    }

    @Override
    public boolean addMoney(int amount) {


        if (amount <= 0) {
            System.out.println("Введите корректную сумму");
            return false;
        }

        //Проверяем, не уйдет ли в плюс баланс счета после пополнения. Если все ок, то
        if ((balance + amount) <= 0) {
            //Пополняем счет
            this.balance += amount;
            System.out.printf("Пополнение счета %s на сумму %d успешно! Текущий баланс: %d \n",
                    this, amount, this.balance);
            return true;
            //Иначе выводим сообщение о некорретности суммы
        } else {
            System.out.printf("Баланс на счете %s составляет %d. Сумма платежа больше, чем сумма долга на %d. " +
                    "Скорректируйте сумму платежа. \n", this, this.balance, (amount + this.balance));
            return false;
        }

    }

    @Override
    public String toString() {
        return super.toString() + " кредитный";
    }

}