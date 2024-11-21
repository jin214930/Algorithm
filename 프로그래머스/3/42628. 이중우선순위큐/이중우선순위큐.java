import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> mnh = new PriorityQueue<>();
        PriorityQueue<Integer> mxh = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for (String s : operations) {
            char c = s.charAt(0);
            int n = Integer.parseInt(s.substring(2));
            if (c == 'I') {
                mnh.add(n);
                mxh.add(n);
                if (mp.containsKey(n))
                    mp.put(n, mp.get(n) + 1);
                else
                    mp.put(n, 1);
            }
            else if (n == 1) {
                while (!mxh.isEmpty()) {
                    int x = mxh.poll();
                    if (mp.get(x) == 0) 
                        continue;
                    mp.put(x, mp.get(x) - 1);
                    break;
                }
            }
            else {
                while (!mnh.isEmpty()) {
                    int x = mnh.poll();
                    if (mp.get(x) == 0) 
                        continue;
                    mp.put(x, mp.get(x) - 1);
                    break;
                }
            }
        }
        
        int[] ans = new int[2];
        while (!mxh.isEmpty()) {
            int x = mxh.poll();
            if (mp.get(x) == 0) 
                continue;
            ans[0] = x;
            break;
        }
        
        while (!mnh.isEmpty()) {
            int x = mnh.poll();
            if (mp.get(x) == 0) 
                continue;
            ans[1] = x;
            break;
        }
            
        return ans;
    }
}