class Account implements Comparable<Account>{

    private int balance = 10000;
    private String name;

    public String getName() {
        return name;
    }

    public Account(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public static void transfer(Account account1, Account account2, int ammount) {
        account1.withdraw(ammount);
        account2.deposit(ammount);

    }

    public int getBalance() {
        return balance;
    }

    @Override
    public int compareTo(Account account) {
        return name.compareTo(account.getName());
    }
}