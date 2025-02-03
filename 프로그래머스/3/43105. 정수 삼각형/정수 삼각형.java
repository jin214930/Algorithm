class Solution {
    public int solution(int[][] triangle) {
        int[][] d = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) 
            d[i] = new int[triangle[i].length];
        d[0][0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            d[i][0] = d[i - 1][0] + triangle[i][0];
            for (int j = 1; j < triangle[i].length - 1; j++) 
                d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + triangle[i][j];
            d[i][triangle[i].length - 1] = d[i - 1][triangle[i - 1].length - 1] + triangle[i][triangle[i].length - 1];
        }
        
        int ans = 0;
        for (int  i = 0; i < triangle.length; i++) 
            ans = Math.max(ans, d[triangle.length - 1][i]);
        return ans;
    }
}