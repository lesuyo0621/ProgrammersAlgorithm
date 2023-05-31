public class AddSpecificTerm {
    public static int solution(int a, int d, boolean[] included){
        int answer = 0;

        for(int i = 0; i < included.length; i++){
            if(included[i] == true) answer += a + (d * i);
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(3, 4, new boolean[]{true, false, false, true, true}));
    }
}
