import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String s : operations) {
            String[] ops = s.split(" ");
            
            int n = Integer.parseInt(ops[1]);

            if (ops[0].equals("I")) {
                minH.add(n);
                maxH.add(n);
            } else {
                if (minH.isEmpty())
                    continue;
                if (n == 1) {
                    int x = maxH.poll();
                    minH.remove(x);
                } else {
                    int x = minH.poll();
                    maxH.remove(x);
                }
            }
        }
        
        int[] ans = new int[2];
        
        if (!maxH.isEmpty()) {
            ans[0] = maxH.poll();
            ans[1] = minH.poll();
        }
        
        return ans;        
    }
}