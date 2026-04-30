class Solution{
	int[][][]dp;
	int[][]g;
	int m,n,k;
	public int maxPathScore(int[][]grid,int K){
		g=grid;
		m=g.length;
		n=g[0].length;
		k=K;
		dp=new int[m][n][k+1];
		for(int i=0;i<m;i++)for(int j=0;j<n;j++)for(int c=0;c<=k;c++)dp[i][j][c]=-2;
		return dfs(0,0,0);
	}
	int dfs(int i,int j,int cost){
		if(cost>k)return -1;
		if(i==m-1&&j==n-1)return 0;
		if(dp[i][j][cost]!=-2)return dp[i][j][cost];
		int res=-1;
		if(i+1<m){
			int nc=cost+(g[i+1][j]>0?1:0);
			int val=dfs(i+1,j,nc);
			if(val!=-1)res=Math.max(res,val+g[i+1][j]);
		}
		if(j+1<n){
			int nc=cost+(g[i][j+1]>0?1:0);
			int val=dfs(i,j+1,nc);
			if(val!=-1)res=Math.max(res,val+g[i][j+1]);
		}
		return dp[i][j][cost]=res;
	}
}