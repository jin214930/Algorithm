class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i - 1) == ' ') {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    sb.append((char)(c - 'a' + 'A'));
                } else {
                    sb.append(c);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}