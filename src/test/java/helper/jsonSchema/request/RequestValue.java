package helper.jsonSchema.request;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RequestValue {
    Random rand = new Random();
    public String pickValueOfTitle() {
        List<String> title = Arrays.asList("mr", "ms", "mrs", "miss", "dr");
        return title.get(rand.nextInt(title.size()));
    }
    public String pickValueOfGender() {
        List<String> title = Arrays.asList("male", "female", "other");
        return title.get(rand.nextInt(title.size()));
    }
    public int pickRandomNumber(){
        return rand.nextInt(10000);
    }
}
