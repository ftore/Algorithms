package linkedlists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by e068529 on 6/19/17.
 */
public class RemoveDumps {
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
        node.next.val = 1;
        node = node.next;

        node.next = new Node();
        node.next.val = 4;
        node = node.next;

        node.next = new Node();
        node.next.val = 5;
        node = node.next;

        //root = removeDups(root);
        root = removeDups2(root);

        printList(root);
    }

    private static Node removeDups(Node root) {
        Set<Integer> set = new HashSet<>();

        while(root != null) {
            if(!set.contains(root.val)) {
                set.add(root.val);
            }
            root = root.next;
        }

        Node tmp = new Node();
        Iterator<Integer> iterator = set.iterator();
        if(iterator.hasNext()) {
            tmp.val = iterator.next();
        }
        Node head = tmp;

        while(iterator.hasNext()) {
            tmp.next = new Node();
            tmp.next.val = iterator.next();
            tmp = tmp.next;
        }

        return head;

    }

    private static Node removeDups2(Node root) {
        if(root == null) return root;

        Node tmpHead = new Node();
        tmpHead.val = root.val;

        Node head = tmpHead;

        root = root.next;

        while (root != null) {
            int curr = tmpHead.val;

            root = removeNode(root, curr);
            tmpHead.next = new Node();
            tmpHead.next.val = root.val;
            tmpHead = tmpHead.next;
            root = root.next;
        }


        return head;
    }

    private static Node removeNode(Node root, int val) {
        if(root == null) return null;

        while(root != null && root.val == val) root = root.next;

        Node tmpHead = new Node();
        tmpHead.val = root.val;
        Node head = tmpHead;

        root = root.next;

        while (root != null) {
            if(root.val != val) {
                tmpHead.next = new Node();
                tmpHead.next.val = root.val;
                tmpHead = tmpHead.next;
            }

            root = root.next;
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

    private static class Node {
        int val;
        Node next;
    }
}
