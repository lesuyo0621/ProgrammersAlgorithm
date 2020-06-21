function solution(array, commands) {
  var answer = [];
  var checkArr = [];

  for (var i = 0; i < commands.length; i++) {
    answer.push(
      array.slice(commands[i][0] - 1, commands[i][1]).sort((a, b) => a - b)[
        commands[i][2] - 1
      ]
    );
  }

  return answer;
}

var array = [1, 5, 2, 6, 3, 7, 4];
var commands = [
  [2, 5, 3],
  [4, 4, 1],
  [1, 7, 3],
];

console.log(solution(array, commands));
