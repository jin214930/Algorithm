class Solution {
    boolean solution(String s) {
        int cntp = 0, cnty = 0;
        for(char c : s.toCharArray()) {
            if(c == 'p' || c == 'P')
                cntp++;
            if(c == 'y' || c == 'Y')
                cnty++;
        }
        
    
        return cntp == cnty;
    }
}