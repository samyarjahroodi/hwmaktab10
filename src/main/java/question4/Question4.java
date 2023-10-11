package question4;

import question3.CustomizeHashMap;

import java.util.Arrays;
import java.util.HashMap;

public class Question4 {
    public static void main(String[] args) {
        Methods<Integer, String> methods = new Methods<>();
        methods.put(1, "sara");
        methods.put(2, "samyar");
        methods.put(3, "ali");
        System.out.println(methods);
        System.out.println(methods.containsValue("sara"));
        System.out.println(methods.containKey(1));
        System.out.println(Arrays.toString(methods.getAllValues()));
        methods.replace(1,"tina");
        System.out.println(Arrays.toString(methods.getAllValues()));

    }
}
