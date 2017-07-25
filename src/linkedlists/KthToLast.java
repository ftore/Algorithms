package linkedlists;

/**
 * Created by e068529 on 6/19/17.
 */
public class KthToLast {
    private static class Node {
        int val;
        Node next;
    }

    public static void main(String[] args) {

    }

    public static Node kthToLast(Node root, int k) {
        int count = 1;

        while(root != null && count <= k) {
            root = root.next;
        }

        return root;
    }
}
