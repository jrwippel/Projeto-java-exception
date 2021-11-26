package entities;

import exceptions.DomainException;

public class Account {

    private int number;
    private String holder;
    private double balance;
    private double withDrawLimit;

    public Account(){

    }

    public Account(int number, String holder, double balance, double withDrawLimit) {

        if(number == 0){
            throw new DomainException("Numero da conta não pode ser zeros!");
        }
        if(balance == 0){
            throw new DomainException("Saldo inicial da conta não pode ser zeros!");
        }
        if(withDrawLimit == 0){
            throw new DomainException("Limite de saques da conta não pode ser zeros!");
        }
        if(holder == ""){
            throw new DomainException("Titular da conta deve ser informado!");
        }

        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithDrawLimit() {
        return withDrawLimit;
    }

    public void setWithDrawLimit(double withDrawLimit) {
        this.withDrawLimit = withDrawLimit;
    }

    public void deposit(double amount){

    }

    public void withdraw(double amount){
        if (amount > withDrawLimit){
            throw new DomainException("Saque é maior que o limite de saque permitido");
        }
        balance = balance - amount;
    }

    @Override
    public String toString() {
        return "Room "
                + number
                + ", balance: "
                + balance
                + ", Holder: "
                + holder;
    }
}
