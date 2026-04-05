import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int h = 0;
        int w = 0;
        for(int[] size : sizes) {
            Arrays.sort(size);
            h = Math.max(h, size[1]);
            w = Math.max(w, size[0]);
        }
        
        return h * w;
    }
}