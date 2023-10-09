package question1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Methods {

    public static boolean isAlpha(String input) {
        return input.matches("[a-zA-Z]+");
    }

    public static HashMap<Integer, String> generate(String word) {
        HashMap<Integer, String> permutations = new HashMap<>();
        generatePermutationsHelper("", word, permutations);
        return permutations;
    }

    private static void generatePermutationsHelper(String prefix, String remaining, HashMap<Integer, String> permutations) {
        int length = remaining.length();
        if (length == 0) {
            if (!permutations.containsValue(prefix)) {
                permutations.put(permutations.size() + 1, prefix);
            }
        } else {
            for (int i = 0; i < length; i++) {
                generatePermutationsHelper(
                        prefix + remaining.charAt(i),
                        remaining.substring(0, i) + remaining.substring(i + 1),
                        permutations
                );
            }
        }
    }
}
