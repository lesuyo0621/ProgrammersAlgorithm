import java.util.stream.Collectors;

public class RockScissorsPaper {
    public static String solution(String rsp) {
        return rsp.chars()
                .mapToObj(c -> (char) c)
                .map(c -> c == '2' ? '0' : c == '0' ? '5' : c == '5' ? '2' : c)
                .map(c -> c.toString())
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(solution("205"));
    }
}
