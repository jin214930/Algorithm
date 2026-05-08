import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		int[] a = new int[]{3, 1, 4, 5, 9};
		bw.write((a[1] + a[3] + a[4]) + "");

		bw.flush();
	}
}
