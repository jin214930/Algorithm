import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 1;
		for (int i = 0; i < n; i++)
			ans *= 2;
		System.out.println(ans);
	}
}