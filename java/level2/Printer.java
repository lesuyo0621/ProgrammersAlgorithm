import java.util.ArrayList;
import java.util.Arrays;

public class Printer {

    public int solution(int[] priorities, int location) {
        int maxIndex = priorities.length - 1;
        int searchIndex = 0;

        ArrayList<Integer> print = new ArrayList<Integer>();

        for (int i = 0; i < priorities.length; i++) {
            print.add(priorities[i]);
        }

        Arrays.sort(priorities);

        while (searchIndex < priorities.length) {
            int target = print.get(searchIndex);
            if (priorities[maxIndex] == target) {
                maxIndex--;
                searchIndex++;
                if (searchIndex > location)
                    break;
            } else if (priorities[maxIndex] > target) {
                if (location == searchIndex) {
                    location = priorities.length - 1;
                } else {
                    location--;
                }
                print.remove(searchIndex);
                print.add(target);
            }
        }

        return location + 1;
    }

    public static void main(String[] args) {

        int[] priorities = { 1, 1, 9, 1, 1, 1 };
        int location = 0;

        Printer p = new Printer();
        System.out.println(p.solution(priorities, location));
    }
}