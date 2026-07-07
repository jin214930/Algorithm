import java.util.*;
import java.io.*;

public class Main {
    static class Person {
        String name;
        int h;
        int w;

        public Person(String name, int h, int w) {
            this.name = name;
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            people[i] = new Person(name, h, w);
        }

        Arrays.sort(people, (p1, p2) -> {
            if (p1.h == p2.h) {
                return p2.w - p1.w;
            }
            return p1.h - p2.h;
        });

        for (int i = 0; i < n; i++) {
            bw.write(people[i].name + " " + people[i].h + " " + people[i].w + "\n");
        }


        bw.flush();
    }
}