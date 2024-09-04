package week1.tableEdit;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution1(8, 2,
                new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));

        System.out.println(solution2(8, 2,
                new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }


    public static String solution1(int n, int k, String[] cmd){
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = 'O';
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int move;

        for (String str : cmd){
            String[] command = str.split(" ");

            switch (command[0]){
                case "U":
                    move = Integer.parseInt(command[1]);
                    while(move > 0) {
                        if(answer[k-1] == 'X') {
                            k--;
                            continue;
                        }
                        move--;
                        k--;
                    }
                    break;

                case "D":
                    move = Integer.parseInt(command[1]);
                    while(move > 0) {
                        if(answer[k+1] == 'X') {
                            k++;
                            continue;
                        }
                        move--;
                        k++;
                    }
                    break;

                case "C":
                    stack.push(k);
                    answer[k] = 'X';
                    while(answer[k] == 'X') {
                        if(k == n - 1){
                            k = reverse(k, answer);
                            break;
                        }
                        k++;
                    }
                    break;

                case "Z":
                    int temp = stack.pop();
                    answer[temp] = 'O';
                    break;
            }
        }

        return String.valueOf(answer);
    }

    public static int reverse(int k, char[] answer){
        while(answer[k] == 'X'){
            k--;
        }

        return k;
    }

    public static String solution2(int n, int k, String[] cmd) {
        int[] up = new int[n+2];
        int[] down = new int[n+2];

        for (int i = 0; i < n+2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        k++;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(String str : cmd){
            String[] command = str.split(" ");

            switch(command[0]){
                case "U":
                    for (int i = 0; i < Integer.parseInt(command[1]); i++) {
                        k = up[k];
                    }
                    break;
                case "D":
                    for(int i = 0; i < Integer.parseInt(command[1]); i++) {
                        k = down[k];
                    }
                    break;
                case "C":
                    stack.push(k);
                    down[up[k]] = down[k];
                    up[down[k]] = up[k];
                    k = n < down[k] ? up[k] : down[k];
                    break;
                case "Z":
                    int temp = stack.pop();
                    down[up[temp]] = temp;
                    up[down[temp]] = temp;
                    break;
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for (int i : stack) {
            answer[i - 1] = 'X';
        }

        return new String(answer);
    }
}
