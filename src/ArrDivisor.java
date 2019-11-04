import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


///////// first try
public class ArrDivisor {

	int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		int n = 0;
	      List<Integer> list = new ArrayList<Integer>();
	      for(int i : arr){
	          if (i%divisor == 0){
	              list.add(i);
	          }
	      }
	      answer = new int[list.size()];
	      for(int item : list) {
	    	  answer[n++] = item;
	      }
	      Arrays.sort(answer);
	      return answer;
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};
		
		ArrDivisor ard = new ArrDivisor();
		System.out.println(Arrays.toString(ard.solution(arr, 5)));
	}
}


////////////////////////////////////////////