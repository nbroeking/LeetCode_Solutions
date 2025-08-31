/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList(10); //This should be root.size() to reduce dynamic array resizing. Choosing 10 though because it will have a noticable difference to the runtime due to minimizing memory allocations. 
        traverseAndAddToList(result, root);
        return result;
    }

    private void traverseAndAddToList(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        traverseAndAddToList(result, root.left);
        traverseAndAddToList(result, root.right);
    }
}