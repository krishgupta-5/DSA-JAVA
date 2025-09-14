package String;
import java.util.*;

public class FindMostFrequentVowelandConsonant {
    public static void main(String[] args) {
        String s = "successes";
        HashMap<Character ,Integer> vowelCounts = new HashMap<>();
        HashMap<Character, Integer> consonantCounts = new HashMap<>();
        HashSet<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowelSet.contains(c)) {
                vowelCounts.put(c, vowelCounts.getOrDefault(c, 0) + 1);
            } else if (c >= 'a' && c <= 'z') {
                consonantCounts.put(c, consonantCounts.getOrDefault(c, 0) + 1);
            }
        }
        int maxVowel = Integer.MIN_VALUE;
        int maxConsonant = Integer.MIN_VALUE;

        for(Character c : vowelCounts.keySet()){
            if(vowelCounts.get(c) > maxVowel){
                maxVowel = vowelCounts.get(c);
            }
        }
        for(Character c : consonantCounts.keySet()){
            if(consonantCounts.get(c) > maxConsonant){
                maxConsonant = consonantCounts.get(c);
            }
        }

        System.out.println(maxVowel + maxConsonant);

    }
}
