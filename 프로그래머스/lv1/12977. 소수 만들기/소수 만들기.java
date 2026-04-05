class Solution {
    public int solution(int[] nums) {
        boolean[] p = new boolean[3001];
        p[1] = true;
        
        for (int i = 2; i <= 3000; i++) {
            if(!p[i]) {
                for (int j = i * 2; j <= 3000; j += i) 
                    p[j] = true;
            }
        }
        
        int ans = 0;
        
        for (int i = 2; i < nums.length; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 0; k < j; k++) {
                    if (!p[nums[i] + nums[j] + nums[k]]) 
                        ans++;
                }
            }
        }
        
        return ans;
    }
}