import java.util.Arrays;

public class CleanUpDesktop {
    private static int[] solution(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int maxX = 0;
        int minY = Integer.MAX_VALUE;
        int maxY = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                char c = wallpaper[i].charAt(j);

                if(c == '#') {
                    if(i < minX) minX = i;
                    if(j < minY) minY = j;
                    if(i + 1 > maxX) maxX = i + 1;
                    if(j + 1 > maxY) maxY = j + 1;
                }
            }
        }

        return new int[]{minX, minY, maxX, maxY};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{".#...", "..#..", "...#."})));
    }
}
