import java.util.*;
class Solution{
	ArrayList<Integer> reducePairs(int[]a){
		Stack<Integer>st=new Stack<>();
		for(int x:a){
			boolean add=true;
			while(!st.isEmpty()&&st.peek()*x<0){
				int y=st.peek();
				if(Math.abs(y)>Math.abs(x)){
					add=false;
					break;
				}else if(Math.abs(y)<Math.abs(x)){
					st.pop();
				}else{
					st.pop();
					add=false;
					break;
				}
			}
			if(add)st.push(x);
		}
		ArrayList<Integer>res=new ArrayList<>();
		for(int x:st)res.add(x);
		return res;
	}
}