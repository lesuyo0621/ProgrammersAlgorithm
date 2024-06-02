import java.time.LocalDate;

public class CompareDate {
    private static int solution(int[] date1, int[] date2) {
        LocalDate l1 = LocalDate.of(date1[0], date1[1], date1[2]);
        LocalDate l2 = LocalDate.of(date2[0], date2[1], date2[2]);

        return l1.isBefore(l2) ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2021, 12, 28}, new int[]{2021, 12, 29}));
    }
}
