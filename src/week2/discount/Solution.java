package week2.discount;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork",
                "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
        System.out.println(solution(new String[]{"apple"},
                new int[]{10},
                new String[]{"banana", "banana", "banana", "banana", "banana"
                        , "banana", "banana", "banana", "banana", "banana"}));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wishList = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < want.length; i++) {
            wishList.put(want[i], number[i]);
        }

        for(int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> discountMap = new HashMap<>();
            for(int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            if(wishList.equals(discountMap)) {
                answer++;
            }
        }

        return answer;
    }
}
