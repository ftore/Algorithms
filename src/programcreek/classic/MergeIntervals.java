package programcreek.classic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
    private static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        public int compareTo(Interval other) {
            if(this.start == other.start) {
                return this.end - other.end;
            }

            return this.start - other.start;
        }

        public String toString() {
            return "[ " + this.start + ", " + this.end + " ]";
        }
    }

    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        Collections.sort(intervals);

        Interval pre = intervals.get(0);


        List<Interval> result = new ArrayList<>();
        for(Interval interval : intervals) {
            // if curr is inside interval
            if(interval.start > pre.end) {
                result.add(pre);
                pre = interval;
            }

            // curr starts before but interval end later
            else {
                Interval newInterval = new Interval(pre.start, Math.max(pre.end, interval.end));
                pre = newInterval;
            }
        }

        result.add(pre);


        return result;

    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        List<Interval> merged = mergeIntervals(intervals);

        for(Interval i : merged) {
            System.out.println(i);
        }
    }
}
