package week2.menuRenewal;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(solution(new String[]{"XYZ", "XWY", "WXA"},
                new int[]{2, 3, 4})));
    }

    private static HashMap<Integer, HashMap<String, Integer>> courseMap;

    public static String[] solution(String[] orders, int[] course) {

        courseMap = new HashMap<>();
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        for (String order : orders) {
            char[] orderArr = order.toCharArray();
            // AB, BA가 같은 조합이기 때문에 중복 제거를 위한 오름차순 정렬
            Arrays.sort(orderArr);
            combination(0, orderArr, "");
        }

        ArrayList<String> answer = new ArrayList<>();

        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values() // 0, 1, 4, 3, ... (메뉴 조합의 빈도 수)
                    .stream()
                    .max(Comparator.comparingInt(o -> o)) // 가장 빈도 수가 높은 메뉴 조합을 찾음 (o(int) -> o(int) : 0, 1, 4, 3, ... 에서 객체 하나(숫자) 기준 오름차순으로 정렬)
                    .ifPresent(cnt -> count.entrySet() // 코스에 있는 메뉴의 개수가 가능한 개수일 때
                            .stream()
                            .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1) // 2번 이상 해당 조합으로 주문이 들어왔을 때
                            .forEach(entry -> answer.add(entry.getKey()))); // answer에 메뉴 조합 저장
        }
        Collections.sort(answer); // 오름차순으로 정답 정렬
        return answer.toArray(new String[0]);
    }

    public static void combination(int idx, char[] order, String result){
        // 가능한 메뉴 개수일 때
        if (courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            // 주문 빈도 수 + 1
            map.put(result, map.getOrDefault(result, 0) + 1);
        }

        for(int i = idx; i < order.length; i++) {
            // 현재 메뉴 조합에서 order[i] 번째 메뉴까지 추가된 조합 확인하기
            combination(i + 1, order, result + order[i]);
        }
    }
}
