public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] arr = data.split(",");
        int[] index = new int[1];

        return build(arr, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(String[] arr, int[] index, int min, int max) {
        if (index[0] == arr.length) return null;

        int val = Integer.parseInt(arr[index[0]]);
        if (val < min || val > max) return null;

        TreeNode root = new TreeNode(val);
        index[0]++;

        root.left = build(arr, index, min, val);
        root.right = build(arr, index, val, max);

        return root;
    }
}