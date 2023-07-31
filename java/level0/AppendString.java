public class AppendString {
    private static String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();

        for(int index : index_list){
            sb.append(my_string.charAt(index));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String my_string = "cvsgiorszzzmrpaqpe";
        int[] index_list = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};

        System.out.println(solution(my_string, index_list));
    }
}
