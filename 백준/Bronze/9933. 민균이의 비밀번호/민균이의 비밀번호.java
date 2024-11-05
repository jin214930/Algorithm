import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] a = new String[n];
		for(int i = 0; i < n;i++)
			a[i] = br.readLine();

		for(int i = 0; i < n;i++) {
			for(int j = 0; j < n;j++) {
				StringBuffer st = new StringBuffer(a[i]);
				String tmp = st.reverse().toString();
				if(tmp.equals(a[j])) {
					bw.write(a[i].length() + " ");
					bw.write(a[i].charAt(a[i].length() / 2));
					bw.flush();
					bw.close();
					return;
				}
			}
		}
	}
}