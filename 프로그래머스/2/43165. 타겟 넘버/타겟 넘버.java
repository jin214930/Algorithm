class Solution {
    int ans = 0;
    
    void dfs(int[] numbers, int idx, int target, int sum) {
        if (idx == numbers.length) {
            if (target == sum)
                ans++;
            return;
        }
        
        dfs(numbers, idx + 1, target, sum + numbers[idx]);
        dfs(numbers, idx + 1, target, sum - numbers[idx]);
        
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        
        return ans;
    }
}