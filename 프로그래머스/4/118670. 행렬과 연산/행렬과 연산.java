import java.util.*;

class Solution {
    int r, c;
    ArrayDeque<Integer> c1, c2;
    ArrayDeque<ArrayDeque<Integer>> rs;
    
    void rotate() {
        if(c == 2) {
            c2.addFirst(c1.pollFirst());
            c1.addLast(c2.pollLast());
            return;
        }
        rs.peekFirst().addFirst(c1.pollFirst());
        c2.addFirst(rs.peekFirst().pollLast());
        rs.peekLast().addLast(c2.pollLast());
        c1.addLast(rs.peekLast().pollFirst());
    }
    
    void shiftRow() {
        rs.addFirst(rs.pollLast());
        c1.addFirst(c1.pollLast());
        c2.addFirst(c2.pollLast());
    }
    
    public int[][] solution(int[][] rc, String[] operations) {
        r = rc.length;
        c = rc[0].length;
        
        c1 = new ArrayDeque<>();
        c2 = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            c1.addLast(rc[i][0]);
            c2.addLast(rc[i][c - 1]);
        }
        
        rs = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            for (int j = 1; j < c - 1; j++)
                tmp.addLast(rc[i][j]);
            rs.addLast(tmp);
        }
        
        for (String s : operations) {
            if (s.equals("Rotate"))
                rotate();
            else
                shiftRow();
        }
        
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            ans[i][0] = c1.pollFirst();
            ans[i][c - 1] = c2.pollFirst();
        }
        
        int idx = 0;
        for(ArrayDeque<Integer> i : rs) {
            for(int j = 1; j < c - 1; j++)
                ans[idx][j] = i.pollFirst();
            idx++;
        }
        
        return ans;
    }
}