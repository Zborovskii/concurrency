import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LegNew implements Runnable {

    //Необходимо научить ноги ходить, то есть сделать так, чтобы в консоли left и right выводились по очереди

    private final String name;
    private final ReentrantLock lock;
    private final Condition condition;

    public LegNew(String name, ReentrantLock lock, Condition condition) {
        this.name = name;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {

        try {
            lock.lock();
            while (true) {
                condition.signal();
                System.out.println(name);
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}