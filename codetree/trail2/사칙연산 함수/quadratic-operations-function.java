import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        String op = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        int ret = eval(a, b, op);
        if (ret == Integer.MAX_VALUE) {
            bw.write("False");
        } else {
            bw.write(a + " " + op + " " + b + " = " + eval(a, b, op));
        }

        bw.flush();
    }

    private static int eval(int a, int b, String op) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else if (op.equals("*")) {
            return a * b;
        } else if (op.equals("/")) {
            return a / b;
        }

        return Integer.MAX_VALUE;
    }
}
