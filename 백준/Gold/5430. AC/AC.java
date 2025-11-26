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

            Deque<String> dq = new ArrayDeque<>();
            String x = br.readLine();
            String[] tmp = x.substring(1, x.length() - 1).split(",");

            if (n > 0) {
                for (String s : tmp)
                    dq.add(s);
            }

            boolean reverse = false;
            boolean error = false;
            for (char c : p.toCharArray()) {
                if (c == 'R')
                    reverse = !reverse;
                else {
                    if (dq.isEmpty()) {
                        error = true;
                        break;
                    } else if (reverse)
                        dq.pollLast();
                    else
                        dq.pollFirst();
                }
            }

            if (error)
                bw.write("error\n");
            else {
                bw.write("[");
                if (reverse) {
                    while (!dq.isEmpty()) {
                        bw.write(dq.pollLast());
                        if (!dq.isEmpty())
                            bw.write(",");
                    }
                } else {
                    while (!dq.isEmpty()) {
                        bw.write(dq.pollFirst());
                        if (!dq.isEmpty())
                            bw.write(",");
                    }
                }
                bw.write("]\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}