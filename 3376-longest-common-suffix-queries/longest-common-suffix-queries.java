class Solution{
	class Trie{
		Trie[] next=new Trie[26];
		int idx;
		Trie(int i){
			idx=i;
		}
	}
	public int[] stringIndices(String[] wordsContainer,String[] wordsQuery){
		int n=wordsContainer.length;
		int best=0;
		for(int i=1;i<n;i++){
			if(wordsContainer[i].length()<wordsContainer[best].length()){
				best=i;
			}
		}
		Trie root=new Trie(best);
		for(int i=0;i<n;i++){
			String s=wordsContainer[i];
			Trie node=root;
			for(int j=s.length()-1;j>=0;j--){
				int c=s.charAt(j)-'a';
				if(node.next[c]==null){
					node.next[c]=new Trie(i);
				}
				node=node.next[c];
				if(wordsContainer[i].length()<wordsContainer[node.idx].length()){
					node.idx=i;
				}
			}
		}
		int[] ans=new int[wordsQuery.length];
		for(int i=0;i<wordsQuery.length;i++){
			String s=wordsQuery[i];
			Trie node=root;
			for(int j=s.length()-1;j>=0;j--){
				int c=s.charAt(j)-'a';
				if(node.next[c]==null){
					break;
				}
				node=node.next[c];
			}
			ans[i]=node.idx;
		}
		return ans;
	}
}