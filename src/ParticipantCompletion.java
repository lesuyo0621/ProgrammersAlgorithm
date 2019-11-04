import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


///////// first try  [ acc : 50, eff : 0  = total 50/100 ]
public class ParticipantCompletion {
	
	String solution(String[] participant, String[] completion) {
        String answer = "";
        
        List<String> participantlist = new ArrayList<String>();
        Collections.addAll(participantlist, participant);

        for(String item : completion){
            participantlist.remove(item);
        }
        answer = participantlist.get(0);
        
        return answer;
    }

	public static void main(String[] args) {
		ParticipantCompletion pc = new ParticipantCompletion();
		
		List<String> list = new ArrayList<String>();
		
		String[] p = new String[]{"mislav", "stanko", "mislav", "ana"};
		
		String[] c = new String[]{"stanko", "ana", "mislav"};
		
		System.out.println(pc.solution(p, c));
	}
}
