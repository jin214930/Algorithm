import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a;
    static Set<List<Integer>> ans;

    static void go(int idx, List<Integer> list) {
        if (list.size() == m) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < n; i++) {
            list.add(a[i]);
            go(i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        ans = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        go(0, new ArrayList<>());

        for (List<Integer> list : ans) {
            for (int i : list) {
                bw.write(i + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}