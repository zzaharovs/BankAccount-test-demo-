package ru.netology.bank.accounts;//package ru.netology.bank.accounts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.bank.accounts.Account;
import ru.netology.bank.accounts.CreditAccount;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CreditAccountHamcrestTest {


    @Test
    public void testPay_NegativeNumber() {
        // given:
        final int amount = -100;

        final Account testChAcc = new CreditAccount("Test");


        // when:

        // then:

        assertThat(testChAcc.pay(amount), is(false));

    }

    @Test
    public void testPayDebitingMoney() {

        //given
        final Account testCredAcc = new CreditAccount("test");
        final int amount = 1000;

        testCredAcc.pay(amount);

        //then

        //when

        assertThat(testCredAcc.getBalance(), is(-amount));

    }


    @Test
    public void testAddMoneyIfBalanceIsZero() {

        //given

        final Account testCredAcc = new CreditAccount("test");
        final int amount = 1000;

        //when

        //then

        assertThat(testCredAcc.addMoney(amount), is(false));

    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 200000})
    public void testAddMoneyValidBalance (int amount) {

        //given

        final Account testCredAcc = new CreditAccount("Тест");
        final int expectedBalance = testCredAcc.getBalance();

        //Для корректности теста сначала списываем сумму со счета
        testCredAcc.pay(amount);

        //when

        testCredAcc.addMoney(amount);

        //then

        assertThat(testCredAcc.getBalance(), is(expectedBalance));

    }


    @Test
    public void testTransferToCreditAccount() {

        //given

        final Account testToSendCredAcc = new CreditAccount("toSendAcc");
        final Account testToGetCredAcc = new CreditAccount("toGetAcc");

        final int amount = 1000;

        //Для корректности теста сначала списываем сумму со счета, на который будем переводить деньги
        testToGetCredAcc.pay(amount);

        //then

        //when

        assertThat(testToSendCredAcc.transfer(testToGetCredAcc, amount), is(true));

    }
}