import java.util.*;
class Solution{
	public ArrayList<Integer> kthLargest(int[] arr,int k){
		ArrayList<Integer> res=new ArrayList<>();
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int x:arr){
			pq.add(x);
			if(pq.size()>k)pq.poll();
			if(pq.size()<k)res.add(-1);
			else res.add(pq.peek());
		}
		return res;
	}
}