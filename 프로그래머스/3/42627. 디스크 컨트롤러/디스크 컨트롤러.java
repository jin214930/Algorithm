import java.util.*;

class Job {
    int s, l, i;
    
    Job(int s, int l, int i) {
        this.s = s;
        this.l = l;
        this.i = i;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        List<Job> list = new ArrayList<>();
        for(int i = 0; i < jobs.length; i++) 
            list.add(new Job(jobs[i][0], jobs[i][1], i));
        
        Collections.sort(list, (j1, j2) -> j1.s - j2.s);
        
        PriorityQueue<Job> pq = new PriorityQueue<>((j1, j2) -> {
            if(j1.l == j2.l) {
                if(j1.s == j2.s)
                    return j1.i - j2.i;
                return j1.s - j2.s;
            }
            return j1.l - j2.l;
        });
        
        int idx = 0;
        int t = 0;
        int sum = 0;
        while(true) {
            if (idx == list.size() && pq.isEmpty())
                break;
            while(idx < list.size() && list.get(idx).s <= t) {
                pq.add(list.get(idx));
                idx++;
            }
            
            if(pq.isEmpty()) {
                t = list.get(idx).s;
            } else {
                Job j = pq.poll();
                t += j.l;
                sum += t - j.s;
            }
        }
        
        return sum / jobs.length;
    }
}