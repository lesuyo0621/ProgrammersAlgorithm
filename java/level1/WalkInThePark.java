import java.util.Arrays;

public class WalkInThePark {
    private static int[] getStartPosition(String[] park){
        int[] start = new int[2];

        for(int i = 0; i < park.length; i++){
            int index = park[i].indexOf("S");

            if(index != -1){
                start[0] = i;
                start[1] = index;
                break;
            }
        }

        return start;
    }

    private static int[] move(int[] currentPosition, String[] park, String route){
        String[] order = route.split(" ");
        String direction = order[0];
        int distance = Integer.parseInt(order[1]);

        if(outOfPark(park, currentPosition, direction, distance)){
            return currentPosition;
        }

        if(meetObstacle(park, currentPosition, direction, distance)){
            return currentPosition;
        }

        switch(direction){
            case "E" :
                currentPosition[1] += distance;
                break;
            case "W" :
                currentPosition[1] -= distance;
                break;
            case "S" :
                currentPosition[0] += distance;
                break;
            case "N" :
                currentPosition[0] -= distance;
                break;
        }

        return currentPosition;
    }

    private static boolean outOfPark(String[] park, int[] currentPosition, String direction, int distance){
        boolean result = false;
        int H = park.length - 1;
        int W = park[0].length() - 1;

        switch(direction){
            case "E" :
                result = currentPosition[1] + distance > W;
                break;
            case "W" :
                result = currentPosition[1] - distance < 0;
                break;
            case "S" :
                result = currentPosition[0] + distance > H;
                break;
            case "N" :
                result = currentPosition[0] - distance < 0;
                break;
        }

        return result;
    }

    private static boolean meetObstacle(String[] park, int[] currentPosition, String direction, int distance){
        int h = currentPosition[0];
        int w = currentPosition[1];

        for(int i = 1; i <= distance; i++){
            switch(direction){
                case "E" :
                    w += 1;
                    break;
                case "W" :
                    w -= 1;
                    break;
                case "S" :
                    h += 1;
                    break;
                case "N" :
                    h -= 1;
                    break;
            }

            if(park[h].charAt(w) == 'X'){
                return true;
            }
        }

        return false;
    }

    private static int[] solution(String[] park, String[] routes) {
        int[] currentPosition = getStartPosition(park);

        for(String route : routes){
            currentPosition = move(currentPosition, park, route);
        }

        return currentPosition;
    }

    public static void main(String[] args) {
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};

        System.out.println(Arrays.toString(solution(park, routes)));
    }
}
