public class Bandage {
    private static int solution(int[] bandage, int health, int[][] attacks) {
        int lastTime = attacks[attacks.length - 1][0];
        int successTime = 0;
        int castingTime = bandage[0];
        int heal = bandage[1];
        int bonusHeal = bandage[2];
        int maxHealth = health;
        int attackIndex = 0;

        for (int i = 1; i <= lastTime; i++) {
            if (attacks[attackIndex][0] == i) {
                health -= attacks[attackIndex][1];
                successTime = 0;
                attackIndex++;

                if (health <= 0) return -1;
            } else {
                health += heal;
                successTime++;

                if (successTime == castingTime) {
                    health += bonusHeal;
                    successTime = 0;
                }
                if (health > maxHealth) health = maxHealth;
            }
        }

        return health;
    }

    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println(solution(bandage, health, attacks));
    }
}
