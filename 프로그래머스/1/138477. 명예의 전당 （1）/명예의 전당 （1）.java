import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] ans = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);
            if (pq.size() == k + 1)
               pq.poll();
            ans[i] = pq.peek();
        }
        
        return ans;
    }
}