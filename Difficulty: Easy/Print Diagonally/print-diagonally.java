import java.util.*;

class Solution {
    public ArrayList<Integer> diagView(int[][] mat) {
        int n = mat.length;
        ArrayList<Integer> result = new ArrayList<>();

        for (int col = 0; col < n; col++) {
            int i = 0;
            int j = col;
            while (i < n && j >= 0) {
                result.add(mat[i][j]);
                i++;
                j--;
            }
        }

        for (int row = 1; row < n; row++) {
            int i = row;
            int j = n - 1;
            while (i < n && j >= 0) {
                result.add(mat[i][j]);
                i++;
                j--;
            }
        }

        return result;
    }
}