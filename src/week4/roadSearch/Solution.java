package week4.roadSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.deepToString(solution(new int[][]{
                new int[]{5, 3}, new int[]{11, 5}, new int[]{13, 3},
                new int[]{3, 5}, new int[]{6, 1}, new int[]{1, 3},
                new int[]{8, 6}, new int[]{7, 2}, new int[]{2, 2}
        })));
    }

    private static class Node {
        int x, y, num;
        Node left, right;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    private static Node makeTree(int[][] nodeInfo) {
        Node[] nodes = new Node[nodeInfo.length];

        // 노드 정보를 nodes에 입력
        for(int i = 0; i < nodeInfo.length; i++) {
            nodes[i] = new Node(nodeInfo[i][0], nodeInfo[i][1], i+1);
        }

        // y값이 같은 노드들끼리는 x값을 비교하고 그렇지 않으면 y값을 기준으로 내림차순 정렬(시간 복잡도를 줄이기 위한 과정)
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y){
                return Integer.compare(o1.x, o2.x);
            }
            return Integer.compare(o2.y, o1.y); // 내림차순으로 정렬하기 위한 순서
        });

        Node root = nodes[0];

        // 트리 구조 생성
        // 모든 노드를 방문하면서 노드를 연결한다
        for(int i = 1; i < nodeInfo.length; i++) {
            Node parent = root;
            while(true) {
                // x값이 중복되지 않으므로
                // 부모 노도의 x가 현재 노드의 x보다 클 경우
                if(nodes[i].x < parent.x) {
                    // 부모 노드의 left가 비어있다면
                    if(parent.left == null) {
                        // 부모 노드의 left에 현재 노드를 저장하고 break
                        parent.left = nodes[i];
                        break;
                    }
                    // 부모 노드의 left가 비어있지 않다면
                    else {
                        // 부모 노드를 현재 부모노드의 left로 변경하고 이 과정을 반복
                        parent = parent.left;
                    }
                }
                // 부모 노드의 x가 현재 노드의 x보다 작을 경우
                else {
                    // 부모 노드의 right가 비어있다면
                    if(parent.right == null) {
                        // 부모 노드의 right에 현재 노드를 저장하고 break
                        parent.right = nodes[i];
                        break;
                    }
                    // 부모 노드의 right가 비어있지 않다면
                    else {
                        // 부모 노드를 현재 부모 노드의 right로 변경하고 이 과정을 반복
                        parent = parent.right;
                    }
                }
            }
        }

        return nodes[0];
    }

    private static void preorder(Node curr, ArrayList<Integer> visit) {
        if (curr == null) { // 현재 노드가 null이면 return
            return;
        }

        visit.add(curr.num); // 현재 노드를 visit에 저장하고
        preorder(curr.left, visit); // left 방문
        preorder(curr.right, visit); // right 방문
        // 순으로 순회
    }

    private static void postorder(Node curr, ArrayList<Integer> visit) {
        if (curr == null) {
            return;
        }

        postorder(curr.left, visit); // left 방문
        postorder(curr.right, visit); // right 방문
        visit.add(curr.num); // 양쪽 노드 방문 후에 현재 노드 visit에 저장하는 순으로 순회
    }

    private static int[][] solution(int[][] nodeInfo) {
        ArrayList<Integer> preorder = new ArrayList<>();
        ArrayList<Integer> postorder = new ArrayList<>();
        Node root = makeTree(nodeInfo);

        preorder(root, preorder);
        postorder(root, postorder);

        return new int[][]{preorder.stream().mapToInt(Integer::intValue).toArray(),
                postorder.stream().mapToInt(Integer::intValue).toArray()};
    }
}
