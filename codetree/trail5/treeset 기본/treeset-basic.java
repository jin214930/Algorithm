import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> ts = new TreeSet<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x;
            Integer tmp;
            switch (cmd) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    ts.add(x);
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    ts.remove(x);
                    break;
                case "find":
                    x = Integer.parseInt(st.nextToken());
                    if (!ts.contains(x)) bw.write("false\n");
                    else bw.write("true\n");
                    break;
                case "lower_bound":
                    x = Integer.parseInt(st.nextToken());
                    tmp = ts.ceiling(x);
                    if (tmp == null) bw.write("None\n");
                    else bw.write(tmp + "\n");
                    break;
                case "upper_bound":
                    x = Integer.parseInt(st.nextToken());
                    tmp = ts.higher(x);
                    if (tmp == null) bw.write("None\n");
                    else bw.write(tmp + "\n");
                    break;
                case "largest":
                    if (ts.isEmpty()) bw.write("None\n");
                    else bw.write(ts.last() + "\n");
                    break;
                case "smallest":
                    if (ts.isEmpty()) bw.write("None\n");
                    else bw.write(ts.first() + "\n");
            }
        }

        bw.flush();
    }
}
