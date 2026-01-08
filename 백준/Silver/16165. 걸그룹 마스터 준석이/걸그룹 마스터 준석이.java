import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, List<String>> groupMap = new HashMap<>();
        Map<String, String> memberMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String groupName = br.readLine();
            int k = Integer.parseInt(br.readLine());

            for (int j = 0; j < k; j++) {
                String memberName = br.readLine();
                groupMap.putIfAbsent(groupName, new ArrayList<>());
                groupMap.get(groupName).add(memberName);
                memberMap.put(memberName, groupName);
            }
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 0) {
                List<String> group = groupMap.get(name);
                Collections.sort(group);
                for (String s : groupMap.get(name))
                    bw.write(s + "\n");
            } else
                bw.write(memberMap.get(name) + "\n");
        }


        bw.flush();
    }
}