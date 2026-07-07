import java.util.*;
import java.io.*;

public class Main {
    static class Person {
        String name;
        int height;
        int weight;

        public Person(String name, int height, int weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
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
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            people[i] = new Person(name, height, weight);
        }

        Arrays.sort(people, (p1, p2) -> {
            return p1.height - p2.height;
        });

        for (int i = 0; i < n; i++) {
            bw.write(people[i].name + " " + people[i].height + " " + people[i].weight + "\n");
        }


        bw.flush();
    }
}