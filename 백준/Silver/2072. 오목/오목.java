import java.util.*;
import java.io.*;

public class Main {
	static int[][] a = new int[20][20];
	static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static int[] dx = { 0, 0, 1, -1, 1, -1, -1, 1 };

	static boolean check(int y, int x) {
		for(int i = 0; i < 8; i+= 2) {
			int cnt = 1;
			int ty = y;
			int tx = x;
			while(true) {
				int ny = ty + dy[i];
				int nx = tx + dx[i];
				if(ny >= 20 || nx >= 20 || ny < 1 || nx < 1 || a[ny][nx]!=a[ty][tx])
				break;
				cnt++;
				ty = ny;
				tx = nx;
			}
			
			ty = y;
			tx = x;
			while(true) {
				int ny = ty + dy[i + 1];
				int nx = tx + dx[i + 1];
				if(ny >= 20 || nx >= 20 || ny < 1 || nx < 1 || a[ny][nx]!=a[ty][tx])
				break;
				cnt++;
				ty = ny;
				tx = nx;
			}

			if(cnt == 5)
				return true;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		int tmp = 1;
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			a[y][x] = tmp;
			tmp *= -1;

			if (check(y, x)) {
				bw.write(i + "");
				bw.flush();
				bw.close();
				return;
			}
		}

		bw.write("-1");
		bw.flush();
		bw.close();
	}
}