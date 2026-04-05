import java.util.*;

class Solution {
    int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
    
    int lcm(int a, int b) {
        return  a * b / gcd(a, b);
    }
    
    public int solution(int[] arr) {
        if (arr.length == 1)
            return arr[0];
        
        int ans = lcm(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) 
           ans = lcm(ans, arr[i]); 
        
        return ans;
    }
}