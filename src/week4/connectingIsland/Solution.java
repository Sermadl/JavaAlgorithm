package week4.connectingIsland;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(4,
                new int[][]{
                        new int[]{0, 1, 1}, new int[]{0, 2, 2},
                        new int[]{1, 2, 5}, new int[]{1, 3, 1},
                        new int[]{2, 3, 8}
                }));
    }

    private static int[] parent;

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        parent[rootY] = rootX;
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;

        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static int solution(int n, int[][] costs) {
        int answer = 0;
        int nodes = 0;

        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }

        // 건설 비용을 기준으로 오름차순 정렬 (비용이 작은 것부터 연결해서 최소 비용을 구하기 위함)
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for (int[] cost : costs) {
            // 사이클이 생기지 않는 선에서 모든 노드들을 연결했을 경우 break
            if (nodes == n - 1) break;

            // 두 노드의 부모 노드가 같지 않다면 연결 (사이클이 생기지 않게 하기 위함)
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                nodes++; // 연결된 노드 수 증가
                answer += cost[2]; // 최소 노드 연결 비용 증가
            }
        }

        return answer;
    }
}
