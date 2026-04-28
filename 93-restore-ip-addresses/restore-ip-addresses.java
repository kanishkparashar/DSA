class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> res=new ArrayList<>();
		backtrack(s,0,0,"",res);
		return res;
	}

	void backtrack(String s,int idx,int parts,String curr,List<String> res) {
		if(parts==4&&idx==s.length()) {
			res.add(curr.substring(0,curr.length()-1));
			return;
		}

		if(parts==4||idx==s.length()) return;

		for(int len=1;len<=3&&idx+len<=s.length();len++) {
			String sub=s.substring(idx,idx+len);

			if((sub.length()>1&&sub.charAt(0)=='0')||Integer.parseInt(sub)>255) continue;

			backtrack(s,idx+len,parts+1,curr+sub+".",res);
		}
	}
}