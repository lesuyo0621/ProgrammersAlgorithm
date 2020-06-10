function solution(arr) {
  var answer = [];

  var index = 0;
  answer[index] = arr[0];
  index++;

  for (var num in arr) {
    if (answer[index - 1] !== arr[num]) {
      answer[index] = arr[num];
      index++;
    }
  }

  return answer;
}

var arr = [1, 1, 3, 3, 0, 1, 1];
console.log(solution(arr));
