package question2;

import java.util.TreeSet;

import static question2.Methods.*;

public class Question2 {
    public static void main(String[] args) {
        TreeSet<Character> characters1 = generateCharacter();
        TreeSet<Character> characters2 = generateCharacter();
        collectList(characters1, characters2);
        findSimilarChar(characters1,characters2);
    }


}
