package week1.craneClawMachine;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(
        solution(new int[][]{
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 1, 0, 3},
                new int[]{0, 2, 5, 0, 1},
                new int[]{4, 2, 4, 4, 2},
                new int[]{3, 5, 1, 3, 1}
                },
                new int[]{1, 5, 3, 5, 1, 2, 1, 4})
        );
    }

    public static int solution(int[][] board, int[] moves){
        ArrayList<ArrayDeque<Integer>> boardStack = new ArrayList<>(){};
        for(int i = 0; i < board.length; i++){
            ArrayDeque<Integer> temp = new ArrayDeque<>();
            for(int j = 0; j < board[i].length; j++){
                if(board[j][i] == 0){
                    continue;
                }
                temp.add(board[j][i]);
            }
            boardStack.add(temp);
        }

        ArrayDeque<Integer> basket = new ArrayDeque<>();
        int answer = 0;

        for(int move : moves){
            if(boardStack.get(move-1).isEmpty()){
                continue;
            }
            int curr = boardStack.get(move - 1).pop();

            if(!basket.isEmpty() && basket.peek() == curr){
                basket.pop();
                answer += 2;
            } else if(basket.isEmpty() || basket.peek() != curr){
                basket.push(curr);
            }
        }

        return answer;
    }
}
