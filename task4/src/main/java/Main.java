import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        //Научиться ходить
        // Посмотрите на код ниже. Необходимо научить ноги ходить, то есть сделать так, чтобы в консоли left и
        // right выводились по очереди. Привести не меньше 3 вариантов решения

        //Первый способ
        //        Object someObject = new Object();
        //
        //        CompletableFuture.allOf(
        //            CompletableFuture.runAsync(new Leg("left", someObject)),
        //            CompletableFuture.runAsync(new Leg("right", someObject))
        //        ).join();

        //Второй способ
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        CompletableFuture.allOf(
            CompletableFuture.runAsync(new LegNew("left", lock, condition)),
            CompletableFuture.runAsync(new LegNew("right", lock, condition))
        ).join();
    }
}
