import java.io.*;
import java.util.*;

public class Main {        
    static class Ship {
        int id, p, r, readyTime;
        
        public Ship(int id, int p, int r) {
            this.id = id;
            this.p = p;
            this.r = r;
            this.readyTime = 0;
        }
    }
    
    static int time = 0;
    static List<Ship> ships = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();
    static PriorityQueue<Ship> ready = new PriorityQueue<>((s1, s2) -> {
        if (s1.p == s2.p) return s1.id - s2.id;
        return s2.p - s1.p;
    });
    static PriorityQueue<Ship> waiting = new PriorityQueue<>((s1, s2) -> s1.readyTime - s2.readyTime);
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            
            if (cmd == 100) {
                int n = Integer.parseInt(st.nextToken());
                for (int i = 0; i < n; i++) {
                    int id = Integer.parseInt(st.nextToken());
                    int p = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    Ship ship = new Ship(id, p, r);
                    ships.add(ship);
                    map.put(id, i);
                    ready.add(ship);
                }
            } else if (cmd == 200) {
                int id = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map.put(id, ships.size());
                Ship ship = new Ship(id, p, r);
                ships.add(ship);
                ready.add(ship);
            } else if (cmd == 300) {
                int id = Integer.parseInt(st.nextToken());
                int pw = Integer.parseInt(st.nextToken());
                int idx = map.get(id);
                Ship ship = ships.get(idx);
                ship.p = pw;
                if (ready.remove(ship)) ready.add(ship);
            } else {
                int sum = 0, cnt = 0;
                List<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    if (ready.isEmpty()) break;
                    Ship ship = ready.poll();
                    sum += ship.p;
                    cnt++;
                    tmp.add(ship.id);
                    ship.readyTime = time + ship.r;
                    waiting.add(ship);
                }
                
                bw.write(sum + " " + cnt + " ");
                for (int i : tmp) {
                    bw.write(i + " ");
                }
                bw.write("\n");
            }
            
            time++;
            while(!waiting.isEmpty() && waiting.peek().readyTime <= time) {
                ready.add(waiting.poll());
            }
        }
        
        bw.flush(); 
    }
}
