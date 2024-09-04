package week1.stockPrice;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(new int[]{1, 2, 3, 2, 3})));
        System.out.println(Arrays.toString(solution2(new int[]{1, 6, 9, 5, 3, 2, 7})));
    }

    public static int[] solution1(int[] price){
        int[] answer = new int[price.length];

        for(int i = 0; i < price.length; i++){
            for(int j = i + 1; j < price.length; j++) {
                answer[i]++;
                if (price[i] > price[j]) {
                    break;
                }
            }
        }

        return answer;
    }

    // stack에 index 저장 후, price[top] 보다 price[i]가 더 큰 경우 price[top] 보다 price[i]가 더 커지거나 stack이 빌 때까지
    // pop 후 answer[pop]에 i - pop(인덱스 간 거리) 저장
    public static int[] solution2(int[] price){
        int n = price.length;
        int[] answer = new int[price.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(0);

        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && price[i] < price[stack.peek()]){
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int j = stack.pop();
            answer[j] = n - j - 1;
        }

        return answer;
    }
}
