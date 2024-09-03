package week1.rotatePatentheses;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }

    public static int solution(String s){
        // 괄호의 종류가 여러개이기 때문에 해시맵에 저장해 두는 것이 효율성이 좋음
        HashMap<Character, Character> map = new HashMap<>();

        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');

        int n = s.length();
        s += s;
        char[] a = s.toCharArray();
        int x = 0;

        A: for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            for(int j = i; j < i + n; j++) {
                char c = a[j];

                if(!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    // 스택이 비어있는 상태에서 닫힘 괄호가 들어오거나, 스택이 비어 있지 않은 상태에서 짝이 맞지 않는 닫힘 괄호가 들어오는 경우
                    if(stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A; // A로 돌아감
                    }
                }
            }

            if(stack.isEmpty()) {
                x++;
            }
        }

        return x;
    }
}
