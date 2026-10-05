import java.io.*;
import java.util.*;

public class Main {
    static class Jewel {
        int w, v;
        
        public Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    
    static List<Jewel> jewels = new ArrayList<>();
    static int[] weights = new int[3001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(br.readLine());
        
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            
            int w;
            switch(cmd) {
            case 1:
                int n = Integer.parseInt(st.nextToken());
                for (int i = 0; i < n; i++) {
                    w = Integer.parseInt(st.nextToken());
                    int v = Integer.parseInt(st.nextToken());
                    jewels.add(new Jewel(w, v));
                    weights[w]++;
                }
                break;
            case 2:
                w = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                jewels.add(new Jewel(w, v));
                weights[w]++;
                break;
            case 3:
                int idx = Integer.parseInt(st.nextToken()) - 1;
                if (idx >= jewels.size() || jewels.get(idx) == null) {
                    bw.write("-1\n");
                } else {
                    Jewel jewel = jewels.get(idx);
                    bw.write(jewel.v + "\n");
                    weights[jewel.w]--;
                    jewels.set(idx, null);
                }
                break;
            case 4:
                w = Integer.parseInt(st.nextToken());
                
                int[] dp = new int[w + 1];
                for (Jewel jewel : jewels) {
                    if (jewel == null || jewel.w > w) continue;
                    
                    for (int i = w; i >= jewel.w; i--) {
                        dp[i] = Math.max(dp[i], dp[i - jewel.w] + jewel.v);
                    }
                }
                
                bw.write(dp[w] + "\n");
                break;
            case 5:
                int d = Integer.parseInt(st.nextToken());
                
                int[] pSum = new int[3001];
                for (int i = 1; i <= 3000; i++) {
                    pSum[i] = pSum[i - 1] + weights[i];
                }
                
                long ret = 0;
                for (int i = 1; i <= 3000; i++) {
                    long cnt = weights[i];
                    ret += cnt * (cnt - 1) / 2;
                    int maxW = Math.min(3000, i + d);
                    ret += cnt * (pSum[maxW] - pSum[i]);
                }
                
                bw.write(ret + "\n");
                break;
            }
        }
        
        bw.flush(); 
    }
}
