import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder(new_id.toLowerCase());
        
        int i = 0;
        while (i < sb.length()) {
            char c = sb.charAt(i);
            if (!(c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c == '-' || c == '_' || c == '.')) {
                sb.deleteCharAt(i);
                continue;
            }
            i++;
        }
        
        i = 0;
        while(i < sb.length() - 1) {
            if (sb.charAt(i) == '.' && sb.charAt(i) == sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                continue;
            }
            i++;
        }
        

        if (sb.length() > 0 && sb.charAt(0) == '.')
            sb.deleteCharAt(0);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.')
            sb.deleteCharAt(sb.length() - 1);
        if (sb.length() == 0)
            sb.append("a");
        if (sb.length() >= 16) {
            sb.setLength(15);
            if (sb.charAt(sb.length() - 1) == '.')
                sb.deleteCharAt(sb.length() - 1);
        }
        if (sb.length() <= 2) {
            while (sb.length() != 3)
                sb.append(sb.charAt(sb.length() - 1));
        }
                
        return sb.toString();
    }
}