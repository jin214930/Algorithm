import java.util.*;
import java.io.*;

public class Main {
    static class Route implements Comparable<Route> {
        int node;
        long cost;
        int time; // 거쳐간 정거장의 수

        Route(int node, long cost, int time) {
            this.node = node;
            this.cost = cost;
            this.time = time;
        }

        @Override
        public int compareTo(Route o) {
            // 1순위: 비용이 작은 순
            if (this.cost != o.cost) {
                return Long.compare(this.cost, o.cost);
            }
            // 2순위: 정거장 수가 작은 순
            return Integer.compare(this.time, o.time);
        }
    }

    static int a, b, n;
    static ArrayList<ArrayList<Route>> graph = new ArrayList<>();
    static long[] minCost;
    static int[] minTime;
    
    // 중복 간선을 최적화하기 위한 2차원 배열 (메모리 초과 방지)
    static long[][] edgeCost = new long[1001][1001];
    static int[][] edgeTime = new int[1001][1001];
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 1000; i++) {
            graph.add(new ArrayList<>());
            Arrays.fill(edgeCost[i], INF);
            Arrays.fill(edgeTime[i], Integer.MAX_VALUE);
        }

        minCost = new long[1001];
        minTime = new int[1001];
        Arrays.fill(minCost, INF);
        Arrays.fill(minTime, Integer.MAX_VALUE);

        // n개의 버스 노선 정보 입력 및 간선 전처리
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long cost = Long.parseLong(st.nextToken());
            int stopCount = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int[] stops = new int[stopCount];
            for (int j = 0; j < stopCount; j++) {
                stops[j] = Integer.parseInt(st.nextToken());
            }

            // 모든 정거장 쌍에 대해 최적의 비용과 시간만 2차원 배열에 남김 (객체 생성 최소화)
            for (int j = 0; j < stopCount; j++) {
                for (int k = j + 1; k < stopCount; k++) {
                    int u = stops[j];
                    int v = stops[k];
                    int t = k - j;
                    
                    if (cost < edgeCost[u][v]) {
                        edgeCost[u][v] = cost;
                        edgeTime[u][v] = t;
                    } else if (cost == edgeCost[u][v] && t < edgeTime[u][v]) {
                        edgeTime[u][v] = t;
                    }
                }
            }
        }

        // 전처리된 2차원 배열을 바탕으로 실제 그래프 리스트 구성 (최대 100만 개 이하의 간선)
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                if (edgeCost[i][j] != INF) {
                    graph.get(i).add(new Route(j, edgeCost[i][j], edgeTime[i][j]));
                }
            }
        }

        dijkstra(a);

        if (minCost[b] == INF) {
            System.out.println("-1 -1");
        } else {
            System.out.println(minCost[b] + " " + minTime[b]);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Route> pq = new PriorityQueue<>();
        pq.offer(new Route(start, 0, 0));
        minCost[start] = 0;
        minTime[start] = 0;

        while (!pq.isEmpty()) {
            Route cur = pq.poll();
            int now = cur.node;

            // 기존에 기록된 최적값보다 비용이 더 크거나, 비용은 같은데 정거장 수가 더 많으면 스킵
            if (minCost[now] < cur.cost || (minCost[now] == cur.cost && minTime[now] < cur.time)) {
                continue;
            }

            for (Route next : graph.get(now)) {
                long nextCost = cur.cost + next.cost;
                int nextTime = cur.time + next.time;

                // 새로운 경로가 비용이 더 저렴하거나, 비용은 같지만 거치는 정거장 수가 더 적을 경우 갱신
                if (nextCost < minCost[next.node] || (nextCost == minCost[next.node] && nextTime < minTime[next.node])) {
                    minCost[next.node] = nextCost;
                    minTime[next.node] = nextTime;
                    pq.offer(new Route(next.node, nextCost, nextTime));
                }
            }
        }
    }
}