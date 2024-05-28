public class SplitString {
    private static int solution(String s) {
        int result = 0;
        int firstCount = 0;
        int anotherCount = 0;
        char firstChar = '0';

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(firstCount == 0) {
                firstChar = c;
                firstCount++;
            }else {
                if(firstChar == c) {
                    firstCount++;
                }else {
                    anotherCount++;

                    if(firstCount == anotherCount){
                        result++;
                        firstCount = 0;
                        anotherCount = 0;
                    }
                }
            }
        }

        if(firstCount > 0) result++;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("banana"));
    }
}
