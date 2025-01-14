import java.util.*;

class Job implements Comparable<Job> {
    int n;
    int r_time;
    int time;
    
    public Job(int n, int r_time, int time) {
        this.n = n;
        this.r_time = r_time;
        this.time = time;
    }
    
    @Override
    public int compareTo(Job j) {
        if (j.time == this.time) {
            if (j.r_time == this.r_time)
                return this.n - j.n;
            return this.r_time - j.r_time; 
        }
        return this.time - j.time;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        int t = 0, idx = 0, ans = 0;
        
        while(!(idx == jobs.length && pq.isEmpty())) {
            while(idx < jobs.length && jobs[idx][0] <= t) {
                pq.add(new Job(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if (pq.isEmpty())
               t = jobs[idx][0];
            else {
                Job j = pq.poll();
                t += j.time;
                ans += t - j.r_time;
            }
        }
        
        return ans / jobs.length;
    }
}
