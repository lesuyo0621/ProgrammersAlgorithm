public class NumericStringAndEnglishWords {
    private static int solution(String s) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < num.length; i++){
            s = s.replaceAll(num[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }
}
