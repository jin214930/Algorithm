import java.util.*;
import java.io.*;

/*
세점  a b c
cb ca cm (a b 중점) 을 구한다.
cb와 cm의 차이가 ca와 cm의 거리차이보다 작으면 
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double ax = Double.parseDouble(st.nextToken());
		double ay = Double.parseDouble(st.nextToken());
		double az = Double.parseDouble(st.nextToken());
		double bx = Double.parseDouble(st.nextToken());
		double by = Double.parseDouble(st.nextToken());
		double bz = Double.parseDouble(st.nextToken());
		double cx = Double.parseDouble(st.nextToken());
		double cy = Double.parseDouble(st.nextToken());
		double cz = Double.parseDouble(st.nextToken());
		double ans = 0;
		while (true) {
			double ac = Math.sqrt((ax - cx) * (ax - cx) + (ay - cy) * (ay - cy) + (az - cz) * (az - cz));
			double bc = Math.sqrt((bx - cx) * (bx - cx) + (by - cy) * (by - cy) + (bz - cz) * (bz - cz));

			double mx = (ax + bx) / 2;
			double my = (ay + by) / 2;
			double mz = (az + bz) / 2;
			double mc = Math.sqrt((mx - cx) * (mx - cx) + (my - cy) * (my - cy) + (mz - cz) * (mz - cz));
			if (Math.abs(mc - ans) < 0.000001)
				break;
			if (bc >= ac) {
				bx = mx;
				by = my;
				bz = mz;
				ans = mc;
			} else {
				ax = mx;
				ay = my;
				az = mz;
				ans = mc;
			}
		}
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
}