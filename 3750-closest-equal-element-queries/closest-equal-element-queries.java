class Solution{
    public List<Integer> solveQueries(int[] nums,int[] queries){
        int n=nums.length;
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        List<Integer> res=new ArrayList<>();
        for(int q:queries){
            ArrayList<Integer> arr=map.get(nums[q]);
            if(arr.size()==1){
                res.add(-1);
                continue;
            }
            int i=Collections.binarySearch(arr,q);
            int left=i>0?arr.get(i-1):arr.get(arr.size()-1);
            int right=i<arr.size()-1?arr.get(i+1):arr.get(0);
            int d1=Math.abs(q-left);
            int d2=Math.abs(q-right);
            d1=Math.min(d1,n-d1);
            d2=Math.min(d2,n-d2);
            res.add(Math.min(d1,d2));
        }
        return res;
    }
}