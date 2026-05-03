class Solution{
	ArrayList<Integer> sortBySetBitCount(int[]arr){
		ArrayList<Integer>list=new ArrayList<>();
		for(int x:arr)list.add(x);
		Collections.sort(list,(a,b)->{
			int c1=Integer.bitCount(a),c2=Integer.bitCount(b);
			if(c1!=c2)return c2-c1;
			return 0;
		});
		return list;
	}
}