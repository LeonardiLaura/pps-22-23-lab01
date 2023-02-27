import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private BankAccount bankAccountAtm;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Ajeje", "Brazorf", 2);
        bankAccountAtm = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccountAtm.getBalance());
    }

    @Test
    void testBankAccountHolder(){
        assertEquals(bankAccountAtm.getHolder(),this.accountHolder);
    }

    @Test
    void testDepositAtm(){
        this.bankAccountAtm.deposit(this.accountHolder.getId(),50);
        assertEquals(49,this.bankAccountAtm.getBalance());
    }

    @Test
    void testWithdrawAtm(){
        this.bankAccountAtm.deposit(this.accountHolder.getId(),51);
        this.bankAccountAtm.withdraw(this.accountHolder.getId(),10);
        assertEquals(39,this.bankAccountAtm.getBalance());
    }


    @Test
    void testWrongDeposit(){
        this.bankAccountAtm.deposit(this.accountHolder.getId(),101);
        this.bankAccountAtm.deposit(1,51);
        assertEquals(this.bankAccountAtm.getBalance(),100);
    }

    @Test
    void testWrongWithdraw(){
        this.bankAccountAtm.deposit(this.accountHolder.getId(),201);
        this.bankAccountAtm.withdraw(1,49);
        assertEquals(this.bankAccountAtm.getBalance(),200);
    }
}
