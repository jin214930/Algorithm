import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        switch (m) {
            case 3:
            case 4:
            case 5:
                bw.write("Spring");
                break;
            case 6:
            case 7:
            case 8:
                bw.write("Summer");
                break;
            case 9:
            case 10:
            case 11:
                bw.write("Fall");
                break;
            default:
                bw.write("Winter");
                break;
        }
        
        bw.flush();
    }
}
