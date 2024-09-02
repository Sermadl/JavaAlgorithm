package week1.failureRate;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 4})));
    }

    public static int[] solution(int N, int[] stages){
        int[][] arr = new int[N][2];
        // col: 클리어 못한 플레이어의 수
        // row: 스테이지에 도달한 플레이어의 수

        for(int i = 0; i < N; i++){
            for(int j = 0; j < stages.length; j++){
                // 클리어 하지 못한 플레이어
                if(stages[j] == (i+1)){
                    arr[i][0]++;
                }
                // 스테이지에 도달한 플레이어
                if(stages[j] >= (i+1)){
                    arr[i][1]++;
                }
            }
        }

        HashMap<Integer, Double> answer = new HashMap<>();

        for(int i = 0; i < N; i++){
            // 스테이지에 도달한 플레이어가 없는 경우
            if (arr[i][1] == 0) {
                answer.put(i+1, 0.);
            } else {
                answer.put(i+1, (double)arr[i][0]/arr[i][1]);
            }
        }

        return answer.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).
                mapToInt(HashMap.Entry::getKey).toArray();
    }
}
