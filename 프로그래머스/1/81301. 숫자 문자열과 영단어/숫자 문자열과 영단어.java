class Solution {
    public int solution(String s) {
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            ans *= 10;
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                ans += c - '0';
                i++;
            }
            else if (c == 'z') 
                i += 4;
            else if (c == 'o') {
                ans += 1;
                i += 3;
            }
            else if (c == 't') {
                if (s.charAt(i + 1) == 'w') {
                    ans += 2;
                    i += 3;
                }
                else {
                    ans += 3;
                    i += 5;
                }
            }
            else if (c == 'f') {
                if (s.charAt(i + 1) == 'o') {
                    ans += 4;
                    i += 4;
                }
                else {
                    ans += 5;
                    i += 4;
                }
            }
            else if (c == 's') {
                if (s.charAt(i + 1) == 'i' ) {
                    ans += 6;
                    i += 3;
                }
                else {
                    ans += 7;
                    i += 5;
                }
            }
            else if (c == 'e') {
                ans += 8;
                i += 5;
            }
            else {
                ans += 9;
                i += 4;
            } 
        }
        
        return ans;
    }
}