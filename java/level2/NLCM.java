public class NLCM {
    public int solution(int[] arr) {
        int answer = 0;
        int num1 = 0;
        int num2 = 0;
        int mod = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                num1 = arr[i];
                num2 = arr[i - 1];
            } else {
                num1 = arr[i - 1];
                num2 = arr[i];
            }

            while (mod != 0) {
                mod = num1 % num2;
                num1 = num2;
                num2 = mod;
            }

            arr[i] = (arr[i] * arr[i - 1]) / num1;
            mod = Integer.MAX_VALUE;
        }

        answer = arr[arr.length - 1];

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 6, 8, 14 };

        NLCM n = new NLCM();
        System.out.println(n.solution(arr));
    }
}