import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RenderCalendar {
    public static class Event {
        private Integer start;
        private Integer end;

        public Event(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class EndPoint implements Comparable {
        public Integer time;
        public Boolean isStart;

        public EndPoint(Integer time, Boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(EndPoint e) {
            if (time != e.time) {
                return time.compareTo(e.time);
            }
            return isStart && !e.isStart ? -1 : !isStart && e.isStart ? 1 : 0;
        }
    }

    public static int findMaximumCurrentEvents(List<Event> events) {
        List<EndPoint> endpoints = new ArrayList<>();
        for (Event event : events) {
            endpoints.add(new EndPoint(event.start, true));
            endpoints.add(new EndPoint(event.end, false));
        }
        Collections.sort(endpoints);

        int maxCurrentEvents = 0, numCurrentEvents = 0;
        for (EndPoint endpoint : endpoints) {
            if (endpoint.isStart) {
                numCurrentEvents++;
                maxCurrentEvents = Math.max(maxCurrentEvents, numCurrentEvents);
            } else {
                numCurrentEvents--;
            }
        }
        return maxCurrentEvents;
    }
}
