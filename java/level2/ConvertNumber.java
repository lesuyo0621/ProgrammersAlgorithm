import java.util.LinkedList;
import java.util.Queue;

public class ConvertNumber {
    private static int find(Queue<Integer> queue, int count, int x, int n){
        if(queue.size() == 0) return -1;

        int size = queue.size();
        count++;

        for(int i = 0; i < size; i++){
            int num = queue.poll();

            int add = num - n;
            int mulTwo = num / 2;
            int mulTwoRemainder = num % 2;
            int mulThree = num / 3;
            int mulThreeRemainder = num % 3;

            if(add == x || (mulTwoRemainder == 0 && mulTwo == x) || (mulThreeRemainder == 0 && mulThree == x)){
                return count;
            }else{
                if(add > x) queue.add(add);
                if(mulTwo > x && mulTwoRemainder == 0) queue.add(mulTwo);
                if(mulThree > x && mulThreeRemainder == 0) queue.add(mulThree);
            }
        }

        return find(queue, count, x, n);
    }

    private static int solution(int x, int y, int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(y);

        return find(queue, 0, x, n);
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 5, 4));
    }
}
