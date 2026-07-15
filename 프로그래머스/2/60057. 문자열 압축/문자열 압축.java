class Solution {
    public int solution(String s) {
        int ans = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            String prev = "";
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j + i < s.length()) {
                String t = s.substring(j, j + i);
                if (t.equals(prev)) cnt++;
                else {
                    if (cnt > 1) sb.append(cnt);
                    sb.append(prev);
                    prev = t;
                    cnt = 1;
                }
                j += i;
            }
            
            String t = s.substring(j);
            if (t.equals(prev)) {
                cnt++;
                if (cnt > 1) sb.append(cnt);
                sb.append(prev);
            } else {
                if (cnt > 1) sb.append(cnt);
                sb.append(prev);
                sb.append(t);
            }
            
            ans = Math.min(ans, sb.length());
        }
        
        return ans;
    }
}