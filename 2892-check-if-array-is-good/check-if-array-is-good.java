class Solution {
	public boolean isGood(int[] nums) {
		int n=nums.length,m=0;
		int[] f=new int[201];
		for(int x:nums){
			f[x]++;
			m=Math.max(m,x);
		}
		if(m!=n-1||f[m]!=2)
			return false;
		for(int i=1;i<m;i++){
			if(f[i]!=1)
				return false;
		}
		return true;
	}
}