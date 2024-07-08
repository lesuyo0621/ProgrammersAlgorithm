import java.util.*;

public class Parallel {
    static class Line {
        public final int x;
        public final int y;
        public final int xr;
        public final int yr;

        Line(int x, int y, int xr, int yr) {
            this.x = x;
            this.y = y;
            this.xr = xr;
            this.yr = yr;
        }

        public double getInclination() {
            return (yr - y) / (double) (xr - x);
        }

        public boolean isParallel(Line l) {
            return getInclination() == l.getInclination();
        }
    }

    private static int solution(int[][] dots) {
        Set<Integer> index = new HashSet<>();
        index.add(0);
        index.add(1);
        index.add(2);
        index.add(3);

        for (int i = 0; i < dots.length - 1; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                index.remove(i);
                index.remove(j);
                Line l1 = new Line(dots[i][0], dots[i][1], dots[j][0], dots[j][1]);

                int[] dot1 = null;
                int[] dot2 = null;
                for (int idx : index) {
                    if (dot1 == null) {
                        dot1 = dots[idx];
                    } else {
                        dot2 = dots[idx];
                    }
                }
                Line l2 = new Line(dot1[0], dot1[1], dot2[0], dot2[1]);

                if (l1.isParallel(l2)) return 1;

                index.add(i);
                index.add(j);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}}));
    }
}
