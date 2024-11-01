import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] a = br.readLine().split(" ");
		HashMap<String, String> mp = new HashMap<>();
		mp.put(".-", "A");
    mp.put("-...", "B");
    mp.put("-.-.", "C");
    mp.put("-..", "D");
    mp.put(".", "E");
    mp.put("..-.", "F");
    mp.put("--.", "G");
    mp.put("....", "H");
    mp.put("..", "I");
    mp.put(".---", "J");
    mp.put("-.-", "K");
    mp.put(".-..", "L");
    mp.put("--", "M");
    mp.put("-.", "N");
    mp.put("---", "O");
    mp.put(".--.", "P");
    mp.put("--.-", "Q");
    mp.put(".-.", "R");
    mp.put("...", "S");
    mp.put("-", "T");
    mp.put("..-", "U");
    mp.put("...-", "V");
    mp.put(".--", "W");
    mp.put("-..-", "X");
    mp.put("-.--", "Y");
    mp.put("--..", "Z");
    mp.put(".----", "1");
    mp.put("..---", "2");
    mp.put("...--", "3");
    mp.put("....-", "4");
    mp.put(".....", "5");
    mp.put("-....", "6");
    mp.put("--...", "7");
    mp.put("---..", "8");
    mp.put("----.", "9");
    mp.put("-----", "0");
    mp.put("--..--", ",");
    mp.put(".-.-.-", ".");
    mp.put("..--..", "?");
    mp.put("---...", ":");
    mp.put("-....-", "-");
    mp.put(".--.-.", "@");
		for(String s : a) 
			bw.write(mp.get(s));
		bw.flush();
		bw.close();
	}
}