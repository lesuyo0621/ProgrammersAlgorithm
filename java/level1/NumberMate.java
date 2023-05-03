import java.util.*;

public class NumberMate {
    private static String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> mateNum = new HashSet<>();

        for(int i = 9; i >= 0; i--){
            String target = String.valueOf(i);

            if(X.indexOf(target) == -1 || Y.indexOf(target) == -1) continue;
            mateNum.add(i);

            int beforeXLength = X.length();
            int beforeYLength = Y.length();

            X = X.replaceAll(target, "");
            Y = Y.replaceAll(target, "");

            int afterXLength = X.length();
            int afterYLength = Y.length();

            int XCount = beforeXLength - afterXLength;
            int YCount = beforeYLength - afterYLength;

            for(int j = 0; j < Math.min(XCount, YCount); j++){
                sb.append(i);
            }
        }

        String answer = "";
        if("".equals(sb.toString())){
            answer = "-1";
        }else if(mateNum.stream().allMatch(num -> num == 0)){
            answer = "0";
        }else{
            answer = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        String X = "12321";
        String Y = "42531";

        System.out.println(solution(X, Y));
    }
}
