class Solution{
    public List<TreeNode> generateTrees(int n){
        return solve(1,n);
    }
    private List<TreeNode> solve(int start,int end){
        List<TreeNode>res=new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode>left=solve(start,i-1);
            List<TreeNode>right=solve(i+1,end);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}