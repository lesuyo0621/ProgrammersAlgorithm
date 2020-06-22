function solution(arr, divisor) {
  var answer = arr.filter((num) => num % divisor === 0).sort((a, b) => a - b);
  return answer.length === 0 ? [-1] : answer;
}

console.log(solution([5, 9, 7, 10], 5));
