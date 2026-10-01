/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ATMtransaction;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class BankTransaction {
static double balance = 10000;
    static final int CORRECT_PIN = 1234;
    static final double DAILY_LIMIT = 5000;

    // Method throws user-defined exceptions
    static void verifyPin(int pin) throws InvalidPinException {
        if (pin != CORRECT_PIN) {
            throw new InvalidPinException("Invalid PIN!");
        }
    }    

    static void withdraw(double amount)
            throws InvalidAmountException,
            InsufficientBalanceException,
            WithdrawalLimitException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Transaction amount must be greater than zero.");
        }

        if (amount > DAILY_LIMIT) {
            throw new WithdrawalLimitException(
                    "Withdrawal limit exceeded! Maximum limit is Rs.5000.");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance!");
        }

        balance = balance - amount;

        System.out.println("Withdrawal successful!");
        System.out.println("Amount withdrawn: Rs." + amount);
        System.out.println("Remaining balance: Rs." + balance);
    }

    static void deposit(double amount) throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero.");
        }

        balance = balance + amount;

        System.out.println("Deposit successful!");
        System.out.println("Amount deposited: Rs." + amount);
        System.out.println("Current balance: Rs." + balance);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            verifyPin(pin);

            int choice;

            do {
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Balance Enquiry");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                try {
                    switch (choice) {

                        case 1:
                            System.out.println(
                                    "Current balance: Rs." + balance);
                            break;

                        case 2:
                            System.out.print(
                                    "Enter withdrawal amount: Rs.");
                            double withdrawAmount = sc.nextDouble();

                            withdraw(withdrawAmount);
                            break;

                        case 3:
                            System.out.print(
                                    "Enter deposit amount: Rs.");
                            double depositAmount = sc.nextDouble();

                            deposit(depositAmount);
                            break;

                        case 4:
                            System.out.println("Thank you for using the ATM.");
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }

                } catch (InvalidAmountException |
                         InsufficientBalanceException |
                         WithdrawalLimitException e) {

                    System.out.println("Error: " + e.getMessage());
                }

            } while (choice != 4);

        } catch (InvalidPinException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Invalid input. Please enter valid data.");

        } finally {

            System.out.println("ATM session ended.");
            sc.close();
        }
    }
}
    
    

