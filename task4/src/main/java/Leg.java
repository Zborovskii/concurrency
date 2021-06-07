import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class Leg implements Runnable {

    //Необходимо научить ноги ходить, то есть сделать так, чтобы в консоли left и right выводились по очереди

    private final String name;

    public Leg(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name);
        }
    }

    public static void main(String[] args) {

        CompletableFuture.allOf(
            CompletableFuture.runAsync(new Leg("left")),
            CompletableFuture.runAsync(new Leg("right"))
        ).join();

    }


}