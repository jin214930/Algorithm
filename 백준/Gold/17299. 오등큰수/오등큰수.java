import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] ans = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            ans[i] = -1;
        }

        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && map.get(a[stk.peek()]) < map.get(a[i])) {
                ans[stk.pop()] = a[i];
            }

            stk.push(i);
        }

        for (int i : ans)
            bw.write(i + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
