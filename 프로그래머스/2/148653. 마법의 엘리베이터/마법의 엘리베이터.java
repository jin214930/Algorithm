class Solution {
    static int ans = Integer.MAX_VALUE;
    
    public int solution(int storey) {
        go(storey, 0);
        
        return ans;
    }
    
    static void go(int storey, int cnt) {
        if (storey == 0) {
            ans = Math.min(ans, cnt);
            return;
        }
        
        int tmp = storey % 10;
        if (tmp < 5) {
            go(storey / 10, cnt + tmp);
        } else if (tmp > 5) {
            go(storey / 10 + 1, cnt + (10 - tmp));
        } else {
            go(storey / 10 + 1, cnt + 5);
            go(storey / 10, cnt + 5);
        }
    }
}