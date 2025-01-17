import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        while ((s = br.readLine()) != null) {
            int[] cnt = new int[4];
            for (char c : s.toCharArray()) {
                if (c >= 'a' && c <= 'z')
                    cnt[0]++;
                else if (c >= 'A' && c <= 'Z')
                    cnt[1]++;
                else if (c >= '0' && c <= '9')
                    cnt[2]++;
                else
                    cnt[3]++;
            }

            for (int i : cnt)
                bw.write(i + " ");
            bw.write("\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}

