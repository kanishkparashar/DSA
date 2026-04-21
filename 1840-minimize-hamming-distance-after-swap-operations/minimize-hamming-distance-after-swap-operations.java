class Solution {
    class DSU {
        int[] p;

        DSU(int n) {
            p = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }

        int f(int x) {
            if (p[x] != x) p[x] = f(p[x]);
            return p[x];
        }

        void u(int a, int b) {
            int pa = f(a), pb = f(b);
            if (pa != pb) p[pa] = pb;
        }
    }

    public int minimumHammingDistance(int[] s, int[] t, int[][] a) {
        int n = s.length;
        DSU d = new DSU(n);

        for (int[] x : a) d.u(x[0], x[1]);

        java.util.Map<Integer, java.util.List<Integer>> m = new java.util.HashMap<>();

        for (int i = 0; i < n; i++) {
            int p = d.f(i);
            m.computeIfAbsent(p, k -> new java.util.ArrayList<>()).add(i);
        }

        int r = 0;

        for (java.util.List<Integer> g : m.values()) {
            java.util.Map<Integer, Integer> f = new java.util.HashMap<>();

            for (int i : g) f.put(s[i], f.getOrDefault(s[i], 0) + 1);

            for (int i : g) {
                int v = t[i];
                if (f.getOrDefault(v, 0) > 0) f.put(v, f.get(v) - 1);
                else r++;
            }
        }

        return r;
    }
}