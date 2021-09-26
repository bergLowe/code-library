class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelpher(root, null, null);
    }

    private boolean isValidBSTHelpher(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if ((min != null && root.val <= min) || 
            (max != null && root.val > max)) {
            return false;
        }

        // System.out.println(root.val + " " + min + " " + max);
        
        if (!isValidBSTHelpher(root.left, min, root.val) || 
            !isValidBSTHelpher(root.right, root.val, max)) {
            return false;
        }

        return true;
    }
}