package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private static final int FEE = 1;
    private double balance;
    private final AccountHolder holder;
    public SimpleBankAccountWithAtm(AccountHolder accountHolder, int i) {
        this.balance=i;
        this.holder=accountHolder;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int userID, double amount) {
        if(this.checkHolder(userID) && this.checkNegativeBalance(this.balance+amount,FEE)){
            this.balance=this.balance+amount-FEE;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if(this.checkHolder(userID) && this.checkNegativeBalance(this.balance,amount+FEE)){
            this.balance=this.balance-amount-FEE;
        }
    }

    private boolean checkHolder(int userID){
        return this.holder.getId()==userID;
    }


    private boolean checkNegativeBalance(double balance, double withdraw ){
        return balance>=withdraw;
    }
}
