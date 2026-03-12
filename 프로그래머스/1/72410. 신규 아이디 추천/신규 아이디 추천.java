class Solution {
    public String solution(String new_id) {
        String id = new_id.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        for (char c : id.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.')
                sb.append(c);
        }
        
        id = sb.toString();
        sb = new StringBuilder();
        char tmp = '\0';
        for (char c : id.toCharArray()) {
            if (c == '.' && tmp == '.')
                continue;
            sb.append(c);
            tmp = c;
        }
        
        id = sb.toString();
        if (id.startsWith("."))
            id = id.substring(1);
        if (id.endsWith("."))
            id = id.substring(0, id.length() - 1);
        
        if (id.length() == 0)
            id = "a";
        
        if (id.length() >= 16) {
            id = id.substring(0, 15);
            if (id.endsWith("."))
                id = id.substring(0, 14);
        }
        
        while (id.length() < 3)
            id = id + id.charAt(id.length() - 1);
        
        return id;
        
        
    }
}