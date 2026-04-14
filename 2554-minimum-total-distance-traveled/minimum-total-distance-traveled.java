class Solution{
	public long minimumTotalDistance(java.util.List<Integer> robot,int[][] factory){
		java.util.Collections.sort(robot);
		java.util.Arrays.sort(factory,(a,b)->a[0]-b[0]);
		int m=robot.size(),n=factory.length;
		long[][] dp=new long[n+1][m+1];
		for(int j=0;j<=n;j++)for(int i=1;i<=m;i++)dp[j][i]=Long.MAX_VALUE/2;
		for(int j=1;j<=n;j++){
			int pos=factory[j-1][0],limit=factory[j-1][1];
			for(int i=0;i<=m;i++)dp[j][i]=dp[j-1][i];
			for(int i=1;i<=m;i++){
				long dist=0;
				for(int k=1;k<=limit&&k<=i;k++){
					dist+=Math.abs(robot.get(i-k)-pos);
					dp[j][i]=Math.min(dp[j][i],dp[j-1][i-k]+dist);
				}
			}
		}
		return dp[n][m];
	}
}