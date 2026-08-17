import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        int[] a = {10};
        Arrays.sort(a);

        for (int i = 1; i < list.size(); i++) {
            numbers.add(i + ": " + list.get(i));
        }

        Collections.sort(numbers);
    }
}
