package week4.wordChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,
                new String[]{
                        "tank", "kick", "know", "wheel", "land",
                        "dream", "mother", "robot", "tank"
                })));

        System.out.println(Arrays.toString(solution(5,
                new String[]{
                        "hello", "observe", "effect", "take",
                        "either", "recognize", "encourage", "ensure",
                        "establish", "hang", "gather", "refer", "reference",
                        "estimate", "executive"
                })));

        System.out.println(Arrays.toString(solution(2,
                new String[]{
                        "hello", "one", "even", "never", "now", "world", "draw"
                })));
    }

    private static int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>();
        char chain = words[0].charAt(0);

        for(int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) != chain || wordSet.contains(words[i])) {
                // i % n => 현재 words 인덱스에서 n을 나눈 나머지는 0, 1, 2, .. / 0, 1, 2, .. 로 계속 반복됨
                // -> 누가 현재 진행 중인지 알 수 있음
                // i / n => 현재 words 인덱스에서 n을 나눈 값은 0, 0, .. / 1, 1, ... / 2, 2, ... 로 계속 반복됨
                // -> 이 사람이 몇 번째로 말한 단어인지 알 수 있음
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            wordSet.add(words[i]);
            chain = words[i].charAt(words[i].length() - 1);
        }


        return new int[]{0, 0};
    }
}
