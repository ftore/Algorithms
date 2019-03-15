package dynamicprogramming;

/**
 * Created by e068529 on 8/3/17.
 */
public class BinaryTreeChildSum {
    public static void addChildSum(Node root) {
        // compute for left subtree
        addChildSum(root.left);

        // compute for right substree
        addChildSum(root.right);

        int totalSum = root.data;

        if(root.left != null) {
            totalSum += root.left.data;
        }

        if(root.right != null) {
            totalSum += root.right.data;
        }

        root.data = totalSum;
    }

    private class Node {
        int data;
        Node left;
        Node right;
    }


}
