import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;

    private ArrayList<User> users;

    private ArrayList<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    public String getUsersId() {
        String id;
        int len = 6;
        boolean unq = false;
        Random rng = new Random();

        do {
            id = "";
            for (int c = 0; c < len; c++) {
                id += ((Integer)rng.nextInt(10)).toString();
            }
            for (User u : this.users ) {
                if (id.compareTo(u.getId()) == 0) {
                    unq = true;
                    break;
                }
            }
        } while (unq);

        return id;
    }
    public String getAccountsId() {
        String id;
        int len = 10;
        boolean unq = false;
        Random rng = new Random();

        do {
            id = "";
            for (int c = 0; c < len; c++) {
                id += ((Integer)rng.nextInt(10)).toString();
            }
            for (Account a: this.accounts ) {
                if (id.compareTo(a  .getId()) == 0) {
                    unq = true;
                    break;
                }
            }
        } while (unq);


        return id;
    }
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public User addUser(String firstName, String lastName, String pin) {

        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        Account newAccount = new Account("Savings", newUser, this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        return newUser;
    }
    public User userLogIn(String userId, String pin) {

        for (User u : this.users) {
            if (u.getId().compareTo(userId) == 0)  {
                return u;
            }
        }
        return null;
    }
}
