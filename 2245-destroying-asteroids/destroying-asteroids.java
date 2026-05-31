import java.util.*;

class Solution{
	public boolean asteroidsDestroyed(int mass,int[] asteroids){
		Arrays.sort(asteroids);
		long cur=mass;

		for(int x:asteroids){
			if(cur<x){
				return false;
			}
			cur+=x;
		}

		return true;
	}
}