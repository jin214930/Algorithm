import java.util.*;

class Job implements Comparable<Job> {
    int n;
    int s;
    int l;
    
    public Job(int n, int s, int l) {
        this.n = n;
        this.s = s;
        this.l = l;
    }
    
    @Override
    public int compareTo(Job j) {
        if (this.l == j.l) {
            if (this.s == j.s) 
                return this.n - j.n;
            return this.s - j.s;
        }
        return this.l - j.l;
    }
}

class Solution {    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        int t = 0;
        int idx = 0;
        int ans = 0;
        
        while(!(idx == jobs.length && pq.isEmpty())) {
            while(idx < jobs.length && jobs[idx][0] <= t) {
                pq.add(new Job(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if (pq.isEmpty())
               t = jobs[idx][0];
            else {
                Job j = pq.poll();
                t += j.l;
                ans += t - j.s;
            }
        }
        
        return ans / jobs.length;
    }
}