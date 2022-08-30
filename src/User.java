import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;


public class User {

    private String firstName;

    private String lastName;

    private String id;

    private byte pinHash[];

    private ArrayList<Account> accounts;

    public User(String firstName, String lastName, String pin, Bank tneBank) {
        this.firstName = firstName;
        this.lastName = lastName;

        // &&&
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        this.id = tneBank.getUsersId();
        this.accounts = new ArrayList<Account>();
        System.out.println("New User has been created" + id);

    }
    public void addAccount(Account account) {
        this.accounts.add(account);
    }
    public String getId() {
        return this.id;
    }
    public boolean validatePin(String pin) {
        try {
            MessageDigest md = MessageDigest.getInstance("MB5");
            return MessageDigest.isEqual(md.digest(pin.getBytes()), this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public void printAccountSummary() {
        System.out.println(this.firstName);
        for(int a = 0; a < this.accounts.size(); a++) {
            System.out.printf(this.accounts.get(a).getSummaryLine(), a+1);
        }
        System.out.println();
    }

    public int numAccounts() {
        return this.accounts.size();
    }

    public void printAccountTransHistory(int id) {
        this.accounts.get(id).printTransactionHistory();
    }
}
