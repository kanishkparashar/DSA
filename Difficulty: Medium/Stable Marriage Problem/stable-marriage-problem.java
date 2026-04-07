class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;

        int[] womanPartner = new int[n];
        int[] manPartner = new int[n];
        int[] next = new int[n];

        java.util.Arrays.fill(womanPartner, -1);
        java.util.Arrays.fill(manPartner, -1);

        int[][] rank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }

        java.util.Queue<Integer> freeMen = new java.util.LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.add(i);
        }

        while (!freeMen.isEmpty()) {
            int m = freeMen.poll();
            int w = men[m][next[m]];
            next[m]++;

            if (womanPartner[w] == -1) {
                womanPartner[w] = m;
                manPartner[m] = w;
            } else {
                int m1 = womanPartner[w];
                if (rank[w][m] < rank[w][m1]) {
                    womanPartner[w] = m;
                    manPartner[m] = w;
                    freeMen.add(m1);
                } else {
                    freeMen.add(m);
                }
            }
        }

        return manPartner;
    }
}