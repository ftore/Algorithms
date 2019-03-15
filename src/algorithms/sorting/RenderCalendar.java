package algorithms.sorting;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class RenderCalendar {
    class Event implements Comparable<Event> {
        int start;
        int end;

        public Event(int s, int e) {
            start = s;
            end = e;
        }

        public int compareTo(Event other) {
            if(this.start == other.start) {
                return this.end - other.end;
            }

            return this.start - other.start;
        }
    }

    public static int maxConcurrentEvents(List<Event> events) {
        Collections.sort(events);

        int max = Integer.MIN_VALUE;
        int maxEnd = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0; i < events.size(); i++) {
            if(events.get(i).end > maxEnd) {
                maxEnd = events.get(i).end;
                count = 1;
            }
        }

        return 0;
    }
}
