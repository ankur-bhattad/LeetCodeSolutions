package com.btd.visa;

import java.util.HashMap;
import java.util.Map;

class SolSix {
    public static void main (String args[]) {
        String text = "abcdefghijklmnopqrstuvwxyz";
        String note = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        System.out.println(canConstructLetter(text, note));
    }

    public static boolean canConstructLetter(String text, String note) {
        // Write your code here
        System.out.println(text+":"+note);
        if (text == null || note == null) {
            return false;
        }
        note = note.replaceAll(" ","");
        if (text.length() < note.length()) {
            return false;
        }

        Map<Character, Integer> charCountInText = new HashMap<>();
        for (int i = 0; i<text.length(); i++) {
            Character c = text.charAt(i);
            int count = 1;
            if (charCountInText.containsKey(c)) {
                count = charCountInText.get(c)+1;
            }
            charCountInText.put(c, count);
        }

        for (int i=0; i<note.length(); i++) {
            Character c = note.charAt(i);
            if (c!=' ') {
                int count = 0;
                if (charCountInText.containsKey(c)) {
                    count = charCountInText.get(c);
                    if (count == 1) {
                        charCountInText.remove(c);
                    } else {
                        charCountInText.put(c, count-1);
                    }
                } else{
                    return false;
                }
            }
        }
        return true;
    }
}
