public class ListOfMatch {
    private static int solution(int n, int a, int b){
        int count = 0;

        while(a != b){
            a = (int) Math.ceil(a / 2.0);
            b = (int) Math.ceil(b / 2.0);
            count++;
        }

        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }
}
