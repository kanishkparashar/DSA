class Solution {
    int currentVal;
    int currentCount = 0;
    int maxCount = 0;
    List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void handle(int val) {
        if (val != currentVal) {
            currentVal = val;
            currentCount = 0;
        }

        currentCount++;

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(val);
        } else if (currentCount == maxCount) {
            modes.add(val);
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        handle(root.val);
        inorder(root.right);
    }
}