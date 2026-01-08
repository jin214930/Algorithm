import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();

                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int ans = 1;
            for (int i : map.values())
                ans *= i + 1;

            bw.write((ans - 1) + "\n");

        }


        bw.flush();
    }
}