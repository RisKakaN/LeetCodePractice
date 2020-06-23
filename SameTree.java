import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SameTree {

    /**
     * Given two binary trees, write a function to check if they are the same or
     * not.
     * 
     * Two binary trees are considered the same if they are structurally identical
     * and the nodes have the same value.
     * 
     * Input:
     * 
     * [1,2,3], [1,2,3]
     * 
     * Output: true
     */

    // Definition for a binary tree node.
    public class TreeNode {
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
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p).equals(helper(q));
    }

    private List<Integer> helper(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current == null) {
                list.add(null);
                continue;
            }

            list.add(current.val);

            if (current.left != null) {
                queue.add(current.left);
            } else {
                queue.add(null);
            }

            if (current.right != null) {
                queue.add(current.right);
            } else {
                queue.add(null);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        SameTree st = new SameTree();

        SameTree.TreeNode tree1 = st.new TreeNode(1);

        tree1.left = st.new TreeNode(2);

        SameTree.TreeNode tree2 = st.new TreeNode(1);

        tree2.right = st.new TreeNode(2);

        // SameTree.TreeNode tree1 = st.new TreeNode(1);

        // tree1.left = st.new TreeNode(2);
        // tree1.right = st.new TreeNode(3);
        // SameTree.TreeNode tree1l = tree1.left;
        // SameTree.TreeNode tree1r = tree1.right;
        // tree1l.left = st.new TreeNode(4);
        // tree1l.right = st.new TreeNode(5);
        // tree1r.left = st.new TreeNode(6);
        // tree1r.right = st.new TreeNode(7);

        // SameTree.TreeNode tree2 = st.new TreeNode(1);

        // tree2.left = st.new TreeNode(2);
        // tree2.right = st.new TreeNode(3);
        // SameTree.TreeNode tree2l = tree2.left;
        // SameTree.TreeNode tree2r = tree2.right;
        // tree2l.left = st.new TreeNode(4);
        // tree2l.right = st.new TreeNode(5);
        // tree2r.left = st.new TreeNode(6);
        // tree2r.right = st.new TreeNode(7);

        System.out.println(st.isSameTree(tree1, tree2));

    }

}