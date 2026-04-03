import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            String[] f1Bits = split(f1);
            String[] f2Bits = split(f2);
            
            String f1Head = f1Bits[0].toUpperCase();
            int f1Num = Integer.parseInt(f1Bits[1]);

            String f2Head = f2Bits[0].toUpperCase();
            int f2Num = Integer.parseInt(f2Bits[1]);
            
            if (f1Head.equals(f2Head)) {                
                return f1Num - f2Num;
            }
            
            return f1Head.compareTo(f2Head);
        });
        
        return files;      
    }
    
    String[] split(String s) {
        int idx = 0;
        
        while (idx < s.length() && !Character.isDigit(s.charAt(idx))) {
            idx++;
        }
        String head = s.substring(0, idx);
        
        int startNum = idx;
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            idx++;
        }
        String number = s.substring(startNum, idx);
        
        String tail = s.substring(idx);
        
        return new String[]{head, number, tail};
    }
}