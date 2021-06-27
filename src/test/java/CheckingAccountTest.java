import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.bank.accounts.Account;
import ru.netology.bank.accounts.CheckingAccount;


public class CheckingAccountTest {


    @org.junit.jupiter.api.Test
    public void testPay_NegativeNumber() {
        // given:
        final int amount = -100;

        final int balance = 0;
        final String name = "TestAcc";

        final Account testChAcc = new CheckingAccount(balance, name);


        // when:

        final boolean resultTest = testChAcc.pay(amount);

        // then:

        Assertions.assertFalse(resultTest);

    }

    @org.junit.jupiter.api.Test
    public void testPay_NegativeBalanceAfterPay () {


        //given

        final int amount = 1000;

        final int balance = 900;
        final String name = "TestAcc";

        final Account testChAcc = new CheckingAccount(balance, name);


        //then

        Assertions.assertFalse(testChAcc.pay(amount));

    }


    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints = {100, 2000, 500000})
    public void testAddMoneyCreditingMoneyInBalance(int amount) {

        //given

        final Account testChAcc = new CheckingAccount(0, "Тест");
        final int expectedResult = amount;

        //when

        testChAcc.addMoney(amount);

        //then

        Assertions.assertEquals(expectedResult, testChAcc.getBalance());

    }

}
