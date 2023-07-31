import java.util.*;

public class DoublePriorityQueue {
    private static int[] solution(String[] operations){
        Set<Integer> set = new HashSet<>();

        for(String operation : operations){
            String[] o = operation.split(" ");
            String oper = o[0];
            String value = o[1];

            switch (oper){
                case "I" :
                    set.add(Integer.valueOf(value));
                    break;
                case "D" :
                    if(set.size() == 0) break;

                    if(value.equals("1")){
                        set.remove(Collections.max(set));
                    }else{
                        set.remove(Collections.min(set));
                    }
                    break;
            }
        }

        if(set.size() == 0) return new int[]{0, 0};
        return new int[]{Collections.max(set), Collections.min(set)};
    }

    public static void main(String[] args) {
//        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(operations)));
    }
}
