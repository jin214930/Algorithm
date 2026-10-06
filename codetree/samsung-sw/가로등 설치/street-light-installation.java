import java.io.*;
import java.util.*;

public class Main {    
    static class Interval {
        int l, r;
        
        public Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Interval)) return false;
            
            Interval i = (Interval) o;
            
            return l == i.l && r == i.r;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(l, r);
        }
    }
    
    static int n;
    static int nextId;
    
    static int[] pos;
    static int[] prev;
    static int[] next;
    static boolean[] alive;
    static int head;
    static int tail;
    
    static PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2) -> {
        int d1 = pos[i1.r] - pos[i1.l];
        int d2 = pos[i2.r] - pos[i2.l];
        if (d1 == d2) {
            return pos[i1.l] - pos[i2.l];
        }
        return d2 - d1;
    });
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(br.readLine());
        
        pos = new int[200001];
        prev = new int[200001];
        next = new int[200001];
        alive = new boolean[200001];
        
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            
            switch(cmd) {
            case 100:
                n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                for (int i = 1; i <= m; i++) {
                    pos[i] = Integer.parseInt(st.nextToken());
                    alive[i] = true;
                    if (i > 1) {
                        prev[i] = i - 1;
                        next[i - 1] = i;
                        pq.add(new Interval(i - 1, i));
                    }
                }
                
                head = 1;
                tail = m;
                nextId = m + 1;
                break;
            case 200:
                cleanPQ();
                
                Interval i = pq.poll();
                int l = i.l;
                int r = i.r;
                
                int id = nextId++;
                pos[id] = (pos[l] + pos[r] + 1) / 2;
                prev[id] = l;
                next[id] = r;
                alive[id] = true;
                
                next[l] = id;
                prev[r] = id;
                
                pq.add(new Interval(l, id));
                pq.add(new Interval(id, r));
                break;
            case 300:
                int d = Integer.parseInt(st.nextToken());
                int left = prev[d];
                int right = next[d];
                alive[d] = false;
                
                if (left != 0 && right != 0) {
                    next[left] = right;
                    prev[right] = left;
                    pq.add(new Interval(left, right));
                } else if (left == 0) {
                    head = right;
                    prev[right] = 0;
                } else {
                    tail = left;
                    next[left] = 0;
                }
                
                prev[d] = 0;
                next[d] = 0;
                break;
            case 400:
                cleanPQ();
                
                int maxGap = 0;
                if (!pq.isEmpty()) {
                    Interval maxInterval = pq.peek();
                    maxGap = pos[maxInterval.r] - pos[maxInterval.l];
                }
                
                int leftPower = 2 * (pos[head] - 1);
                int rightPower = 2 * (n - pos[tail]);
                
                int ans = Math.max(maxGap, Math.max(leftPower, rightPower));
                
                bw.write(ans + "\n");
                break;
            }
        }
    
        
        bw.flush(); 
    }
    
    static boolean isValid(Interval i) {
        return alive[i.l] && alive[i.r] && next[i.l] == i.r && prev[i.r] == i.l;
    }
    
    static void cleanPQ() {
        while(!pq.isEmpty() && !isValid(pq.peek())) {
            pq.poll();
        }
    }
}
