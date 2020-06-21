function solution(a, b) {
  var dayLabel = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
  return dayLabel[new Date(`2016-${a}-${b}`).getDay()];
}

console.log(solution(5, 24));
