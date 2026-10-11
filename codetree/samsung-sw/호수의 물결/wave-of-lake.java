import java.io.*;
import java.util.*;

public class Main {
    static class Shooter {
        int x, time, interval, power, height, cnt;

        public Shooter(int x, int time, int interval, int power, int height, int cnt) {
            this.x = x;
            this.time = time;
            this.interval = interval;
            this.power = power;
            this.height = height;
            this.cnt = cnt;
        }
    }

    static class Bomb {
        int y, x, power, height;
        boolean burst;

        public Bomb(int y, int x, int power, int height) {
            this.y = y;
            this.x = x;
            this.power = power;
            this.height = height;
            burst = false;
        }
    }

    static class Node {
        int y, x;
        
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n, m, k;
    static int[][] fire;
    static int[][] mist;
    static boolean[][] visited;
    static List<Node> nodes;
    static List<Shooter> shooters;
    static List<Bomb> bombs = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            bw.write("#" + t + " ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            shooters = new ArrayList<>();
            bombs = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                int interval = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                shooters.add(new Shooter(x, time, interval, p, h, cnt));
            }

            mist = new int[n][m];
            for (int time = 1; time <= 50; time++) {
                fire = new int[n][m];

                // 폭죽 이동
                for (Bomb bomb : bombs) {
                    if (bomb.burst) continue;
                    bomb.y--;
                }
                
                // 폭죽 발사
                for (Shooter shooter : shooters) {
                    if (shooter.cnt == 0 || time < shooter.time) continue;
                    if ((time - shooter.time) % shooter.interval == 0) {
                        bombs.add(new Bomb(n - 1, shooter.x, shooter.power, shooter.height));
                        shooter.cnt--;
                    }
                }

                // 폭발
                for (Bomb bomb : bombs) {
                    if (bomb.burst) continue;
                    if (n - bomb.y == bomb.height) {
                        burst(bomb);
                        bomb.burst = true;
                    }
                }

                // 점수 계산
                int ans = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        ans += Math.max(0, fire[i][j] - mist[i][j]);
                    }
                }

                bw.write(ans + " ");

                // 연기 이동
                int[][] newMist = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = m - 1; j > 0; j--) {
                        if (isInner(i, j)) {
                            newMist[i][j - 1] = Math.max(0, mist[i][j] - 1);
                        }
                        else {
                            newMist[i][j - 1] = Math.max(0, mist[i][j] - 2);
                        }
                    }
                }
                mist = newMist;

                // 연기 생성
                visited = new boolean[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (fire[i][j] != 0 && !visited[i][j]) {
                            nodes = new ArrayList<>();
                            int sum = dfs(i, j);

                            int avg = sum / nodes.size();
                            for (Node node : nodes) {
                                mist[node.y][node.x] += avg;
                            }
                        }
                    }
                }

                // 종료
                boolean allShooted = true;
                for (Shooter shooter : shooters) {
                    if (shooter.cnt > 0) {
                        allShooted = false;
                        break;
                    }
                }

                boolean allBurst = true;
                for (Bomb bomb : bombs) {
                    if (!bomb.burst) {
                        allBurst = false;
                        break;
                    }
                }

                if (allShooted && allBurst) break;
            }

            bw.write("\n");
        }

        bw.flush();
    }

    static void burst(Bomb bomb) {
        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[n][m];

        q.offer(new Node(bomb.y, bomb.x));
        visited[bomb.y][bomb.x] = bomb.power * 3;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (visited[ny][nx] != 0) continue;
                int d = Math.abs(bomb.y - ny) + Math.abs(bomb.x - nx);
                if (3 * bomb.power - 5 * d <= 0) continue;
                q.offer(new Node(ny, nx));
                visited[ny][nx] = 3 * bomb.power - 5 * d;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                fire[i][j] += visited[i][j];
            }
        }
    } 

    static boolean isInner(int y, int x) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (mist[ny][nx] == 0) continue;
            cnt++;
        }

        return cnt == 4;
    }
    
    static int dfs(int y, int x) {
        visited[y][x] = true;
        nodes.add(new Node(y, x));
        int ret = fire[y][x];

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (visited[ny][nx] || fire[ny][nx] == 0) continue;
            ret += dfs(ny, nx);
        }

        return ret;
    }
}