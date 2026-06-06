class Solution{
	public int[] leftRightDifference(int[] nums){
		int n=nums.length;
		int[] ans=new int[n];

		int total=0;
		for(int x:nums){
			total+=x;
		}

		int left=0;

		for(int i=0;i<n;i++){
			total-=nums[i];
			ans[i]=Math.abs(left-total);
			left+=nums[i];
		}

		return ans;
	}
}