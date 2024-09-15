package week2.circuitTree;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6, 7})));
    }

    public static String[] solution(int[] nodes) {
        String[] answer = new String[3];
        answer[0] = preOrder(0, nodes);
        answer[1] = inOrder(0, nodes);
        answer[2] = postOrder(0, nodes);

        return answer;
    }

    public static String preOrder(int idx, int[] nodes) {
        if(idx >= nodes.length) {
            return "";
        }

        // 재귀 함수로 전위 순회 구현
        // 탐색 순서: 현재 노드 -> 왼쪽 노드(가장 바닥의 노드부터 먼저 탐색됨) -> 오른쪽 노드
        return nodes[idx]
                + preOrder(2 * idx + 1, nodes)
                + preOrder(2 * idx + 2, nodes);
    }

    public static String inOrder(int idx, int[] nodes) {
        if(idx >= nodes.length) {
            return "";
        }

        // 재귀 함수로 중위 순회 구현
        // 탐색 순서: 왼쪽 노드(가장 바닥의 노드부터 먼저 탐색됨) -> 현재 노드 -> 오른쪽 노드
        return inOrder(2 * idx + 1, nodes)
                + nodes[idx]
                + inOrder(2 * idx + 2, nodes);
    }

    public static String postOrder(int idx, int[] nodes) {
        if(idx >= nodes.length) {
            return "";
        }

        // 재귀 함수로 후위 순회 구현
        // 탐색 순서: 왼쪽 노드(가장 바닥의 노드부터 먼저 탐색됨) -> 오른쪽 노드 -> 현재 노드
        return postOrder(2 * idx + 1, nodes)
                + postOrder(2 * idx + 2, nodes)
                + nodes[idx];
    }


}
