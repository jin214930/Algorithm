class Solution {
    public long solution(int[] sequence) {
        long[][] d = new long[sequence.length][2];
        
        d[0][0] = sequence[0];
        d[0][1] = -sequence[0];
        
        long ans = Math.abs(sequence[0]);
        for (int i = 1; i < sequence.length; i++) {
            d[i][0] = Math.max(d[i - 1][1] + sequence[i], sequence[i]);
            d[i][1] = Math.max(d[i - 1][0] - sequence[i], -sequence[i]);
            ans = Math.max(ans, Math.max(d[i][0], d[i][1]));
        }
        
        return ans;
    }
}