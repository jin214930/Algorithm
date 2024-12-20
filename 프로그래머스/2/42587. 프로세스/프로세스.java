import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Process(i, priorities[i]));
            pq.add(priorities[i]);
        }
        
        int ans = 1;
        while (true) {
            int mx = pq.poll();
            while (mx != q.peek().priority) {
                q.add(q.peek());
                q.poll();
            }
            
            if (q.peek().idx == location) {
                return ans;
            }
            q.poll();
            ans++;
        }
        
    }
}

class Process {
    int idx;
    int priority;
    
    public Process(int idx, int priority) {
        this.idx = idx;
        this.priority = priority;
    }
}