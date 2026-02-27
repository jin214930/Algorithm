import java.util.*;

class Song {
    String genre;
    int play;
    int idx;
    
    Song(String genre, int play, int idx) {
        this.genre = genre;
        this.play = play;
        this.idx = idx;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Song[] songs = new Song[genres.length];
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            songs[i] = new Song(genres[i], plays[i], i);
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        Arrays.sort(songs, (s1, s2) -> {
            if (s1.genre.equals(s2.genre)) {
                if(s1.play == s2.play)
                    return s1.idx - s2.idx;
                return s2.play - s1.play;
            }
            
            return map.get(s2.genre) - map.get(s1.genre);
        });
        
                
        List<Integer> list = new ArrayList<>();
        String tmp = "";
        int cnt = 0;
        for (Song s : songs) {
            if (s.genre.equals(tmp)) {
                if (cnt == 2)
                    continue;
                else {
                    cnt++;
                    list.add(s.idx);
                }
            }
            else {
                cnt = 1;
                tmp = s.genre;
                list.add(s.idx);
            }
        }
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        
        return ans;        
    }
}