import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] visited = new boolean[101];
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            visited[x] = true;
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x  = Integer.parseInt(st.nextToken());
            if (!visited[x]) {
                bw.write("No");
                bw.flush();
                return;
            }
        }
        
        bw.write("Yes");
        bw.flush();
    }
}