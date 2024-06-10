import java.util.*;

public class ParkingFeeCalculation {
    private static int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int perTime = fees[2];
        int perFee = fees[3];
        Map<Integer, Integer> timePerCar = new HashMap<>();
        Map<Integer, String> inTime = new HashMap<>();

        for (String r : records) {
            String[] rArr = r.split(" ");
            String time = rArr[0];
            int carNum = Integer.parseInt(rArr[1]);
            String status = rArr[2];

            if (status.equals("IN")) {
                inTime.put(carNum, time);
            } else {
                int totalTime = timePerCar.getOrDefault(carNum, 0);

                totalTime += calcMinute(inTime.get(carNum), time);

                timePerCar.put(carNum, totalTime);
                inTime.remove(carNum);
            }
        }

        if (inTime.size() > 0) {
            for (int carNum : inTime.keySet()) {
                int totalTime = timePerCar.getOrDefault(carNum, 0);

                totalTime += calcMinute(inTime.get(carNum), "23:59");

                timePerCar.put(carNum, totalTime);
            }
        }

        List<Integer> carNumList = new ArrayList<>(timePerCar.keySet());
        carNumList.sort((i1, i2) -> i1 - i2);

        int[] answer = new int[carNumList.size()];

        int i = 0;
        for (int carNum : carNumList) {
            int totalTime = timePerCar.get(carNum);

            if (totalTime <= basicTime) {
                answer[i] = basicFee;
            } else {
                int remainTime = totalTime - basicTime;
                int adjust = remainTime % perTime > 0 ? 1 : 0;

                answer[i] += basicFee + ((remainTime / perTime + adjust) * perFee);
            }

            i++;
        }

        return answer;
    }

    private static int calcMinute(String inTime, String outTime) {
        String[] inTimes = inTime.split(":");
        String[] outTimes = outTime.split(":");
        int inHour = Integer.parseInt(inTimes[0]);
        int outHour = Integer.parseInt(outTimes[0]);
        int inMinute = Integer.parseInt(inTimes[1]);
        int outMinute = Integer.parseInt(outTimes[1]);
        int minute = 0;
        int adjust = 0;

        if (outMinute - inMinute < 0) {
            minute += outMinute + 60 - inMinute;
            adjust = 1;
        } else {
            minute += outMinute - inMinute;
        }

        minute += (outHour - inHour - adjust) * 60;

        return minute;
    }

    public static void main(String[] args) {
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};

        System.out.println(Arrays.toString(solution(fees, records)));
    }
}
