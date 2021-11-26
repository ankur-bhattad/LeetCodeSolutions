package com.btd.atlassian;

import java.util.*;

public class Solution {

    class Vote {
        String voter;
        List<String> candidates;

        public Vote(String voter, List<String> candidates) {
            this.voter = voter;
            this.candidates = candidates;
        }
    }

    public static void main(String args[]) {

    }

    public static List<String> findWinner(List<Vote> votes) {
        Map<String, Integer> candidateVoteCount =  new HashMap<>();
        if (votes == null || votes.size() == 0) {
            return new ArrayList<>();
        }

        votes.forEach(vote -> {
            List<String> candidates = vote.candidates;
            if (candidates != null && candidates.size() > 0) {
                int points = 3;
                for (int i=0; i< candidates.size() || i<3; i++) {
                    String candidate = candidates.get(i);
                    candidateVoteCount.put(candidate, candidateVoteCount.getOrDefault(candidate, 0) + points);
                    points -= 1;
                }
            }
        });

        Set<Map.Entry<String, Integer>> entrySet= candidateVoteCount.entrySet();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(entrySet);

        Collections.sort(entryList, (candidateOne, candidateTwo) -> candidateTwo.getValue() - candidateOne.getValue());

        List<String> winners = new ArrayList<>();
        for (int i=0; i<entryList.size() || i<3; i++) {
            winners.add(entryList.get(i).getKey());
        }
        return winners;
    }
}

//
//sam :6 -> 3+2+1
//Raj :6 -> 3 + 3
