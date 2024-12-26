package week4.lambAndWoolf;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(
                solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                        new int[][]{
                                new int[]{0, 1}, new int[]{1, 2},
                                new int[]{1, 4}, new int[]{0, 8}, new int[]{8, 7},
                                new int[]{9, 10}, new int[]{9, 11}, new int[]{4, 3},
                                new int[]{6, 5}, new int[]{4, 6}, new int[]{8, 9}
                        }));
        System.out.println(
                solution(new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                        new int[][]{
                                new int[]{0, 1}, new int[]{0, 2},
                                new int[]{1, 3}, new int[]{1, 4}, new int[]{2, 5},
                                new int[]{2, 6}, new int[]{3, 7}, new int[]{4, 8},
                                new int[]{6, 9}, new int[]{9, 10}
                        }));
    }

    private static class Info {
        int node, sheep, wolf;
        HashSet<Integer> visit; // 다음에 방문할 수 있는 노드들이 저장되어 있음

        public Info(int node, int sheep, int wolf, HashSet<Integer> visit) {
            this.node = node;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visit = visit;
        }
    }

    private static ArrayList<Integer>[] tree;

    private static void buildTree(int[] info, int[][] edges) {
        tree = new ArrayList[info.length];
        // 노드 수 만큼 배열 공간 확보
        for(int i=0; i < tree.length; i++){
            tree[i] = new ArrayList<>();
        }

        // edge[0]와 직접적으로 연결되어 있는 노드를 edge[0]번 인덱스에 저장하기
        for(int[] edge: edges){
            tree[edge[0]].add(edge[1]);
        }
    }

    public static int solution(int[] info, int[][] edges) {
        buildTree(info, edges); // 트리 생성
        int answer = 0; // 양의 수를 저장

        ArrayDeque<Info> queue = new ArrayDeque<>();

        // 노드 방문 정보 및 양, 늑대 정보 초기화 (루트 노드에는 항상 양이 있음)
        queue.add(new Info(0, 1, 0, new HashSet<>()));

        while(!queue.isEmpty()) {
            // 큐에서 현재 상태를 꺼냄
            Info curr = queue.pollLast();

            answer = Math.max(answer, curr.sheep);
            curr.visit.addAll(tree[curr.node]);

            for (int now : curr.visit){
                HashSet<Integer> set = new HashSet<>(curr.visit);
                set.remove(now); // 현재 방문한 노드 지우고 다음에 방문할 노드만 남겨두기

                if(info[now] == 1) { // 현재 방문한 노드가 늑대일 경우
                    if(curr.sheep != curr.wolf + 1) {
                        queue.add(new Info(now, curr.sheep, curr.wolf + 1, set));
                    }
                }
                else { // 현재 방문한 노드가 양일 경우
                    queue.add(new Info(now, curr.sheep + 1, curr.wolf, set));
                }
            }
        }


        return answer;
    }
}
