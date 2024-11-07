import java.util.*;
import java.io.*;

public class Main {
	static boolean[] gom;
	static boolean flag;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	static void dfs(int x) {
		if (gom[x] || flag)
			return;
		if (adj.get(x).size() == 0) {
			flag = true;
			return;
		}
		for (int nx : adj.get(x))
			dfs(nx);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
		}

		int s = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		gom = new boolean[n + 1];
		while (s-- > 0)
			gom[Integer.parseInt(st.nextToken())] = true;

		dfs(1);
		if (flag)
			bw.write("yes");
		else
			bw.write("Yes");

		bw.flush();
		bw.close();
	}
}