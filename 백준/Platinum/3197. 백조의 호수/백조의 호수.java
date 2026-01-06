import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    static int r, c;
    static char[][] a;
    static boolean[][] visited;
    static Node startSwan;

    static Queue<Node> waterQ = new LinkedList<>();
    static Queue<Node> swanQ = new LinkedList<>();
    static Queue<Node> nextWaterQ;
    static Queue<Node> nextSwanQ;

    static boolean check() {
        while (!swanQ.isEmpty()) {
            Node node = swanQ.poll();

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                if (visited[ny][nx]) continue;

                if (a[ny][nx] == 'X')
                    nextSwanQ.add(new Node(ny, nx));
                else if (a[ny][nx] == 'L')
                    return true;
                else
                    swanQ.add(new Node(ny, nx));
                visited[ny][nx] = true;
            }
        }

        return false;
    }

    static void melt() {
        while (!waterQ.isEmpty()) {
            Node node = waterQ.poll();

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                if (a[ny][nx] == 'X') {
                    a[ny][nx] = '*';
                    nextWaterQ.add(new Node(ny, nx));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        a = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                a[i][j] = s.charAt(j);
                if (a[i][j] != 'X')
                    waterQ.add(new Node(i, j));
                if (a[i][j] == 'L')
                    startSwan = new Node(i, j);
            }
        }

        swanQ.add(startSwan);
        visited[startSwan.y][startSwan.x] = true;

        int ans = 0;
        while (true) {
            nextWaterQ = new LinkedList<>();
            nextSwanQ = new LinkedList<>();

            if (check()) break;

            melt();

            waterQ = nextWaterQ;
            swanQ = nextSwanQ;
            ans++;
        }

        bw.write(ans + "");
        bw.flush();
    }
}