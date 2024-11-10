import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();

		int x = 0;
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			switch (s) {
				case "push":
					x = Integer.parseInt(st.nextToken());
					q.add(x);
					break;
				case "pop":
					if (q.isEmpty())
						bw.write("-1\n");
					else
						bw.write(q.poll() + "\n");
					break;
				case "size":
					bw.write(q.size() + "\n");
					break;
				case "empty":
					if (q.isEmpty())
						bw.write("1\n");
					else
						bw.write("0\n");
					break;
				case "front":
					if (q.isEmpty())
						bw.write("-1\n");
					else
						bw.write(q.peek() + "\n");
					break;
				default:
					if (q.isEmpty())
						bw.write("-1\n");
					else
						bw.write(x + "\n");
			}
		}

		bw.flush();
		bw.close();
	}
}