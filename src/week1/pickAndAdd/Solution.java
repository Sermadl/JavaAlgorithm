package week1.pickAndAdd;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7})));
    }

    public static int[] solution(int[] arr){
        TreeSet<Integer> answer = new TreeSet<>();

        for(int i=0; i<arr.length; i++){
            for (int j=i+1; j<arr.length; j++){
                answer.add(arr[i]+arr[j]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
