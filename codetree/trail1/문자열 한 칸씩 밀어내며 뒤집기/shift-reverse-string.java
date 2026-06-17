import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Character> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        for (char c : s.toCharArray()) {
            dq.addLast(c);
        }

        int q = Integer.parseInt(st.nextToken());
        boolean isReversed = false;
        while (q-- > 0) {
            int cmd = Integer.parseInt(br.readLine());
            switch (cmd) {
                case 1:
                    if (isReversed) {
                        dq.addFirst(dq.pollLast());
                    } else {
                        dq.addLast(dq.pollFirst());
                    }
                    break;
                case 2:
                    if (isReversed) {
                        dq.addLast(dq.pollFirst());
                    } else {
                        dq.addFirst(dq.pollLast());
                    }
                    break;
                case 3:
                    isReversed = !isReversed;
            }

            if (isReversed) {
                for (int i = 0; i < dq.size(); i++) {
                    char x = dq.pollLast();
                    bw.write(x);
                    dq.addFirst(x);
                }
            } else {
                for (int i = 0; i < dq.size(); i++) {
                    char x = dq.pollFirst();
                    bw.write(x);
                    dq.addLast(x);
                }
            }
            bw.newLine();
        }

        bw.flush();
    }
}
