package application;

import entities.Account;
import exceptions.DomainException;

import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        try {

            System.out.print("Number:");
            int number = sc.nextInt();
            System.out.print("Holder:");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial Balance:");
            double inibalance = sc.nextDouble();
            System.out.print("WithDraw limit:");
            double withdrawlimit = sc.nextDouble();

            Account account = new Account(number, holder, inibalance, withdrawlimit);

            System.out.println();
            System.out.print("Enter amount for withdraw:");
            double amountwithdraw = sc.nextDouble();
            account.withdraw(amountwithdraw);

            System.out.print(account.getBalance());

            System.out.println("New balance:");
        }
        catch (DomainException e){
            System.out.println("Erro na operacao:" + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        finally {
            sc.close();
        }
    }
}
