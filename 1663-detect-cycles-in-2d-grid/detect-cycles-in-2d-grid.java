class Solution {
    int m, n;
    boolean[][] vis;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    if (dfs(grid, i, j, -1, -1)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, int i, int j, int pi, int pj) {
        vis[i][j] = true;

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == grid[i][j]) {
                if (!vis[ni][nj]) {
                    if (dfs(grid, ni, nj, i, j)) return true;
                } else if (ni != pi || nj != pj) {
                    return true;
                }
            }
        }
        return false;
    }
}