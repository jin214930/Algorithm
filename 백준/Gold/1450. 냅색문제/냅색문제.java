import java.io.*;
import java.util.*;

public class Main {
    static int c;
    static int[] a;
    static List<Integer> left, right;

    static void go(List<Integer> list, int s, int e, int sum) {
        if (sum > c)
            return;
        if (s == e) {
            list.add(sum);
            return;
        }

        go(list, s + 1, e, sum);
        go(list, s + 1, e, sum + a[s]);
    }

    static int bs(int s, int e, int x) {
        while (s <= e) {
            int m = (s + e) / 2;
            if (right.get(m) <= c - x)
                s = m + 1;
            else
                e = m - 1;
        }

        return e;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        left = new ArrayList<>();
        right = new ArrayList<>();

        go(left, 0, n / 2, 0);
        go(right, n / 2, n, 0);

        Collections.sort(right);

        int ans = 0;
        for (int i = 0; i < left.size(); i++)
            ans += bs(0, right.size() - 1, left.get(i)) + 1;

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}