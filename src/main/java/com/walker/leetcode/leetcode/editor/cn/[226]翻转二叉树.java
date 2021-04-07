//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 812 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayDeque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 */
class Solution {
    /**
     * 基于递归
     *
     * @param root
     * @return
     */
    /*public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }*/

    /**
     * dfs：基于栈
     *
     * @param root
     * @return
     */
    /*public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        // 1、根结点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            // 2、出栈一个节点
            TreeNode pop = stack.pop();
            // 3、将出栈节点的左右子节点交换
            TreeNode temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
            // 4、将子节点入栈，优先保证左子树优先遍历
            if (null != pop.right) {
                if (null != pop.right.left || null != pop.right.right) {
                    stack.push(pop.right);
                }
            }
            if (null != pop.left) {
                if (null != pop.left.left || null != pop.left.right) {
                    stack.push(pop.left);
                }
            }
        }
        return root;
    }*/

    /**
     * bfs：基于队列
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        // 1、根结点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            // 2、出队
            TreeNode node = queue.remove();
            // 3、交换出队节点的左右子节点
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            // 4、将子节点入对，优先保证左子树优先遍历
            if(null != node.left){
                if(null != node.left.left || null != node.left.right){
                    queue.add(node.left);
                }
            }
            if(null != node.right){
                if(null != node.right.left || null != node.right.right){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    /*public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
