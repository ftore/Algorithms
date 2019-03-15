package linkedlists;

public class ReverseLinkedList2 {
//    public static ListNode reverseBetween(ListNode head, int m, int n) {
//        if(head == null || m == n) return head;
//        ListNode headTrack = head;
//
//        int count = 1;
//        while(head != null && count < m - 1) {
//            head = head.next;
//            count++;
//        }
//
//        head.next = reverse(head.next, n - m + 1);
//
//        //head.next = reverse;
//
//        return headTrack;
//    }
//
//    // 1 -> 3 -> 4 -> 5
//    private static ListNode reverse(ListNode head, int n) {
//        ListNode root = null;
//        int counter = 0;
//        while(head != null) {
//            if(counter < n) {
//                ListNode curr = new ListNode(head.val); // 1, 3, 4
//                curr.next = root; // 1 -> null, 3 -> 1 -> null, 4 -> 3 -> 1 -> null
//                root = curr; // 1 -> null , 3 -> 1 -> null
//
//                head = head.next;
//                counter++;
//            } else break;
//        }
//
//        //root.next = head;
//        ListNode rootTrack = root; // 4 -> 3 -> 1 -> null
//
//        while(root.next != null) root = root.next;
//
//        root.next = new ListNode(head.val);
//
//        return rootTrack;
//    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode reversed = null;
        ListNode tail = null;

        int counter = 1;
        while(curr != null) {
            if(counter == m) {
                ListNode root = null;
                ListNode reversing = curr;

                while(reversing != null) {
                    ListNode c = new ListNode(reversing.val); // c = 2, c = 3
                    c.next = root; // c.next = null, c.next = 2 -> null
                    root = c; // root = 2 -> null, 3 -> 2 -> null

                    reversing = reversing.next;
                    counter++;

                    if(counter == n) break;
                }
                root.next = reversing;
                curr.next = root;
            }

            curr = curr.next;
            counter++;
        }

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode headTrack = head;

        head.next = new ListNode(2);
        head = head.next;

        head.next = new ListNode(3);
        head = head.next;

        head.next = new ListNode(4);
        head = head.next;

        head.next = new ListNode(5);
        head = head.next;

        ListNode reversed = reverseBetween(headTrack, 2, 4);

        while(reversed != null) {
            System.out.println(reversed.val);

            reversed = reversed.next;
        }

    }
}
