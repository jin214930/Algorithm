import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String cmd = st.nextToken();

            if (cmd.equals("enter"))
                set.add(s);
            else
                set.remove(s);
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        for (String s : list)
            bw.write(s + "\n");


        bw.flush();
    }
}