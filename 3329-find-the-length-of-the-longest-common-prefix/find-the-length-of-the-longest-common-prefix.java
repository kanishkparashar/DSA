class Solution{
	public int longestCommonPrefix(int[]arr1,int[]arr2){
		HashSet<String>set=new HashSet<>();
		
		for(int x:arr1){
			String s=String.valueOf(x);
			String t="";
			
			for(char c:s.toCharArray()){
				t+=c;
				set.add(t);
			}
		}
		
		int ans=0;
		
		for(int x:arr2){
			String s=String.valueOf(x);
			String t="";
			
			for(char c:s.toCharArray()){
				t+=c;
				
				if(set.contains(t)){
					ans=Math.max(ans,t.length());
				}
			}
		}
		
		return ans;
	}
}