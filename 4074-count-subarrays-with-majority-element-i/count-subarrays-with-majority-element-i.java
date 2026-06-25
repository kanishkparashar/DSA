class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (nums[i] == target ? 1 : 0);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int cnt = pre[j + 1] - pre[i];
                int len = j - i + 1;
                if (cnt * 2 > len) ans++;
            }
        }
        return ans;
    }
}