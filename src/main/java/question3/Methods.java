package question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Methods {


    public static ArrayList<Integer> check() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<>();
        Random random = new Random();

        System.out.println("How many numbers you want to add?");
        int quantityOfNumbers = scanner.nextInt();

        for (int i = 0; i < quantityOfNumbers; i++) {
            int randomInt = random.nextInt(10);
            integers.add(randomInt);
        }
        System.out.println("Provided list is: " + integers);

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            if (i + 1 < integers.size()) {
                result.add(integers.get(i));
                result.add(integers.get(i + 1));
                i++;
            } else {
                break;
            }
        }

        System.out.println("After initial changes your list is: " + result);
        return result;

    }

    public static ArrayList<Integer> split() {
        ArrayList<Integer> integerArrayList = check();


        if (integerArrayList.size() % 2 == 0) {
            StringBuilder result = new StringBuilder("{");


            for (int i = 0; i < integerArrayList.size(); i += 2) {
                int firstValue = integerArrayList.get(i);
                int secondValue = integerArrayList.get(i + 1);

                result.append("{").append(firstValue).append(", ").append(secondValue).append("}");


                if (i + 2 < integerArrayList.size()) {
                    result.append(", ");
                }
            }

            result.append("}");

            System.out.println("Your list after some changes is: " + result.toString());
            return integerArrayList;
        } else {
            System.out.println("The input list does not have an even number of elements.");
            return integerArrayList;
        }

    }

    public static void checkTheBigger() {
        ArrayList<Integer> integerArrayList = split();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < integerArrayList.size(); i += 2) {
            int firstValue = integerArrayList.get(i);
            int secondValue = integerArrayList.get(i + 1);
            if (firstValue>secondValue){
                System.out.print("{"+firstValue+","+secondValue+"}");
            }

        }
    }



}





