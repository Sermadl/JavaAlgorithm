package week2.bestAlbum;

import java.util.*;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {

    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> playMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++) {
            if(!genreMap.containsKey(genres[i])) {
                genreMap.put(genres[i], new ArrayList<>());
                playMap.put(genres[i], 0);
            }
            genreMap.get(genres[i]).add(new int[]{i, plays[i]}); // (장르(키) : [고유 번호, 재생 횟수](값))
            playMap.put(genres[i], playMap.get(genres[i]) + plays[i]); //(장르(키) : 총 재생 횟수(값))
        }

        ArrayList<Integer> answer = new ArrayList<>();

        Stream<Map.Entry<String, Integer>> sortedGenre = playMap.entrySet().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        // Integer.compare(a, b) : a < b 면 -1, a = b 면 0, a > b면 1
        // sorted((o1, o2)) 에서 Integer.compare(o2.getValue(), o1.getValue())의 반환 값이 음수면 위치 유지, 양수면 위치 바뀜, 0이면 위치 유지
        // => 해시 값을 기준으로 내림차순으로 정렬됨

        sortedGenre.forEach(entry -> {
           Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                   .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                   .limit(2);
           sortedSongs.forEach(song -> answer.add(song[0]));
        });
        // 장르의 재생 횟수 기준 내림차순으로 정렬된 배열(sortedGenre)을 순차적으로 탐색하며(entry)
        // 각 장르에서 재생 횟수(o2[1], o2[1] : 0은 고유 번호, 1은 재생 횟수)를 기준으로 내림차순으로 정렬 후
        // 최대 2개씩 가져와 sortedSongs에 고유 번호를 저장한다.

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
