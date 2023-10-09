package question1;

import java.util.*;

import static question1.Methods.generate;

public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter characters");
            try {
                for (int i = 0; i < 1; i++) {
                    String input = scanner.next();
                    if (Methods.isAlpha(input)) {
                        HashMap<Integer, String> permutations = generate(input);
                        System.out.println("Permutations of " + input + ":");
                        for (String permutation : permutations.values()) {
                            System.out.println(permutation);
                        }
                        System.out.println("Enter character if its matches it would pass otherwise it would fail!");
                        String string = scanner.next();
                        if (permutations.containsValue(string)) {
                            System.out.println("PASS");
                        } else {
                            System.out.println("FAIL");
                        }
                    } else {
                        System.out.println("CAUTION!! Enter characters");
                    }
                }
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("You have to give characters !!! " + inputMismatchException.getMessage());
            }
            System.out.println("if you want to quit, press \"q\". if you want to continue, press anything else");
            if (scanner.next().equals("q")) {
                break;
            }

        }
    }
}
