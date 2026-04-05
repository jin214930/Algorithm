class Solution {
    public String solution(String s) {
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        s += " ";
        int idx = -1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                int n = Integer.parseInt(s.substring(idx + 1, i));
                idx = i;
                mx = Math.max(mx, n);
                mn = Math.min(mn, n);
            }
            
        }
        String ans = "";
        ans += mn;
        ans += " ";
        ans += mx;
        return ans;
    }
}