import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();

            List<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (char c : s.toCharArray()) {
                switch (c) {
                    case '<':
                        if (iter.hasPrevious())
                            iter.previous();
                        break;
                    case '>':
                        if (iter.hasNext())
                            iter.next();
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(c);
                        break;
                }
            }

            for (char c : list)
                bw.write(c);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}