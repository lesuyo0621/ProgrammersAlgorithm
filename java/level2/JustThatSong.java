import java.util.*;

public class JustThatSong {
    private static String convertNote(String targetNote) {
        String[] notes = {"C#", "D#", "E#", "F#", "G#", "A#", "B#", "C", "D", "E", "F", "G", "A", "B"};
        StringBuilder sb = new StringBuilder();

        while (targetNote.length() > 0) {
            for (int i = 0; i < notes.length; i++) {
                if (targetNote.startsWith(notes[i])) {
                    if (sb.length() > 0) sb.append(",");
                    sb.append(i);

                    targetNote = targetNote.substring(notes[i].length());
                    break;
                }
            }
        }

        return sb.toString();
    }

    private static int convertMinute(String time) {
        String[] times = time.split(":");

        int minute = 0;
        minute += Integer.parseInt(times[0]) * 60;
        minute += Integer.parseInt(times[1]);

        return minute;
    }

    private static String solution(String m, String[] musicinfos) {
        List<String> playList = new ArrayList<>();
        Map<String, Integer> playTimeMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String findNote = convertNote(m);

        for (String music : musicinfos) {
            String[] mInfo = music.split(",");
            int playTime = convertMinute(mInfo[1]) - convertMinute(mInfo[0]);
            String title = mInfo[2];
            String note = convertNote(mInfo[3]);
            String[] notes = note.split(",");

            int time = playTime;
            while (time / notes.length > 0) {
                if (sb.length() > 0) sb.append(",");
                sb.append(note);
                time -= notes.length;
            }

            for (int i = 0; i < time; i++) {
                if (sb.length() > 0) sb.append(",");
                sb.append(notes[i]);
            }

            if (sb.toString().contains(findNote)) {
                playList.add(title);
                playTimeMap.put(title, playTime);
            }

            sb.setLength(0);
        }

        String answer = "(None)";
        int maxPlayTime = 0;
        for (int i = 0; i < playList.size(); i++) {
            String title = playList.get(i);
            int playTime = playTimeMap.get(title);

            if (maxPlayTime < playTime) {
                answer = title;
                maxPlayTime = playTime;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
}
