class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[27][27];
        
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dp[26][26] = 0;
        
        for (char c : word.toCharArray()) {
            int curr = c - 'A';
            int[][] newDp = new int[27][27];
            
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    newDp[i][j] = Integer.MAX_VALUE;
                }
            }
            
            for (int i = 0; i < 27; i++) {
                for (int j = 0; j < 27; j++) {
                    if (dp[i][j] == Integer.MAX_VALUE) continue;
                    
                    int cost1 = dp[i][j] + (i == 26 ? 0 : dist(i, curr));
                    newDp[curr][j] = Math.min(newDp[curr][j], cost1);
                    
                    int cost2 = dp[i][j] + (j == 26 ? 0 : dist(j, curr));
                    newDp[i][curr] = Math.min(newDp[i][curr], cost2);
                }
            }
            
            dp = newDp;
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                res = Math.min(res, dp[i][j]);
            }
        }
        
        return res;
    }
    
    private int dist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}