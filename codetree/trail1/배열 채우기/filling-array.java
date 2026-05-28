import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = st.countTokens();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == 0) {
                break;
            }
            list.add(x);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i) + " ");
        }

        bw.flush();
    }
}
