import java.util.*;
import java.io.*;

public class Main {
    static class Person {
        String name;
        String zipCode;
        String area;

        public Person(String name, String zipCode, String area) {
            this.name = name;
            this.zipCode = zipCode;
            this.area = area;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person(st.nextToken(), st.nextToken(), st.nextToken());
        }

        Arrays.sort(people, (p1, p2) -> {
            return p2.name.compareTo(p1.name);
        });

        bw.write("name " + people[0].name + "\n");
        bw.write("addr " + people[0].zipCode + "\n");
        bw.write("city " + people[0].area + "\n");

        bw.flush();
    }
}