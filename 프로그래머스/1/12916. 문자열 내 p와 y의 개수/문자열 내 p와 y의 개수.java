class Solution {
    boolean solution(String s) {
        int cntP = 0, cntY = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'p') cntP++;
            else if (c == 'y') cntY++;
        }
        
        return cntP == cntY;
    }
}