import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> mnh = new PriorityQueue<>();
        PriorityQueue<Integer> mxh = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String s : operations) {
            char c = s.charAt(0);
            int x = Integer.parseInt(s.substring(2));

            if (c == 'I') {
                mnh.add(x);
                mxh.add(x);
            } else if (x == 1 && !mxh.isEmpty()) { 
                mnh.remove(mxh.poll());
            } else if (x == -1 && !mnh.isEmpty()) {
                mxh.remove(mnh.poll());
            } 
        }
        
        int[] ans = new int[2];
        
        if (!mxh.isEmpty()) {
            ans[0] = mxh.peek();
            ans[1] = mnh.peek();
        }
        
        return ans;
    }
}