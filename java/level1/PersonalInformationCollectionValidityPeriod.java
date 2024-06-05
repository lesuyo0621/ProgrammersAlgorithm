import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PersonalInformationCollectionValidityPeriod {
    private static List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();
        LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));

        for (String term : terms) {
            String[] tArr = term.split(" ");

            termMap.put(tArr[0], Integer.parseInt(tArr[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] pArr = privacies[i].split(" ");
            LocalDate pDate = LocalDate.parse(pArr[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));

            if (!todayDate.isBefore(pDate.plusMonths(termMap.get(pArr[1])))) answer.add(i + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(solution(today, terms, privacies));
    }
}
