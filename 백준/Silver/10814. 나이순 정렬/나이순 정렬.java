import java.io.*;
import java.util.*;

public class Main {
    static class Person {
        int age;
        int idx;
        String name;

        public Person(int age, int idx, String name) {
            this.age = age;
            this.idx = idx;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            persons[i] = new Person(age, i, name);
        }

        Arrays.sort(persons, (a, b) -> {
            if (a.age == b.age) {
                return a.idx - b.idx;
            }
            return a.age - b.age;
        });

        for (Person person : persons)
            bw.write(person.age + " " + person.name + "\n");

        bw.flush();
    }
}