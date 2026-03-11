class Solution {
    public int solution(String[] babbling) {
        int ans = 0;
        
        for(String s : babbling) {
            if (check(s)) {
                ans++;
            }
        }
        
        return ans;
    }
    
    boolean check(String s) {
        if (s.length() == 1) {
            return false;
        }
        
        String prev = "";
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            
            if (c == 'a' && i + 2 < s.length() && s.substring(i, i + 3).equals("aya") && !prev.equals("aya")) {
                i += 3;
                prev = s.substring(i, i + 3);
            } else if (c == 'y' && i + 1 < s.length() && s.substring(i, i + 2).equals("ye") && !prev.equals("ye")) {
                i += 2;
                prev = s.substring(i, i + 2);
            } else if (c == 'w' && i + 2 < s.length() && s.substring(i, i + 3).equals("woo") && !prev.equals("woo")) {
                i += 3;
                prev = s.substring(i, i + 3);
            } else if (c == 'm' && i + 1 < s.length() && s.substring(i, i + 2).equals("ma") && !prev.equals("ma")) {
                i += 2;
                prev = s.substring(i, i + 2);
            } else {
                return false;
            }
        }
        
        return true;
    }
}