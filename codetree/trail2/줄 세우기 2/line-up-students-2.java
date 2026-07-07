import java.util.*;
import java.io.*;

public class Main {
    static class Student {
        int h, w, n;

        public Student(int h, int w, int n) {
            this.h = h;
            this.w = w;
            this.n = n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            students[i] = new Student(h, w, i + 1);
        }

        Arrays.sort(students, (s1, s2) -> {
            if (s1.h == s2.h) {
                return s2.w - s1.w;
            }
            return s1.h - s2.h;
        });

        for (int i = 0; i < n; i++) {
            bw.write(students[i].h + " " + students[i].w + " " + students[i].n + "\n");
        }

        bw.flush();
    }
}