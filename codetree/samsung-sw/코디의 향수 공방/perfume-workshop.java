import java.io.*;
import java.util.*;

public class Main {    
    static List<Integer> list = new ArrayList<>();
    static int[] values = new int[3001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(br.readLine());
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            
            int k;
            switch(cmd) {
            case 1:
                int n = Integer.parseInt(st.nextToken());
                for (int i = 0; i < n; i++) {
                    int s = Integer.parseInt(st.nextToken());
                    list.add(s);
                    values[s]++;
                }
                break;
            case 2:
                int v = Integer.parseInt(st.nextToken());
                list.add(v);
                values[v]++;
                break;
            case 3:
                int idx = Integer.parseInt(st.nextToken()) - 1;
                if (idx >= list.size() || list.get(idx) == null) {
                    bw.write("-1\n");
                } else {
                    bw.write(list.get(idx) + "\n");
                    values[list.get(idx)]--;
                    list.set(idx, null);
                }
                break;
            case 4:
                k = Integer.parseInt(st.nextToken());
                
                int[] d = new int[k + 1];
                Arrays.fill(d, Integer.MAX_VALUE);
                d[0] = 0;
                
                for (int i = 1; i <= k; i++) {                    
                    for (int j = 0; j < i; j++) {
                        if (d[j] != Integer.MAX_VALUE && values[i - j] != 0) {
                            d[i] = Math.min(d[i], d[j] + 1);
                        }
                    }
                }
                
                if (d[k] == Integer.MAX_VALUE) {
                    bw.write("-1\n");
                } else {
                    bw.write(d[k] + "\n");
                }
                break;
            case 5:
                k = Integer.parseInt(st.nextToken());
                
                long[] pair = new long[6001];
                for (int i = 1; i <= 3000; i++) {
                    if (values[i] == 0) continue;
                    for (int j = 1; j <= 3000; j++) {
                        pair[i + j] += (long) values[i] * values[j];
                    }
                }
                
                long[] suffix = new long[6002];
                for (int i = 6000; i >= 0; i--) {
                    suffix[i] = suffix[i + 1] + pair[i];
                }
                
                long ret = 0;
                for (int i = 1; i <= 3000; i++) {
                    if (values[i] == 0) continue;
                    
                    int need = k - i;
                    if (need <= 0) {
                        ret += (long) values[i] * suffix[0];
                    } else {
                        ret += (long) values[i] * suffix[need];
                    }
                }
                
                bw.write(ret + "\n");
                break;
            }
        }
        
        bw.flush(); 
    }
}
