import java.util.*;

public class EnforcementCamera {
    private static int bestSolution(int[][] routes){
        Arrays.sort(routes, Comparator.comparingInt(route -> route[1]));
        int lastCamera = Integer.MIN_VALUE;

        int answer = 0;
        for(int[] route : routes){
            if(lastCamera < route[0]){
                answer++;
                lastCamera = route[1];
            }
        }

        return answer;
    }

    private static int solution(int[][] routes){
        Arrays.sort(routes, Comparator.comparingInt((int[] route) -> route[1])
                .thenComparingInt(route -> route[0]));

        int cameraCount = 0;
        for(int i = 0; i < routes.length; i++){
            if(i + 1 >= routes.length) break;

            int[] route = routes[i];

            for(int j = i + 1; j < routes.length; j++){
                int[] nextRoute = routes[j];

                if(nextRoute[0] > route[1] || j == routes.length - 1){
                    i = j - 1;
                    cameraCount++;
                    break;
                }
            }
        }

        return cameraCount;
    }

    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(routes));

        // 다 따로
//        int[][] routes = {{-20,-19}, {-18,-17}, {-16,-15}, {-14,-13}};
//        System.out.println(solution(routes));

        // 18 에 2개 나머지는 각각
//        int[][] routes = {{-20,-18}, {-18,-17}, {-16,-15}, {-14,-13}};
//        System.out.println(solution(routes));

        // 모두 같은 것
//        int[][] routes = {{-20,-18}, {-20,-18}, {-20,-18}, {-20,-18}};
//        System.out.println(solution(routes));

        // 첫 번째의 끝 지점 하나에 다 겹치는 것
//        int[][] routes = {{-20,-18}, {-18,-17}, {-18,-15}, {-18,-13}};
//        System.out.println(solution(routes));

//        int[][] routes = {{-20,-15}, {-18,-10}, {-18,-15}, {-18,-9}, {-15, -9}, {-14, -11}, {-11, -9}, {-8, -8}, {-9, -7}, {-8, -6}, {-8, -5}};
//        System.out.println(solution(routes));
    }
}
