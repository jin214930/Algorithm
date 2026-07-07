import java.util.*;
import java.io.*;

public class Main {
    static class Student {
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, kor, eng, math);
        }

        Arrays.sort(students, (s1, s2) -> {
            int sum1 = s1.kor + s1.eng + s1.math;
            int sum2 = s2.kor + s2.eng + s2.math;
            return sum1 - sum2;
        });

        for (int i = 0; i < n; i++) {
            bw.write(students[i].name + " " + students[i].kor + " " + students[i].eng + " " + students[i].math + "\n");
        }


        bw.flush();
    }
}