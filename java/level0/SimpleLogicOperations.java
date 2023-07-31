public class SimpleLogicOperations {
    private static boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return (x1 || x2) && (x3 || x4);
    }

    public static void main(String[] args) {
        System.out.println(solution(false, true, true, true));
    }
}
