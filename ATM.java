/*                                          TASK 4-ATM Interface
1.Create a class to represent the ATM machine.
2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.
3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().
4. Create a class to represent the user's bank account, which stores the account balance.
5. Connect the ATM class with the user's bank account class to access and modify the account
balance.
6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transaction*/

import java.util.Scanner;
public class ATM {
    float balance=500;                             //Minimum balance in account
    int pin_no=1234;
    Scanner s=new Scanner(System.in);
    public void menu(){
        System.out.println("***MENU***");
        System.out.println("1.Deposit Money");
        System.out.println("2.Withdraw Money");
        System.out.println("3.Check account balance");
        System.out.println("4.Exit");
        System.out.println("Enter your choice: ");
        int m=s.nextInt();
        switch (m){
            case 1:
                deposit();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                checkbalance();
                break;
            case 4:
                System.out.println("Thank you,please visit again!!");
                break;
            default:
                System.out.println("Enter valid choice");
        }
    }
    public void checkbalance() {
        System.out.println("Your account balance is: "+balance);
        menu();
    }
    public void deposit() {
        System.out.println("Enter the amount you want to deposit: ");
        float amount=s.nextFloat();
        balance=balance+amount;
        System.out.println("Money deposited successfully!!!");
        menu();
    }
    public void withdraw() {
        System.out.println("There should be minimum balance of Rs.500");
        System.out.println("Enter the amount you want to withdraw: ");
        float a=s.nextFloat();
        if(a<balance && balance-a<500) {
                System.out.println("Can't withdraw!!,Minimum balance required");
        }
        else if (a>balance)
            System.out.println("Insufficient balance!!");
        else {
            balance=balance-a;
            System.out.println("Withdrawn Successfully!!!");
        }
        menu();
    }
    public void Pin()
    {
        System.out.println("Enter the pin number: ");
        int pin=s.nextInt();
        if(pin==pin_no)
        {
            menu();
        }
        else System.out.println("Enter valid pin number!");
    }
}

class User extends ATM{
    public static void main(String[] args) {
        ATM ob=new ATM();
        ob.Pin();
    }
}
