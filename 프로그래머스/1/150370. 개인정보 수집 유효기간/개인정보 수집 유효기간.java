import java.util.*;

class Solution {
    HashMap<String, Integer> mp = new HashMap<>();
    
    boolean check(String a, String b, int c) {
        int y1 = Integer.parseInt(a.substring(0, 4));
        int m1 = Integer.parseInt(a.substring(5, 7));
        int d1 = Integer.parseInt(a.substring(8));
        
        int y2 = Integer.parseInt(b.substring(0, 4));
        int m2 = Integer.parseInt(b.substring(5, 7));
        int d2 = Integer.parseInt(b.substring(8));
        
        m2 += c % 12;
        y2 += c / 12;
        if (m2 > 12) {
            m2 -= 12;
            y2++;
        }
        
        return y1 > y2 || (y1 == y2 && m1 > m2) || (y1 == y2 && m1 == m2 && d1 >= d2);  
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        for (String s : terms) 
            mp.put(s.substring(0, 1), Integer.parseInt(s.substring(2)));
        
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++) {
            if (check(today, privacies[i].substring(0, 10), mp.get(privacies[i].substring(11)))) 
                al.add(i + 1);
        }
        
        int[] ans = new int[al.size()];
        int idx = 0;
        for (int i : al)
            ans[idx++] = i;
        
        return ans;
    }
}