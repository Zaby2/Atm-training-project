import java.util.Scanner;


public class Atm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank theBank = new Bank("Zaby");

        User newUser = theBank.addUser("Bogdan", "Shitov", "0706");

        Account newAccount = new Account("Test", newUser, theBank);

        newUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while(true) {
            curUser = Atm.mainMenuPrompt(theBank, sc);

            Atm.printUserMenu(curUser, sc);

        }
    }
    public static User mainMenuPrompt(Bank theBank, Scanner sc) {

        String Id;
        String pin;
        User authUser;

        do {
            System.out.println("Welcome");
            System.out.println("Enter user ID");
            Id = sc.nextLine();
            System.out.println("Enter Pin");
            pin = sc.nextLine();
            authUser = theBank.userLogIn(Id, pin);
            if(authUser == null) {
                System.out.println("Incorrect");
            }

        } while(authUser == null);

        return authUser;
    }

    public static void printUserMenu(User theUser, Scanner sc) {
        theUser.printAccountSummary();
        int choice;
        do {
            System.out.println("Welcome, what do u want to do?");
            System.out.println("1. Show transaction history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.println("Enter num of your choice");
            choice = sc.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Error");

            }
        } while (choice < 1 || choice > 5);

        switch (choice) {
            case 1:
                Atm.showTransactionHistory(theUser, sc);
                break;
            case 2:
                Atm.withdrawFunds(theUser, sc);
                break;
            case 3:
                Atm.depositFunds(theUser,sc);
                break;
            case 4:
                Atm.transferFunds(theUser, sc);
                break;
        }
        if (choice != 5) {
            Atm.printUserMenu(theUser, sc);
        }
    }

    private static void transferFunds(User theUser, Scanner sc) {
        int account;

        do {
            System.out.printf("Enter number of account (1-%d)", theUser.numAccounts() );
            account = sc.nextInt()-1;

            if (account < 0 || account >= theUser.numAccounts()) {
                System.out.println("Erorr");
            }

        } while (account < 0 || account >= theUser.numAccounts());
        theUser.printAccountTransHistory(account);
    }

    private static void depositFunds(User theUser, Scanner sc) {

    }

    private static void withdrawFunds(User theUser, Scanner sc) {

    }

    private static void showTransactionHistory(User theUser, Scanner sc) {

    }
}
