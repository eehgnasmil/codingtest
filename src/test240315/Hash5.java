package test240315;

import java.util.*;

public class Hash5 {
    // 베스트앨범
    public static void main(String[] args) {
        String[] genres={"classic", "pop", "classic", "classic", "pop"};
        int[] plays={500, 600, 150, 800, 2500};

        // 장르별 총 개수 구한 후
        // 해당 장르를 우선으로 두고 2개씩만 뽑아내기..?
        // 장르별로 2개씩


        HashMap<String,Integer> hm = new LinkedHashMap<>();
        HashMap<String,Integer> hmTotal = new HashMap<>();
        for(int i=0;i< genres.length;i++){
            hmTotal.put(genres[i],hmTotal.getOrDefault(genres[i],0)+plays[i]);
            hm.put(genres[i]+ " " +i,plays[i]);
        }
        int[] answer=new int[hmTotal.size()*2];
        // 총 수 정렬
        HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        List<String> genresOrder = new ArrayList<>();
        hmTotal.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> genresOrder.add(entry.getKey()));

        hm.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        for(String s : genresOrder){
            for(String key:sortedMap.keySet()){
                String genre = key.split(" ")[0];
                int index = Integer.parseInt(key.split(" ")[1]);
                if(genre.equals(s)){
                    System.out.println(index);
                }
            }
        }

        System.out.println(hmTotal);

        System.out.println(sortedMap);
    }
}
