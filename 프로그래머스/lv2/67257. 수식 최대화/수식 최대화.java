import java.util.*;

class Solution {
    long ans = 0;
    String[] priorities = {
        "*+-", "*-+", "+-*", "+*-", "-+*", "-*+"
    };
    
    void eval(String exp, String p) {
        List<Long> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for (char c : exp.toCharArray()) {
            if (c == '*' || c == '+' || c == '-') {
                ops.add(c);
                nums.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            } else
                sb.append(c);
        }
        
        nums.add(Long.parseLong(sb.toString()));

        for (char op : p.toCharArray()) {
            for (int i = 0; i < ops.size(); ) {
                if (ops.get(i) == op) {
                    long res = cal(nums.get(i), nums.get(i + 1), op);
                    
                    nums.set(i, res);
                    nums.remove(i + 1);
                    ops.remove(i);
                } else
                    i++;
            }
        }
        
        ans = Math.max(ans, Math.abs(nums.get(0)));
    }
    
    long cal(long a, long b, char op) {
        if (op == '*') return a * b;
        if (op == '+') return a + b;
        return a - b;
    }
    
    public long solution(String expression) {
        for(String priority : priorities)
            eval(expression, priority);
        
        return ans;
    }
}