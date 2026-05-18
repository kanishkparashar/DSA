class Solution{
	public int minJumps(int[] arr){
		int n=arr.length;
		if(n==1)return 0;
		
		Map<Integer,List<Integer>> map=new HashMap<>();
		
		for(int i=0;i<n;i++){
			map.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
		}
		
		Queue<Integer> q=new LinkedList<>();
		boolean[] vis=new boolean[n];
		
		q.offer(0);
		vis[0]=true;
		
		int step=0;
		
		while(!q.isEmpty()){
			int size=q.size();
			
			while(size-->0){
				int cur=q.poll();
				
				if(cur==n-1)return step;
				
				if(cur+1<n&&!vis[cur+1]){
					vis[cur+1]=true;
					q.offer(cur+1);
				}
				
				if(cur-1>=0&&!vis[cur-1]){
					vis[cur-1]=true;
					q.offer(cur-1);
				}
				
				if(map.containsKey(arr[cur])){
					for(int next:map.get(arr[cur])){
						if(!vis[next]){
							vis[next]=true;
							q.offer(next);
						}
					}
					map.remove(arr[cur]);
				}
			}
			
			step++;
		}
		
		return -1;
	}
}