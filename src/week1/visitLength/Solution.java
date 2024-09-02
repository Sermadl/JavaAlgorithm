package week1.visitLength;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
    }

    public static int solution(String dirs){
        HashMap<Character, int[]> moves = new HashMap<>();

        int currX = 0, currY = 0;

        moves.put('U', new int[]{0, 1});
        moves.put('L', new int[]{-1, 0});
        moves.put('R', new int[]{1, 0});
        moves.put('D', new int[]{0, -1});

        HashSet<String> visited = new HashSet<>();

        for(int i = 0; i < dirs.length(); i++){
            int nextX = currX + moves.get(dirs.charAt(i))[0];
            int nextY = currY + moves.get(dirs.charAt(i))[1];

            if(nextX >= -5 && nextY >= -5 && nextX <= 5 && nextY <= 5){
                visited.add(currX + " " + currY + " " + nextX + " " + nextY);
                visited.add(nextX + " " + nextY + " " + currX + " " + currY);

                currX = nextX;
                currY = nextY;
            } else {
                continue;
            }
        }
        return visited.size() / 2;
    }
}
