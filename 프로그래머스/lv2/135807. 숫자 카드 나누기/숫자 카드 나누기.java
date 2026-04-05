import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        int ansA = 0;
        if (check(arrayB, gcdA)) ansA = gcdA;
        
        int ansB = 0;
        if (check(arrayA, gcdB)) ansB = gcdB;
        
        return Math.max(ansA, ansB);
    }
    
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    boolean check(int[] arr, int gcd) {
        if (gcd == 1) return false;
        
        for (int n : arr) {
            if (n % gcd == 0)
                return false;
        }
        
        return true;
    }
    
    
}