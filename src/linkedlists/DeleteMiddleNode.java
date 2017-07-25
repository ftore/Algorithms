package linkedlists;

/**
 * Created by e068529 on 6/20/17.
 */
public class DeleteMiddleNode {
    private static class Node {
        int val;
        Node next;
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.val = 1;
        Node root = node;

        node.next = new Node();
        node.next.val = 2;
        node = node.next;

        node.next = new Node();
        node.next.val = 3;
        node = node.next;

        node.next = new Node();
        node.next.val = 4;
        node = node.next;

        node.next = new Node();
        node.next.val = 5;
        node = node.next;

        root = deleteMiddleNode(root);

        printList(root);
    }

    private static Node deleteMiddleNode(Node root) {
        Node head = root;

        int size = 0;
        while (root != null) {
            root = root.next;
            size++;
        }

        return deleteMiddleNode(head, size);
    }

    private static Node deleteMiddleNode(Node root, int size) {
        if(size <= 2) return root;
        int mid = size / 2;

        Node headTmp = new Node();
        headTmp.val = root.val;
        Node head = headTmp;

        root = root.next;

        int count = 1;

        while (root != null) {
            if(mid != count) {
                headTmp.next = new Node();
                headTmp.next.val = root.val;
                headTmp = headTmp.next;
            }
            root = root.next;
            count++;
        }

        return head;
    }

    private static void printList(Node root) {
        while(root != null) {
            System.out.print(root.val);
            root = root.next;
            if(root != null) {
                System.out.print(" -> ");
            }
        }
    }
}
