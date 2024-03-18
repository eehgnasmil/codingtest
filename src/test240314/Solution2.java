package test240314;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        int answer = 0;
        int[][] maps ={{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        // 나 0,0 상대 n,m
        // int[n][m]일 때 [n][m-1] [n][n+1] [n+1][m] [n-1][m] 이 1 이 있어야 움직이기 가능
        // 모두 위아래양옆이 모두 0이면 못움직임
        System.out.println(Solution2.solution(maps));
    }
    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.offer(new int[]{0, 0, 1}); // 시작점을 큐에 넣음 이동거리 1
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == n - 1 && y == m - 1) { // 상대 팀 진영에 도착한 경우
                return distance;
            }

            for (int i = 0; i < 4; i++) { // 상하좌우 이동을 확인
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) { // 맵 범위를 벗어나지 않고 벽이 아니며 방문하지 않은 경우
                    queue.offer(new int[]{nx, ny, distance + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        // 상대 팀 진영에 도달할 수 없는 경우
        return -1;
    }
}
