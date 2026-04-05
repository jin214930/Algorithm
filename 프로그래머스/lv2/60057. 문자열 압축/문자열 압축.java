class Solution {
    public int solution(String s) {
        int ans = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int cnt = 1;
            
            for (int j = i; j < s.length(); j += i) {
                int end = Math.min(j + i, s.length());
                String curr = s.substring(j, end);
                
                if (prev.equals(curr)) 
                    cnt++;
                else {
                    if (cnt >= 2)
                        sb.append(cnt);
                    sb.append(prev);
                    prev = curr;
                    cnt = 1;
                }
            }
            
            if (cnt >= 2)
                sb.append(cnt);
            sb.append(prev);
            
            ans = Math.min(ans, sb.length());
        }
        
        return ans;
    }
}