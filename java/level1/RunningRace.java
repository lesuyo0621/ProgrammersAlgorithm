import java.util.*;

public class RunningRace {
    public static String[] solution(String[] players, String[] callings){
        Map<String, Integer> playerNameMap = new HashMap<>();
        Map<Integer, String> playerIndexMap = new HashMap<>();

        for(int i = 0; i < players.length; i++){
            playerNameMap.put(players[i], i);
            playerIndexMap.put(i, players[i]);
        }

        for(String calledPlayer : callings){
            int index = playerNameMap.get(calledPlayer);
            String frontPlayer = playerIndexMap.get(index - 1);

            playerNameMap.put(calledPlayer, index - 1);
            playerNameMap.put(frontPlayer, index);
            playerIndexMap.put(index - 1, calledPlayer);
            playerIndexMap.put(index, frontPlayer);
        }

        playerIndexMap.forEach((index, name) -> players[index] = name);

        return players;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(solution(players, callings)));
    }
}
