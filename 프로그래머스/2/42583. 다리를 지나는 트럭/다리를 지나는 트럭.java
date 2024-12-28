import java.util.*;

class Truck {
    int weight;
    int time;
    
    public Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }
}

class Solution {    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> q = new LinkedList<>();
        int ans = 0;
        int idx = 0;
        int sum = 0;
        
        while (true) {
            if (idx == truck_weights.length && q.isEmpty())
                break;
            
            if (!q.isEmpty() && ans - q.peek().time == bridge_length) 
                sum -= q.poll().weight;
            
            if (idx != truck_weights.length && sum + truck_weights[idx] <= weight) {
                q.add(new Truck(truck_weights[idx], ans));
                sum += truck_weights[idx++];
            }
            
            ans++;
        }
        
        return ans;
    }
}