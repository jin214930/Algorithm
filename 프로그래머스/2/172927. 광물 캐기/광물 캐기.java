class Solution {
    static int n;
    static int ans = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        n = minerals.length;
        
        go(0, 0, picks[0], picks[1], picks[2], minerals);
        
        return ans;
    }
    
    static void go(int idx, int sum, int dia, int iron, int stone, String[] minerals) {
        if (idx == n || (dia == 0 && iron == 0 && stone == 0)) {
            ans = Math.min(ans, sum);
            return;
        }
        
        if (dia > 0) {
            int tmp = 0;
            for (int i = 0; i < 5; i++) {
                if (idx + i >= n) break;
                tmp += 1;
            }
            
            go(Math.min(n, idx + 5), sum + tmp, dia - 1, iron, stone, minerals);
        }
        
        if (iron > 0) {
            int tmp = 0;
            for (int i = 0; i < 5; i++) {
                if (idx + i >= n) break;
                if (minerals[idx + i].equals("diamond")) tmp += 5;
                else tmp += 1;
            }
            
            go(Math.min(n, idx + 5), sum + tmp, dia, iron - 1, stone, minerals);
        }
        
        if (stone > 0) {
            int tmp = 0;
            for (int i = 0; i < 5; i++) {
                if (idx + i >= n) break;
                if (minerals[idx + i].equals("diamond")) tmp += 25;
                else if (minerals[idx + i].equals("iron")) tmp += 5;
                else tmp += 1;
            }
            
            go(Math.min(n, idx + 5), sum + tmp, dia, iron, stone - 1, minerals);
        }
    }
}