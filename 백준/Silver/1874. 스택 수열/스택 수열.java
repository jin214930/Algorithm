import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        List<Character> list = new ArrayList<>();
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            list.add('+');

            while (!stack.isEmpty() && stack.peek() == a[idx]) {
                stack.pop();
                list.add('-');
                idx++;
            }
        }

        if (!stack.isEmpty()) {
            bw.write("NO");
        } else {
            for (char c : list) {
                bw.write(c + "\n");
            }
        }

        bw.flush();
    }
}
