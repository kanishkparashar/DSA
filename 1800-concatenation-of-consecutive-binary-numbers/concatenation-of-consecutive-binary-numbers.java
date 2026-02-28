class Solution{
	public int concatenatedBinary(int n){
		int mod=1000000007;
		long ans=0;
		int length=0;
		for(int i=1;i<=n;i++){
			if((i&(i-1))==0) length++;
			ans=((ans<<length)|i)%mod;
		}
		return(int)ans;
	}
}
