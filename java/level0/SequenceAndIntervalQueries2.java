import java.util.Arrays;

public class SequenceAndIntervalQueries2 {

    private static int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];

            for(int j = query[0]; j <= query[1]; j++){
                if(arr[j] > query[2]){
                    if(answer[i] == 0){
                        answer[i] = arr[j];
                    }else if(answer[i] > arr[j]){
                        answer[i] = arr[j];
                    }
                }
            }

            if(answer[i] == 0) answer[i] = -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 2},{0, 3, 2},{0, 2, 2}};

        System.out.println(Arrays.toString(solution(arr, queries)));
    }
}
