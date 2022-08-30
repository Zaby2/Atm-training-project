import java.util.ArrayList;

public class Account {
    private String name;

    private String id;

    private User holder;

    private ArrayList<Transaction> transactions;

    public Account(String name, User holder, Bank theBank) {

        this.name = name;
        this.holder = holder;

        this.id = theBank.getAccountsId();

        this.transactions = new ArrayList<Transaction>();


    }

    public String getId() {
        return this.id;
    }


    public String getSummaryLine() {
        double balance = this.getBalance();

        if (balance >= 0) {
            return String.format(this.id, balance, this.name);
        } else {
            return String.format(this.id, balance, this.name);
        }
    }

    public double getBalance() {
        double balance = 0;
        for(Transaction t : this.transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println(this.id);
        for (int t = this.transactions.size()-1; t >= 0; t--) {
            System.out.printf(this.transactions.get(t).getSum());
        }
    }
}
