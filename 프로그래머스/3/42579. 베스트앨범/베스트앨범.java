import java.util.*;

class Solution {
    static class Song implements Comparable<Song> {
        int cnt;
        int idx;
    
        public Song(int cnt, int idx) {
            this.cnt = cnt;
            this.idx = idx;
        }

        @Override
        public int compareTo(Song song) {
            if (this.cnt == song.cnt)
                return this.idx - song.idx;
            return song.cnt - this.cnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            songMap.putIfAbsent(genres[i], new ArrayList<>());
            songMap.get(genres[i]).add(new Song(plays[i], i));
        }
        
        List<String> genreList = new ArrayList<>(genreMap.keySet());
        Collections.sort(genreList, (g1, g2) -> genreMap.get(g2) - genreMap.get(g1));
        
        List<Integer> ansList = new ArrayList<>();
        for (String g : genreList) {
            List<Song> songList = songMap.get(g);
            if (songList.size() == 1) {
                ansList.add(songList.get(0).idx);
                continue;
            }
            Collections.sort(songList);
            for (int i = 0; i < 2; i++)
                ansList.add(songList.get(i).idx);
        }
        
        int[] ans = new int[ansList.size()];
        int idx = 0;
        for (int i : ansList)
            ans[idx++] = i;
        
        return ans;
    }
}