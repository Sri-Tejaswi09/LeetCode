import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (grid[i][j] == 2) 
                {
                    q.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!q.isEmpty()) 
        {
            int size = q.size();
            boolean rottenThisMinute = false;
            for (int i = 0; i < size; i++) 
            {
                int[] p = q.poll();
                for (int j = 0; j < 4; j++) 
                {
                    int x = p[0] + dx[j];
                    int y = p[1] + dy[j];
                    if (x < 0 || y < 0 || x >= m || y >= n)
                        continue;
                    if (grid[x][y] != 1)
                        continue;
                    grid[x][y] = 2;
                    fresh--;
                    rottenThisMinute = true;
                    q.offer(new int[]{x, y});
                }
            }
            if (rottenThisMinute)
                time++;
        }
        if (fresh==0)
            return time;
        else
            return -1;
    }
}