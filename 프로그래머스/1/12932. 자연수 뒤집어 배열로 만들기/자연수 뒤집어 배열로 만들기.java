class Solution {
    public int[] solution(long n) {
        String s = n + "";
        
        int[] ans = new int[s.length()];
        
        int idx = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            ans[idx++] = s.charAt(i) - '0';
        }
        
        return ans;
    }
}