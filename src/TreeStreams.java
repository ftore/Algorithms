import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TreeStreams {
    class StreamNumber implements Comparable<StreamNumber> {
        int value;
        int streamNo;

        public StreamNumber(int v, int n) {
            value = v;
            streamNo = n;
        }

        public int compareTo(StreamNumber other) {
            return this.value - other.value;
        }
    }

    private List<List<Integer>> streams;

    private PriorityQueue<StreamNumber> pq;

    public TreeStreams(List<List<Integer>> s) {
        streams = s;

        pq = new PriorityQueue<>();

        for(int i = 0; i < streams.size(); i++) {
            pq.add(new StreamNumber(streams.get(i).get(0), i));
            streams.get(i).remove(0);
        }
    }

    public int read() {
        if(pq.isEmpty()) return -1;

        StreamNumber number = pq.poll();

        if(streams.get(number.streamNo).size() >= 1) {
            pq.add(new StreamNumber(streams.get(number.streamNo).get(0), number.streamNo));
            streams.get(number.streamNo).remove(0);
        }

        return number.value;
    }

    public static void main(String[] args) {
        List<Integer> stream1 = new ArrayList<>();
        List<Integer> stream2 = new ArrayList<>();
        List<Integer> stream3 = new ArrayList<>();

        stream1.add(1);
        stream1.add(3);
        stream1.add(8);
        stream1.add(10);

        stream2.add(1);
        stream2.add(4);
        stream2.add(5);
        stream2.add(6);

        stream3.add(3);
        stream3.add(7);
        stream3.add(8);
        stream3.add(9);

        List<List<Integer>> streams = new ArrayList<>();
        streams.add(stream1);
        streams.add(stream2);
        streams.add(stream3);

        TreeStreams treeStreams = new TreeStreams(streams);

        int nextInteger = 0;
        while((nextInteger = treeStreams.read()) != -1) {
            System.out.println(nextInteger);
        }
    }
}
