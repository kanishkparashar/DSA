class Solution {
    static final long MOD = 1000000007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int d = m * 2;

        long[] v = new long[d];
        for (int a = 1; a <= m; a++) {
            v[a - 1] = a - 1;
            v[m + a - 1] = m - a;
        }

        long[][] t = new long[d][d];

        for (int x = 1; x <= m; x++) {
            for (int p = 1; p < x; p++) {
                t[x - 1][m + p - 1] = 1;
            }
        }

        for (int x = 1; x <= m; x++) {
            for (int p = x + 1; p <= m; p++) {
                t[m + x - 1][p - 1] = 1;
            }
        }

        long e = n - 2;

        while (e > 0) {
            if ((e & 1) == 1) v = mul(t, v);
            t = mul(t, t);
            e >>= 1;
        }

        long ans = 0;
        for (long x : v) ans = (ans + x) % MOD;
        return (int) ans;
    }

    private long[] mul(long[][] a, long[] v) {
        int n = a.length;
        long[] r = new long[n];
        for (int i = 0; i < n; i++) {
            long s = 0;
            for (int j = 0; j < n; j++) {
                if (a[i][j] != 0) {
                    s = (s + a[i][j] * v[j]) % MOD;
                }
            }
            r[i] = s;
        }
        return r;
    }

    private long[][] mul(long[][] a, long[][] b) {
        int n = a.length;
        long[][] r = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;
                long x = a[i][k];
                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;
                    r[i][j] = (r[i][j] + x * b[k][j]) % MOD;
                }
            }
        }
        return r;
    }
}