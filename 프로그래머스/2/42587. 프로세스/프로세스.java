import java.util.*;

class Process {
    int priority;
    int idx;
    
    public Process(int priority, int idx) {
        this.priority = priority;
        this.idx = idx;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Process> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(new Process(priorities[i], i));
        }
        
        int ans = 1;
        while (true) {
            int mx = pq.poll();
            while (mx != q.peek().priority) {
                q.add(q.peek());
                q.poll();
            }
            
            Process p = q.poll();
            if (p.idx == location)
                return ans;
            ans++;
        }
    }
}