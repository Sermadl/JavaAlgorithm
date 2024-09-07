package week1.serviceDev;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[]{93, 30, 55},
                new int[]{1, 30, 5}
        )));
        System.out.println(Arrays.toString(solution(
                new int[]{95, 90, 99, 99, 80, 99},
                new int[]{1, 1, 1, 1, 1, 1}
        )));
    }
    public static int[] solution(int[] progress, int[] speeds) {
        ArrayDeque<Integer> answer = new ArrayDeque<>();

        int n = progress.length;
        int[] deploy = new int[n];

        for(int i = 0; i < n; i++){
           deploy[i] = (int) Math.ceil((100.0 - progress[i]) / speeds[i]);
        }

        int cnt = 0;
        int max = deploy[0];

        for(int i = 0; i < n; i++){
            if(deploy[i] <= max){
                cnt++;
            } else {
                answer.add(cnt);
                max = deploy[i];
                cnt = 1;
            }
        }

        answer.add(cnt);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
