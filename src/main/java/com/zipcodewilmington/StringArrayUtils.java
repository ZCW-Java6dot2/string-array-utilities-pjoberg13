package com.zipcodewilmington;

import java.util.ArrayList;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for(int i = 0; i < array.length; i++) {
            if(array[i].equals(value)) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String temp;
        int start = 0;
        int end = array.length - 1;

        while (start < end)
        {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
       String[] tempArray;
       tempArray = new String[array.length];

       for(int i = 0; i < array.length; i++) {
           tempArray[i] = array[i];
       }

        String temp;
        int start = 0;
        int end = array.length - 1;

        while (start < end)
        {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }

        for(int i = 0; i < array.length; i++) {
            if(array[i] != tempArray[i]) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        StringBuilder letterList = new StringBuilder();
        boolean[] letterPresent = new boolean[26];
        int index = 0;

        for(int i = 0; i < array.length; i++) {
            letterList.append(array[i]);
        }

        if(letterList.length() < 26) {
            return false;
        }

        for(int i = 0; i < letterList.length(); i++) {
            if ('A' <= letterList.charAt(i) && letterList.charAt(i) <= 'Z')
                index = letterList.charAt(i) - 'A';

                // If lowercase character, subtract 'a'
                // to find index.
            else if ('a' <= letterList.charAt(i) && letterList.charAt(i) <= 'z')

                index = letterList.charAt(i) - 'a';

                // If this character is other than english
                // lowercase and uppercase characters.
            else
                continue;
            letterPresent[index] = true;
        }

        for (int i = 0; i <= 25; i++) {
            if (letterPresent[i] == false) {
                return (false);
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int occurrenceCount = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i].equals(value)) {
                occurrenceCount++;
            } else {
                continue;
            }
        }
        return occurrenceCount;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        ArrayList<String> newArray = new ArrayList<String>();

        for(int i = 0; i < array.length; i++) {
            if(array[i].equals(valueToRemove)) {
                continue;
            } else {
                newArray.add(array[i]);
            }
        }

        return newArray.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        ArrayList<String> newArray = new ArrayList<String>();

        for(int i = 0; i < array.length; i++) {
            if(i == 0) {
                newArray.add(array[i]);
                continue;
            }
            if(array[i].equals(array[i-1])) {
                continue;
            } else {
                newArray.add(array[i]);
            }
        }
        return newArray.toArray(new String[0]);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder placeHolder = new StringBuilder();
        placeHolder.append(array[0]);

        // "a", "a", "a", "b", "c", "c", "a", "a", "d"
        for(int i = 1; i < array.length; i++){
            if (array[i].equals(array[i-1])){
                placeHolder.append(array[i]);
            } else {
                result.add(placeHolder.toString());
                placeHolder.setLength(0);
                placeHolder.append(array[i]);
            }
        }
        result.add(placeHolder.toString());
        String[] finalArray = result.toArray(new String[0]);
        System.out.print(result);
        return finalArray;
    }


}
