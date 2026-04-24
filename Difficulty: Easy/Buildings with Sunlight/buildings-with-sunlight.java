class Solution{
	int visibleBuildings(int[]arr){
		int max=0,c=0;
		for(int h:arr){
			if(h>=max){
				c++;
				max=h;
			}
		}
		return c;
	}
}