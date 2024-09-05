package week1.josephus;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution1(5, 2));
        System.out.println(solution2(5, 2));
    }

    public static int solution1(int n, int k) {
        ArrayList<Integer> circle = new ArrayList<>();
        int curr = k - 1;

        for(int i = 0; i < n; i++) {
            circle.add(i);
        }

        while(circle.size() > 1) {
            circle.remove(curr);
            n--;
            curr = (curr + k ) % n;
        }

        return circle.get(0) + 1;
    }

    public static int solution2(int n, int k) {
        ArrayDeque<Integer> circle = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            circle.addLast(i);
        }

        while(circle.size() > 1) {
            for(int i = 0; i < k - 1; i++) {
                circle.addLast(circle.poll());
            }
            circle.poll();
        }

        return circle.poll();
    }
}
