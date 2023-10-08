package question2;

import com.sun.source.tree.Tree;

import java.util.Random;
import java.util.TreeSet;

public class Methods {

    public static TreeSet<Character> generateCharacter() {
        TreeSet<Character> characters1 = new TreeSet<>();
        Random random = new Random();
        while (characters1.size() < 10) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            characters1.add(randomChar);
        }
        System.out.println("Generated characters: " + characters1);
        return characters1;
    }

    public static void collectList(TreeSet<Character> character1, TreeSet<Character> character2) {
        TreeSet<Character> combinedSet = new TreeSet<>(character1);
        combinedSet.addAll(character2);
        System.out.println("Combined both list is: "+combinedSet);
    }

    public static void findSimilarChar(TreeSet<Character> character1, TreeSet<Character> character2) {
        TreeSet<Character> similarCharacters = new TreeSet<>();
        for (Character character : character1) {
            if (character2.contains(character)) {
                similarCharacters.add(character);
            }
        }
            if (similarCharacters.isEmpty()) {
                System.out.println("There is no similar character");
            } else {
                System.out.println("Similar characters are: " + similarCharacters);
            }
        }
    }


