class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int hp = health;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        for (int[] attack : attacks) {
            int tmp = attack[0] - time - 1;
            hp = Math.min(health, hp + x * tmp + y * (tmp / t));
            if (hp <= attack[1])
                return -1;
            hp -= attack[1];
            time = attack[0];
        }
        
        return hp;
    }
}