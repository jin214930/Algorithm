import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");

            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                dq.offerLast(Integer.parseInt(st.nextToken()));
            }

            boolean isReverse = false;
            boolean isError = false;
            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (dq.isEmpty()) {
                        isError = true;
                        break;
                    } else if (isReverse) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                }
            }

            if (isError) {
                bw.write("error\n");
                continue;
            }

            bw.write("[");
            if (isReverse) {
                while (!dq.isEmpty()) {
                    bw.write(dq.pollLast() + "");
                    if (!dq.isEmpty()) {
                        bw.write(",");
                    }
                }
            } else {
                while (!dq.isEmpty()) {
                    bw.write(dq.pollFirst() + "");
                    if (!dq.isEmpty()) {
                        bw.write(",");
                    }
                }
            }
            bw.write("]\n");
        }

        bw.flush();
    }
}
