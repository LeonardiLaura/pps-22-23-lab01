package lab01.example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

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
        if(this.checkHolder(userID)){
            this.balance=this.balance+amount-1;
        }
    }

    @Override
    public void withdraw(int userID, double amount) {
        if(this.checkHolder(userID) && this.balance>=amount+1){
            this.balance=this.balance-amount-1;
        }
    }

    private boolean checkHolder(int userID){
        return this.holder.getId()==userID;
    }
}
