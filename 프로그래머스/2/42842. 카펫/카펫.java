class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];
        for(int i = 1; i <= (int)Math.sqrt(yellow); i++) {
            if(yellow % i != 0)
                continue;
            int x = i;
            int y = yellow / i;
            if(2 * x + 2 * y + 4 == brown) {
                ans[0] = y + 2;
                ans[1] = x + 2;
                return ans;
            }
                
        }
        return ans;
    }
}