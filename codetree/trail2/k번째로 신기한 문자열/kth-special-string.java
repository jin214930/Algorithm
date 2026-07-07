import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String p = st.nextToken();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.startsWith(p)) list.add(s);
        }

        Collections.sort(list);
        bw.write(list.get(k - 1));

        bw.flush();
    }
}