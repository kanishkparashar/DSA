import java.util.*;

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root){
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;

        if(!isLeaf(root)) res.add(root.data);

        addLeft(root,res);
        addLeaves(root,res);
        addRight(root,res);

        return res;
    }

    boolean isLeaf(Node node){
        return node.left==null&&node.right==null;
    }

    void addLeft(Node node,ArrayList<Integer> res){
        Node cur=node.left;
        while(cur!=null){
            if(!isLeaf(cur)) res.add(cur.data);
            if(cur.left!=null) cur=cur.left;
            else cur=cur.right;
        }
    }

    void addLeaves(Node node,ArrayList<Integer> res){
        if(node==null) return;

        if(isLeaf(node)){
            res.add(node.data);
            return;
        }

        addLeaves(node.left,res);
        addLeaves(node.right,res);
    }

    void addRight(Node node,ArrayList<Integer> res){
        Node cur=node.right;
        Stack<Integer> st=new Stack<>();

        while(cur!=null){
            if(!isLeaf(cur)) st.push(cur.data);
            if(cur.right!=null) cur=cur.right;
            else cur=cur.left;
        }

        while(!st.isEmpty())
            res.add(st.pop());
    }
}