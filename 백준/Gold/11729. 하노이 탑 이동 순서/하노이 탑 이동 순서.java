import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static StringBuilder sb = new StringBuilder();

    static void go(int n, int from, int via, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            ans++;
            return;
        }

        go(n - 1, from, to, via);

        sb.append(from).append(" ").append(to).append("\n");
        ans++;

        go(n - 1, via, from, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        go(n, 1, 2, 3);

        bw.write(ans + "\n");
        bw.write(sb.toString());
        bw.flush();
    }
}