package test240317;


import java.util.*;

public class Hash5 {
    // 베스트앨범
    public static void main(String[] args) {
        String[] genres={"classic", "pop", "classic", "classic", "pop"};
        int[] plays={500, 600, 150, 800, 2500};

        class Song{
            int idx;
            int play;

            public Song(int idx, int paly) {
                this.idx = idx;
                this.play = paly;
            }
        }


        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, PriorityQueue<Song>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 장르별 총 재생 횟수 계산
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + play);

            // 장르별 곡 정보 저장 및 재생 횟수가 높은 순으로 우선순위 큐에 저장
            if (!songMap.containsKey(genre)) {
                songMap.put(genre, new PriorityQueue<>((a, b) -> {
                    if (a.play == b.play) return a.idx - b.idx;
                    return b.play - a.play;
                }));
            }
            songMap.get(genre).add(new Song(i, play));
        }

        // 재생 횟수가 높은 장르부터 순회하며 최대 두 개의 곡 선택
        List<String> genreList = new ArrayList<>(genreCount.keySet());
        Collections.sort(genreList, (a, b) -> genreCount.get(b) - genreCount.get(a));

        List<Integer> answerList = new ArrayList<>();
        for (String genre : genreList) {
            PriorityQueue<Song> pq = songMap.get(genre);
            int count = 0;
            while (!pq.isEmpty() && count < 2) {
                answerList.add(pq.poll().idx);
                count++;
            }
        }

        // List<Integer>을 int[]로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

    }
}
