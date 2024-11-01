import java.util.*;
import java.io.*;

class Flower {
	int s, e;

	public Flower(int s, int e) {
		this.s = s;
		this.e = e;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Flower[] a = new Flower[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sm, sd, em, ed;
			sm = Integer.parseInt(st.nextToken());
			sd = Integer.parseInt(st.nextToken());
			em = Integer.parseInt(st.nextToken());
			ed = Integer.parseInt(st.nextToken());
			a[i] = new Flower(sm * 100 + sd, em * 100 + ed);
		}
		Arrays.sort(a, new Comparator<Flower>() {
			@Override
			public int compare(Flower f1, Flower f2) {
				return Integer.compare(f1.s, f2.s);
			}
		});
		int s = 301, e = 1130;
		int idx = 0, ans = 0;
		while(s <= e) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			while(idx < n && a[idx].s <= s) 
				pq.add(a[idx++].e);
			if(pq.isEmpty()) {
				bw.write("0");
				bw.flush();
				bw.close();
				return;
			}
			int mx = pq.poll();
			ans++;
			s = mx;
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}