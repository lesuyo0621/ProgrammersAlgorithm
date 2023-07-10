import java.util.Arrays;

public class LifeBoat {
    private static int solution(int[] people, int limit){
        int count = 0;
        int L = 0;

        Arrays.sort(people);
        for(int R = people.length - 1; R >= L; R--){
            if(people[L] + people[R] <= limit){
                count++;
                L++;
            }else{
                count++;
            }
        }

        return count;
    }
    
    
    public static void main(String[] args) {
        int[] people1 = {70, 50, 80, 50};
        int limit1 = 100;
        int answer1 = 3;
        System.out.println(solution(people1, limit1));

        int[] people2 = {70, 80, 50};
        int limit2 = 100;
        int answer2 = 3;
        System.out.println(solution(people2, limit2));

        int[] people3 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int limit3 = 100;
        int answer3 = 6;
        System.out.println(solution(people3, limit3));
        
        int[] people4 = {10, 90, 90, 90, 90};
        int limit4 = 100;
        int answer4 = 5;
        System.out.println(solution(people4, limit4));
    }
}
