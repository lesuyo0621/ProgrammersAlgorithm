import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelRoom {
    public static boolean canUse(String start, String end){
        LocalTime startTime = LocalTime.parse(start);
        LocalTime endTime = LocalTime.parse(end);

        if(endTime.isAfter(LocalTime.parse("23:48"))){
            return false;
        }

        endTime = endTime.plusMinutes(10);

        if(startTime.isAfter(endTime)){
            return true;
        }else if(startTime.isBefore(endTime)){
            return false;
        }else{
            return true;
        }
    }

    public static int solution(String[][] book_time){
        Arrays.sort(book_time, (time1, time2) -> {
            LocalTime time1Start = LocalTime.parse(time1[0]);
            LocalTime time1End = LocalTime.parse(time1[1]);
            LocalTime time2Start = LocalTime.parse(time2[0]);
            LocalTime time2End = LocalTime.parse(time2[1]);

            if(time1Start.isAfter(time2Start)){
                return 1;
            }else if(time1Start.isBefore(time2Start)){
                return -1;
            }else{
                if(time1End.isAfter(time2End)){
                    return 1;
                }else if(time1End.isBefore(time2End)){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        List<String> rooms = new ArrayList<>();
        for (String[] time : book_time){
            String startTime = time[0];
            String endTime = time[1];
            boolean isEmpty = false;

            for(int i = 0; i < rooms.size(); i++){
                if(canUse(startTime, rooms.get(i))){
                    isEmpty = true;
                    rooms.set(i, endTime);
                    break;
                }
            }

            if(!isEmpty){
                rooms.add(endTime);
            }
        }

        return rooms.size();
    }


    public static void main(String[] args) {
        String[][] book_time = new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
//        String[][] book_time = new String[][]{{"15:00", "17:00"}};
//        String[][] book_time = new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}};

        System.out.println(solution(book_time));
    }
}
