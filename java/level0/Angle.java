import java.util.stream.Stream;

public class Angle {

    private static int solution(int angle){
        return Stream.of(0, 90, 91, 180).filter(x -> angle >= x).toArray().length;
    }

    public static void main(String[] args) {
        int angle = 91;
        System.out.println(solution(angle));
    }
}
