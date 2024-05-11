import java.util.Arrays;

public class SecretMap {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if((arr1[i] >> j) % 2 == 0 && (arr2[i] >> j) % 2 == 0){
                    sb.insert(0, " ");
                }else{
                    sb.insert(0, "#");
                }
            }

            answer[i] = sb.toString();
            sb.setLength(0);
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }
}
