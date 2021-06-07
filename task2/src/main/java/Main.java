import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    //    Задание 2. Deadlock
    //    Реализовать ситуацию взаимной блокировки. Как предотвратить такую блокировку?

    public static void main(String[] args) throws InterruptedException {

//        Runner runner = new Runner(); //здесь потоки ждут бруг друга бесконечно

        RunnerNew runner = new RunnerNew(); //здесь потоки сортируются и не ждут

        Thread thread1 = new Thread(() -> {
            runner.thirstThread();
        });

        Thread thread2 = new Thread(() -> {
            runner.secondThread();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();
    }
}