import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileNameSorting {
    private static Comparator<File> comp = (o1, o2) -> {
        int headCompResult = o1.head.compareTo(o2.head);

        if (headCompResult != 0) return headCompResult;
        if (o1.number != o2.number) return o1.number - o2.number;
        return o1.index - o2.index;
    };

    private static String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            String f = files[i];
            String head = f.split("[0-9]+")[0];
            int number = Integer.parseInt(f.split("[^0-9]+")[1]);

            fileList.add(new File(f, head, number, i));
        }

        fileList.sort(comp);

        String[] answer = new String[files.length];
        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).fileName;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }
}

class File {
    String fileName;
    String head;
    int number;
    int index;

    File(String fileName, String head, int number, int index) {
        this.fileName = fileName;
        this.head = head.toLowerCase();
        this.number = number;
        this.index = index;
    }
}
