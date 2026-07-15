class Solution {
    public String solution(String new_id) {
        String id = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : id.toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c == '-' || c == '_' || c == '.')
                sb.append(c);
        }
        
        id = sb.toString();
        sb.setLength(0);
        
        boolean flag = false;
        for (char c : id.toCharArray()) {
            if (c == '.') {
                if (flag) continue;
                else {
                    sb.append(c);
                    flag = true;
                }
            } else {
                sb.append(c);
                flag = false;
            }
        }
        
        if (sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        id = sb.toString();
        if (id.length() == 0) id = "a";
        if (id.length() >= 16) {
            id = id.substring(0, 15);
            if (id.charAt(14) == '.') id = id.substring(0, 14);
        }
        
        while (id.length() < 3) {
            id = id + id.charAt(id.length() - 1);
        }
        
        return id;
    }
}