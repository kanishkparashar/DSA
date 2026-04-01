class Solution{
    public List<Integer> survivedRobotsHealths(int[] positions,int[] healths,String directions){
        int n=positions.length;
        int[][]arr=new int[n][4];
        for(int i=0;i<n;i++){
            arr[i][0]=positions[i];
            arr[i][1]=healths[i];
            arr[i][2]=directions.charAt(i)=='R'?1:0;
            arr[i][3]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(arr[i][2]==1){
                st.push(i);
            }else{
                while(!st.isEmpty()&&arr[st.peek()][2]==1&&arr[i][1]>0){
                    if(arr[st.peek()][1]<arr[i][1]){
                        arr[i][1]--;
                        arr[st.peek()][1]=0;
                        st.pop();
                    }else if(arr[st.peek()][1]>arr[i][1]){
                        arr[st.peek()][1]--;
                        arr[i][1]=0;
                    }else{
                        arr[st.peek()][1]=0;
                        arr[i][1]=0;
                        st.pop();
                    }
                }
                if(arr[i][1]>0)st.push(i);
            }
        }
        List<int[]>res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i][1]>0){
                res.add(new int[]{arr[i][3],arr[i][1]});
            }
        }
        Collections.sort(res,(a,b)->a[0]-b[0]);
        List<Integer>ans=new ArrayList<>();
        for(int[]r:res)ans.add(r[1]);
        return ans;
    }
}