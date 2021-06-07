import java.util.ArrayList;
import java.util.List;

public class DataSystem {

    private List<Integer> numberList = new ArrayList<>();

    public void addNumber(int number){
        numberList.add(number);
    }

    public int getNumber(int number){
        return numberList.get(number);
    }

}
