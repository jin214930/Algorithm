import java.util.*;

class Solution {
    public String solution(int[] food) {
        Deque<Character> dq = new LinkedList<>();
        dq.add('0');
        
        for (int i = food.length - 1; i >= 1; i--) {
            for(int j = 0; j < food[i] / 2; j++) {
                dq.add((char)(i + '0'));
                dq.addFirst((char)(i + '0'));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!dq.isEmpty())
            sb.append(dq.pollFirst());
        
        return sb.toString();        
    }
}