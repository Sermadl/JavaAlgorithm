package week2.makeValue;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 8}, 6));
        System.out.println(solution(new int[]{2, 3, 5, 9}, 10));
    }

    public static boolean solution(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            if(set.contains(target - arr[i])) {
                return true;
            }

            set.add(arr[i]);
        }

        return false;
    }
}
