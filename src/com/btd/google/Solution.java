package com.btd.google;

import java.util.*;

//https://www.tutorialspoint.com/maximum-number-of-events-that-can-be-attended-in-cplusplus
// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/1553308/Using-MinHeap-with-explaination
public class Solution {
    public static void main(String args[]) {
        int startTime[] = {1,4,2,3,1};
        int endTime[] = {4,4,2,4,1};

        List<Event> shows = new ArrayList<>();
        for (int i=0; i<startTime.length; i++) {
            shows.add(new Event(startTime[i], endTime[i]));
        }

        System.out.println(findMaximumNoOfEventsPossibleToAttend(shows));
    }

    private static int findMaximumNoOfEventsPossibleToAttend(List<Event> shows) {

        Collections.sort(shows, Comparator.comparingInt(Event::getStartTime));

        int ret = 0;
        int itr = 0;

        PriorityQueue<Event> pq = new PriorityQueue<>(Comparator.comparingInt(Event::getEndTime));
        for (int i =1; i<= shows.size(); i++) {

            while (!pq.isEmpty() && pq.peek().getEndTime() < i) {
                pq.poll();
            }

            while (itr < shows.size() && shows.get(itr).getStartTime() <= i) {
                pq.add(shows.get(itr));
                itr++;
            }

            if (!pq.isEmpty()) {
                pq.poll();
                ret ++;
            }
        }

        return ret;
    }

    static class Event {
        int startTime;
        int endTime;

        public Event(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }
}
