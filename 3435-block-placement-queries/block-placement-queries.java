import java.util.*;

class Solution{
	int[] seg;

	public List<Boolean> getResults(int[][] queries){
		int mx=0;
		for(int[] q:queries){
			mx=Math.max(mx,q[1]);
		}
		mx+=2;

		seg=new int[mx*4];

		TreeSet<Integer> set=new TreeSet<>();
		set.add(0);
		set.add(mx);

		for(int[] q:queries){
			if(q[0]==1){
				set.add(q[1]);
			}
		}

		for(int x:set){
			update(1,0,mx,x,0);
		}

		Integer prev=null;
		for(int x:set){
			if(prev!=null){
				update(1,0,mx,x,x-prev);
			}
			prev=x;
		}

		List<Boolean> res=new ArrayList<>();

		for(int i=queries.length-1;i>=0;i--){
			int[] q=queries[i];

			if(q[0]==2){
				int x=q[1];
				int sz=q[2];

				Integer p=set.floor(x);

				int best=Math.max(
					query(1,0,mx,0,p),
					x-p
				);

				res.add(best>=sz);
			}else{
				int x=q[1];

				Integer l=set.lower(x);
				Integer r=set.higher(x);

				set.remove(x);

				update(1,0,mx,r,r-l);
			}
		}

		Collections.reverse(res);
		return res;
	}

	void update(int node,int l,int r,int idx,int val){
		if(l==r){
			seg[node]=val;
			return;
		}

		int mid=(l+r)>>1;

		if(idx<=mid){
			update(node<<1,l,mid,idx,val);
		}else{
			update(node<<1|1,mid+1,r,idx,val);
		}

		seg[node]=Math.max(seg[node<<1],seg[node<<1|1]);
	}

	int query(int node,int l,int r,int ql,int qr){
		if(ql>r||qr<l){
			return 0;
		}

		if(ql<=l&&r<=qr){
			return seg[node];
		}

		int mid=(l+r)>>1;

		return Math.max(
			query(node<<1,l,mid,ql,qr),
			query(node<<1|1,mid+1,r,ql,qr)
		);
	}
}