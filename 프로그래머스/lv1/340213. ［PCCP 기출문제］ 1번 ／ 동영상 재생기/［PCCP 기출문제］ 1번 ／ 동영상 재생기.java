class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = stoi(video_len);
        int now = stoi(pos);
        int ops = stoi(op_start);
        int ope = stoi(op_end);
        
        for (String c : commands) {
            if(now >= ops && now < ope)
                now = ope;
            
            if (c.equals("prev")) {
                now = Math.max(0, now - 10);
            } else {
                now = Math.min(len, now + 10);
            }
        }
        
        if(now >= ops && now < ope)
            now = ope;
        
        return itos(now);
    }
    
    int stoi(String s) {
        String[] tmp = s.split(":");
        int m = Integer.parseInt(tmp[0]);
        int sec = Integer.parseInt(tmp[1]);
        
        return m * 60 + sec;
    }
    
    String itos(int i) {
        int m = i / 60;
        int s = i % 60;
        
        return String.format("%02d:%02d", m, s);
    }
}