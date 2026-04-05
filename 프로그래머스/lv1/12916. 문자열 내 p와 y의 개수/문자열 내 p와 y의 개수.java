class Solution {
    boolean solution(String s) {
        int cntP = 0, cntY = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P')
                cntP++;
            else if (c == 'y' || c == 'Y')
                cntY++;
        }
        
        return cntP == cntY;
    }
}