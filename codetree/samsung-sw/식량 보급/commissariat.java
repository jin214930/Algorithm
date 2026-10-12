import java.io.*;
import java.util.*;

public class Main {
    static List<Long> food;
    static long[] prefix;

    static long upgrade;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(br.readLine());

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 100) {
                n = Integer.parseInt(st.nextToken());

                food = new ArrayList<>();
                upgrade = 0;

                for (int i = 0; i < n; i++) {
                    long x = Long.parseLong(st.nextToken());
                    food.add(x);
                }

                Collections.sort(food);
                makePrefix();
            } else if (cmd == 200) {
                long x = Long.parseLong(st.nextToken());
                long value = x - upgrade;

                int idx = lowerBound(value);
                food.add(idx, value);
                n++;
                makePrefix();

            } else if (cmd == 300) {
                long p = Long.parseLong(st.nextToken());

                upgrade += p;
            } else if (cmd == 400) {
                long p = Long.parseLong(st.nextToken());

                long ans = solve(p);

                bw.write(ans + "\n");
            }
        }

        bw.flush();
    }

    static long solve(long p) {
        int left = 0;
        int right = n - 1;
        int idx = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long cost =
                    food.get(mid) * (mid + 1L)
                    - prefix[mid + 1];

            if (cost <= p) {
                idx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        long cost =food.get(idx) * (idx + 1L) - prefix[idx + 1];
        long remain = p - cost;
        long base = food.get(idx) + remain / (idx + 1L);

        return base + upgrade;
    }

    static int lowerBound(long value) {
        int left = 0;
        int right = food.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (food.get(mid) < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static void makePrefix() {
        prefix = new long[food.size() + 1];

        for (int i = 0; i < food.size(); i++) {
            prefix[i + 1] = prefix[i] + food.get(i);
        }
    }
}