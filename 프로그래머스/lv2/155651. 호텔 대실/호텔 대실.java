import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (bt1, bt2) -> {
            int s1 = stoi(bt1[0]);
            int s2 = stoi(bt2[0]);
            if (s1 == s2) return stoi(bt1[1]) - stoi(bt2[1]);
            
            return s1 - s2;
        });
        
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String[] bt : book_time) {
            while(!pq.isEmpty() && pq.peek() <= stoi(bt[0])) {
                pq.poll();
            }
            pq.add(stoi(bt[1]) + 10);
            ans = Math.max(ans, pq.size());
        }
        
        return ans;
    }
    
    int stoi(String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
    }
}