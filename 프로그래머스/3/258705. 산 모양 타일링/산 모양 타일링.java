class Solution {
    public int solution(int n, int[] tops) {
        int[][] d = new int[n + 1][2];
        d[0][1] = 1;
        for (int i = 0; i < n; i++) {
            d[i + 1][0] = (d[i][1] + d[i][0]) % 10007;
            if (tops[i] == 1)
                d[i + 1][1] = (d[i][0] * 2 + d[i][1] * 3) % 10007;
            else
                d[i + 1][1] = (d[i][0] + d[i][1] * 2) % 10007;
        }
        
        return (d[n][0] + d[n][1]) % 10007;
    }
}