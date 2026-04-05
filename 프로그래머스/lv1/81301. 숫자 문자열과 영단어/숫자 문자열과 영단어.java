class Solution {
    public int solution(String s) {
        int ans = 0;    
        
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            ans = ans * 10;
            
            if (c >= '0' && c <= '9') {
                ans += c - '0';
            } else if (c == 'z') {
                i+= 3;
            } else if (c == 'o') {
                ans += 1;
                i+= 2;
            } else if (c == 't') {
                if (s.charAt(i + 1) == 'o') {
                    ans += 2;
                    i += 2;                    
                } else {
                    ans += 3;
                    i += 4;
                }
            } else if (c == 'f') {
                if (s.charAt(i + 1) == 'o') {
                    ans += 4;
                } else {
                    ans += 5;
                }
                i += 3;
            } else if (c == 's') {
                if (s.charAt(i + 1) == 'i') {
                    ans += 6;
                    i += 2;
                } else {
                    ans += 7;
                    i += 4;
                }
            } else if (c == 'e') {
                ans += 8;
                i += 4;
            } else {
                ans += 9;
                i += 3;
            }
            
            i++;
        }
        
        return ans;        
    }
}