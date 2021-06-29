public class Leg implements Runnable {

    //Необходимо научить ноги ходить, то есть сделать так, чтобы в консоли left и right выводились по очереди

    private final String name;
    private final Object someObject;

    public Leg(String name, Object someObject) {
        this.name = name;
        this.someObject = someObject;
    }

    @Override
    public void run() {
        synchronized (someObject) {
            while (true) {
                try {
                    someObject.notify();
                    System.out.println(name);
                    someObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}