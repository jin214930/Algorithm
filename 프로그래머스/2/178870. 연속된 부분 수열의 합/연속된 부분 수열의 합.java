class Solution {
    public int[] solution(int[] sequence, int k) {        
        int l = 0, r = 0, sum = sequence[0];
        int[] ans = new int[2];
        ans[1] = 10000000;
        
        while (r < sequence.length) {
            if (sum <= k) {
                if (sum == k) {
                    if (ans[1] - ans[0] > r - l) {
                        ans[0] = l;
                        ans[1] = r;
                    }
                }
                r++;
                if (r != sequence.length)
                sum += sequence[r];
            } else {
                sum -= sequence[l];
                l++;
            }
        }
        
        return ans;      
    }
}