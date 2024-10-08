import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i = 1; i <=n;i++) {
			if(n % i == 0)
			ans++;
			if(ans == k) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
		
	}
}