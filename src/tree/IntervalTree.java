package tree;

/**
 * Created by e068529 on 8/28/17.
 */
class Interval {
    int low;
    int hi;
}

class Node {
    Interval interval;
    int max;
    Node left;
    Node right;

    public Node(Interval i) {
        interval = i;
    }
}

public class IntervalTree {
    public Node insert(Node root, Interval i) {
        // Base case: Tree is empty, new node becomes root
        if(root == null) {
            return new Node(i);
        }

        // Get low value of interval at root
        int low = root.interval.low;

        // If root's low value is greater, then new interval goes to
        // left subtree
        if(i.low < low) {
            root.left = insert(root.left, i);
        }

        else {
            root.right = insert(root.right, i);
        }

        // Update the max value of this ancestor if needed
        if(root.max < i.hi) {
            root.max = i.hi;
        }

        return root;
    }

    public boolean doOverlap(Interval i1, Interval i2) {
        if(i1.low <= i2.hi && i2.low <= i1.hi) {
            return true;
        }
        else return false;
    }

    public Interval overlapSearch(Node root, Interval i) {
        // Base Case, tree is empty
        if(root == null) return null;

        // If given interval overlaps with root
        if(doOverlap(root.interval, i)) {
            return root.interval;
        }
        // If left child of root is present and max of left child is
        // greater than or equal to given interval, then i may
        // overlap with an interval is left subtree
        if(root.left != null && root.left.max >= i.low) {
            return overlapSearch(root.left, i);
        }

        // Else interval can only overlap with right subtree
        return overlapSearch(root.right, i);
    }

    public void inorder(Node root) {
        if(root == null) return;

        inorder(root.left);
        System.out.println("[" + root.interval.low + ", " + root.interval.hi + "]" + " max = " + root.max);
        inorder(root.right);
    }
}
