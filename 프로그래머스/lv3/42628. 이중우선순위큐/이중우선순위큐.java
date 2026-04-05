import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeSet<Integer> ts = new TreeSet<>();
        
        for (String s : operations) {
            String[] ops = s.split(" ");
            
            int n = Integer.parseInt(ops[1]);

            if (ops[0].equals("I")) {
                ts.add(n);
            } else {
                if (ts.isEmpty())
                    continue;
                if (n == 1) {
                    ts.remove(ts.last());
                } else {
                    ts.remove(ts.first());
                }
            }
        }
        
        int[] ans = new int[2];
        
        if (!ts.isEmpty()) {
            ans[0] = ts.last();
            ans[1] = ts.first();
        }
        
        return ans;        
    }
}