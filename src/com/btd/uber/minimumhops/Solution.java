package com.btd.uber.minimumhops;

import java.util.*;

/*

We have Uber HCV(High Capacity Vehicles) plying on the same routes in loops. Every route has a certain number of stops. The routes are represented as 2D array as below [[1, 2, 7], [3, 6, 7]] where route[i] shows the route that the ith HCV takes. For e.g 1st HCV route would be 1 -> 2 -> 7 -> 1 -> 2 -> 7... and so on. Find the minimum number of HCV hops needed given a source and a destination hop.

Example 1: Input: HCV routes: [[1, 2, 7], [3, 6, 7]] , Source: 1, Destination: 7 Output: 0 (get into the first HCV on stop 1 and get down at stop 7, no hops needed)
Source: 1, Destination: 6 Output: 1 (get into the first HCV on stop 1, transfer on stop 7 to the next HCV and then get down at stop 6 from the other HCV, hence it needed 1 hop)
Return -1, if it's unable to reach the destination from the given source.

Example 2: HCV routes: [[1,2,3,4,5,6,7,8,9,10], [2,7]]
Source: 1, Destination: 7
Output: 0

(A potential route could be 1->2->3->4->5->6->7 which uses 1 bus, hence 0 hops and 6 moves or 1->2->7 which uses 2 buses and just 2 moves.
In this case, the first route would be the answer because the aim is minimum hops and not minimum stops)

max: 100*100
*/
class Solution {
    public static void main(String[] args) {
        int routes[][] = {{1, 2, 7},{7,6} ,{3, 6, 5}};
        int source = 1;
        int destination = 5;
        Solution solution = new Solution();
        List<BusNode> buses = solution.createGraph(routes);
        System.out.println(solution.findMinimumHops(buses, source, destination));
    }

    public List<BusNode> createGraph(int routes[][]) {
        List<BusNode> buses = new ArrayList<>();
        Map<Integer, List<BusNode>> stopToBusMapping = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            BusNode bus = new BusNode(i + 1);
            for (int j = 0; j < routes[i].length; j++) {
                bus.stops.add(routes[i][j]);
                List<BusNode> busesForGivenStop = stopToBusMapping.getOrDefault(routes[i][j], new ArrayList<>());
                for (BusNode existingBusForStop : busesForGivenStop) {
                    bus.connectedBuses.add(existingBusForStop);
                    existingBusForStop.connectedBuses.add(bus);
                }
                busesForGivenStop.add(bus);
                stopToBusMapping.put(routes[i][j], busesForGivenStop);
            }
            buses.add(bus);
        }
        return buses;
    }

    public int findMinimumHops(List<BusNode> buses, int source, int destination) {
        int hops = 0;
        Queue<BusNode> bfsTraversal = new LinkedList<>();
        bfsTraversal.add(buses.get(0));
        buses.get(0).visited = true;
        while (!bfsTraversal.isEmpty()) {
            BusNode currentBus = bfsTraversal.poll();
            if (currentBus.stops.contains(destination)) {
                return hops;
            }

            hops++;
            for (BusNode connectedBus : currentBus.connectedBuses) {
                if (!connectedBus.visited) {
                    bfsTraversal.add(connectedBus);
                    connectedBus.visited = true;
                }
            }
        }
        return -1;
    }

    public class BusNode {
        public int busNo;
        public Set<Integer> stops = new HashSet<>();
        public List<BusNode> connectedBuses = new ArrayList<>();
        boolean visited = false;

        public BusNode(int no) {
            this.busNo = no;
        }
    }
}

