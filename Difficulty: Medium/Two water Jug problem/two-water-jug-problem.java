class Solution{
	int gcd(int a,int b){
		while(b!=0){
			int t=b;
			b=a%b;
			a=t;
		}
		return a;
	}
	int solve(int from,int to,int d){
		int f=0,t=0,step=0;
		while(f!=d&&t!=d){
			if(f==0){f=from;step++;}
			else if(t==to){t=0;step++;}
			else{
				int pour=Math.min(f,to-t);
				t+=pour;
				f-=pour;
				step++;
			}
		}
		return step;
	}
	public int minSteps(int m,int n,int d){
		if(d>Math.max(m,n))return -1;
		if(d%gcd(m,n)!=0)return -1;
		return Math.min(solve(m,n,d),solve(n,m,d));
	}
}