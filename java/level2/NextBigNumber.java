public class NextBigNumber {
    private static int solution2(int n){
        int count = Integer.bitCount(n);

        while (true) {
            int nextCount = Integer.bitCount(++n);
            if(count == nextCount) break;
        }

        return n;
    }


    private static int getBinaryOneCount(int n){
        int num = 1;
        StringBuffer sb = new StringBuffer();

        while(n > num){
            if((n & num) > 0) sb.append("1");
            num *= 2;
        }

        return sb.length();
    }

    private static int solution(int n){
        int count = getBinaryOneCount(n);

        while (true) {
            int nextNumCount = getBinaryOneCount(++n);
            if(count == nextNumCount) break;
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution2(78));
    }
}
