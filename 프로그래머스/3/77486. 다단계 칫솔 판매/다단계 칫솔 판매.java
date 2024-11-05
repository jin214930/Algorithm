import java.util.*;
class Solution {    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Integer> mp = new HashMap<>();
        int parent[] = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            mp.put(enroll[i], i);
            if(referral[i].equals("-"))
                parent[i] = -1;
            else 
                parent[i] = mp.get(referral[i]);
        }
        
        int[] ans = new int[enroll.length];
        for (int i = 0; i < seller.length; i++) {
            int tmp = amount[i] * 100;
            int x = mp.get(seller[i]);
            while(true) {
                if(x == -1)
                    break;
                if(tmp >= 10) {
                    ans[x] += tmp - (tmp / 10);
                    tmp /= 10;
                    x = parent[x];
                }
                else {
                    ans[x] += tmp;
                    break;
                }
            }
        }
        return ans;
    }
}