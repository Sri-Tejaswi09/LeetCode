import java.util.*;

public class Solution {
    public int maxEvents(int[][] events) {
        // Step 1: Sort events by start day
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap to track event end days
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int day = 0, i = 0, n = events.length, attended = 0;

        // Step 2: Process days until all events are considered
        while (i < n || !minHeap.isEmpty()) {
            // If heap is empty, jump to next event's start day
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }

            // Add all events starting today
            while (i < n && events[i][0] == day) {
                minHeap.add(events[i][1]);
                i++;
            }

            // Remove expired events
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend one event (the one ending earliest)
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
                day++;
            }
        }

        return attended;
    }
}