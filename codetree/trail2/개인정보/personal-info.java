import java.util.*;
import java.io.*;

public class Main {
    static class Person {
        String name;
        int h;
        String w;

        public Person(String name, int h, String w) {
            this.name = name;
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Person[] people = new Person[5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int h = Integer.parseInt(st.nextToken());
            String w = st.nextToken();
            people[i] = new Person(name, h, w);
        }

        Arrays.sort(people, (p1, p2) -> {
            return p1.name.compareTo(p2.name);
        });

        bw.write("name\n");
        for (int i = 0; i < 5; i++) {
            bw.write(people[i].name + " " + people[i].h + " " + people[i].w + "\n");
        }
        bw.newLine();

        Arrays.sort(people, (p1, p2) -> {
            return p2.h - p1.h;
        });
        bw.write("height\n");
        for (int i = 0; i < 5; i++) {
            bw.write(people[i].name + " " + people[i].h + " " + people[i].w + "\n");
        }

        bw.flush();
    }
}