package week1.cardPack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(
                new String[]{"i", "drink", "water"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}
        ));
        System.out.println(solution(
                new String[]{"i", "water", "drink"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}
        ));
    }
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> c1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> c2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalQueue = new ArrayDeque<>(Arrays.asList(goal));

        while(!goalQueue.isEmpty()) {
            String c1Temp = c1.peek();
            String c2Temp = c2.peek();
            String goalTemp = goalQueue.peek();

            if(!c1.isEmpty() && c1Temp.equals(goalTemp)) {
                c1.poll();
                goalQueue.poll();
            } else if(!c2.isEmpty() && c2Temp.equals(goalTemp)) {
                c2.poll();
                goalQueue.poll();
            } else {
                break;
            }
        }

        return goalQueue.isEmpty() ? "Yes" : "No";
    }
}
