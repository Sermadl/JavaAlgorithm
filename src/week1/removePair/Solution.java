package week1.removePair;

import java.util.ArrayDeque;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] c = s.toCharArray();

        for(char a : c){
            // stack이 비어있지 않고, stack top이 현재 push 하려는 문자와 같을 때 pop
            if(!stack.isEmpty() && stack.peek() == a){ // peek() : stack top 반환
                stack.pop();
            } else {
                stack.push(a);
            }
        }

        // stack이 비어있으면 1, 그렇지 않으면 0 반환
        return stack.isEmpty() ? 1 : 0;
    }
}
