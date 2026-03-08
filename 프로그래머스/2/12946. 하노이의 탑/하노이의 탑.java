import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();
    
    void hanoi(int from, int by, int to, int n) {
        if (n == 1) {
            list.add(new int[]{from, to});
            return;
        }
        
        hanoi(from, to, by, n - 1);
        hanoi(from, by, to, 1);
        hanoi(by, from, to, n - 1);
    }
    
    public int[][] solution(int n) {
        hanoi(1, 2, 3, n);
        
        int[][] ans = new int[list.size()][2];
        
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        
        return ans;
    }
}