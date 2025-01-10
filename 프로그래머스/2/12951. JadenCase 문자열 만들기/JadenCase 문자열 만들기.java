class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        
        for (char c : s.toLowerCase().toCharArray()) {
            if (flag && c >= 'a' && c <= 'z') {
                sb.append((char) (c + 'A' - 'a'));
                flag = false;
            } else if (c == ' ') {
                sb.append(c);
                flag = true;
            } else {
                sb.append(c);
                flag = false;
            }
        }
        
        return sb.toString();
    }
}