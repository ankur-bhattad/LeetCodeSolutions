package com.btd.suprdaily;

import java.util.*;

public class SolutionOne {

    public static void main(String args[]){
        System.out.println(KFrequency("aabcd", 2));
    }

    static String KFrequency(String S, int K) {
        // Write your code here
        if (S == null || S.length() == 0) {
            return "-1";
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i=0; i<S.length(); i++) {
            int count = 0;
            if (charCountMap.containsKey(S.charAt(i))) {
                count = charCountMap.get(S.charAt(i)) + 1;
            } else {
                count = 1;
            }
            charCountMap.put(S.charAt(i), count);
        }

        Map<Integer, TreeSet<Character>> frequencyCharMapping = new TreeMap<>();
        charCountMap.forEach((character, count) -> {
            if (!(frequencyCharMapping.containsKey(count))) {
                TreeSet<Character> charSet = new TreeSet<>();
                frequencyCharMapping.put(count, charSet);
            }
            frequencyCharMapping.get(count).add(character);
        });

        if (frequencyCharMapping.size() < K) {
            return "-1";
        } else {
            int size = frequencyCharMapping.size();
            int index = size - K;
            ArrayList<Integer> keys = new ArrayList<>(frequencyCharMapping.keySet());
            int frequency = keys.get(index);
            Set<Character> charSet = frequencyCharMapping.get(frequency);
            return charSet.stream().findFirst().get().toString();
        }
    }
}
