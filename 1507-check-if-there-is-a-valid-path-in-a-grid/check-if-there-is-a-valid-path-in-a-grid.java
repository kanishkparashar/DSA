class Solution {
    int[][][] dir = {
        {},
        {{0,-1},{0,1}},
        {{-1,0},{1,0}},
        {{0,-1},{1,0}},
        {{0,1},{1,0}},
        {{0,-1},{-1,0}},
        {{0,1},{-1,0}}
    };

    public boolean isValid(int x, int y, int nx, int ny, int[][] grid) {
        for (int[] d : dir[grid[nx][ny]]) {
            if (nx + d[0] == x && ny + d[1] == y) return true;
        }
        return false;
    }

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == m - 1 && y == n - 1) return true;

            for (int[] d : dir[grid[x][y]]) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !vis[nx][ny]) {
                    if (isValid(x, y, nx, ny, grid)) {
                        vis[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return false;
    }
}