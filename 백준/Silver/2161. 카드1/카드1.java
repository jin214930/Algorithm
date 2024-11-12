import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1 ; i <=n;i++)
			q.add(i);

		while(!q.isEmpty()) {
			bw.write(q.poll() + " ");
			if(!q.isEmpty()) {
				int tmp = q.poll();
				q.add(tmp);
			}
		}

		bw.flush();
		bw.close();
	}
}