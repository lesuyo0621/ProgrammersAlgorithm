import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class kakaoColoring {

    // 내 풀이.. 재귀함수에 대해 인지가 부족함.. 재귀로 undo하는 것이 아닌 스택으로 undo 구현생각
    public int[] solution(int m, int n, int[][] picture) {
        int nArea = 0;
        int mArea = 0;
        int maxArea = 0;

        int[] answer = new int[2];
        int[][] map = new int[m][n];
        Map<Integer, Integer> Area = new HashMap<Integer, Integer>();
        Stack<Integer> undo = new Stack<Integer>();

        // 모든 영역 탐색
        // 상하좌우 영역 탐색
        // 같으면 영역넓이 +1
        // 찍은 좌표 체크

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 체크되지 않은 같은 걸 찾았다
                if (map[i][j] != 1 && picture[i][j] != 0) {
                    // 타겟키 기록
                    int target = picture[i][j];
                    // 원점 기록. 최종 원점으로 돌아오면 영역 찾기 끝내는 용도로
                    undo.push(i);
                    undo.push(j);
                    // 맵에 체크기록
                    map[i][j] = 1;
                    // 새로운 영역 발견 체크
                    nArea++;
                    // 새로운 영역넓이 체크
                    mArea++;

                    // 같은 값 비교 시작 와일
                    while (!undo.empty()) {
                        if (i - 1 >= 0 && map[i - 1][j] != 1 && picture[i - 1][j] == target) {
                            // 상
                            // 전 위치 기록
                            undo.push(i);
                            undo.push(j);
                            i--;
                            // 맵에 체크기록
                            map[i][j] = 1;
                            // 영역 넓이 체크
                            mArea++;
                        } else if (i + 1 < picture.length && map[i + 1][j] != 1 && picture[i + 1][j] == target) {
                            // 하
                            // 전 위치 기록
                            undo.push(i);
                            undo.push(j);
                            i++;
                            // 맵에 체크기록
                            map[i][j] = 1;
                            // 영역 넓이 체크
                            mArea++;
                        } else if (j + 1 < picture[0].length && map[i][j + 1] != 1 && picture[i][j + 1] == target) {
                            // 우
                            // 전 위치 기록
                            undo.push(i);
                            undo.push(j);
                            j++;
                            // 맵에 체크기록
                            map[i][j] = 1;
                            // 영역 넓이 체크
                            mArea++;
                        } else if (j - 1 >= 0 && map[i][j - 1] != 1 && picture[i][j - 1] == target) {
                            // 좌
                            // 전 위치 기록
                            undo.push(i);
                            undo.push(j);
                            j--;
                            // 맵에 체크기록
                            map[i][j] = 1;
                            // 영역 넓이 체크
                            mArea++;
                        } else {
                            // 전의 위치로
                            j = undo.pop();
                            i = undo.pop();
                        }
                    }

                    // 타겟이 존재할 경우 원래 영역보다 큰 경우 put
                    // 아닐 경우 그냥 put
                    if (Area.containsKey(target)) {
                        if (mArea > Area.get(target)) {
                            Area.put(target, mArea);
                        }
                    } else {
                        Area.put(target, mArea);
                    }

                    // 리셋 해줘야 하는 변수 리셋
                    mArea = 0;
                }
            }
        }

        for (Integer key : Area.keySet()) {
            if (maxArea < Area.get(key)) {
                maxArea = Area.get(key);
            }
        }

        answer[0] = nArea;
        answer[1] = maxArea;
        return answer;
    }

    // 재귀함수로 푸신 분 꺼 디버깅용.. 실행속도 내 풀이의 절반..
    int span = 0;

    public int[] solution2(int m, int n, int[][] picture) {

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] pathBool = new boolean[m][n];
        ArrayList<Integer> answerList = new ArrayList<>();
        int[] answer = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0) {
                    findPath(i, j, picture, pathBool);
                    if (span > 0) {
                        answerList.add(span);
                        span = 0;
                    }
                }
            }
        }
        numberOfArea = answerList.size();
        if (numberOfArea == 0) {
            return new int[] { 0, 0 };
        }
        Collections.sort(answerList, Collections.reverseOrder());
        maxSizeOfOneArea = answerList.get(0);
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public void findPath(int m, int n, int[][] picture, boolean[][] pathBool) {
        if (pathBool[m][n] == true)
            return; // 이미 거친 경로일 경우
        long su = picture[m][n]; // 이미지 값
        int column = picture[0].length;
        int row = picture.length;
        pathBool[m][n] = true;
        span++;
        // 오른쪽 이동
        if ((n + 1 < column) && (pathBool[m][n + 1] == false && su == picture[m][n + 1])) {
            findPath(m, n + 1, picture, pathBool);
        }
        // 아래쪽 이동
        if ((m + 1 < row) && (pathBool[m + 1][n] == false && su == picture[m + 1][n])) {
            findPath(m + 1, n, picture, pathBool);
        }
        // 왼쪽 이동
        if ((n - 1 >= 0) && (pathBool[m][n - 1] == false && su == picture[m][n - 1])) {
            findPath(m, n - 1, picture, pathBool);
        }
        // 위쪽 이동
        if ((m - 1 >= 0) && (pathBool[m - 1][n] == false && su == picture[m - 1][n])) {
            findPath(m - 1, n, picture, pathBool);
        }
    }

    public static void main(String[] args) {

        int m = 6;
        int n = 4;
        int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
                { 0, 0, 0, 3 } };

        kakaoColoring cl = new kakaoColoring();
        System.out.println(Arrays.toString(cl.solution(m, n, picture)));
    }
}