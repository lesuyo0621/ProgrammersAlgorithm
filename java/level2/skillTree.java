public class skillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String check = "";
        int Err = 0;

        for (int j = 0; j < skill_trees.length; j++) {
            for (int i = 0; i < skill_trees[j].length(); i++) {
                if (skill.contains(Character.toString(skill_trees[j].charAt(i)))) {
                    check = check + Character.toString(skill_trees[j].charAt(i));
                }
            }

            for (int k = 0; k < check.length(); k++) {
                if (skill.charAt(k) != check.charAt(k)) {
                    Err++;
                }
            }
            if (Err == 0) {
                answer++;
            }
            check = "";
            Err = 0;
        }
        return answer;
    }

    public static void main(String[] args) {

        String skill = "CBD";
        String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

        skillTree st = new skillTree();
        System.out.println(st.solution(skill, skill_trees));
    }
}