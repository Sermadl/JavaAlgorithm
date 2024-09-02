package week1.matrixProduct;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] answer1 = solution(
                new int[][]{{1, 4}, {3, 2}, {4, 1}},
                new int[][]{{3, 3}, {3, 3}});

        System.out.println("Answer 1: ");
        for (int i = 0; i < answer1.length; i++) {
            System.out.println(Arrays.toString(answer1[i]));
        }

        int[][] answer2 = solution(
                new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}},
                new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}});

        System.out.println("Answer 2: ");
        for (int i = 0; i < answer2.length; i++) {
            System.out.println(Arrays.toString(answer2[i]));
        }
    }

    public static int[][] solution(int[][] matrix1, int[][] matrix2) {
        int row = matrix1.length;
        int col = matrix2[0].length;

        int[][] answer = new int[row][col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                for(int k=0; k<matrix1[0].length; k++) {
                    answer[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return answer;
    }
}
