import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        while (k-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) stack.pop();
            else stack.push(x);
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        bw.write(ans + "");

        bw.flush();
    }
}
