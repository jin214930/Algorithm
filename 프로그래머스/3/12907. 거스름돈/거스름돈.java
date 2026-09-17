class Solution {
    public int solution(int n, int[] money) {
        int[] d = new int[n + 1];
        
        d[0] = 1;     
        for (int m : money) {
            for (int i = m; i <= n; i++) {
                if (i - m >= 0) {
                    d[i] += d[i - m];
                    d[i] %= 1000000007;
                }
            }
        }
        
        return d[n];
    }
}