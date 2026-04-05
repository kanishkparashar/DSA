class Solution {
    public int totalWays(int[] arr, int target) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        if ((target + totalSum) % 2 != 0 || Math.abs(target) > totalSum)
            return 0;

        int sum = (target + totalSum) / 2;

        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int num : arr) {
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[sum];
    }
}