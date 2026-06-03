import java.util.*;

class Solution{
	public int earliestFinishTime(int[] landStartTime,int[] landDuration,int[] waterStartTime,int[] waterDuration){
		long ans=Long.MAX_VALUE;

		ans=Math.min(ans,
			solve(landStartTime,landDuration,waterStartTime,waterDuration)
		);

		ans=Math.min(ans,
			solve(waterStartTime,waterDuration,landStartTime,landDuration)
		);

		return (int)ans;
	}

	long solve(int[] s1,int[] d1,int[] s2,int[] d2){
		int n=s2.length;

		long[] a=new long[n];
		long[] b=new long[n];

		for(int i=0;i<n;i++){
			a[i]=s2[i]+d2[i];
			b[i]=d2[i];
		}

		int[][] arr=new int[n][2];

		for(int i=0;i<n;i++){
			arr[i][0]=s2[i];
			arr[i][1]=i;
		}

		Arrays.sort(arr,(x,y)->x[0]-y[0]);

		long[] pre=new long[n];
		long[] suf=new long[n];

		pre[0]=b[arr[0][1]];
		for(int i=1;i<n;i++){
			pre[i]=Math.min(pre[i-1],b[arr[i][1]]);
		}

		suf[n-1]=a[arr[n-1][1]];
		for(int i=n-2;i>=0;i--){
			suf[i]=Math.min(suf[i+1],a[arr[i][1]]);
		}

		long res=Long.MAX_VALUE;

		for(int i=0;i<s1.length;i++){
			long t=(long)s1[i]+d1[i];

			int l=0,r=n-1,pos=n;

			while(l<=r){
				int mid=(l+r)/2;

				if(arr[mid][0]<=t){
					l=mid+1;
				}else{
					pos=mid;
					r=mid-1;
				}
			}

			if(pos>0){
				res=Math.min(res,t+pre[pos-1]);
			}

			if(pos<n){
				res=Math.min(res,suf[pos]);
			}
		}

		return res;
	}
}