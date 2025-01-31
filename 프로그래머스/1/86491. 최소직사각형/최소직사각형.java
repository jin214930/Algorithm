import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        for (int[] size : sizes)
            Arrays.sort(size);
        
        int mxw = 0, mxh = 0;
        for (int[] size : sizes) {
            mxw = Math.max(mxw, size[0]);
            mxh = Math.max(mxh, size[1]);
        }
        
        return mxw * mxh;
    }
}