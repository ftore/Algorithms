package stackqueue;

/**
 * Created by e068529 on 6/27/17.
 */
public class SortStack {
    public static void main(String[] args) {

    }


}

class Stack {
    private class Node {
        int val;
        Node next;

        public Node(int v) {
            val = v;
        }
    }

    private Node first;
    private int N;

    public void push(int v) {
        Node oldfirst = first;
        first = new Node(v);
        first.next = oldfirst;
        N++;
    }

    public int pop() {
        int v = first.val;
        first = first.next;
        return v;
    }

    public int peek() {
        return first.val;
    }

    public boolean isEmpty() {
        return N == 0;
    }
}
