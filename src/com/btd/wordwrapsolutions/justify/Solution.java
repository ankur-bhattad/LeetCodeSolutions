package com.btd.wordwrapsolutions.justify;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String args[]) {
        String words[] = {"This", "is", "an", "example", "of", "text", "justify.", "Its", "been", "a", "good", "day"};
        justifyText(words, 20);
    }

    public static void justifyText(String[] words, int lineLength) {
        List<String> lines = new ArrayList<>();
        int startIndex = 0;

        while (startIndex < words.length) {
            int endIndex = startIndex;
            int curLineLength = -1;

            while (endIndex < words.length) {
                if (curLineLength + 1 + words[endIndex].length() > lineLength) {
                    break;
                }
                curLineLength += 1 + words[endIndex].length();
                endIndex++;
            }

            StringBuilder line = new StringBuilder("");
            endIndex--;
            int noOfWords = endIndex - startIndex + 1;

            //last line or single word in a line, left justify
            if (endIndex == words.length - 1 || noOfWords == 1) {
                for (int i = startIndex; i <= endIndex; i++) {
                    line.append(words[i] + " ");
                }
            } else {
                int spaceCount = lineLength - curLineLength + (noOfWords-1);
                int evenDistributedSpaceCount = spaceCount / (noOfWords - 1);
                int remainder = spaceCount % (noOfWords - 1);
                for (int i = startIndex; i <= endIndex; i++) {
                    if (i == startIndex) {

                    } else {
                        for (int j=1; j<= evenDistributedSpaceCount; j++) {
                            line.append(" ");
                        }
                        if (remainder > 0) {
                            line.append(" ");
                            remainder -= 1;
                        }
                    }
                    line.append(words[i]);
                }
            }
            startIndex = endIndex + 1;
            lines.add(line.toString());
            System.out.println(line.toString());
        }
    }
}
