class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 1000000; i++) 
            sb.append(Integer.toString(i, n));
        
        StringBuilder ans = new StringBuilder();
        int idx = p - 1;
        while (ans.length() != t) {
            ans.append(sb.charAt(idx));
            idx += m;
        }
        
        return ans.toString().toUpperCase();
    }
}