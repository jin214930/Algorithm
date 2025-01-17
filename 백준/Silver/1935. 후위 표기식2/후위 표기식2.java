import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String s = br.readLine();
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(br.readLine());

        Stack<Double> st = new Stack<>();
        double ans = 0;
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z')
                st.push((double) a[c - 'A']);
            else {
                double tmp1 = st.pop();
                double tmp2 = st.pop();
                switch (c) {
                    case '+':
                        st.push(tmp2 + tmp1);
                        break;
                    case '-':
                        st.push(tmp2 - tmp1);
                        break;
                    case '*':
                        st.push(tmp2 * tmp1);
                        break;
                    default:
                        st.push(tmp2 / tmp1);
                        break;
                }
            }
        }

        ans = st.pop();
        System.out.printf("%.2f", ans);

//        bw.flush();
//        bw.close();
        br.close();
    }
}
