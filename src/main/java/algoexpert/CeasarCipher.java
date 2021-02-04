package algoexpert;

import java.util.*;
import java.util.stream.Collectors;

class CeasarCipher {
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return Arrays.stream(alphabet.split("")).map(s -> {
            var index = (alphabet.indexOf(s) + key) % alphabet.length();
            return Character.toString(alphabet.charAt(index));
        }).collect(Collectors.joining(""));
    }

    public static int[] findThreeLargestNumbers(int[] array) {

        int large, larger, largest;

        if (array[0] >= array[1] && array[0] >= array[2]) {
            largest = array[0];
            if (array[1] >= array[2]) {
                larger = array[1];
                large = array[2];
            } else {
                larger = array[2];
                large = array[1];
            }
        } else if (array[1] >= array[0] && array[1] >= array[2]) {
            largest = array[1];
            if (array[0] >= array[2]) {
                larger = array[0];
                large = array[2];
            } else {
                larger = array[2];
                large = array[0];
            }
        } else {
            largest = array[2];
            if (array[0] >= array[1]) {
                larger = array[0];
                large = array[1];
            } else {
                larger = array[1];
                large = array[0];
            }
        }

        for (int i = 3; i < array.length; i++) {
            int num = array[i];
            if (num > largest) {
                large = larger;
                larger = largest;
                largest = num;
            } else if (num > larger) {
                large = larger;
                larger = num;
            } else if (num > large) {
                large = num;
            }
        }

        return new int[]{large, larger, largest};

    }

    public static void main(String[] args) {
//        caesarCypherEncryptor("xyz", 2);
        System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{9, 8, 7})));
        System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{9, 8, 7, 10, 12, 11})));
        System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{1, 2, 3})));
    }
}