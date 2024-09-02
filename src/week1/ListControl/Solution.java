package week1.ListControl;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(new int[]{4, 2, 2, 1, 3, 4})));
        System.out.println(Arrays.toString(solution2(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }

    public static int[] solution1(int[] arr) {
        Integer[] answer = Arrays.stream(arr).boxed().distinct().sorted().toArray(Integer[]::new);
        Arrays.sort(answer, Collections.reverseOrder());

        return Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
    }

    private static int[] solution2(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : arr) {
            set.add(num);
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
