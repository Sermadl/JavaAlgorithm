package week1.mockTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

    public static int[] solution(int[] arr){
        int[] dumb1 = {1, 2, 3, 4, 5};
        int[] dumb2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] dumb3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = {0, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            int index1 = i % dumb1.length;
            if (arr[i] == dumb1[index1]) {
                score[0]++;
            }

            int index2 = i % dumb2.length;
            if (arr[i] == dumb2[index2]) {
                score[1]++;
            }

            int index3 = i % dumb3.length;
            if (arr[i] == dumb3[index3]) {
                score[2]++;
            }
        }

        int maxScore = Arrays.stream(score).max().getAsInt();

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0;i<score.length;i++){
            if(score[i] == maxScore) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
