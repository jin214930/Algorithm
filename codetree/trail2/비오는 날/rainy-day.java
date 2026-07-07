import java.util.*;
import java.io.*;

public class Main {
    static class Weather {
        String date;
        String day;
        String weather;

        public Weather(String date, String day, String weather) {
            this.date = date;
            this.day = day;
            this.weather = weather;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Weather> weathers = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String date = st.nextToken();
            String day = st.nextToken();
            String weather = st.nextToken();
            if (weather.equals("Rain")) {
                weathers.add(new Weather(date, day, weather));
            }
        }

        Collections.sort(weathers, (w1, w2) -> w1.date.compareTo(w2.date));

        Weather w = weathers.get(0);
        bw.write(w.date + " " + w.day + " " + w.weather);


        bw.flush();
    }
}