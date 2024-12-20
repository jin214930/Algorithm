import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String pn1 = phone_book[i];
            String pn2 = phone_book[i + 1];
    
            if (pn1.length() > pn2.length() && pn2.equals(pn1.substring(0, pn2.length())))
                return false;
            else if (pn2.length() > pn1.length() && pn1.equals(pn2.substring(0, pn1.length())))
                return false;
        }
        
        return true;
    }
}