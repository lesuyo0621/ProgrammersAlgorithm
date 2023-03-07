import java.util.ArrayList;
import java.util.Collections;

public class JumpAndTeleport {
    public int solution(int n) {
        int ans = 0;
        int step = 0;
        int target = n;
        ArrayList<Integer> tree = new ArrayList<Integer>();

        // k = k + k 순간이동 배터리 -0 전제조건 현재까지 온 거리
        // k = k + n 점프이동 배터리 -n
        // n/2 스텝 기록. 0부터 단계 거치기

        tree.add(target);

        while (!(target == 0)) {
            target = target / 2;
            tree.add(target);
        }

        Collections.sort(tree);

        for (int i = 0; i < tree.size() - 1; i++) {
            target = tree.get(i + 1).intValue();
            if (target == (step * 2)) {
                step = step * 2;
            } else if (target == (step * 2) + 1) {
                step = step * 2 + 1;
                ans++;
            } else {
                while (step == target) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;

        JumpAndTeleport jt = new JumpAndTeleport();
        System.out.println(jt.solution(n));

    }
}