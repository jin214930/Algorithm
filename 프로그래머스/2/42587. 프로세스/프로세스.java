import java.util.*;

class Process {
    int p, idx;
    
    Process(int p, int idx) {
        this.p = p;
        this.idx = idx;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < priorities.length; i++) {
            q.add(new Process(priorities[i], i));
            pq.add(priorities[i]);
        }
        
        int ans = 1;
        while(!q.isEmpty()) {
            while(pq.peek() != q.peek().p) 
                q.add(q.poll());
            
            Process process = q.poll();
            pq.poll();
            if(process.idx == location)
                return ans;
            ans++;                
        }
        
        return 0;
    }
}