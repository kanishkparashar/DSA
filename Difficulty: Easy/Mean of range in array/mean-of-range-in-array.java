class Solution{
	ArrayList<Integer> findMean(int[] arr,int[][] queries){
		int n=arr.length;
		long[] pre=new long[n+1];
		for(int i=0;i<n;i++)pre[i+1]=pre[i]+arr[i];
		ArrayList<Integer> res=new ArrayList<>();
		for(int i=0;i<queries.length;i++){
			int l=queries[i][0],r=queries[i][1];
			long sum=pre[r+1]-pre[l];
			res.add((int)(sum/(r-l+1)));
		}
		return res;
	}
}