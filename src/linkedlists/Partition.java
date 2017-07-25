package linkedlists;

/**
 * Created by e068529 on 6/20/17.
 */
public class Partition {
    public static void main(String[] args) {
        Node node = new Node();
        node.val = 3;
        Node root = node;

        node.next = new Node();
        node.next.val = 5;
        node = node.next;

        node.next = new Node();
        node.next.val = 8;
        node = node.next;

        node.next = new Node();
        node.next.val = 5;
        node = node.next;

        node.next = new Node();
        node.next.val = 10;
        node = node.next;

        node.next = new Node();
        node.next.val = 2;
        node = node.next;

        node.next = new Node();
        node.next.val = 1;
        node = node.next;

        root = partition(root, 5);

        printList(root);
    }

    private static Node partition(Node root, int x) {
        Node firstHalf = new Node();
        Node secondHalf = new Node();

        Node firstHalfHead = firstHalf;
        Node secondHalfHead = secondHalf;

        while(root != null) {
            if(root.val < x) {
                firstHalf.val = root.val;
                firstHalf.next = new Node();
                firstHalf = firstHalf.next;
            } else {
                secondHalf.val = root.val;
                secondHalf.next = new Node();
                secondHalf = secondHalf.next;
            }

            root = root.next;

        }

        firstHalf.next = secondHalfHead;

        return firstHalfHead;
    }

    private static class Node {
        int val;
        Node next;
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
