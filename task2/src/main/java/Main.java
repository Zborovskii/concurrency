import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Account account1 = new Account(1000);
        Account account2 = new Account(1000);

        AccountThread accountThread1 = new AccountThread(account1, account2, random.nextInt(10));
        AccountThread accountThread2 = new AccountThread(account2, account1, random.nextInt(10));

        Thread firstThread = new Thread(accountThread1);
        Thread secondThread = new Thread(accountThread2);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

    }
}