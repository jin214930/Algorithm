import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int ans = Integer.MAX_VALUE;
    static int n, m;
    static int[][] a;
    static List<Node> people = new ArrayList<>();
    static List<Node> hospitals = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] == 1) {
                    people.add(new Node(i, j));
                } else if (a[i][j] == 2) {
                    hospitals.add(new Node(i, j));
                }
            }
        }

        go(0, new ArrayList<>());

        bw.write(ans + "");
        bw.flush();
    }

    static void go(int idx, List<Integer> tmp) {
        if (tmp.size() == m) {
            int total_dist = 0;
            for (Node person : people) {
                int hospital_dist = getHospitalDist(person, tmp);
                total_dist += hospital_dist;
            }

            ans = Math.min(ans, total_dist);
            return;
        }

        for (int i = idx; i < hospitals.size(); i++) {
            tmp.add(i);
            go(i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    static int getHospitalDist(Node person, List<Integer> tmp) {
        int hospital_dist = Integer.MAX_VALUE;

        for (int i : tmp) {
            Node hospital = hospitals.get(i);
            int d = Math.abs(person.y - hospital.y) + Math.abs(person.x - hospital.x);
            hospital_dist = Math.min(hospital_dist, d);
        }

        return hospital_dist;
    }
}