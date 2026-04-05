class Solution {
    public int solution(int n, int m, int[] section) {
        int ans = 0;
        int tmp = 0;
        
        for (int i : section) {
            if (tmp < i)
                tmp = i;
            else
                continue;
            tmp += m - 1;
            ans++;
        }
        
        return ans;
    }
}