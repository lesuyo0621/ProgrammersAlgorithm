public class WhatDay2016 {

    public String solution(int a, int b) {
        String answer = "";
        int totaldays = 0;
        String[] days = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };

        for (int i = 2; i < a + 1; i++) {
            if (i == 3) {
                totaldays = totaldays + 29;
            } else if (i == 5 || i == 7 || i == 10 || i == 12) {
                totaldays = totaldays + 30;
            } else if (i == 2 || i == 4 || i == 6 || i == 8 || i == 9 || i == 11) {
                totaldays = totaldays + 31;
            }
        }
        totaldays = totaldays + b;

        answer = days[totaldays % 7];

        return answer;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 24;

        WhatDay2016 wd = new WhatDay2016();
        System.out.println(wd.solution(a, b));
    }

}