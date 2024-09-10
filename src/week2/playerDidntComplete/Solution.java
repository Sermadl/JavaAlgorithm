package week2.playerDidntComplete;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}));
    }

    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String str : completion) {
            // completion에 이름이 중복으로 들어가 있는 경우도 있을 수 있음(getOrDefault 사용)
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(String str : participant) {
            if(map.getOrDefault(str, 0) == 0) {
                return str;
            }
            map.put(str, map.get(str) - 1);
        }

        return null;
    }
}
