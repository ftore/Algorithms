package tree;

public class SegmentTree {
    private int[] segTree;
    public SegmentTree() {

    }
    public void constructSegmentTree(int[] arr, int[] segTree, int lo, int hi, int pos) {
        if(lo == hi) {
            segTree[pos] = arr[lo];
            return;
        }

        int mid = lo + (hi - lo) / 2;

        // construct left subtree
        constructSegmentTree(arr, segTree, lo, mid, 2 * pos + 1);

        // construct right subtree
        constructSegmentTree(arr, segTree, mid + 1, hi, 2 * pos + 2);

        segTree[pos] = Math.min(segTree[2 * pos + 1], segTree[2 * pos + 2]);
    }
}
