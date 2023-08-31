import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewsClustering {

    private static int solution(String str1, String str2) {
        final String strL1 = str1.toLowerCase();
        final String strL2 = str2.toLowerCase();

        List<String> str1List = IntStream.range(1, str1.length())
                .mapToObj(i -> strL1.substring(i - 1, i + 1))
                .filter(s -> s.matches("[a-zA-Z]{2}"))
                .collect(Collectors.toList());

        List<String> str2List = IntStream.range(1, str2.length())
                .mapToObj(i -> strL2.substring(i - 1, i + 1))
                .filter(s -> s.matches("[a-zA-Z]{2}"))
                .collect(Collectors.toList());

        // 합집합 구하기
        List<String> unionList = new ArrayList<>();
        List<String> s2List = new ArrayList<>(str2List);
        for(String s : str1List){
            unionList.add(s);
            s2List.remove(s);
        }

        if(s2List.size() > 0) s2List.forEach(s -> unionList.add(s));

        int unionCount = unionList.size();

        // 교집합 구하기
        List<String> intersectionList = new ArrayList<>();

        for(String s : str1List){
            if(str2List.contains(s)){
                intersectionList.add(s);
                str2List.remove(s);
            }
        }

        int intersectionCount = intersectionList.size();

        if(unionCount == 0 || intersectionCount == 0) return 65536;
        return (int) Math.floor((intersectionCount / (double) unionCount) * 65536);
    }

    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }
}
