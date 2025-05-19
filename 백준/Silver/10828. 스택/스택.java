import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stk = new Stack<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stk.push(x);
                    break;
                case "pop":
                    bw.write((stk.isEmpty() ? -1 : stk.pop()) + "\n");
                    break;
                case "size":
                    bw.write(stk.size() + "\n");
                    break;
                case "empty":
                    bw.write((stk.isEmpty() ? 1 : 0) + "\n");
                    break;
                default:
                    bw.write((stk.isEmpty() ? -1 : stk.peek()) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
