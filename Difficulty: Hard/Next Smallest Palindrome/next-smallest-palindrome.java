class Solution {
    public int[] nextPalindrome(int[] num) {
        int n = num.length;

        if (all9(num, n)) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        int[] ans = num.clone();
        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;

        boolean leftSmaller = false;

        while (i >= 0 && ans[i] == ans[j]) {
            i--;
            j++;
        }

        if (i < 0 || ans[i] < ans[j]) leftSmaller = true;

        while (i >= 0) {
            ans[j] = ans[i];
            i--;
            j++;
        }

        if (leftSmaller) {
            int carry = 1;
            i = mid - 1;

            if (n % 2 == 1) {
                ans[mid] += carry;
                carry = ans[mid] / 10;
                ans[mid] %= 10;
                j = mid + 1;
            } else {
                j = mid;
            }

            while (i >= 0) {
                ans[i] += carry;
                carry = ans[i] / 10;
                ans[i] %= 10;
                ans[j] = ans[i];
                i--;
                j++;
            }
        }

        return ans;
    }

    boolean all9(int[] num, int n) {
        for (int i = 0; i < n; i++)
            if (num[i] != 9) return false;
        return true;
    }
}