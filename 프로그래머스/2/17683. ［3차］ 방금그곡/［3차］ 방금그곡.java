class Solution {    
    public String solution(String m, String[] musicinfos) {
        m = convert(m);
        
        String ans = "(None)";
        int maxTime = -1;
        
        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            
            int start = toMinute(info[0]);
            int end = toMinute(info[1]);
            int time = end - start;
            String title = info[2];
            String melody = convert(info[3]);
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < time; i++) {
                sb.append(melody.charAt(i % melody.length()));
            }
            
            if (sb.toString().contains(m)) {
                if (time > maxTime) {
                    maxTime = time;
                    ans = title;
                }
            }
        }
        
        return ans;
    }
    
    static String convert(String melody) {
        return melody
            .replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a")
            .replace("B#", "b");
    }
    
    static int toMinute(String time) {
        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3));
        
        return h * 60 + m;
    }
}