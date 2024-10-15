package week3.bracketPredict;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 8));
    }

    public static int solution(int n, int a, int b) {
        int answer;

        for (answer = 0; a != b; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }
}
