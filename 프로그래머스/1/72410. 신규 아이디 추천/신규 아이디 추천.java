class Solution {
    public String solution(String id) {
        id = id.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        for (char c : id.toCharArray()) {
            if(c >= 'a' && c <= 'z')
                sb.append(c);
            else if (c >= '0' && c <= '9')
                sb.append(c);
            else if (c == '-' || c == '_' || c == '.')
                sb.append(c);
        }
        
        id = sb.toString();
        sb = new StringBuilder();
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if(c != '.')
                sb.append(c);
            else if (c == '.' && (i != 0 && id.charAt(i - 1) != '.'))
                sb.append(c);
        }
        
        if (sb.length() != 0 && sb.charAt(sb.length() - 1) == '.')
            sb.deleteCharAt(sb.length() - 1);
        
        id = sb.toString();
        
        if(id.length() == 0)
            id = "a";
        
        if (id.length() >= 16) {
            id = id.substring(0, 15);
            if (id.charAt(id.length() - 1) == '.')
                id = id.substring(0, 14);
        }
        
        while(id.length() <= 2)
            id = id + id.charAt(id.length() - 1);
        
        return id;
        
        
                     
    
        
    }
}