import java.util.LinkedList;
import java.util.Queue;

public class ChainableNumbers {
    public static boolean isChainable(int A, int B, int[] set) {
        String start = String.valueOf(A);
        String end = String.valueOf(B);

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            String curr = queue.remove();

            if(curr.equals(end)) return true;

            for(int i = 0; i < set.length; i++) {
                String str = String.valueOf(set[i]);
                if(curr.substring(2).equals(str.substring(0, 2))) {
                    queue.add(str);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int A = 8183;
        int B = 9380;
        int[] set = {8363, 6388, 8183, 5364, 8353, 8365, 9380};

        System.out.println(isChainable(A, B, set));
    }
}
