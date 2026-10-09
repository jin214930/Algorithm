import java.io.*;
import java.util.*;

public class Main {    
    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int q = Integer.parseInt(br.readLine());
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            
            if (cmd == 100) {
                n = Integer.parseInt(st.nextToken());
                
                for (int i = 1; i <= n; i++) {
                    int x = Integer.parseInt(st.nextToken());
                    list.add(x);
                    map.put(i, x);
                }
            } else if (cmd == 200) {
                int x = Integer.parseInt(st.nextToken());
                list.add(x);
                map.put(++n, x);
            } else if (cmd == 300) {
                int x = Integer.parseInt(st.nextToken());
                list.remove(Integer.valueOf(map.get(x)));                
                map.remove(x);
            } else {
                int r = Integer.parseInt(st.nextToken());
                
                int s = 0;
                int e = 1000000000;
                int ans = 0;
                while(s <= e) {
                    int m = (s + e) / 2;
                    if (check(m, r)) {
                        e = m - 1;
                        ans = m;
                    } else {
                        s = m + 1;
                    }
                }
                bw.write(ans + "\n");
            }
        }
        
        bw.flush(); 
    }
    
    static boolean check(int m, int r) {
        int s = list.get(0);
        
        int cnt = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - s > m) {
                s = list.get(i);
                cnt++;
            }
        }

        return cnt <= r;
    }
}
