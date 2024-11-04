class Solution {
    boolean solution(String s) {
        int cntp = 0, cnty = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p')
                cntp++;
            if (c == 'y')
                cnty++;
        }
        
        return cntp == cnty;
    }
}