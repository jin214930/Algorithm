import java.util.*;

class Solution {
    static class Food {
        int time;
        int idx;
        
        Food(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }
    }
    
    public int solution(int[] food_times, long k) {
        long sum = 0;
        for (int time : food_times) {
            sum += time;
        }
        
        if (sum <= k) return -1;
        
        PriorityQueue<Food> pq = new PriorityQueue<>((f1, f2) -> {
            return f1.time - f2.time;
        });
        
        for (int i = 0; i < food_times.length; i++) {
            pq.add(new Food(food_times[i], i + 1));
        }
        
        long prev = 0;
        long foodCnt = food_times.length;
        
        while(!pq.isEmpty() && (pq.peek().time - prev) * foodCnt <= k) {
            int now = pq.poll().time;
            k -= (now - prev) * foodCnt;
            foodCnt--;
            prev = now;
        }
        
        List<Food> foods = new ArrayList<>();
        while(!pq.isEmpty()) {
            foods.add(pq.poll());
        }
        
        Collections.sort(foods, (f1, f2) -> {
            return f1.idx - f2.idx;
        });
        
        int targetIdx = (int) (k % foodCnt);
        
        return foods.get(targetIdx).idx;
    }
}