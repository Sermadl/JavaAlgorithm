package week4.unionFind;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,
                new int[][]{
                new int[]{0, 0, 1}, new int[]{0, 1, 2}, new int[]{1, 1, 2}
        })));

        System.out.println(Arrays.toString(solution(3,
                new int[][]{
                        new int[]{0, 0, 1}, new int[]{1, 1, 2},
                        new int[]{0, 1, 2}, new int[]{1, 0, 2}
                })));
    }

    public static int[] parent;

    private static void union(int x, int y){
        // x와 y의 루트 노드를 각각 찾음
        int rootX = find(x);
        int rootY = find(y);

        // 더 작은 루트 노드로 합치기
        if(rootX < rootY) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) { // 부모 노드가 자기 자신인 경우 return
            return x;
        }

        parent[x] = find(parent[x]); // 재귀로 가장 루트 노드를 찾음
        return parent[x];
    }

    public static Boolean[] solution(int k, int[][] operations){
        ArrayList<Boolean> answer = new ArrayList<>();
        parent = new int[k];

        // 처음에는 부모 노드가 자기 자신임
        for(int i=0; i<k; i++) {
            parent[i] = i;
        }

        for(int[] operate : operations) {
            // 0번 명령이라면(union 명령)
            if(operate[0] == 0) {
                union(operate[1], operate[2]);
            } else { // 1번 명령이라면(equals 명령)
                answer.add(find(operate[1]) == find(operate[2]));
            }
        }

        return answer.toArray(new Boolean[0]);
    }
}
