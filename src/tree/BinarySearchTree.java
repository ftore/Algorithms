package tree;

public class BinarySearchTree {
    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int v) {
            this.value = v;
        }
    }

    public TreeNode root;

    public void add(int val) {
        if(root == null) {
            root = new TreeNode(val);
        } else {
            TreeNode curr = root;

            TreeNode tmp = new TreeNode(val);

            while(curr != null) {
                if(curr.value < val) {
                    if(curr.right == null) {
                        curr.right = tmp;
                        break;
                    }
                    curr = curr.right;
                } else {
                    if(curr.left == null) {
                        curr.left = tmp;
                        break;
                    }
                    curr = curr.left;
                }
            }
        }
    }

    public boolean contains(int val) {
        return contains(this.root, val);
    }

    private boolean contains(TreeNode head, int val) {
        if(head == null) return false;
        if(head.value == val) return true;

        if(head.value < val) {
            return contains(head.right, val);
        } else {
            return contains(head.left, val);
        }
    }

    public void printAll(TreeNode head) {
        if(head == null) return;

        System.out.println(head.value);
        printAll(head.left);
        printAll(head.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(2);
        bst.add(1);
        bst.add(3);

        bst.printAll(bst.root);

        System.out.println(bst.contains(3));
        System.out.println(bst.contains(4));
    }

}
