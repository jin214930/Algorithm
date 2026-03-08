class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                idx = 0;
                sb.append(c);
            } else {
                if (idx % 2 == 0) {
                    if (c >= 'a' && c <= 'z')
                        sb.append((char)(c - 'a' + 'A'));
                    else
                        sb.append(c);
                } else {
                    if (c >= 'a' && c <= 'z')
                        sb.append(c);
                    else
                        sb.append((char)(c - 'A' + 'a'));
                }
                idx++;
            }
        }
        
        return sb.toString();
    }
}