class Solution{
	char[] s;
	long[][][][][] cnt;
	long[][][][][] sum;

	public long totalWaviness(long num1,long num2){
		return calc(num2)-calc(num1-1);
	}

	long calc(long x){
		if(x<=0){
			return 0;
		}

		s=String.valueOf(x).toCharArray();
		int n=s.length;

		cnt=new long[n+1][11][11][2][2];
		sum=new long[n+1][11][11][2][2];

		for(int i=0;i<=n;i++){
			for(int j=0;j<11;j++){
				for(int k=0;k<11;k++){
					for(int l=0;l<2;l++){
						for(int m=0;m<2;m++){
							cnt[i][j][k][l][m]=-1;
							sum[i][j][k][l][m]=-1;
						}
					}
				}
			}
		}

		return dfs(0,10,10,1,0);
	}

	long dfs(int pos,int prev1,int prev2,int tight,int started){
		if(pos==s.length){
			return 0;
		}

		if(sum[pos][prev1][prev2][tight][started]!=-1){
			return sum[pos][prev1][prev2][tight][started];
		}

		long total=0;
		long ways=0;

		int lim=tight==1?s[pos]-'0':9;

		for(int d=0;d<=lim;d++){
			int nt=(tight==1&&d==lim)?1:0;

			if(started==0&&d==0){
				total+=dfs(pos+1,10,10,nt,0);
				ways+=count(pos+1,10,10,nt,0);
			}else{
				long add=0;

				if(prev2!=10){
					if((prev1>prev2&&prev1>d)||(prev1<prev2&&prev1<d)){
						add=1;
					}
				}

				long c=count(pos+1,d,prev1,nt,1);

				total+=dfs(pos+1,d,prev1,nt,1)+add*c;
				ways+=c;
			}
		}

		cnt[pos][prev1][prev2][tight][started]=ways;
		return sum[pos][prev1][prev2][tight][started]=total;
	}

	long count(int pos,int prev1,int prev2,int tight,int started){
		if(pos==s.length){
			return 1;
		}

		if(cnt[pos][prev1][prev2][tight][started]!=-1){
			return cnt[pos][prev1][prev2][tight][started];
		}

		long ways=0;
		int lim=tight==1?s[pos]-'0':9;

		for(int d=0;d<=lim;d++){
			int nt=(tight==1&&d==lim)?1:0;

			if(started==0&&d==0){
				ways+=count(pos+1,10,10,nt,0);
			}else{
				ways+=count(pos+1,d,prev1,nt,1);
			}
		}

		return cnt[pos][prev1][prev2][tight][started]=ways;
	}
}