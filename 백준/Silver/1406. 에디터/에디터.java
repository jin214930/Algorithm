import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int m = Integer.parseInt(br.readLine());
        List<Character> list = new LinkedList<>();
        for (char c : s.toCharArray())
            list.add(c);

        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext())
            iter.next();

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "L":
                    if (iter.hasPrevious())
                        iter.previous();
                    break;
                case "D":
                    if (iter.hasNext())
                        iter.next();
                    break;
                case "B":
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P":
                    iter.add(st.nextToken().charAt(0));
                    break;
            }
        }

        for (char c : list)
            bw.write(c);

        bw.flush();
        bw.close();
        br.close();
    }
}