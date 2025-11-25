import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        while (k-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0)
                st.pop();
            else
                st.push(x);
        }

        int sum = 0;
        while (!st.isEmpty())
            sum += st.pop();

        bw.write(sum + "");

        bw.flush();
        bw.close();
        br.close();
    }
}