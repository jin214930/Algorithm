class Solution {
    public int solution(String s) {
        int ans = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = getPalin(s, i, i);
            int len2 = getPalin(s, i, i + 1);
            
            ans = Math.max(ans, Math.max(len1, len2));
        }
        
        return ans;
    }
    
    int getPalin(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        
        return r - l - 1;
    }
}