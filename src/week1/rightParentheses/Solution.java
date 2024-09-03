package week1.rightParentheses;

import java.util.ArrayDeque;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    public static boolean solution(String s) {
        ArrayDeque<Character> par = new ArrayDeque<>();

        char[] a = s.toCharArray();

        for(char c : a) {
            if(c == '(') {
                par.push(c);
            } else if(c == ')') {
                if(par.isEmpty()) {
                    return false;
                }
                par.pop();
            }
        }

        return par.isEmpty();
    }
}
