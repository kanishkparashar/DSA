class Solution {
    public int smallestSubstring(String s) {
        int n = s.length();
        int[] count = new int[3];
        int left = 0, ans = Integer.MAX_VALUE, distinct = 0;

        for (int right = 0; right < n; right++) {
            int r = s.charAt(right) - '0';
            if (count[r] == 0) distinct++;
            count[r]++;

            while (distinct == 3) {
                ans = Math.min(ans, right - left + 1);

                int l = s.charAt(left) - '0';
                count[l]--;
                if (count[l] == 0) distinct--;

                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}