public class Main {

//    Задание 1. Счетчик
//    Реализовать потокобезопасный счетчик. Предусмотреть метод для получения текущего значения счетчика.

    private int count;

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.doWork();
    }

    private synchronized void increment(){
        count++;
    }

    private int getCount(){
        return count;
    }

    private void doWork() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for(int i=0; i < 100000; i++){
                increment();
            }
        });

        Thread thread2 = new Thread(()-> {
            for(int i=0; i < 100000; i++){
                increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }
}
