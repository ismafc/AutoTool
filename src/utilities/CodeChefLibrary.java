package utilities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @class CodeChefLibrary
 * @brief A library of utility functions for CodeChef problems
 * @author 
 */
public class CodeChefLibrary {

    /**
     * @brief Check if a character is a vowel
     * @param c Character to check
     * @return true if the character is a vowel, false otherwise
     */
    public static boolean isVowel(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
               c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    /**
     * @brief Check if a year is leap
     * @param y Year
     * @return true if the year is leap, false otherwise
     */
    public static boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    /**
     * Calculates all divisors for 'n'.
     * @param n value to check divisors
     * @return Ordered array with all divisors of 'n'
     */
    public static ArrayList<Long> divisors(long n) {
        ArrayList<Long> l1 = new ArrayList<>();
        ArrayList<Long> l2 = new ArrayList<>();
        
        // Calculamos el límite para los divisores 'complementarios'
        long limit = (long)Math.sqrt(n);
        
        // Añadimos el 1
        l1.add(1L);
        for (long i = 2; i <= limit; i++) {
            if (n % i == 0) {
                l1.add(i);
                if (i != n / i) {
                    // No es un cuadrado perfecto
                    l2.add(0, n / i);
                }
            }
        }
        l1.addAll(l2);
        
        // Añadimos 'n'
        if  (n != 1L)
            l1.add(n);
        return l1;
    }

    /**
     * @brief Check if a date is valid
     * @param d Day
     * @param m Month
     * @param y Year
     * @return true if the date is valid, false otherwise
     */
    public static boolean isValid(int d, int m, int y) {
        if (d < 1 || d > 31 || m < 1 || m > 12 || y > 2099)
            return false;
        if (m == 2) {
            if (d > 29)
                return false;
            if (d == 29 && !isLeapYear(y))
                return false;
        }
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            if (d > 30)
                return false;
        }
        return true;
    }

    /**
     * Check if 'n' is prime. 'n' must be positive (1 or more)
     * @param n value to test
     * @return TRUE if value is primer and FALSE otherwise
     */
    public static boolean isPrime(long n) {
        if (n == 1)
            return false;
        if (n % 2 == 0)
            return n == 2;
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Calculates greater common divisor between <b><i>a</i></b> and <b><i>b</i></b>.
     * If returned value is 1, both values are prime among them
     * @param a first value to check
     * @param b second value to check
     * @return greater common divisor found
     */
    public static long mcd(long a, long b) {
        long lAux;
        if (a < b) {
            lAux = a;
            a = b;
            b = lAux;
        }
        while (a % b != 0) {
            lAux = a % b;
            a = b;
            b = lAux;
        }
        return b;
    }

    /**
     * @brief Given two character's frequency maps f1 and f2 for two different strings, 
     * checks if the characters in f1 can fit into f2 given the maximum length provided.
     * @param length The maximum length available.
     * @param f1 The first hash map with character's frequency map.
     * @param f2 The second hash map with character's frequency map.
     * @return True if the characters in f1 can fit into f2 given the length, false otherwise.
     */
        public static boolean fits(int lenght, HashMap<Character, Integer> f1, HashMap<Character, Integer> f2) {
        boolean fits = true;
        for (Character c : f1.keySet()) {
            int chars_to_put = f1.get(c);
            int free_spaces = lenght - (f2.containsKey(c) ? f2.get(c) : 0);
            if (chars_to_put > free_spaces)
                fits = false;
        }
        return fits;
    }

    /**
     * @brief Returns a hash map that contains the frequency of each character in the input string.
     * @param S The input string.
     * @return A hash map that contains the frequency of each character in the input string.
     */
    public static HashMap<Character, Integer> getFrequencyMap(String S) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char character = S.charAt(i);
            if (frequencyMap.containsKey(character))
                frequencyMap.put(character, frequencyMap.get(character) + 1);
            else
                frequencyMap.put(character, 1);
        }        
        return frequencyMap;
    }

    /**
     * @brief Checks if the first number is equal to the third number but different from the second number.
     * @param first The first number.
     * @param second The second number.
     * @param third The third number.
     * @return True if the first number is equal to the third number but different from the second number, false otherwise.
     */
    public static boolean posibleMishear(long first, long second, long third) {
        boolean mishear = false;
        if (second != Long.MIN_VALUE) {
            if (first != second && first != Long.MIN_VALUE)
                mishear = true;
            else if (third != second && third != Long.MIN_VALUE)
                mishear = true;
        }
        return mishear;
    }

    /**
     * @brief Checks if 'Pi' is lower than all elements in 'prices'.
     * @param Pi The value to check.
     * @param prices The array of prices.
     * @return True if 'Pi' is lower than all elements in 'prices', false otherwise.
     */
    public static boolean isCheaper(long Pi, long[] prices) {
        boolean cheaper = true;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= Pi) {
                cheaper = false;
                break;
            }
        }
        return cheaper;
    }

    /**
     * @brief Shifts all elements in 'prices' to the left and assigns 'Pi' to the last element.
     * @param prices The array of prices.
     * @param Pi The value to assign to the last element.
     */
    public static void leftShiftPrices(long[] prices, long Pi) {
        for (int i = 0; i < prices.length - 1; i++) {
            prices[i] = prices[i + 1];
        }
        prices[prices.length - 1] = Pi;
    }

    /**
     * @brief returns the sum of all digits in 'N'
     * @param N The number to sum its digits
     * @return The sum of all digits in 'N'
     */
    public static long digitSum(long N) {
        long sum = 0;
        while (N > 0) {
            sum += N % 10;
            N /= 10;
        }
        return sum;
    }
    
}