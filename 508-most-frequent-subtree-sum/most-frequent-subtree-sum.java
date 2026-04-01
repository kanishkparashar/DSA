class Solution{
    HashMap<Integer,Integer>map=new HashMap<>();
    int max=0;
    public int[] findFrequentTreeSum(TreeNode root){
        dfs(root);
        List<Integer>res=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==max)res.add(key);
        }
        int[]ans=new int[res.size()];
        for(int i=0;i<res.size();i++)ans[i]=res.get(i);
        return ans;
    }
    private int dfs(TreeNode node){
        if(node==null)return 0;
        int sum=node.val+dfs(node.left)+dfs(node.right);
        map.put(sum,map.getOrDefault(sum,0)+1);
        max=Math.max(max,map.get(sum));
        return sum;
    }
}