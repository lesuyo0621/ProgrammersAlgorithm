function solution(skill, skill_trees) {
  var answer = 0;
  let check = true;

  for (let i = 0; i < skill_trees.length; i++) {
    for (let j = skill.length - 1; j >= 1; j--) {
      if (skill_trees[i].indexOf(skill.charAt(j)) == -1) {
        continue;
      }
      if (
        skill_trees[i].indexOf(skill.charAt(j)) != -1 &&
        skill_trees[i].indexOf(skill.charAt(j - 1)) == -1
      ) {
        check = false;
        break;
      }
      if (
        skill_trees[i].indexOf(skill.charAt(j)) <
        skill_trees[i].indexOf(skill.charAt(j - 1))
      ) {
        check = false;
        break;
      }
      if (
        skill_trees[i].indexOf(skill.charAt(j)) >
        skill_trees[i].indexOf(skill.charAt(j - 1))
      ) {
        continue;
      }
    }
    if (check == true) {
      answer++;
    } else {
      check = true;
    }
  }
  return answer;
}

const skill = "CBD";
const skill_trees = ["BACDE", "CBADF", "AECB", "BDA"];

console.log(solution(skill, skill_trees));
