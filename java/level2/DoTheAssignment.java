import java.util.*;

public class DoTheAssignment {
    static class Task {
        public final String name;
        public final int start;
        public int processingTime;

        Task(String name, String start, String processingTime) {
            this.name = name;
            this.start = getMinutes(start);
            this.processingTime = Integer.parseInt(processingTime);
        }

        private int getMinutes(String time) {
            String[] times = time.split(":");
            return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        }
    }

    private static List<String> solution(String[][] plans) {
        Task[] tasks = new Task[1500];
        for (String[] p : plans) {
            Task t = new Task(p[0], p[1], p[2]);
            tasks[t.start] = t;
        }

        Stack<Task> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        Task progress = null;
        for (int i = 0; i < tasks.length; i++) {
            if (progress != null && progress.processingTime == 0) {
                result.add(progress.name);
                progress = null;
            }

            Task t = tasks[i];

            if (t != null) {
                if (progress != null) {
                    stack.push(progress);
                }

                progress = t;
            } else if(progress == null && !stack.empty()) {
                progress = stack.pop();
            }

            if (progress != null) {
                progress.processingTime--;
            }
        }

        if (progress != null) {
            result.add(progress.name);
        }

        while (!stack.empty()) {
            result.add(stack.pop().name);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}}));
    }
}
