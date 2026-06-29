import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int k, v;
            switch (cmd) {
                case "add":
                    k = Integer.parseInt(st.nextToken());
                    v = Integer.parseInt(st.nextToken());
                    tm.put(k, v);
                    break;
                case "remove":
                    k = Integer.parseInt(st.nextToken());
                    tm.remove(k);
                    break;
                case "find":
                    k = Integer.parseInt(st.nextToken());
                    if (tm.containsKey(k)) bw.write(tm.get(k) + "\n");
                    else bw.write("None\n");
                    break;
                default:
                    if (tm.isEmpty()) bw.write("None\n");
                    else {
                        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
                            bw.write(entry.getValue() + " ");
                        }
                        bw.write("\n");
                    }
            }
        }

        bw.flush();
    }

}
