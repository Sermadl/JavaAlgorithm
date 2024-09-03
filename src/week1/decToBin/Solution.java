package week1.decToBin;

import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution1(10));
        System.out.println(solution2(27));
        System.out.println(solution2(12345));

    }


    public static String solution1(int dec) {
        return Integer.toBinaryString(dec);
    }

    private static String solution2(int dec) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while(dec > 0) {
            int waste = dec % 2;
            dec = dec / 2;
            stack.push(waste);
        }

        StringBuilder sb = new StringBuilder(); // 시간 복잡도 측면에서 String + 연산보다 효율적임

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
