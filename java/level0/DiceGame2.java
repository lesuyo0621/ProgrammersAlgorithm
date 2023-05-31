public class DiceGame2 {
    public static int solution(int a, int b, int c){
        if(a == b && b == c){
            return (a + b + c)
                    * ((a * a) + (b * b) + (c * c))
                    * ((a * a * a) + (b * b * b) + (c * c * c));
        }
        if((a == b && b != c)
                || (b == c && c != a)
                || (c == a && a != b)){
            return (a + b + c) * ((a * a) + (b * b) + (c * c));
        }
        if(a != b && a != c && b != c) return a + b + c;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 6, 1));
    }
}
