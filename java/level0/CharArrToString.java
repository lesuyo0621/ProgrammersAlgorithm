import java.util.Arrays;
import java.util.stream.Collectors;

public class CharArrToString {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c"};

        System.out.println(Arrays.stream(arr).collect(Collectors.joining()));
    }
}
