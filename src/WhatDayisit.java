import java.util.Date;

///////// first try  [ acc : 100 = total 100/100 ]
public class WhatDayisit {
	
	public String solution(int a, int b) {
	      String answer = "";
	      int totaldays = 0;
	      String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
	      
	      for(int i = 2; i < a+1; i++){
	          if(i == 3){
	              totaldays = totaldays + 29;
	          }else if(i == 5 || i == 7 || i == 10 || i == 12){
	              totaldays = totaldays + 30;
	          }else if(i == 2 || i == 4 || i == 6 || i == 8 || i == 9 || i == 11){
	              totaldays = totaldays + 31;
	          }
	      }
	      totaldays = totaldays + b;

	      answer = days[totaldays % 7];
	      
	      return answer;
	}

	public static void main(String[] args) {
		WhatDayisit wd = new WhatDayisit();
		
		System.out.println(wd.solution(1, 1));
		System.out.println(wd.solution(5, 24));
	}

}

///////// OTher's Answer 1

/*

class Solution {
  public String solution(int a, int b) {
      String answer = "";

      int[] c = {31,29,31,30,31,30,31,31,30,31,30,31};
      String[] MM ={"FRI","SAT","SUN","MON","TUE","WED","THU"};
      int Adate = 0;
      for(int i = 0 ; i< a-1; i++){
          Adate += c[i];
      }
      Adate += b-1;
      answer = MM[Adate %7];

      return answer;
  }
}

 */

///////// My other Answer ( Too Late )

/*
	public String solution2(int a, int b) {
	    String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
		String day = days[new Date(2016+1900, a-1, b).getDay()];
		return day;
	}
 
*/

