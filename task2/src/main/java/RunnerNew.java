import java.util.Random;

class RunnerNew {
// класс с взаимной блокировкой
    private Account account1 = new Account("1");
    private Account account2 = new Account("2");

    public void thirstThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            synchronized (account1.compareTo(account2) > 1 ? account1 : account2) {
                synchronized (account2.compareTo(account1) > 1 ? account2 : account1) {
                    Account.transfer(account1, account2, random.nextInt(100));
                }
            }

        }
    }

    public void secondThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            synchronized (account2) {
                synchronized (account1) {
                    Account.transfer(account2, account1, random.nextInt(100));
                }
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        System.out.println("Total balance = " + (account1.getBalance() + account2.getBalance()));
    }
}