package ru.netology.bank.accounts;

public class CheckingAccount extends Account {


    public CheckingAccount(int balance, String name) {
        super(balance, name);
    }

    @Override
    public boolean pay(int amount) {

        if (amount <= 0) {
            System.out.println("Введите корректную сумму");
            return false;
        }

        //Проверяем, не уйдет ли баланс в минус после платежа. Если все ок, то
        if ((this.balance - amount) >= 0) {
            //Списываем деньги и выводим сообщение
            this.balance -= amount;
            System.out.printf("Платеж со счета %s выполнен. Сумма платежа составила %d. Баланс счета: %d \n",
                    this, amount, this.balance);
            return true;
            //Иначе пишем, что денег недостаточно
        } else {
            System.out.println("Сумма платежа превышает остаток средств на счете! Платеж не выполнен");
            return false;
        }
    }

    @Override
    public boolean transfer(Account account, int amount) {

        if (amount <= 0) {
            System.out.println("Введите корректную сумму");
            return false;
        }
        //Если денег хватает
        if ((this.balance - amount) >= 0) {
            //Делаем запись об отправке перевода, проводим транзакцию и записываем ее результат в переменную
            System.out.printf("Перевод со счета %s на счет %s отправлен. Сумма перевода составила %d \n",
                    this, account, amount);
            //Проверяем успешно ли прошла транзакция. Если нет - деньги со счета не списываем
            if (!account.addMoney(amount)) {
                System.out.printf("Перевод на сумму %d возвращен на счет %s \n", amount, this);
                return false;
            }
            ;
            //списываем деньги со счета
            this.balance -= amount;
            // account.addMoney(amount);
            return true;
            //Иначе пишем, что денег не хватает
        } else {
            System.out.println("Сумма перевода превышает остаток средств на счете! Перевод не выполнен");
            return false;
        }

    }

    @Override
    public boolean addMoney(int amount) {


        if (amount <= 0) {
            System.out.println("Введите корректную сумму");
            return false;
        }

        this.balance += amount;
        System.out.printf("Пополнение счета %s на сумму %d успешно! Текущий баланс: %d \n", this, amount, this.balance);
        return true;

    }

    @Override
    public String toString() {
        return super.toString() + " расчетный";
    }
}
