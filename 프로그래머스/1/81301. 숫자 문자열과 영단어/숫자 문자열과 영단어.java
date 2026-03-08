class Solution {
    
    public int solution(String s) {
        int ans = 0;
        
        int idx = 0;
        while(idx < s.length()) {
            char c = s.charAt(idx);
            ans *= 10;
            if(c >= '0' && c <= '9')
                ans += c - '0';
            else if (c == 'z') {
                idx+=3;
            } else if (c == 'o') {
                idx += 2;
                ans += 1;
            } else if (c == 't') {
                if (s.charAt(idx + 1) == 'w') {
                    idx += 2;
                    ans += 2;
                } else {
                    idx += 4;
                    ans += 3;
                }
            } else if (c == 'f') {
                if (s.charAt(idx + 1) == 'o') 
                    ans += 4;
                else
                    ans += 5;
                idx += 3;
            } else if (c == 's') {
                if (s.charAt(idx + 1) == 'i') {
                    idx += 2;
                    ans += 6;
                } else {
                    idx += 4;
                    ans += 7;
                }
            } else if (c == 'e') {
                idx += 4;
                ans += 8;
            } else {
                idx += 3;
                ans += 9;
            }
            
            idx++;
        }
        
        return ans;
    }
}