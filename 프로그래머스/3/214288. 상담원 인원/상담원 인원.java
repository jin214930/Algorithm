import java.util.*;

class Solution {
    int ans = 1000000000;
    int[] a;
    
    void go(int idx, int cnt, int k, int n, int[][] reqs) {
        if(cnt == n - k) {
            int[] b = new int[k + 1];
            for(int i = 0; i < k;i++)
                b[i + 1] = a[i];
            int sum = 0;
            PriorityQueue<Integer>[] pqs = new PriorityQueue[k + 1];
            for(int i = 0; i <= k; i++)
                pqs[i] = new PriorityQueue<>();
            
            for(int[] i : reqs) {
                if(b[i[2]] == 0) {
                    if(pqs[i[2]].peek() <= i[0]) {
                        pqs[i[2]].poll();
                        pqs[i[2]].add(i[0] + i[1]);
                    }
                    else {
                        int tmp = pqs[i[2]].poll();
                        sum += tmp - i[0];
                        pqs[i[2]].add(tmp + i[1]);
                    }
                }
                else {
                    b[i[2]]--;
                    pqs[i[2]].add(i[0] + i[1]);
                }
            }
            
            ans = Math.min(ans, sum);
            return;
        }
        for(int i = idx; i < k; i++) {
            a[i]++;
            go(i, cnt + 1, k, n, reqs);
            a[i]--;
        }
    }
    
    public int solution(int k, int n, int[][] reqs) {
        a = new int[k];
        Arrays.fill(a, 1);
        go(0, 0, k, n, reqs);
        
        return ans;
    }
}