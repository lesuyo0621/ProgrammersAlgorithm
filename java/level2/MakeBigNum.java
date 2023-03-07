import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MakeBigNum {

    // 내 풀이
    // 두 수의 인덱스 하나하나 비교해서 어떤 수가 붙였을 때 더 큰 값인지 비교하는 방식
    // 인덱스 포인트 2개 - o1Index, o2Index
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(nums, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                int o1Index = 0;
                int o2Index = 0;

                while (true) {
                    if (o1.charAt(o1Index) != o2.charAt(o2Index)) {
                        return o2.charAt(o2Index) - o1.charAt(o1Index);
                    }

                    o1Index++;
                    o2Index++;

                    if (o1Index >= o1.length())
                        o1Index = 0;
                    if (o2Index >= o2.length())
                        o2Index = 0;
                    if (o1Index == 0 && o2Index == 0) {
                        return o1.length() - o2.length();
                    }
                }
            }
        });

        for (int j = 0; j < nums.length; j++) {
            sb.append(nums[j]);
        }

        answer = sb.toString();

        if (answer.startsWith("0"))
            answer = "0";

        return answer;
    }

    // 다른 사람의 풀이
    // num1, num2 두 수를 (num1 num2), (num2 num1) 으로 배치하여 크기 비교 후
    // 큰 수를 앞으로 정렬
    public String solution2(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });

        StringBuilder sb = new StringBuilder();

        for (Integer i : list) {
            sb.append(i);
        }

        answer = sb.toString();

        if (answer.charAt(0) == '0') {
            return "0";
        } else {
            return answer;
        }
    }

    public static void main(String[] args) {

        int[] numbers = { 22, 222, 33, 333 };

        int[] numbers2 = { 121212, 12, 1212, 121212 };
        int[] numbers3 = { 11111, 1111, 11 };

        MakeBigNum mb = new MakeBigNum();
        System.out.println(mb.solution(numbers));
    }
}