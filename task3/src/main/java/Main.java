import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    private static Integer ARRAY_SIZE = 1000000;

    //Напишите код, который параллельно выкачивает данные из двух разных систем и объединяет их результат. Ответ от
    // обоих систем одинаковый

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DataSystem systemA = new DataSystem();
        DataSystem systemB = new DataSystem();

        //fill systems
        for (int i = 0; i < ARRAY_SIZE; i++) {
            systemA.addNumber(i);
            systemB.addNumber(i);
        }

        CompletableFuture<List<Integer>> downloadFirstData = CompletableFuture.supplyAsync(() -> {
            List<Integer> resultData = new ArrayList<>();

            for (Integer i = 0; i < ARRAY_SIZE; i++) {
                resultData.add(systemA.getNumber(i));
            }
            return resultData;
        });

        CompletableFuture<List<Integer>> downloadSecondData = CompletableFuture.supplyAsync(() -> {
            List<Integer> resultData = new ArrayList<>();

            for (Integer i = 0; i < ARRAY_SIZE; i++) {
                resultData.add(systemB.getNumber(i));
            }
            return resultData;
        });

        System.out.println(downloadFirstData
                               .thenCombineAsync(downloadSecondData,
                                                 (firstResult, secondResult) -> firstResult.addAll(secondResult))
                               .get());

    }
}
