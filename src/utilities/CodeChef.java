package utilities;

import java.util.*;
import java.lang.reflect.*;

/**
 * @class CodeChef 
 * @brief A library of solutions for CodeChef problems. All function names must start with 'solveCodeChef'
 * @author ismael.flores
 */
public class CodeChef {

    /**
    * Problem:
    * CodeChef offers a feature called streak count. A streak is maintained if you solve at least one problem daily.
    * Om and Addy actively maintain their streaks on CodeChef. Over a span of N consecutive days, 
    * you have observed the count of problems solved by each of them.
    * Your task is to determine the maximum streak achieved by Om and Addy and find who had the longer maximum streak.
    
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of multiple lines of input.
    * The first line of each test case contains an integer N denoting the number of days.
    * The second line of each test case contains N space-separated integers, 
    * the ith of which is Ai, representing the problems solved by Om on the ith day.
    * The third line of each test case contains N space-separated integers, 
    * the ith of which is Bi, representing the problems solved by Addy on the ith day.
    * 
    * Output Format:
    * For each test case, output:
    * OM, if Om has longer maximum streak than Addy;
    * ADDY, if Addy has longer maximum streak than Om;
    * DRAW, if both have equal maximum streak.
    *
    * You may print each character in uppercase or lowercase. For example, OM, om, Om, and oM, are all considered the same.
    * 
    * Constraints:
    * 1 <= T <= 10^5
    * 1 <= N <= 10^5
    * 0 <= Ai, Bi <= 10^9
    * 
    * The sum of N over all test cases won't exceed 6*10^5
    */
    public static void solveCodeChefCS2023_STK() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            int streakA = 0;
            int streakB = 0;
            int maxStreakA = 0;
            int maxStreakB = 0;
            for (long i = 0; i < N; i++) {
                if (scn.nextLong() > 0)
                    streakA++;
                else
                    streakA = 0;
                maxStreakA = Math.max(maxStreakA, streakA);
            }
            for (long i = 0; i < N; i++) {
                if (scn.nextLong() > 0)
                    streakB++;
                else
                    streakB = 0;
                maxStreakB = Math.max(maxStreakB, streakB);
            }
            if (maxStreakA > maxStreakB)
                System.out.println("OM");
            else if (maxStreakA < maxStreakB)
                System.out.println("ADDY");
            else
                System.out.println("DRAW");
        }
        scn.close();
    }

    /**
     * Problem:
     * Chef is going on a road trip and needs to apply for inter-district and inter-state travel e-passes. 
     * It takes A minutes to fill each inter-district e-pass application and B minutes for each inter-state e-pass application.
     * His journey is given to you as a binary string S of length N where 0 denotes crossing from one district to another district 
     * (which needs an inter-district e-pass), and a 1 denotes crossing from one state to another (which needs an inter-state e-pass).
     * Find the total time Chef has to spend on filling the various forms.
     * 
     * Input Format:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * Each test case contains two lines of input. First line contains three space separated integers N, A and B.
     * Second line contains the string S.
     * 
     * Output Format:
     * For each testcase, output in a single line the total time Chef has to spend on filling the various forms for his journey.
     * 
     * Constraints:
     * 1 <= T <= 10^2
     * 1 <= N, A, B <= 10^2
     * Si is '0' or '1'
     */
    public static void solveCodeChefTRAVELPS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            scn.nextLong();
            long A = scn.nextLong();
            long B = scn.nextLong();
            String S = scn.next();
            long count = 0;
            for (char c : S.toCharArray())
                count += (c == '0') ? A : B;
            System.out.println(count);
        }
        scn.close();
    }

    /** 
     * Problem:
     * Chef is playing Need For Speed. Currently, 
     * his car is running on a straight road with a velocity U metres per second and approaching a 90 degrees turn which is S metres away from him.
     * To successfully cross the turn, velocity of the car when entering the turn must not exceed V metres per second.
     * The brakes of Chef's car allow him to slow down with a deceleration (negative acceleration) not exceeding A metres per squared second. 
     * Tell him whether he can cross the turn successfully. 
     * The velocity v when entering the turn can be determined from Newton's 2nd law to be 
     * v^2 = U^2 + 2 . a . S if the car is moving with a uniform acceleration a.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first and only line of each test case contains four space-separated integers U, V, A and S.
     * 
     * Output:
     * For each test case, print a single line containing the string "Yes" if Chef can cross the turn successfully or "No" if he cannot (without quotes).
     * You may print each character of each string in uppercase or lowercase (for example, the strings "yEs", "yes", "Yes" and "YES" will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= U, V, A, S <= 10^4
     */
    public static void solveCodeChefNFS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long U = scn.nextLong();
            long V = scn.nextLong();
            long A = scn.nextLong();
            long S = scn.nextLong();
            System.out.println((U * U - 2 * A * S <= V * V) ? "Yes" : "No");
        }
        scn.close();
    }

    /**
     * Problem:
     * Tonmoy has a special torch. The torch has 4 levels numbered 1 to 4 and 2 states ("On" and "Off"). 
     * Levels 1, 2, and 3 correspond to the "On" state while level 4 corresponds to the "Off" state.
     * The levels of the torch can be changed as:
     * 
     * Level 1 changes to level 2.
     * Level 2 changes to level 3.
     * Level 3 changes to level 4.
     * Level 4 changes to level 1.
     * 
     * Given the initial state as K and the number of changes made in the levels as N, find the final state of the torch. 
     * If the final state cannot be determined, print "Ambiguous" instead.
     * 
     * Input Format:
     * First line will contain T, the number of test cases. Then the test cases follow.
     * Each test case contains of a single line of input, two integers N, K - the number of changes made in the levels and initial state of the torch. 
     * Here, K = 0 denotes "Off" state while K = 1 denotes "On" state.
     * 
     * Output Format:
     * For each test case, output in a single line, the final state of the torch, i.e. "On" or "Off". 
     * If the final state cannot be determined, print "Ambiguous" instead.
     * You may print each character of the string in uppercase or lowercase (for example, the strings "On", "ON", "on" and "oN" will all be treated as identical).
     * 
     * Constraints
     * 1 <= T <= 10^5 
     * 0 <= N <= 10^9
     * 0 <= K <= 1
     */
    public static void solveCodeChefDARLIG() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            int K = scn.nextInt();
            if (K == 0)
                K = (N % 4 == 0) ? 0 : 1;
            else
                K = (N % 4 == 0) ? 1 : -1;
            switch (K) {
                case 0:
                    System.out.println("Off");
                    break;
                case 1:
                    System.out.println("On");
                    break;
                default:
                    System.out.println("Ambiguous");
                    break;
            }
        }
        scn.close();
    }

    /**
     * Problem:
     * Chef is confused by all the different formats dates can be written in. 
     * Here's a simple problem Chef wants you to solve.
     * You are given a date string S. 
     * The date follows the Gregorian calendar, the one used in most parts of the world.
     * Identify whether it is of the form DD/MM/YYYY or MM/DD/YYYY, or if it can be of both forms.
     * Here D denotes the 2-digit day, M denotes the 2-digit month and YYYY denotes the 4-digit year.
     * It is guaranteed that S is a valid date taking at least one of these forms.
     * 
     * For example,
     * 
     * 21/05/2001 is of the form DD/MM/YYYY and not MM/DD/YYYY.
     * 10/15/2069 is of the form MM/DD/YYYY and not DD/MM/YYYY.
     * 05/11/1999 can be of both forms.
     * 
     * Input Format:
     * The first line contains a single integer T — the number of test cases. Then the test cases follow.
     * Each test case consists of a single line containing a string of 10 characters S — the date string S, 
     * which is of the form DD/MM/YYYY or MM/DD/YYYY. 
     * It is guaranteed that S is a valid date taking at least one of these forms.
     * 
     * Output Format:
     * For each test case, output "BOTH" if the date string satisfies both forms.
     * Otherwise output "DD/MM/YYYY" if it is of the form DD/MM/YYYY, else "MM/DD/YYYY".
     * Note that the output may be case-insensitive. So "DD/MM/YYYY", "dd/mm/yyyy" and so on will be considered the same.
     * 
     * Constraints:
     * 1 <= T <= 2023
     * S is of the form DD/MM/YYYY or MM/DD/YYYY
     */
    public static void solveCodeChefDDMMORMMDD() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            String S = scn.next();
            int D = Integer.parseInt(S.substring(0, 2));
            int M = Integer.parseInt(S.substring(3, 5));
            int Y = Integer.parseInt(S.substring(6, 10));
            boolean validDDMMYYY = CodeChefLibrary.isValid(D, M, Y);
            boolean validMMDDYYY = CodeChefLibrary.isValid(M, D, Y);
            if (validDDMMYYY && validMMDDYYY)
                System.out.println("BOTH");
            else if (validDDMMYYY)
                System.out.println("DD/MM/YYYY");
            else if (validMMDDYYY)
                System.out.println("MM/DD/YYYY");
        }
        scn.close();
    }

    /**
     * Problem:
     * Reverse Polish Notation (RPN) is a mathematical notation where every operator follows all of its operands.
     * For instance, to add three and four, one would write "3 4 +" rather than "3 + 4".
     * If there are multiple operations, the operator is given immediately after its second operand; 
     * so the expression written "3 − 4 + 5" would be written "3 4 − 5 +" first subtract 4 from 3, then add 5 to that.
     * Transform the algebraic expression with brackets into RPN form.
     * You can assume that for the test cases below only single letters will be used,
     * brackets [] will not be used and each expression has only one RPN form (no expressions like a*b*c)
     * 
     * Input Format:
     * The first line contains t, the number of test cases (less then 100).
     * Followed by t lines, containing an expression to be translated to RPN form, 
     * where the length of the expression is less then 400.
     * 
     * Output Format:
     * The expressions in RPN form, one per line.
     */
    public static void solveCodeChefONP() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            String S = scn.next();
            Stack<String> val = new Stack<>();
            Stack<Character> op = new Stack<>();
            for (char c : S.toCharArray()) {
                switch (c) {
                    case '(':
                        break;
                    case '*':
                    case '-':
                    case '+':
                    case '/':
                    case '^':
                        op.push(c);
                        break;
                    case ')':
                        String polish = val.pop();
                        polish = val.pop() + polish + op.pop();
                        val.push(polish);
                        break;
                    default:
                        val.push(Character.toString(c));
                        break;
                }
            }
            System.out.println(val.pop());
        }
        scn.close();
    }
    
    /**
     * Problem:
     * Read problem statements in Bengali, Mandarin Chinese, Russian, and Vietnamese as well.
     * For a given N, find the number of ways to choose an integer x from the range [0, 2^N - 1] 
     * such that x⊕(x+1) = (x+2)⊕(x+3), where ⊕ denotes the bitwise XOR operator.
     * Since the number of valid x can be large, output it modulo 10^9+7
     * 
     * Input:
     * The first line contains an integer T, the number of test cases. Then the test cases follow.
     * The only line of each test case contains a single integer N.
     * 
     * Output: 
     * For each test case, output in a single line the answer to the problem modulo 10^9+7
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= N <= 10^5
     */
    public static void solveCodeChefXOREQUAL() {
        Scanner scn = new Scanner(System.in);

        // Precalculate all 2^N [0 <= N < 100000]
        long[] p = new long [100000];
        p[0] = 1;
        for (int i = 1; i < 100000; i++)
            p[i] = (p[i - 1] * 2) % 1000000007;

        long T = scn.nextLong(); 
        while (T-- > 0) {
            int N = scn.nextInt();
            System.out.println(p[N - 1]);
        }
        scn.close();
    }

    /*
     * Problem:
     * Karan likes the number 4 very much.
     * Impressed by the power of this number, Karan has begun to look for occurrences of four anywhere. 
     * He has a list of T integers, for each of them he wants to calculate the number of occurrences of
     * the digit 4 in the decimal representation. He is too busy now, so please help him.
     * 
     * Input Format:
     * The first line of input consists of a single integer T, denoting the number of integers in Karan's list.
     * Then, there are T lines, each of them contain a single integer from the list.
     * 
     * Output Format:
     * Output T lines. Each of these lines should contain the number of occurrences of the digit 4 
     * in the respective integer from Karan's list.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     */
    public static void solveCodeChefLUCKYFR() {
        Scanner scn = new Scanner(System.in);

        long T = scn.nextLong(); 
        while (T-- > 0) {
            String S = scn.next();
            long count4s = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '4')
                    count4s++;
            }
            System.out.println(count4s);
        }
        scn.close();
    }

    /*
     * Problem:
     * Chef had a sequence of positive integers with length N + K. 
     * He managed to calculate the arithmetic average of all elements of this sequence (let's denote it by V), 
     * but then, his little brother deleted K elements from it. All deleted elements had the same value.
     * Chef still knows the remaining N elements — a sequence A1, A2, ..., AN. 
     * Help him with restoring the original sequence by finding the value of the deleted elements 
     * or deciding that there is some mistake and the described scenario is impossible.
     * Note that the if it is possible for the deleted elements to have the same value, 
     * then it can be proven that it is unique. Also note that this value must be a positive integer.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first line of each test case contains three space-separated integers N, K and V.
     * The second line contains N space-separated integers A1, A2, ..., AN.
     * 
     * Output:
     * For each test case, print a single line containing one integer — 
     * the value of the deleted elements, or -1 if there is a mistake.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N, K <= 100
     * 1 <= V <= 10^5
     * 1 <= Ai <= 10^5 for each valid i
     */
    public static void solveCodeChefAVG() {
        Scanner scn = new Scanner(System.in);

        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            long V = scn.nextLong();
            long sum = 0;
            for (long i = 0; i < N; i++)
                sum += scn.nextLong();
            // (sum + K * n) / (K + N) = V
            long remain = V * (K + N) - sum;
            System.out.println(((remain % K) != 0 || remain <= 0) ? -1 : remain / K);
        }
        scn.close();
    }

    /*
     * Problem:
     * You are given a sequence A1, A2, ..., AN. 
     * Find the maximum value of the expression |Ax - Ay| + |Ay - Az| + |Az - Ax|
     * over all triples of pairwise distinct valid indices (x, y, z).
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first line of each test case contains a single integer N.
     * The second line contains N space-separated integers A1, A2, ..., AN.
     * 
     * Output:
     * For each test case, print a single line containing one integer ― 
     * the maximum value of |Ax - Ay| + |Ay - Az| + |Az - Ax|.
     * 
     * Constraints:
     * 1 <= T <= 5
     * 3 <= N <= 10^5
     * |Ai| <= 10^9 for each valid i
     */
    public static void solveCodeChefMAXFUN() {
        Scanner scn = new Scanner(System.in);

        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong() - 3;
            long Ax = scn.nextLong();
            long Ay = scn.nextLong();
            long Az = scn.nextLong();
            long actual = Math.abs(Ax - Ay) + Math.abs(Ax - Az) + Math.abs(Ay - Az);
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                long nActual = Math.abs(Ai - Ay) + Math.abs(Ai - Az) + Math.abs(Ay - Az);
                if (nActual > actual) {
                    actual = nActual;
                    Ax = Ai;
                }
                nActual = Math.abs(Ax - Ai) + Math.abs(Ax - Az) + Math.abs(Ai - Az);
                if (nActual > actual) {
                    actual = nActual;
                    Ay = Ai;
                }
                nActual = Math.abs(Ax - Ay) + Math.abs(Ax - Ai) + Math.abs(Ay - Ai);
                if (nActual > actual) {
                    actual = nActual;
                    Az = Ai;
                }
            }
            System.out.println(actual);
        }
        scn.close();
    }
    
    public static void solveCodeChefMXENVSUB() {
        Scanner scn = new Scanner(System.in);

        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long sum = (N * (N + 1)) / 2;
            if (sum % 2 == 1)
                N--;
            System.out.println(N);
        }
        scn.close();
    }
    
    /*
     * Problem:
     * Vishesh has gone to watch the new Spider-Man movie, 
     * but he is having troubles choosing which Popcorn-and-Coke combo to buy.
     * There are three combos A, B, and C available at the counter. 
     * You are given the time (in minute) for which each Popcorn bucket and Coke cup lasts. 
     * Given that Vishesh's satisfaction from a combo is defined as the total lasting time (in minute) 
     * of the Popcorn bucket and the Coke cup, 
     * find the maximum satisfaction he can get by buying a single combo.
     * 
     * Input Format:
     * The first line of each input contains T - the number of test cases. 
     * The test cases then follow.
     * The first line of each test case contains two space-separated integers A1 and A2, 
     * meaning that for combo A, the Popcorn bucket lasts A1 minutes and the Coke cup lasts A2 minutes.
     * The second line of each test case contains two space-separated integers B1 and B2, 
     * meaning that for combo B, the Popcorn bucket lasts B1 minutes and the Coke cup lasts B2 minutes.
     * The third line of each test case contains two space-separated integers C1 and C2, 
     * meaning that for combo C, the Popcorn bucket lasts C1 minutes and the Coke cup lasts C2 minutes.
     * 
     * Output Format:
     * For each test case, output on a single line the maximum satisfaction Vishesh can get.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= A1, A2, B1, B2, C1, C2 <= 10^9
     */
    public static void solveCodeChefPOPCORN() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long A1 = scn.nextLong();
            long A2 = scn.nextLong();
            long B1 = scn.nextLong();
            long B2 = scn.nextLong();
            long C1 = scn.nextLong();
            long C2 = scn.nextLong();
            System.out.println(Math.max(C1 + C2, Math.max(A1 + A2, B1 + B2)));
        }
        scn.close();
    }

    /*
     * Problem:
     * Nitin and Sobhagya were playing a game with coins. 
     * If Sobhagya has more coins then he is winning, otherwise Nitin is winning. 
     * Note that this means if both Nitin and Sobhagya have the same number of coins, then Nitin is winning.
     * Initially Nitin has A coins while Sobhagya has B coins. 
     * Then Ritik came and gave his C coins to the player who is not winning currently, 
     * after which Satyarth came and repeated the same process 
     * (gave his D coins to the player who is not winning currently).
     * Find the final winner of the game.
     * 
     * Input Format:
     * The first line of the input contains an integer T - 
     * the number of test cases. The test cases then follow.
     * The only line of each test case contains four space-separated integers A, B, C, and D.
     * 
     * Output Format:
     * For each test case, output on a single line N if Nitin is the final winner of the game, 
     * or S if Sobhagya is the final winner of the game.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 0 <= A, B, C, D <= 10^6
     */
    public static void solveCodeChefFRGAME() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long A = scn.nextLong();
            long B = scn.nextLong();
            long C = scn.nextLong();
            long D = scn.nextLong();
            if (A < B)
                A = A + C;
            else
                B = B + C;
            if (A < B)
                A = A + D;
            else
                B = B + D;
            System.out.println(A >= B ? "N" : "S");
        }
        scn.close();
    }    
    
    /*
     * Problem:
     * You have N balls and K boxes. You want to divide the N balls into K boxes such that:
     * Each box contains >= 1 balls.
     * No two boxes contain the same number of balls.
     * Determine if it is possible to do so.
     * 
     * Input Format:
     * The first line contains a single integer T — the number of test cases. 
     * Then the test cases follow.
     * The first and only line of each test case contains two space-separated integers N and K — 
     * the number of balls and the number of boxes respectively.
     * 
     * Output Format:
     * For each test case, output YES if it is possible to divide the N balls into K boxes 
     * such that the conditions are satisfied. Otherwise, output NO.
     * You may print each character of YES and NO in uppercase or lowercase 
     * (for example, yes, yEs, Yes will be considered identical).
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= N <= 10^9
     * 1 <= K <= 10^4
     */
    public static void solveCodeChefBALLBOX() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            long min = K * (K + 1) / 2;
            System.out.println(N >= min ? "YES" : "NO");
        }        
        scn.close();
    }
    
    /*
     * Problem:
     * Kepler’s Law states that the planets move around the sun in elliptical orbits with the sun at one focus.
     * Kepler's 3rd law is The Law of Periods, according to which:
     * The square of the time period of the planet is directly proportional 
     * to the cube of the semimajor axis of its orbit.
     * You are given the Time periods (T1, T2) and Semimajor Axes (R1, R2) of two planets orbiting the same star.
     * Please determine if the Law of Periods is satisfied or not, 
     * i.e, if the constant of proportionality of both planets is the same.
     * Print "Yes" (without quotes) if the law is satisfied, else print "No".
     * 
     * Input Format:
     * The first line of input contains a single integer T, denoting the number of test cases.
     * The description of T test cases follows.
     * Each test case consists a single line of input, containing four space-separated integers T1, T2, R1, R2.
     * 
     * Output Format:
     * For each test case, output a single line containing one string — "Yes" or "No" (without quotes); 
     * the answer to the problem.
     * You may print each character of the answer in uppercase or lowercase 
     * (for example, the strings "yEs", "yes", "Yes" and "YES" will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= T1, T2 <= 10
     * 1 <= R1, R2 <= 10
     */
    public static void solveCodeChefKEPLERSLAW() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long T1 = scn.nextLong();
            long T2 = scn.nextLong();
            long R1 = scn.nextLong();
            long R2 = scn.nextLong();
            boolean keplerok = (R2 * R2 * R2) * (T1 * T1) == (R1 * R1 * R1) * (T2 * T2);
            System.out.println(keplerok ? "YES" : "NO");
        }        
        scn.close();
    }    

    /*
     * Problem:
     * Finally, a COVID vaccine is out on the market and the Chefland government has asked you to form a plan to distribute it to the public as soon as possible. 
     * There are a total of N people with ages a1, a2, ..., aN.
     * There is only one hospital where vaccination is done and it is only possible to vaccinate up to D people per day. 
     * Anyone whose age is >= 80 or <= 9 is considered to be at risk. 
     * On each day, you may not vaccinate both a person who is at risk and a person who is not at risk. 
     * Find the smallest number of days needed to vaccinate everyone.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first line of each test case contains two space-separated integers N and D.
     * The second line contains N space-separated integers a1, a2, ..., aN.
     * 
     * Output:
     * For each test case, print a single line containing one integer ― the smallest required number of days.
     * 
     * Constraints:
     * 1 <= T <= 10
     * 1 <= N <= 10^4
     * 1 <= D <= 10^5
     * 1 <= ai <= 100 for each valid i
     */
    public static void solveCodeChefVACCINE2() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long D = scn.nextLong();
            long atRisk = 0;
            for (long i = 0; i < N; i++) {
                long A = scn.nextLong();
                if (A >= 80 || A <= 9)
                    atRisk++;
            }
            long atNoRisk = N - atRisk;
            long daysAtRisk = atRisk / D + (atRisk % D == 0 ? 0 : 1);
            long daysAtNoRisk = atNoRisk / D + (atNoRisk % D == 0 ? 0 : 1);
            System.out.println(daysAtRisk + daysAtNoRisk);
        }        
        scn.close();
    }
    
    /*
     * Problem:
     * CodeChef has just finished migrating to a new judging system.
     * Chef would like to test the performance of the new judging system.
     * Chef has some code for an older task, which he knows ran in X milliseconds on the old judging server.
     * On resubmitting the code to the new judging server, it ran in Y milliseconds.
     * Which judging system is faster?
     * 
     * Input Format:
     * The only line of input will contain two space-separated integers X and Y — 
     * the runtime on the old judging system, and the runtime on the new judging system.
     * 
     * Output Format:
     * Print:
     * Old, if the older judging system is faster
     * New, if the new judging system is faster
     * Same, if they're equally fast
     * Each letter of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings Old, OlD, old, oLD will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= X, Y <= 3000
     */
    public static void solveCodeChefNEWCC() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        if (X < Y)             
            System.out.println("Old");
        else if (X > Y)
            System.out.println("New");
        else
            System.out.println("Same");
        scn.close();
    }

    /*
     * Problem:
     * Chef has a special ability: he can use both his left and right hands equally well, and at the same time!
     * To put this ability into practice, Chef decides that he's going to write a novel with his left hand, 
     * while writing code with his right.
     * Chef needs L minutes to write a page with his left hand, 
     * and R minutes to write a line of code with his right.
     * Chef defines his satisfaction to be the number of pages he's started writing, 
     * plus the number of lines of code he's finished writing.
     * What will Chef's satisfaction be after M minutes?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case will contain three space-separated integers L, R, and M — 
     * Chef writing speed, coding speed, and the number of minutes he has.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: Chef's satisfaction after M minutes.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= L, R, M <= 10^6
     */
    public static void solveCodeChefAMBIDEXTROUS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long L = scn.nextLong();
            long R = scn.nextLong();
            long M = scn.nextLong();
            long satisfaction = M / L + (M % L != 0 ? 1 : 0) + M / R;
            System.out.println(satisfaction);
        }        
        scn.close();
    }

    /*
     * Problem:
     * A new patisserie has opened up to rave reviews. 
     * You, in your quest for deliciousness, are going to visit it.
     * The patisserie has N pastries. With your trained eye, 
     * you judge that the i-th of them has deliciousness Ai.
     * Of course, you want to eat pastries whose total deliciousness is as high as possible. 
     * Unfortunately, you can't just buy everything out.
     * There are K customers in the store, including you. 
     * They form a queue to order pastries, of which you're the L-th person.
     * Each customer, including you, will do the following:
     * Among the remaining pastries, buy the one with the highest deliciousness.
     * Then, move to the back of the queue.
     * This will repeat till all the pastries are sold out.
     * What's the total deliciousness of the pastries you buy?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * The first line of each test case contains three space-separated integers N, K, and L — 
     * the number of pastries, the number of people, and your initial position in the queue.
     * The second line contains N space-separated integers A1, A2, ..., AN — the deliciousness of the pastries.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: the total deliciousness of the pastries you buy.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= L <= K <= N <= 2*10^5
     * 1 <= Ai <= 10^9
     * The sum of N across all tests won't exceed 2*10^5
     */
    public static void solveCodeChefKDELI() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            ArrayList<Long> deliciouness = new ArrayList<>();
            long N = scn.nextLong();
            long K = scn.nextLong();
            long L = scn.nextLong();
            for (int i = 0; i < N; i++)
                deliciouness.add(scn.nextLong());
            Collections.sort(deliciouness);
            Collections.reverse(deliciouness);
            long buy = 0;
            for (int i = 0; i < N; i++) {
                if (i % K == L - 1)
                    buy += deliciouness.get(i);
            }
            System.out.println(buy);            
        }
        scn.close();
    }
  
    /**
     * Problem:
     * You want to create an Online Judge like Codechef - in fact, you decide to just copy Codechef as a whole!
     * Just like Codechef, you give your judge a name of length 88, given by the string S.
     * However, you're worried that people will find out that your judge is a copy — 
     * in particular, you think that if S and the string "codechef" have the same character at some position, 
     * people will find out.
     * For example, "rolldown" has "o" in the second position (just like "codechef"), 
     * and so wouldn't be a valid name. 
     * However, "fehcedoc" doesn't match with "codechef" at any position, and so is valid.
     * To avoid this happening, you'd like to instead rename your judge to an anagram of S.
     * Find any anagram of S that satisfies the condition, or say that none exist.
     * Note: An anagram of a string S is formed by simply rearranging the characters of S.
     * For example, "chefcode" and "occfedeh" are anagrams of "codechef", while "codeche" and "coderchef" are not.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case contains a single string S, of length 8.
     * 
     * Output Format:
     * For each test case, output on a new line the anagram you made.
     * If no valid anagram exists, print -1 instead.
     * If there are multiple possible answers, any of them will be accepted.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * |S| = 8
     * The string S contains only lowercase English letters, i.e, the characters 'a' to 'z'.
     */
    public static void solveCodeChefCC_COPY() {
        String codechef = "codechef";
        ArrayList<HashMap<Character, Integer>> fMapsCodechef = new ArrayList<>();
        for (int k = 0; k < codechef.length(); k++)
            fMapsCodechef.add(CodeChefLibrary.getFrequencyMap(codechef.substring(k)));
        fMapsCodechef.add(new HashMap<>());
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            String S = scn.next();
            String anagram = "";
            HashMap<String, HashMap<Character, Integer>> fMapsS = new HashMap<>();
            for (int i = 0; i < codechef.length(); i++) {
                for (int j = 0; j < S.length(); j++) {
                    if (codechef.charAt(i) != S.charAt(j)) {
                        String S1 = S.substring(j + 1);
                        HashMap<Character, Integer> f2 = null;
                        if (fMapsS.containsKey(S1))
                            f2 = fMapsS.get(S1);
                        else {
                            f2 = CodeChefLibrary.getFrequencyMap(S1);
                            fMapsS.put(S1, f2);
                        }
                        if (CodeChefLibrary.fits(codechef.length() - i - 1, fMapsCodechef.get(i + 1), f2)) {
                            anagram += S.charAt(j);
                            S = S.substring(0, j) + S.substring(j + 1);
                            j = S.length();
                        }
                    }
                }
            }
            System.out.println(anagram.length() == codechef.length() ? anagram : -1);
        }
        scn.close();        
    }
  
    /*
     * Problem:
     * Chef is judging a game called "Broken telephone". 
     * There are total N players taking part in the game. 
     * They are all sitting in a line. In the start of the game, 
     * first player is given a secret message written on a sheet of paper. 
     * Then they keep sending the message by whispering it to the player sitting immediate right to one 
     * and so on until it reaches the last person.
     * Finally, the message received by the last player is compared with the message said by first player.
     * If these messages aren't equal, there is someone who has misheard the message 
     * or whispered it wrongly to the next player. 
     * If messages is equal, then the players win and receive a tasty chocolate.
     * Note that first player receives the message on a sheet of paper, thus he cannot mishear it.
     * As Chef wants to be sure that every player has fulfilled his/ her role in the game, 
     * so he asks everyone to state their received messages after the end of the game. 
     * You are given an array A of N integers denoting messages received by each person.
     * Please help Chef to find the number of players that could mishear the message or whisper it wrongly.
     * 
     * Input:
     * The first line of the input contains an integer T denoting the number of test cases.
     * The first line of each test case contains a single integer N denoting the number of players
     * The second line contains N space-separated integers A1, A2, ..., AN denoting the messages of players.
     *
     * Output:
     * For each test case, output a single line containing an integer 
     * corresponding to the number of players that could mishear the message or whisper it wrongly.
     * 
     * Constraints and Subtasks:
     * 1 <= T <= 5
     * 1 <= Ai <= 10
     * Subtask 1: 40 points
     * 2 <= N <= 10^3
     * Subtask 2: 60 points
     * 2 <= N <= 10^5
     */
    public static void solveCodeChefBROKPHON() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long first = Long.MIN_VALUE;
            long second = Long.MIN_VALUE;
            long third = Long.MIN_VALUE;
            long count = 0;
            for (long i = 0; i < N; i++) {
                first = second;
                second = third;
                third = scn.nextLong();
                if (CodeChefLibrary.posibleMishear(first, second, third))
                    count++;
            }
            first = second;
            second = third;
            third = Long.MIN_VALUE;
            if (CodeChefLibrary.posibleMishear(first, second, third))
                count++;
            System.out.println(count);
        }        
        scn.close();
    }

    /*
     * Problem:
     * Chef considers the number 7 lucky. 
     * As a result, he believes that the 7-th letter he sees on a day is his lucky letter of the day.
     * 
     * You are given a string S of length 10, denoting the first 10 letters Chef saw today.
     * What is Chef's lucky letter?
     * 
     * Input Format:
     * The only line of input contains a string S, of length 10.
     * 
     * Output Format:
     * Print a single character: Chef's lucky letter.
     * 
     * Constraints:
     * S has a length of 10
     * S contains only lowercase Latin letters (i.e, the characters 'a' to 'z')
     */
    public static void solveCodeChefLUCKYSEVEN() {
        Scanner scn = new Scanner(System.in);
        String S = scn.next();
        System.out.println(S.charAt(6));
        scn.close();
    }

    /*
     * Problem:
     * Chef is playing a certain video game that requires him to collect Monsters, and use them to fight against other Monsters.
     * Chef's favorite Monster has an attack stat of X, and is fighting against another monster whose health stat is H.
     * The fight proceeds in turns: each turn, Chef's Monster does X damage to its opponent.
     * However, Chef's Monster has the ability Slow Start, which halves its attack for the first five turns.
     * That is, for the first five turns, the damage done to the opponent is X/2 and not X.
     * How many turns will Chef's Monster take to defeat the opponent (i.e, do at least H damage to it)?
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single line of input, containing two space-separated integers X and H, that is, 
     * Chef's Monster's attack, and the opponent's health.
     *
     * Output Format:
     * For each test case, output on a new line the number of turns required for the opponent to be defeated.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= X, H <= 1000
     * X is even
     */
    public static void solveCodeChefSLOWSTART() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long X = scn.nextLong();
            long H = scn.nextLong();
            long X2 = X / 2;
            long halves = 5 * X2;
            if (H <= halves)
                System.out.println(H / X2 + (H % X2 == 0 ? 0 : 1));
            else {
                H -= halves;
                System.out.println(5 + H / X + (H % X == 0 ? 0 : 1));
            }
        }
        scn.close();
    }

    /*
     * Problem:
     * Chef is playing a card game with his friend Rick Sanchez. He recently won against Rick's grandson Morty; 
     * however, Rick is not as easy to beat. The rules of this game are as follows:
     * - The power of a positive integer is the sum of digits of that integer. For example, the power of 13 is 1 + 3 = 4.
     * - Chef and Rick receive randomly generated positive integers. For each player, let's call the integer he received final power.
     * - The goal of each player is to generate a positive integer such that its power (defined above) is equal to his final power.
     * - The player who generated the integer with fewer digits wins the game. If both have the same number of digits, then Rick cheats and wins the game.
     *
     * You are given the final power of Chef Pc and the final power of Rick Pr. 
     * Assuming that both players play optimally, find the winner of the game and the number of digits of the integer he generates.
     *
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first and only line of each test case contains two space-separated integers Pc and Pr.
     *
     * Output:
     * For each test case, print a single line containing two space-separated integers. 
     * The first of these integers should be either 0 if Chef wins or 1 if Rick wins. 
     * The second integer should be the number of digits of the integer generated by the winner.
     * 
     * Constraints:
     *
     * 1 <= T <= 10^5
     * 1 <= Pc, Pr <= 10^6
     */
    public static void solveCodeChefCRDGAME3() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long Pc = scn.nextLong();
            long Pr = scn.nextLong();
            long Pcd = Pc / 9 + (Pc % 9 == 0 ? 0 : 1);
            long Prd = Pr / 9 + (Pr % 9 == 0 ? 0 : 1);
            System.out.println((Pcd < Prd ? 0 : 1) + " " + Math.min(Pcd, Prd));
        }
        scn.close();
    }
    
    /*
     * Problem:
     * In the light of G-20 summit, 
     * government has decided to keep the average air quality index (AQI) strictly below 100.
     * On some random day, Chef measures the AQI and found the value to be X.
     * Find whether the government was able to keep the AQI within limits.
     * 
     * Input Format:
     * The input consists of an integer X — the AQI Chef measured.
     * 
     * Output Format:
     * Output YES, if the government was able to keep the AQI within limits and NO otherwise.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= X <= 150
     */
    public static void solveCodeChefAIRINDEX() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        scn.close();
        System.out.println(X < 100 ? "YES" : "NO");
    }
    
    /*
     * Problem:
     * Chefland consists of three countries named A, B and C.
     * Country A exports goods worth A1 units and imports goods worth A2 units.
     * Country B exports goods worth B1 units and imports goods worth B2 units.
     * A trade surplus occurs when a country exports strictly more than it imports.
     * Find whether country C is in trade surplus.
     * Note that the countries A,B,C trade only between themselves.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of four space-separated integers A1, A2, B1 and B2 — 
     * denoting the exports and imports of countries A and B respectively.
     * 
     * Output Format:
     * For each test case, output on a new line, YES, if country C is in trade surplus and NO otherwise.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= A1, A2, B1, B2 <= 100
     */
    public static void solveCodeChefSURPLUS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long A1 = scn.nextLong();
            long A2 = scn.nextLong();
            long B1 = scn.nextLong();
            long B2 = scn.nextLong();
            long C = (A2 - A1) + (B2 - B1);
            System.out.println(C > 0 ? "YES" : "NO");
        }
        scn.close();
    }

    /**
     * Problem:
     * Farmer Feb has three fields with potatoes planted in them. 
     * He harvested x potatoes from the first field, y potatoes from the second field and is yet to harvest potatoes from the third field. 
     * Feb is very superstitious and believes that if the sum of potatoes he harvests from the three fields is a prime number 
     * (http://en.wikipedia.org/wiki/Prime_number), he'll make a huge profit. 
     * Please help him by calculating for him the minimum number of potatoes that if harvested from the third field will make the sum of potatoes prime. 
     * At least one potato should be harvested from the third field.
     * 
     * Input:
     * The first line of the input contains an integer T denoting the number of test cases. 
     * Each of the next T lines contain 2 integers separated by single space: x and y.
     * 
     * Output:
     * For each test case, output a single line containing the answer.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= x <= 1000
     * 1 <= y <= 1000
     */
    public static void solveCodeChefPOTATOES() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long x = scn.nextLong();
            long y = scn.nextLong();
            boolean found = false;
            long j = 1;
            while (!found) {
                if (CodeChefLibrary.isPrime(x + y + j)) {
                    System.out.println(j);
                    found = true;
                }
                j++;
            }
        }
        scn.close();
    }

    /*
     * Problem:
     * Rushitote went to a programming contest to distribute apples and oranges to the contestants.
     * He has N apples and M oranges, which need to be divided equally amongst the contestants.
     * Find the maximum possible number of contestants such that:
     * 
     * Every contestant gets an equal number of apples;
     * and Every contestant gets an equal number of oranges.
     * 
     * Note that every fruit with Rushitote must be distributed, there cannot be any left over.
     * 
     * For example, 2 apples and 4 oranges can be distributed equally to two contestants, 
     * where each one receives 1 apple and 2 oranges.
     * However, 2 apples and 5 oranges can only be distributed equally to one contestant.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case contains two space-separated integers N and M — 
     * the number of apples and oranges, respectively.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: 
     * the maximum number of contestants such that everyone receives an equal number of apples and 
     * an equal number of oranges.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N, M <= 10^9
     */
    public static void solveCodeChefAPPLEORANGE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long M = scn.nextLong();
            System.out.println(CodeChefLibrary.mcd(N, M));
        }
        scn.close();
    }
    
    /*
    * Problem:
    * Chef owns an icecream shop in Chefland named scoORZ. There are only three types of coins in Chefland: 
    * Rs. 5, Rs. 10 and Rs. 15. An icecream costs Rs. 5.
    * There are N people (numbered 1 through N) standing in a queue to buy icecream from scoORZ. 
    * Each person wants to buy exactly one icecream. 
    * For each valid i, the i-th person has one coin with value ai. 
    * It is only possible for someone to buy an icecream when Chef can give them back their change exactly ― 
    * for example, if someone pays with a Rs. 10 coin, Chef needs to have a Rs. 5 coin that he gives to this person as change.
    * Initially, Chef has no money. He wants to know if he can sell icecream to everyone in the queue, in the given order. 
    * Since he is busy eating his own icecream, can you tell him if he can serve all these people?
    *
    * Input:
    * The first line of the input contains a single integer T denoting the number of test cases. 
    * The description of T test cases follows.
    * The first line of each test case contains a single integer N. 
    * The second line contains N space-separated integers a1, a2, ..., aN.
    *
    * Output:
    * For each test case, print a single line containing the string "YES" if all people can be served or "NO" otherwise (without quotes).
    *
    * Constraints:
    * 1 <= T <= 100
    * 1 <= N <= 10^3
    * ai ∈ {5,10,15} for each valid i
    */
    public static void solveCodeChefCHFICRM() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long rs5 = 0;
            long rs10 = 0;
            long imposible = 0;
            long N = scn.nextLong();
            for (long i = 0; i < N; i++) {
                long ai = scn.nextLong();
                if (ai == 5)
                    rs5++;
                else if (ai == 10 && rs5 > 0) {
                    rs5--;
                    rs10++;
                }
                else if (ai == 15 && rs10 > 0)
                    rs10--;
                else if (ai == 15 && rs5 > 1)
                    rs5 -= 2;
                else
                    imposible++;
            }
            System.out.println(imposible == 0 ? "YES" : "NO");
        }
        scn.close();        
    }

    /*
    * Problem:
    * You just bought a new calculator, but it seems to have a small problem: 
    * all its results have an extra 1 appended to the end.
    * For example, if you ask it for 3 + 5, it'll print 81, and 4 + 12 will result in 161.
    * Given A and B, can you predict what the calculator will print when you ask it for A+B?
    * 
    * Input Format:
    * The first and only line of input will contain two space-separated integers A and B.
    *
    * Output Format:
    * Print a single integer: the calculator's output when you enter A+B into it.
    *
    * Constraints:
    * 1 <= A,B <= 50
    */
    public static void solveCodeChefOFFBY1() {
        Scanner scn = new Scanner(System.in);
        long A = scn.nextLong(); 
        long B = scn.nextLong(); 
        System.out.println((A + B) * 10 + 1);
        scn.close();        
    }
    
    /*
    * Problem:
    * The tortoise and the hare decide to run a race, yet again.
    * This time around however, the hare has gotten a bit smarter!
    * The racetrack is a straight line, L meters long.
    * The tortoise moves at V1 meters per second, while the hare moves at V2 meters per second. 
    * It is known that V1 < V2, that is, the hare is strictly faster.
    * The hare still wants to be a bit lazy, so it decides to give the tortoise a headstart - 
    * the hare will wait for an integer number of seconds before starting to run.
    * Unfortunately, the animals' measuring devices aren't up to par - 
    * they can only measure in integer seconds, and will round up — so for example:
    * If the hare takes 1.57 seconds to finish, the reported time will be 2 seconds.
    * If the hare takes 3 seconds to finish, the reported time will be 3 seconds.
    * If the hare takes 3.01 seconds to finish, the reported time will be 4 seconds.
    * What's the longest time the hare can wait, while still being able to win the race?
    * Note that to win the race, the hare's reported time must be strictly less than the tortoise's.
    * If the hare cannot win no matter what, print −1.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * The first and only line of each test case contains three space-separated integers L1, V1 and V2 -
    * the length of the racetrack, the tortoise's speed, and the hare's speed.
    *
    * Output Format:
    * For each test case, output on a new line the longest time the hare can wait, 
    * while still being able to win the race.
    *
    * Constraints:
    * 1 <= T <= 10^4
    * 1 <= L <= 1000
    * 1 <= V1 < V2 <= 1000
    */
    public static void solveCodeChefSMARTER() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long L = scn.nextLong();
            long V1 = scn.nextLong();
            long V2 = scn.nextLong();
            long T1 = L / V1 + (L % V1 != 0 ? 1 : 0);
            long T2 = L / V2 + (L % V2 != 0 ? 1 : 0);
            System.out.println((T2 == T1) ? -1 : T1 - T2 - 1);
        }
        scn.close();        
    }
    
    /*
    * Problem:
    * Chef bought a new digital lock, 
    * but is quite suspicious of its actual strength in keeping out pesky thieves. 
    * So, he wants to find out how quickly he can open the lock.
    * The digital lock works as follows:
    * On its screen, there is a string of digits S of length N.
    * There is also a secret code K of length M (1 <= M <= 10), which acts as the key to the lock.
    * The lock will open if K is present anywhere in S as a contiguous substring.
    * Operating the lock is simple: Chef can choose an index i, 
    * and either increment Si by 1, or decrement it by 1.
    * Here, the digits are cyclic, following the order 0 → 1 → 2 → 3 → ... → 8 → 9 → 0 → ...
    * In particular, incrementing 9 will turn it into 0 
    * and decrementing 0 will turn it into 9.
    * You are given S and K. What's the minimum number of moves Chef needs to open the lock?
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of three lines of input.
    * The first line of each test case contains two space-separated integers N and M - 
    * the lengths of the string and the secret code, respectively.
    * The second line contains a string S of length N, containing only the digits 0-9.
    * The third line contains a string K of length M, also containing only the digits 0-9.
    *
    * Output Format:
    * For each test case, output on a new line the minimum number of moves Chef needs to open the lock.
    *
    * Constraints:
    * 1 <= T <= 10^4
    * 1 <= N <= 10^5 
    * 1 <= M <= min(N,10)
    * The sum of N across all tests won't exceed 10^5.
    * Strings S and K will only contain the digits 0-9.
    */
    public static void solveCodeChefLPC() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long M = scn.nextLong();
            String S = scn.next();
            String K = scn.next();
            int min_movements = Integer.MAX_VALUE;
            for (int i = 0; i <= N - M; i++) {
                int i_movements = 0;
                for (int j = 0; j < M; j++) {
                    int dS = Integer.parseInt(S.substring(i + j, i + j + 1));
                    int dK = Integer.parseInt(K.substring(j, j + 1));
                    int up_movements = Math.abs(dS - dK);
                    int down_movements = Math.abs(Math.min(dS, dK) + 10 - Math.max(dS, dK));
                    i_movements += Math.min(up_movements, down_movements);
                }
                if (i_movements < min_movements)
                    min_movements = i_movements;
            }
            System.out.println(min_movements);
        }
        scn.close();        
    }
    
    /*
    * Problem:
    * Chef is on a solo mission in Chefland, facing N enemies. 
    * The strength of the ith enemy is denoted by Ai.
    * Chef starts with an initial strength of H and a resistance level of X.
    * Here are the rules of the fight:
    * If an enemy's strength is less than or equal to Chef's resistance (X), 
    * Chef wins without losing any strength.
    * If an enemy's strength exceeds Chef's resistance, 
    * Chef can still win, but only if his strength is strictly greater than the enemy's.
    * In this case, Chef's strength decreases by the enemy's strength after the battle.
    * Your task is to find the minimum resistance value (X) that Chef needs to defeat all N enemies 
    * while ensuring he maintains a positive strength after the last battle.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of two lines of input.
    * The first line of each test case contains two space-separated integers N and H - 
    * the number of enemies and Chef's initial strength, respectively.
    * The next line contains N space-separated integers A1, A2, ..., AN - 
    * the strengths of the N enemies.
    *
    * Output Format:
    * For each test case, output on a new line, the minimum resistance value (X) that Chef needs to defeat 
    * all N enemies while ensuring he maintains a positive strength after the last battle.
    *
    * Constraints:
    * 1 <= T <= 1000
    * 1 <= N,H,Ai <= 10^5 
    * The sum of N over all test cases won't exceed 10^6.
    */
    public static void solveCodeChefWARRIORCHEF() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long H = scn.nextLong();
            long max_strength = 1;
            TreeSet<Long> ordered_strengths = new TreeSet<>();
            HashMap<Long, Long> strengths = new HashMap<>();
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                max_strength += Ai;
                if (!strengths.containsKey(Ai)) {
                    strengths.put(Ai, 1L);
                    ordered_strengths.add(Ai);
                }                    
                else
                    strengths.put(Ai, strengths.get(Ai) + 1);
            }
            if (max_strength <= H)
                System.out.println(0);
            else {
                for (Long Ai : ordered_strengths) {
                    max_strength -= strengths.get(Ai) * Ai;
                    if (max_strength <= H) {
                        System.out.println(Ai);
                        break;
                    }
                }
            }
        }
        scn.close();
    }
    
    /*
    * Problem:
    * Chef is planning a heist in the reserve bank of Chefland. 
    * They are planning to hijack the bank for D days and print the money. 
    * The initial rate of printing the currency is P dollars per day and they 
    * increase the production by Q dollars after every interval of d days.
    * For example, after d days the rate is P+Q dollars per day, 
    * and after 2d days the rate is P+2Q dollars per day, and so on. 
    * Output the amount of money they will be able to print in the given period.
    *
    * Input:
    * The first line contains an integer T, the number of test cases. Then the test cases follow.
    * Each test case contains a single line of input, four integers D,d,P,Q.
    *
    * Output:
    * For each test case, output in a single line the answer to the problem.
    *
    * Constraints:
    * 1 <= T <= 10^5 
    * 1 <= d <= D <= 10^6
    * 1 <= P,Q <= 10^6 
    */
    public static void solveCodeChefCHFHEIST() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long D = scn.nextLong();
            long d = scn.nextLong();
            long P = scn.nextLong();
            long Q = scn.nextLong();
            long n = D / d;
            long Pbox = P * n * d + P * (D % d);
            long Qstairs = d * Q * ((n - 1) * n) / 2;
            long Qremain = Q * (D% d) * n;
            System.out.println(Pbox + Qstairs + Qremain);
        }
        scn.close();        
    }
    
    /*
    * Problem:
    * Chef has started a new job as an insurance agent. 
    * Each insurance costs X dollars and Chef gets a 20% commission on selling each insurance.
    * Find the minimum number of insurances Chef needs to sell to earn at least 100 dollars.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of a single integer X, the cost of an insurance.
    * 
    * Output Format:
    * For each test case, output on a new line, 
    * the minimum number of insurances Chef needs to sell to earn at least 100 dollars.
    *
    * Constraints:
    * 1 <= T <= 100
    * 1 <= X <= 100
    */
    public static void solveCodeChefAGENTCHEF() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long N = 10000 / (X * 20) + (((10000 % (X * 20)) != 0) ? 1 : 0);
            System.out.println(N);
        }
        scn.close();        
    }

    /*
    * Problem:
    * Chef has started learning about the stock market and has already selected a favourite stock.
    * He traded the stock for N consecutive days. 
    * Let Ai denotes the profit earned by Chef on the ith day. 
    * Note that Ai < 0 indicates that Chef had a loss on the ith day.
    * Chef wants to find the maximum amount of of profit he would have earned, 
    * if he skipped trading for exactly one day.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of multiple lines of input.
    * The first line of each test case contains N — the number of days.
    * The next line denotes N space-separated integers, denoting the profit earned by Chef on the ith day.
    *
    * Output Format:
    * For each test case, output on a new line, the maximum amount of of profit he would have earned, 
    * if he skipped trading for exactly one day.
    *
    * Constraints:
    * 1 <= T <= 1000
    * 1 <= N <= 10^5
    * −100 <= Ai <= 100
    * The sum of N over all test cases won't exceed 10^6.
    */
    public static void solveCodeChefSTOCKMARKET() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long minAi = Long.MAX_VALUE;
            long sumAi = 0;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                sumAi += Ai;
                if (Ai < minAi)
                    minAi = Ai;
            }
            System.out.println(sumAi - minAi);
        }
        scn.close();        
    }
   
    /*
     * Problem:
     * The newspaper in Chefland consists of 10 pages numbered 1 to 10.
     * The last 3 pages of the newspaper are always dedicated to the sports section.
     * Given a random page number X, determine whether that page is dedicated to the sports section.
     * 
     * Input Format:
     * The first and only line of input consists of a single integer X, denoting the page number.
     * 
     * Output Format:
     * Output on a new line, YES, if the given page number is dedicated to the sports section, and NO otherwise.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= X <= 10
     */
    public static void solveCodeChefNEWSPAPER() {
        Scanner scn = new Scanner(System.in);
        int X = scn.nextInt();
        System.out.println(X >= 8 ? "YES" : "NO");
        scn.close();
    }    
    
    /*
    * Problem:
    * You are given a string S with length N. You may perform the following operation any number of times: 
    * choose a non-empty substring of S (possibly the whole string S) 
    * such that each character occurs an even number of times in this substring and erase this substring from S. 
    * (The parts of S before and after the erased substring are concatenated and the next operation is performed on this shorter string.)
    * For example, from the string "acabbad", we can erase the highlighted substring "abba", 
    * since each character occurs an even number of times in this substring. After this operation, the remaining string is "acd".
    * Is it possible to erase the whole string using one or more operations?
    * Note: A string B is a substring of a string A if B can be obtained from A by deleting several (possibly none or all) 
    * characters from the beginning and several (possibly none or all) characters from the end.
    *
    * Input:
    * The first line of the input contains a single integer T denoting the number of test cases. 
    * The description of T test cases follows.
    * The first line of each test case contains a single integer N.
    * The second line contains a single string S with length N.
    *
    * Output:
    * For each test case, print a single line containing the string "YES" if it is possible to erase the whole string 
    * or "NO" otherwise (without quotes).
    *
    * Constraints:
    * 1 <= T <= 200
    * 1 <= N <= 1000
    * S contains only lowercase English letters
    */
    public static void solveCodeChefEVENTUAL() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            String S = scn.next();
            if (N % 2 == 1)
                System.out.println("NO");
            else {
                boolean pairs = true;
                HashMap<Character, Integer> map = CodeChefLibrary.getFrequencyMap(S);
                for (Character c : map.keySet()) {
                    int chars = map.get(c);
                    if (chars % 2 == 1) {
                        pairs = false;
                        break;
                    }
                }
                System.out.println(pairs ? "YES" : "NO");
            }
        }
        scn.close();        
    }

    /*
     * Problem:
     * Read problem statements in Bengali, Mandarin Chinese, Russian, and Vietnamese as well.
     * There are N seats in a row. You are given a string S with length N; 
     * for each valid i, the i-th character of S is '0' if the i-th seat is empty or '1' if there is someone sitting in that seat.
     * 
     * Two people are friends if they are sitting next to each other. 
     * Two friends are always part of the same group of friends. Can you find the total number of groups?
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first and only line of each test case contains a single string S.
     * 
     * Output:
     * For each test case, print a single line containing one integer ― the number of groups.
     * 
     * Constraints:
     * 1 <= T <= 50
     * 1 <= N <= 10^5
     */
    public static void solveCodeChefGROUPS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            String S = scn.next();
            long groups = 0;
            long friends = 0;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == '0') {
                    if (friends > 0)
                        groups++;
                    friends = 0;
                }
                else
                    friends++;
            }
            if (friends > 0)
                groups++;
            System.out.println(groups);
        }
        scn.close();
    }

    /*
     * Problem:
     * Chef usually likes to play cricket, but now, he is bored of playing it too much, 
     * so he is trying new games with strings. Chef's friend Dustin gave him binary strings S and R, 
     * each with length N, and told him to make them identical. 
     * However, unlike Dustin, Chef does not have any superpower and Dustin lets Chef perform only operations of one type: 
     * choose any pair of integers (i,j) such that 1 <= i,j <= N and swap the i-th and j-th character of S. 
     * He may perform any number of operations (including zero).
     * For Chef, this is much harder than cricket and he is asking for your help. 
     * Tell him whether it is possible to change the string S to the target string R only using operations of the given type.
     *
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first line of each test case contains a single integer N.
     * The second line contains a binary string S.
     * The third line contains a binary string R.
     *
     * Output:
     * For each test case, print a single line containing the string "YES" if it is possible to change S to R 
     * or "NO" if it is impossible (without quotes).
     * 
     * Constraints:
     * 1 <= T <= 400
     * 1 <= N <= 100
     * |S| = |R| = N
     * S and R will consist of only '1' and '0'
     */
    public static void solveCodeChefPLAYSTR() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            String S = scn.next();
            String R = scn.next();
            long ones = 0;
            long zeros = 0;
            for (long i = 0; i < N; i++) {
                char Sc = S.charAt((int)i);
                char Rc = R.charAt((int)i);
                if (Sc != Rc) {
                    if (Sc == '1')
                        ones++;
                    else
                        zeros++;
                }
            }
            System.out.println(zeros == ones ? "YES" : "NO");
        }
        scn.close();        
    }
    
    /*
    * Problem:
    * Chef likes problems involving arrays. Unfortunately, 
    * the last one he tried to solve didn't quite get solved.
    * Chef has an array A of N positive numbers. 
    * He wants to find the number of subarrays for which the sum and product of elements are equal.
    * Please help Chef find this number.
    *
    * Input:
    * The first line of input contains an integer T denoting the number of test cases. 
    * T test cases follow. The first line of each test contains the integer N. 
    * The next line contains N integers - A1, A2, ..., AN - denoting the array.
    *
    * Output:
    * For each test case, output a single line with the answer for the instance.
    *
    * Constraints:
    * 1 <= T <= 50
    * 1 <= n <= 50
    * 1 <= Ai <= 10^9
    * A1 * A2 * ... * An <= 10^9
    */
    public static void solveCodeChefCHEFARRP() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long total = 0;
            long N = scn.nextLong();
            ArrayList<Long> A = new ArrayList<>();
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                A.add(Ai);
                long suma = 0;
                long producto = 1;
                for (long j = i; j >= 0; j--) {
                    suma += A.get((int)j);
                    producto *= A.get((int)j);
                    if (suma == producto)
                        total++;
                }
            }
            System.out.println(total);
        }
        scn.close();
    }

    /*
     * Problem:
     * Given an integer N, determine the number of pairs (A, B)(A,B) such that:
     * 1 <= A,B <= N
     * A + B is odd.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single integer N.
     * 
     * Output Format:
     * For each test case, output the number of required pairs.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 10^9
     */
    public static void solveCodeChefODDPAIRS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long pairs = N / 2;
            long odds = (N % 2 == 0) ? pairs : pairs + 1;
            System.out.println(pairs * odds * 2);
        }
        scn.close();
    }

    /*
     * Problem:
     * You are given an even integer N and an integer K.
     * Generate an array A of size N such that:
     * 1 <= Ai <= 10^5 for all 1 <= i <= N;
     * The number of odd elements in the array is same as the number of even elements.
     * The sum of all elements of the array is K.
     * If multiple such arrays exist, print any. If no such array exists, print -1 instead.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two space-separated integers N and K - the size of the array and the required sum.
     * 
     * Output Format:
     * For each test case, output on a new line, N space-separated integers, 
     * denoting the array A satisfying the given conditions.
     * If multiple such arrays exist, print any. If no such array exists, print -1 instead.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 2 <= N <= 10^5, N is even
     * 1 <= K <= 10^9 The sum of N over all test cases won't exceed 10^6
     */
    public static void solveCodeChefSUMARRAY() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            if ((N / 2) % 2 != K % 2)
                System.out.println(-1);
            else if (K < ((3 * N) / 2))
                System.out.println(-1);
            else if ((K / (N / 2)) > 199999)
                System.out.println(-1);
            else {
                String S = "";
                long sum = 3 * (N / 2 - 1);
                long v1 = (K - sum) / 2;
                long v2 = K - sum - v1;
                while (v1 + v2 > 199999) {
                    S +="99999 100000 ";
                    N -= 2;
                    K -= 199999;
                    sum = 3 * (N / 2 - 1);
                    v1 = (K - sum) / 2;
                    v2 = K - sum - v1;
                }
                if (v1 < 1 || v2 < 1 || N < 2)
                    System.out.println(-1);
                else {
                    System.out.print(S);
                    for (long i = 1; i < N / 2; i++)
                        System.out.print("1 2 ");
                    System.out.println(v1 + " " + v2);
                }
            }
        }
        scn.close();
    }

    /*
     * Problem:
     * Chef organised a 30 kilometres marathon in Chefland.
     * The participants receive medals on completing the marathon as following:
     * If the total time taken is less than 3 hours, they receive a GOLD medal.
     * If the total time taken is greater than equal to 3 hours but less than 6 hours, they receive a SILVER medal.
     * If the total time taken is greater than equal to 6 hours, they receive a BRONZE medal.
     * Chefina participated in the marathon and completed it in X hours. Which medal would she receive?
     *
     * Input Format:
     * The input consists of a single integer X - the number of hours Chefina took to complete the marathon.
     * 
     * Output Format:
     * Output the medal Chefina would recieve.
     * Note that you may print each character in uppercase or lowercase. 
     * For example, the strings GOLD, gold, Gold, and gOlD are considered the same.
     * 
     * Constraints:
     * 1 <= X <= 10.
     */
    public static void solveCodeChefOCTATHON() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        if (X < 3)
            System.out.println("GOLD");
        else if (X < 6)
            System.out.println("SILVER");
        else
            System.out.println("BRONZE");
        scn.close();        
    }
    
    /*
     * Problem:
     * On a sunny Sunday afternoon, Chef prepared a brunch for his 20 neighbours.
     * Chef prepared a total of X plates. 
     * However, the meal was so good that the neighbours started taking Y plates each.
     * Find the maximum number of neighbours Chef can feed completely.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two space-separated integers X and Y - 
     * the number of plates Chef prepared and the number of plates each person takes respectively.
     * 
     * Output Format:
     * For each test case, output on a new line, the maximum number of neighbours Chef can feed completely.
     *
     * Constraints:
     * 1 <= T <= 405
     * 20 <= X <= 100
     * 1 <= Y <= 5
     */
    public static void solveCodeChefBRUNCH() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            long total = X / Y;
            System.out.println(total > 20 ? 20 : total);
        }
        scn.close();
    }
    
    /*
     * Problem:
     * Alice and Bob are playing a game. Each player rolls a regular six faced dice 3 times.
     * The score of a player is the maximum number that can be formed using the rolls.
     * The player with the highest score wins, and the game ends in a tie if both players have the same score.
     * Find the winner of the game or determine whether it is a tie.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case contains six space-separated integers A1,A2,A3,B1,B2 and B3 -
     * the values Alice gets in her 3 dice rolls, followed by the values which Bob gets in his 3 dice rolls.
     * 
     * Output Format:
     * For each test case, output on a new line Alice if Alice wins, Bob if Bob wins and Tie in case of a tie.
     * Note that you may print each character in uppercase or lowercase. 
     * For example, the strings tie, TIE, Tie, and tIe are considered identical.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= A1,A2,A3,B1,B2,B3 <= 6
     */
    public static void solveCodeChefDICENUM() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            ArrayList<Long> A = new ArrayList<>();
            ArrayList<Long> B = new ArrayList<>();
            A.add(scn.nextLong());
            A.add(scn.nextLong());
            A.add(scn.nextLong());
            B.add(scn.nextLong());
            B.add(scn.nextLong());
            B.add(scn.nextLong());
            Collections.sort(A);
            Collections.sort(B);
            long MaxA = 0;
            long MaxB = 0;
            long pow = 1;
            for (int i = 0; i < 3; i++) {
                MaxA = MaxA + A.get(i) * pow;
                MaxB = MaxB + B.get(i) * pow;
                pow *= 10;
            }
            if (MaxA > MaxB)
                System.out.println("Alice");
            else if (MaxB > MaxA)
                System.out.println("Bob");
            else
                System.out.println("Tie");
        }
        scn.close();
    }

    /*
     * Problem:
     * You are given a binary string S of length N. 
     * You are allowed to perform the following types of operations on string S:
     * Delete any one character from S, and concatenate the remaining parts of the string. 
     * For example, if we delete the third character of S=1101, it becomes S=111.
     * Flip all the characters of S. 
     * For example, if we flip all character of S=1101, it becomes S=0010.
     * Given that you can use either type of operation any number of times, 
     * find the minimum number of operations required to make all characters of the string S equal to 0.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains an integer N - the length of the string.
     * The next line contains a binary string S of length N.
     *
     * Output Format:
     * For each test case, output on a new line, 
     * the minimum number of operations required to make all characters of the string S equal to 0.
     * 
     * Constraints:
     * 1 <= T <= 2000
     * 1 <= N <= 10^5
     * S contains 0 and 1 only.
     * The sum of N over all test cases won't exceed 2*10^5
     */
    public static void solveCodeChefZEROSTRING() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            scn.nextLong();
            String S = scn.next();
            long ones = 0;
            long zeros = 0;
            for (char c : S.toCharArray()) {
                if (c == '1')
                    ones++;
                else
                    zeros++;
            }
            if (ones > zeros)
                System.out.println(zeros + 1);
            else
                System.out.println(ones);
        }
        scn.close();

    }

    /*
     * Problem:
     * Chefina decided to move into Chef's apartment.
     * Chef was initially paying a rent of X rupees. 
     * Since Chefina is moving in, the owner decided to double the rent.
     * Find the final rent Chef needs to pay.
     * 
     * Input Format:
     * The input consists of a single integer X, denoting the rent Chef was initially paying.
     * 
     * Output Format:
     * Output on a new line, the final rent Chef needs to pay.
     * 
     * Constraints:
     * 1 <= X <= 10
     */
    public static void solveCodeChefDOUBLERENT() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        System.out.println(X * 2);
        scn.close();
    }
    
    /*
     * Problem:
     * Chef has a circular pizza and a knife to cut that into pieces. 
     * He can only cut the pizza in a way such that the knife starts from the boundary of the pizza, 
     * passes the centre, and ends at the boundary.
     * Find whether Chef an divide the pizza into N pieces using any (possibly zero) number of cuts.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single integer N - denoting the desired number of cuts.
     * 
     * Output Format:
     * For each test case, output on a new line, YES, 
     * if Chef can divide the pizza into N pieces using any (possibly zero) number of cuts, 
     * and NO otherwise.
     * Note that you may print each character in uppercase or lowercase. 
     * For example, the strings NO, no, No, and nO are considered the same.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     */
    public static void solveCodeChefPIZZAC() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextInt();
        while (T-- > 0) {
            long N = scn.nextInt();
            boolean posible = (N % 2 == 0 || N == 1);
            System.out.println(posible ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem:
     * Read problem statements in Bengali, Russian, Mandarin and Vietnamese as well.
     * Chef has X coins worth 1 rupee each and Y coins worth 2 rupees each. 
     * He wants to distribute all of these X+Y coins to his two sons so that the total value of coins received by each of them is the same. 
     * Find out whether Chef will be able to do so.
     * 
     * Input Format:
     * The first line of input contains a single integer T, denoting the number of testcases. 
     * The description of T test cases follows.
     * Each test case consists of a single line of input containing two space-separated integers X and Y.
     * 
     * Output Format:
     * For each test case, print "YES" (without quotes) if Chef can distribute all the coins equally and "NO" otherwise. 
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings "yEs", "yes", "Yes" and "YES" will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10^3
     * 0 <= X,Y <= 10^8
     * X + Y > 0
     */
    public static void solveCodeChefEQUALCOIN() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            if (X % 2 == 1)
                System.out.println("NO");
            else if (X >= 2 && X % 2 == 0)
                System.out.println("YES");
            else if (Y % 2 == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        scn.close();
    }

    /*
     * Problem:
     * Read problems statements in Mandarin Chinese, Russian and Vietnamese as well.
     * Chef is instructor of the famous course "Introduction to Algorithms" in a famous univerisity. 
     * There are n students in his class. 
     * There is not enough space in the class room, so students sit in a long hallway in a linear fashion.
     * One day Chef was late to class. 
     * As a result, some of the students have formed pairs and are talking to each other, while the others are busy studying. 
     * This information is given to you by a string s of length n, consisting of characters '*', <' and '>', 
     * where '*' denotes that the student is studying, 
     * '>' denotes that the corresponding student is talking to the student to the right, 
     * and '<' denotes that the corresponding student is talking to the student to the left.
     * For example, consider a sample configuration of students - *><*. 
     * Here students numbered 1 and 4 are busy studying, while the student 2 and 3 are talking to each other. 
     * In this example, ><><, student 1 and 2 are talking to each other, and 3 and 4 are also talking to each other.
     * You are guaranteed that the given input is a valid configuration, i.e. <> can not be a valid string s, 
     * as here student 1 is shown to be talking to left, but there is no student to the left. 
     * Same is the case for right. Similarly, >><< is also not a valid configuration, as students 2 and 3 are talking to each other, 
     * so student 1 won't be able to talk to student 2.
     * When the students see their teacher coming, those who were talking get afraid and immediately turn around, 
     * i.e. students talking to left have now turned to the right, and the one talking to right have turned to the left. 
     * When Chef sees two students facing each other, he will assume that they were talking. 
     * A student who is busy studying will continue doing so. 
     * Chef will call each pair of students who were talking and punish them. 
     * Can you find out how many pairs of students will get punished?
     * For example, in case *><*, when students see Chef, their new configuration will be *<>*. 
     * Chef sees that no students are talking to each other. 
     * So no one is punished. While in case ><><, the new configuration of students will be <><>, 
     * Chef sees that student 2 and 3 are talking to each other and they will be punished.
     * 
     * Input:
     * The first line of the input contains an integer T denoting the number of the test cases.
     * Each test case contains a string s denoting the activities of students before students see Chef entering the class.
     * 
     * Output:
     * For each test case, output a single integer denoting the number of pairs of students that will be punished.
     * 
     * Constraints:
     * 1 <= T <= 10
     * 1 <= |s| <= 10^5
     * 
     * Subtasks:
     * 
     * Subtask #1: (30 points)
     * 1 <= T <= 10
     * 1 <= |s| <= 10^5
     * No student is studying.
     * 
     * Subtask #2: (70 points)
     * Original Constraints.
     */
    public static void solveCodeChefCHEFSTUD() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        int ST_NONE = 0;
        int ST_WATING_RIGHT = 1;
        while (T-- > 0) {
            String S = scn.next();
            int state = ST_NONE;
            long punished = 0;
            for (char c : S.toCharArray()) {
                switch(c) {
                    case '*':
                        state = ST_NONE;
                        break;
                    case '<':
                        if (state == ST_NONE)
                            state = ST_WATING_RIGHT;
                        else if (state == ST_WATING_RIGHT)
                            state = ST_NONE;
                        break;
                    case '>':
                        if (state == ST_WATING_RIGHT) {
                            punished++;
                            state = ST_NONE;
                        }
                        break;
                }
            }
            System.out.println(punished);
        }
        scn.close();
    }

    /*
     * Problem:
     * Trick or treat, bags of sweets, ghosts are walking down the street.
     * It's Halloween and Suri Bhai is out to get his treats.
     * There are two sectors in his neighborhood, "Bones" and "Blood". 
     * They have N and M people, respectively.
     * Each person in "Bones" will hand out X treats, and each person in "Blood" will hand out Y treats.
     * How many treats does Suri Bhai get from visiting everyone in his neighborhood in total?
     * 
     * Input Format:
     * The first line of input contains two space-separated integers N and M - 
     * the number of people in "Bones" and "Blood", respectively.
     * The second line of input contains two space-separated integers X and Y - 
     * the number of treats handed out by each person in "Bones" and "Blood", respectively.
     * 
     * Output Format:
     * For each test case output a single integer: the total number of treats Suri Bhai will receive.
     * 
     * Constraints:
     * 0 <= N,M <= 100
     * 0 <= X,Y <= 1000
     */
    public static void solveCodeChefBNE_APT() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong();
        long M = scn.nextLong();
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println(N * X + M * Y);
        scn.close();
    }

    /*
     * Problem:
     * Eat, drink, and be scary.
     * There are N spooky days left until Halloween.
     * Dracula dines at a mysterious restaurant that changes its spooky menu daily.
     * He particularly enjoys what they serve on Tuesday.
     * Today is Monday, so he wishes to calculate how many times he can indulge 
     * in his favourite menu in the next N days (including today) before Halloween.
     * Note that Dracula follows the standard 7-day calendar, with Tuesday immediately following Monday.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The only line of each test case contains a single integer N, denoting the number of spooky days.
     * 
     * Output Format:
     * For each test case, output on a new line the number of times Dracula would have had his favorite meal after N days.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N <= 1000
     */
    public static void solveCodeChefCHEAT() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            System.out.println((N + 5) / 7);
        }
        scn.close();
    }

    /*
     * Problem:
     * Read problem statements in Russian and Mandarin Chinese.
     * A great deal of energy is lost as metabolic heat 
     * when the organisms from one trophic level are consumed by the next level.
     * Suppose in Chefland the energy reduces by a factor of K, i.e, if initially, the energy is X, 
     * then the transfer of energy to the next tropic level is ⌊X/K⌋.
     * This limits the length of foodchain which is defined to be the highest level receiving non-zero energy.
     * E is the energy at the lowest tropic level. Given E and K for an ecosystem, find the maximum length of foodchain.
     * Note: ⌊x⌋ denoted the floor function, and it returns the greatest integer that is less than or equal to x 
     * (i.e rounds down to the nearest integer). For example, ⌊1.4⌋ = 1, ⌊5⌋ = 5, ⌊−1.5⌋ = −2, ⌊−3⌋ = −3 , ⌊0⌋ = 0.
     * 
     * Input Format:
     * First line will contain T, number of testcases. Then the testcases follow.
     * Each testcase contains a single line of input, two integers E,K.
     * 
     * Output Format:
     * For each testcase, output in a single line answer to the problem.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= E <= 10^9
     * 2 <= K <= 10^9
     */
    public static void solveCodeChefFODCHAIN() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long E = scn.nextLong();
            long K = scn.nextLong();
            long levels = 0;
            while (E > 0) {
                E /= K;
                levels++;
            }
            System.out.println(levels);
        }
        scn.close();
    }

    /*
    * Problem:
    * Chef Sports conducted a fan poll to find out who their fans thought was the best captain.
    * The three players nominated were Dhoni, Rohit, and Kohli. 
    * They received A, B, and C votes, respectively.
    * Find out whether Dhoni won the poll, i.e, if he received the maximum number of votes.
    * Note: It is guaranteed that no two players received the same number of votes.
    *
    * Input Format:
    * The only line of input contains three space-separated integers A, B, and C -
    * the number of votes obtained by Dhoni, Rohit, and Kohli, respectively.
    * 
    * Output Format:
    * Print the answer on a single line: "Yes" (without quotes) if Dhoni won the poll, 
    * and "No" (without quotes) otherwise.
    * Each character of the output may be printed in either uppercase or lowercase, 
    * i.e, the strings No, no, nO, and NO` will all be treated as equivalent.
    *
    * Constraints:
    * 1 <= A <= 1000
    * 1 <= B <= 1000
    * 1 <= C <= 1000
    * A != B, A != C, and B != C
    */
    public static void solveCodeChefFIZZBUZZ2301() {
        Scanner scn = new Scanner(System.in);
        long A = scn.nextLong();
        long B = scn.nextLong();
        long C = scn.nextLong();
        boolean dhoni = (A == Math.max(A, Math.max(B, C)));
        System.out.println(dhoni ? "Yes" : "No");
        scn.close();
    }
    
    /*
    * Problem:
    * The apocalypse has arrived, and Alice and her 4 other family members 
    * (a total of 5 people) are now stuck in a shopping mall from where they have nowhere to run.
    * Fortunately, the place where they are stuck has frozen buns which they can eat and survive.
    * There are N buns in the mall, and each member of the family needs to eat X buns everyday to survive.
    * After the food supply runs out, the family can survive for a further D days.
    * How many days can Alice and family survive under these conditions?
    * Note: If there aren't enough buns to feed the whole family, nobody will eat anything. 
    * The samples below showcase an example of this.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * The first and only line of each test case contains three space-separated integers N, X, and D -
    * the total number of frozen buns, the number of buns every member needs everyday, 
    * and the number of days everyone can survive after food gets exhausted, respectively.
    * 
    * Output Format:
    * For each test case, output on a new line the total number of days Alice and family can survive.
    *
    * Constraints:
    * 1 <= T <= 10^5
    * 0 <= N < 500
    * 1 <= X <= 10
    * 0 <= D < 20
    */
    public static void solveCodeChefFIZZBUZZ23_2() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long X = scn.nextLong();
            long D = scn.nextLong();
            long days = D + N / (5 * X);
            System.out.println(days);
        }
        scn.close();        
    }
    
    /*
    * Problem:
    * All of Chef's friends are playing fantasy cricket based upon the ODI World Cup, and Chef would like to join them.
    * For a certain cricket match, Chef has decided upon his team of 11 players. 
    * However, he hasn't yet decided who should be the captain and who should be the vice-captain.
    * He's narrowed his decision down to N players out of the 11, 
    * from which he'll choose one to be the captain and one to be the vice captain.
    * How many different choices does he have?
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * The first and the only line of each testcase contains a single integer N, the number of players Chef is considering.
    *
    * Output Format:
    * For each test case, output on a new line the number of possible choices of captain and vice-captain.
    * 
    * Constraints:
    * 1 <= T <= 10
    * 2 <= N <= 11
    */
    public static void solveCodeChefFIZZBUZZ2303() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            System.out.println(N * (N - 1));
        }
        scn.close();
    }
      
    /*
    * Problem:
    * Chef classifies a day to be either rainy, cloudy, or clear.
    * In a particular week, Chef finds X days to be rainy and Y days to be cloudy.
    * Find the number of clear days in the week.
    *
    * Input Format:
    * The first and only line of input will contain two space-separated integers X and Y, 
    * denoting the number of rainy and cloudy days in the week.
    *
    * Output Format:
    * Output the number of clear days in the week.
    *
    * Constraints:
    * 0 <= X,Y <= 7
    * 0 <= X + Y <= 7
    */
    public static void solveCodeChefCLEARDAY() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println(7 - X - Y);
        scn.close();
    }
    
    /*
    * Problem:
    * Chef and Chefina are playing the famous game of Rock, Paper, Scissors.
    * The game consists of N rounds. 
    * In each round, both players choose one of the three moves: Rock, Paper, or Scissors, denoted by R, P, and S respectively.
    * If both players play the same move, the current round ends in a draw and neither of them gets a point.
    * If one of the players plays Rock and the other plays Scissors, the player who played Rock wins the round and gets a point.
    * If one of the players plays Scissors and the other plays Paper, the player who played Scissors wins the round and gets a point.
    * If one of the players plays Paper and the other plays Rock, the player who played Paper wins the round and gets a point.
    * The winner of the game is the player who gets the maximum number of points after playing all the rounds. 
    * If both players have the same number of points, then the game ends in a draw.
    * You are given two strings A and B, each of length N, 
    * consisting of uppercase English letters R, P, and S, 
    * where Ai denotes the move made by Chef in the ith round and Bi denotes the move made by Chefina in the ith round.
    * Find the minimum number of rounds Chef should have played differently to have won the game.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of multiple lines of input.
    * The first line of each test case contains an integer N - the number of rounds.
    * The second line contains string A of length N denoting the moves played by Chef.
    * The third line contains string B of length N denoting the moves played by Chefina.
    *
    * Output Format:
    * For each test case, output on a new line, the minimum number of rounds Chef should have played differently to have won the game.
    *
    * Constraints:
    * 1 <= T <= 7.10^4
    * 1 <= N <= 1000
    * Ai, Bi ∈ {R, P, S}
    * The sum of N over all test cases won't exceed 4.10^5
    */
    public static void solveCodeChefPASCRO() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            String A = scn.next();
            String B = scn.next();
            long score_A = 0;
            long score_B = 0;
            for (int i = 0; i < N; i++) {
                if (A.charAt(i) == 'R' && B.charAt(i) == 'S')
                    score_A++;
                else if (A.charAt(i) == 'S' && B.charAt(i) == 'P')
                    score_A++;
                else if (A.charAt(i) == 'P' && B.charAt(i) == 'R')
                    score_A++;
                else if (A.charAt(i) != B.charAt(i))
                    score_B++;
            }
            long difference = score_B - score_A;
            if (difference < 0)
                System.out.println(0);
            else
                System.out.println(difference / 2 + 1);
        }
        scn.close();
    }

    /*
    * Problem:
    * Chef has finally decided to complete all of his pending assignments.
    * There are X assignments where each assignment takes Y minutes to complete.
    * Find whether Chef would be able to complete all the assignments in Z days.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists three space-separated integers X, Y, and Z - 
    * the number of assignments, time taken in minutes to complete each assignment, 
    * and the number of days in which Chef wants to complete the assignments.
    *
    * Output Format:
    * For each test case, output on a new line, YES, if Chef would be able to complete all the assignments in Z days. 
    * Otherwise, print NO.
    * You may print each character of the string in uppercase or lowercase 
    * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
    *
    * Constraints:
    * 1 <= T <= 10^5
    * 1<= X, Y <= 100
    * 1 <= Z <= 10
    */
    public static void solveCodeChefASSIGNMNT() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            long Z = scn.nextLong();
            long needed = X * Y;
            long remainded = Z * 24 * 60;
            System.out.println(remainded >= needed ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem:
     * Given an integer N, find a permutation of size N such that:
     * 
     * A(i) != A(i-1)|A(i-2) for all 3 <= i <= N, where | denotes the bitwise or operation.
     * 
     * It is guaranteed that such permutation always exists. 
     * If multiple such permutations exist, you may print any.
     * Note that a permutation of size N consists of all integers from 1 to N exactly once.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists a single integer N — the size of the permutation.
     * 
     * Output Format:
     * For each test case, output on a new line, 
     * N space-separated integers denoting the permutation satisfying the given conditions.
     * It is guaranteed that such permutation always exists. If multiple such permutations exist, you may print any.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 3 <= N <= 10^5
     * The sum of N over all test cases won't exceed 10^6
     */
    public static void solveCodeChefPERMOR() {
        Scanner scn = new Scanner(System.in);
        long[] pattern3 = {1, 3, 2, 4};
        long[] pattern = {1, 2, 4, 3};
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            if (N % 4 == 3) {
                for (long i = 0; i < N; i++) {
                    System.out.print((4 * (i / 4) + pattern3[(int)i % 4]) + " ");
                }
            }
            else {
                for (long i = 0; i < N; i++) {
                    System.out.print((4 * (i / 4) + pattern[(int)i % 4]) + " ");
                }
            }
            System.out.println();
        }
        scn.close();
    }

    /*
    * Problem:
    * Dominater and Everule are very competitive, 
    * and keep trying to show that they are better at competitive programming than the other. 
    * What better measure is there than their rating?
    * Both of them participated in a contest. 
    * Before the contest, Dominater's rating was R1 and Everule's rating was R2.
    * Dominater's rating changed by D1 in the contest, and Everule's rating changed by D2.
    * Who has the higher final rating after the contest?
    * Print "Dominater" if his rating is higher, and "Everule" if his rating is higher (without the quotes).
    * It is guaranteed they do not have equal ratings at the end of the contest.
    *
    * Input Format:
    * The first line of input will contain two space-separated integers R1 and R2, 
    * denoting the initial ratings of Dominater and Everule.
    * The second line of input will contain two space-separated integers D1 and D2,
    * denoting the rating changes of Dominater and Everule.
    *
    * Output Format:
    * Output Dominater or Everule, depending on who has a higher rating at the end.
    * Each character of the output may be printed in either uppercase or lowercase, 
    * i.e, Everule, EVERULE, and evERuLe will all be treated as equivalent.
    *
    * Constraints:
    * 1 <= R1, R2 <= 3000
    * -200 <= D1, D2 <= 200
    * It is guaranteed Dominater and Everule have different final ratings.
    */
    public static void solveCodeChefCPRIVAL() {
        Scanner scn = new Scanner(System.in);
        long R1 = scn.nextLong();
        long R2 = scn.nextLong();
        long D1 = scn.nextLong();
        long D2 = scn.nextLong();
        long dominater = R1 + D1;
        long everule = R2 + D2;
        System.out.println(dominater > everule ? "Dominater" : "Everule");
        scn.close();
    }
    
    /*
    * Problem:
    * You are hosting a chess tournament with 2N people. 
    * Exactly X of them are rated players, and the remaining 2N − X are unrated players.
    * Your job is to distribute the players into N pairs, 
    * where every player plays against the person paired up with them.
    * Since you want the rated players to have an advantage, you want to pair them with unrated players. 
    * Thus, you want to minimize the number of rated players whose opponent is also rated.
    * Print the minimum number of rated players whose opponents are also rated, among all possible pairings.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of 1 line containing 2 space-separated integers N and X, 
    * meaning there are 2N players, and X of them are rated.
    *
    * Output Format:
    * For each test case, output on a new line the minimum number of rated players who will have rated opponents.
    * 
    * Constraints:
    * 1 <= T <= 2600
    * 1 <= N <= 50
    * 0 <= X <= 2 * N
    */
    public static void solveCodeChefCHESS_PAIR() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long X = scn.nextLong();
            long unrated = 2 * N - X;
            System.out.println((X <= unrated) ? 0 : (X - unrated));
        }
        scn.close();
    }

    /*
    * Problem:
    * A palindromic prime number is a positive integer that is both a prime number (meaning it has exactly two divisors:
    * 1 and itself) and a palindrome in base 10 (meaning it reads the same both backwards and forwards).
    * Leading zeros are not considered when determining if a number is a palindrome 
    * (so 20 is not a palindrome, even though it can be written as 020).
    * You are given an integer N. Consider the first N palindromic prime numbers. 
    * How many of them have an even number of digits, and how many of them have an odd number of digits?
    *
    * Some examples:
    * 2,7, and 11 are palindromic primes.
    * 22 and 121 are palindromes that are not primes.
    * 17 and 37 are primes that are not palindromes.
    * 42 is neither a palindrome nor a prime.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * The first and only line of each test case contains a single integer N -
    * meaning you must consider the first N palindromic prime numbers.
    *
    * Output Format:
    * For each test case, output on a new line two space-separated integers: 
    * among the first N palindromic primes, the number of them that have an even number of digits
    * and the number of them that have an odd number of digits, respectively.
    *
    * Constraints:
    * 1 <= T <= 10^5
    * 1 <= N <= 10^5
    */
    public static void solveCodeChefMD_RIEV() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            if (N < 5)
                System.out.println("0 " + N);
            else
                System.out.println("1 " + (N - 1));
        }
        scn.close();
    }
    
    /*
     * Problem:
     * Chef Ada is preparing N dishes (numbered 1 through N). For each valid i, 
     * it takes Ci minutes to prepare the i-th dish. The dishes can be prepared in any order.
     * Ada has a kitchen with two identical burners. 
     * For each valid i, to prepare the i-th dish, she puts it on one of the burners and after Ci minutes, 
     * removes it from this burner; the dish may not be removed from the burner before those Ci minutes pass, 
     * because otherwise it cools down and gets spoiled. 
     * Any two dishes may be prepared simultaneously, 
     * however, no two dishes may be on the same burner at the same time. 
     * Ada may remove a dish from a burner and put another dish on the same burner at the same time.
     * What is the minimum time needed to prepare all dishes, 
     * i.e. reach the state where all dishes are prepared?
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first line of each test case contains a single integer N.
     * The second line contains N space-separated integers C1, C2, ..., CN.
     * 
     * Output:
     * For each test case, print a single line containing one integer - 
     * the minimum number of minutes needed to prepare all dishes.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N <= 4
     * 1 <= Ci <= 5 for each valid i
     */
    public static void solveCodeChefADADISH() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            ArrayList<Long> Ci = new ArrayList<>();
            long N = scn.nextLong();
            while (N > 0) {
                Ci.add(scn.nextLong());
                N--;
            }
            Collections.sort(Ci, Collections.reverseOrder());
            long burner1 = 0;
            long burner2 = 0;
            for (long C : Ci) {
                if (burner1 < burner2)
                    burner1 += C;
                else
                    burner2 += C;
            }
            System.out.println(Math.max(burner1, burner2));
        }
        scn.close();
    }

    /*
    * Problem:
    * The cricket World Cup has started in Chefland. There are many teams participating in the group stage matches. 
    * Any team that scores 12 or more points in the group stage matches qualifies for the next stage.
    * You know the score that a particular team has scored in the group stage matches. 
    * Determine if the team has qualified for the next stage or not.
    *
    * Input Format:
    * The first and only line of input consists of an integer X 
    * denoting the total points scored by the given team in the group stage matches.
    *
    * Output Format:
    * Output Yes, if the team has qualified for the next stage, and No otherwise.
    * You may print each character of the string in uppercase or lowercase 
    * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
    *
    * Constraints:
    * 1 <= X <= 20
    */
    public static void solveCodeChefCWC23QUALIF() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        System.out.println(X >= 12 ? "Yes" : "No");
        scn.close();
    }

    /*
    * Problem:
    * We know that "A picture is worth a thousand words". So let's calculate the worth of a video using this!
    * Suppose a video has 24 frames (or pictures) per second, and has a duration of S seconds. 
    * We know that each frame is worth 1000 words. So, how many words is this video worth in total?
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of a single line with a single integer S, the number of seconds in the video.
    *
    * Output Format:
    * For each test case, output on a new line the number of words that the video is worth.
    *
    * Constraints:
    * 1 <= T <= 100
    * 1 <= S <= 100
    */
    public static void solveCodeChefVIDEOWORTH() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long S = scn.nextLong();
            System.out.println(S * 24 * 1000);
        }
        scn.close();
    }

    /*
    * Problem:
    * Sonu and Titu are playing a tennis match. 
    * They are playing a "best of N sets" match (N is always odd). 
    * That means that they will play at most N sets, 
    * and the person who has won most sets wins the match. 
    * But they are smart, and if they notice at any point that one of them has no chance of winning the match, 
    * they will stop the match right then, without playing out all the N sets needlessly.
    * 
    * For example, suppose N = 11. And at some point, Sonu has won 5 sets, and Titu has won 4 sets. 
    * Sonu is leading now, but it is possible that Titu wins the two remaining sets and wins the whole match. 
    * So they will not stop right now.
    *
    * But suppose Sonu wins the next set as well, and so now the score is (6, 4). 
    * Now, even though there is one set remaining, there is no chance of Titu winning the whole match, 
    * since at best, even if he wins the next set, the score will become (6,5), 
    * and Sonu still wins. So, they will stop at a score of (6, 4) and declare Sonu as the winner.
    *
    * As another example, if N = 15, and the score is currently (8, 2), 
    * then they'll stop right now, since there is no way for Titu to win the match. 
    * Even if Titu wins all the 5 remaining sets, Titu cannot win the match.
    * You are watching the match, and you see that the match has ended with a score of (X, Y). 
    * That is, Sonu has won X sets, and Titu has won Y sets. But you don't know what N is. 
    * Can you find out N from just knowing the final score?
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of a single line of input containing two space-separated integers X and Y 
    * where X is the number of sets won by Sonu and Y is the number of sets won by Titu.
    *
    * Output Format:
    * For each test case, output on a new line the value of N.
    * Note that you should only output an odd integer.
    *
    * Constraints:
    * 1 <= T <= 10000
    * 1 <= X <= 100
    * 1 <= Y <= 100
    * X != Y, since they would never stop when they have won the same number of sets.
    */
    public static void solveCodeChefBESTOFTENNIS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            System.out.println(Math.max(X, Y) * 2 - 1);
        }
        scn.close();
    }

    /*
    * Problem:
    * Chef decides to go to the water park to play. To enter the water slide, 
    * a person must have a weight of at most W Kg and a height of at least H cm.
    * Chef weighs 60 Kg and his height is 130 cm.
    * Is Chef allowed to enter the water slide?
    *
    * Input Format:
    * The first and only line of input will contain two space-separated integers W and H.
    *
    * Output Format:
    * Output YES if Chef can enter the waterslide and NO if he cannot.
    * You may print each character of the string in either uppercase or lowercase 
    * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
    *
    * Constraints:
    * 1 <= W, H <= 1000
    */
    public static void solveCodeChefSPCP1() {
        Scanner scn = new Scanner(System.in);
        long W = scn.nextLong();
        long H = scn.nextLong();
        System.out.println((W >= 60 && H <= 130) ? "YES" : "NO");
        scn.close();
    }

    /*
    * Problem:
    * An airline operates X aircraft every day. Each aircraft can carry up to 100 passengers.
    * One day, N passengers would like to travel to the same destination. 
    * What is the minimum number of new planes that the airline must buy to carry all N passengers?
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of a single line containing two space-separated integers X and N - 
    * the number of aircraft the airline owns and the number of passengers travelling, respectively.
    *
    * Output Format:
    * For each test case, output the minimum number of planes the airline needs to purchase.
    *
    * Constraints:
    * 1 <= T <= 1000
    * 1 <= X <= 10 
    * 1 <= N <= 10 
    */
    public static void solveCodeChefSPCP2() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long N = scn.nextLong();
            long remaining = N - X * 100;
            System.out.println((remaining <= 0) ? 0 : ((remaining - 1) / 100 + 1));
        }
        scn.close();
    }

    /*
    * Problem:
    * A school has organized a field trip for a class of N students, 
    * of which X students are boys, and the remaining students are girls.
    * Everyone is excited to go trekking, and must form groups of size exactly K to do so. 
    * However, boys will only form groups among themselves, and girls will only form groups among themselves.
    * Both boys and girls will form as many groups as possible.
    * The remaining students can either dance around a bonfire, or just read books.
    * Dancing around the bonfire requires a pair of one girl and one boy, while reading is done alone.
    * Reading is much more boring than dancing, so students will try to avoid it.
    * What's the minimum number of students who will be engaged in reading?
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * The only line of each test case contains three space-separated integers N, X and K -
    * the total number of students, the number of boys and the number of students in each trekking group.
    *
    * Output Format:
    * For each test case, output on a new line the the minimum number of students engaged in reading.
    *
    * Constraints:
    * 1 <= T <= 1000
    * 1 <= N, K <= 10 
    * 1 <= X <= N
    */
    public static void solveCodeChefSPCP4() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long X = scn.nextLong();
            long K = scn.nextLong();
            long girls = N - X;
            long boys_not_in_group = X - (X / K) * K;
            long girls_not_in_group = girls - (girls / K) * K;
            long pairs = Math.min(boys_not_in_group, girls_not_in_group);
            System.out.println(boys_not_in_group + girls_not_in_group - pairs * 2);
        }
        scn.close();
    }
    
    /*
    * Problem:
    * Chef has A marbles, and his friend has B. They want to redistribute the marbles among themselves such that after redistributing:
    * Chef and his friend both have at least one marble each; 
    * The number of marbles with Chef is divisible by the number of marbles with his friend.
    * What's the minimum number of marbles that need to be transferred from one person to another to achieve this?
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * The only line of each test case contains two space-separated integers A and B - 
    * the number of marbles with Chef and the number of marbles with his friend, respectively.
    *
    * Output Format:
    * For each test case, output on a new line the minimum number of marbles to be transferred.
    *
    * Constraints:
    * 1 <= T <= 1000
    * 1 <= A, B <= 1000
    */
    public static void solveCodeChefSPCP3() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long A = scn.nextLong();
            long B = scn.nextLong();
            long moved1 = 0;
            long Aa = A;
            long Bb = B;
            while (Aa % Bb != 0) {
                Aa++;
                Bb--;
                moved1++;
            }
            long moved2 = 0;
            Aa = A;
            Bb = B;
            while (Aa % Bb != 0 && Aa > Bb) {
                Aa--;
                Bb++;
                moved2++;
            }
            if (Aa < Bb)
                moved2 = Long.MAX_VALUE;
            System.out.println(Math.min(moved1, moved2));
        }
        scn.close();
    }

    /*
    * Problem:
    * Ben is fighting a monster with a health of H. He starts with an attack power of 1.
    * Ben has two types of moves:
    * He can use a regular attack, which damages the monster by his current attack power.
    * After this, his attack power doubles.
    * He can use a special move: choose a prime number P such that P <= H (H being the current health of the monster), 
    * and deal P damage to the monster. This move can be done at most once.
    * Note that this special move doesn't affect his attack power: it doesn't double, and remains the same.
    * To kill the monster, Ben must deal exactly H damage to it.
    * Find the minimum number of moves needed for Ben to kill the monster, or print −1 if it's impossible to kill it no matter what.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each of the next T lines contains one integer H - the initial health of monster.
    *
    * Output Format:
    * For each test case, output on a new line the minimum number of moves Ben will perform 
    * to kill the monster (if he's able to do so at all). If he is unable to kill the monster no matter what, output −1 instead.
    *
    * Constraints:
    * 1 <= T <= 1000
    * 1 <= H <= 10^6
    */
    public static void solveCodeChefSPCP5() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long H = scn.nextLong();
            long pow = 0;
            long moves = 0;
            while (H > pow) {
                if (!CodeChefLibrary.isPrime(H - pow)) {
                    pow += Math.pow(2, moves);
                    moves++;
                }
                else
                    break;
            }
            if (H > pow)
                System.out.println(moves + 1);
            else if (H == pow)
                System.out.println(moves);
            else 
                System.out.println(-1);                
        }
        scn.close();
    }

    /*
     * Problem:
     * You're a bit all over the place as a college student. 
     * You used to eat out at expensive restaurants almost every day until your parents gave you a talking-to about being irresponsible. 
     * Now, you've got to control your eating and spending habits.
     * So, here's the plan: you'll stick to the college mess for your meals every day, except Sundays. 
     * On Sundays, you're treating yourself to those fancy restaurant meals.
     * The cost is Rs. X for the mess food each day, and Rs. Y for the restaurant splurges.
     * Now, what's the cost of food per week? Note that you don't have to pay for the mess on Sundays.
     * A week has seven days, as usual.
     * 
     * Input Format:
     * The first and only line of input contains 2 space-separated integers, X and Y.
     * 
     * Output Format:
     * Output a single integer: the weekly cost of food.
     * 
     * Constraints:
     * 1 <= X < Y <= 1000
     */
    public static void solveCodeChefFOODCOST() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println(X * 6 + Y);
        scn.close();
    }

    /*
     * Problem:
     * Christmas is celebrated on 25th December every year.
     * You are given a day X in December. Determine whether it is Christmas.
     * Print CHRISTMAS if it is Christmas. Otherwise print ORDINARY.
     * 
     * Input Format:
     * The input consists of a single integer X, denoting a day in December.
     * 
     * Output Format:
     * Output on a new line CHRISTMAS, if it is Christmas and ORDINARY otherwise.
     * You may print each character in uppercase or lowercase. 
     * For example the strings CHRISTMAS, christmas, Christmas are all considered identical.
     * 
     * Constraints:
     * 1 <= X <= 31
     */
    public static void solveCodeChefCHRISTGREET() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        System.out.println(X == 25 ? "CHRISTMAS" : "ORDINARY");
        scn.close();
    }

    /*
     * Problem:
     * You are given an integer N.
     * Print THALA if N = 7, otherwise print SADGE.
     * 
     * Input Format:
     * The only line of input contains an integer N.
     * 
     * Output Format:
     * Output a single string, print THALA if N = 7, otherwise print SADGE.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings THALA, thALa, thala, and tHalA will all be treated as identical).
     * 
     * Constraints:
     * 1 <= N <= 10
     */
    public static void solveCodeChefTHALA7() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong();
        System.out.println(N == 7 ? "THALA" : "SADGE");
        scn.close();
    }

    /*
     * Problem:
     * Chef's website has a specific response mechanism based on the HTTP status code received:
     * If the response code is 404, the website will return NOT FOUND.
     * For any other response code different from 404, the website will return FOUND.
     * Given the response code as X, determine the website response.
     * 
     * Input Format:
     * The first and only line of input contains a response code X.
     * 
     * Output Format:
     * Output on a new line NOT FOUND, if the response code is 404. Otherwise print FOUND.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings FOUND, fouND, FouND, and found will all be treated as identical).
     * 
     * Constraints:
     * 100 <= X <= 999
     */
    public static void solveCodeChefERROR404() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong();
        System.out.println(N == 404 ? "NOT FOUND" : "FOUND");
        scn.close();
    }

    /*
     * Problem:
     * In Chefland, there are X schools, and each school has Y students.
     * The year end results are in and a total of Z students passed the exams.
     * Assuming that all students appeared for the exams, 
     * find whether the number of students who passed in Chefland was strictly greater than 50%.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of three space-separated integers X, Y and Z, as mentioned in the statement.
     * 
     * Output Format:
     * For each test case, output on a new line, YES, 
     * if the total number of students who passed in Chefland was strictly greater than 50%, otherwise print NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 2 * 10^4
     * 1 <= X <= 5
     * 1 <= Y <= 50
     * 0 <= Z <= X * Y
     */
    public static void solveCodeChefEXAMCHEF() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            long Z = scn.nextLong();
            long notZ = Z - X * Y;
            System.out.println(Z > notZ ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem:
     * Chef wants to decorate his house by painting the walls this Christmas. Each wall has a dimension of X * Y m.
     * If the cost of paint is 2 rupees per m^2, find the maximum number of walls Chef can paint completely with Z rupees.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of three space-separated integers X, Y and Z - 
     * where X and Y denote the dimensions of each wall in metres and Z denotes the money Chef has.
     * 
     * Output Format:
     * For each test case, output on a new line, the maximum number of walls Chef can paint completely with Z rupees.
     * 
     * Constraints:
     * 1 <= T <= 10 
     * 1 <= X, Y <= 10
     * 1 <= Z <= 100
     */
    public static void solveCodeChefPAINTCHRIS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            long Z = scn.nextLong();
            System.out.println(Z / (2 * X * Y));
        }
        scn.close();
    }

    /*
     * Problem:
     * You and K of your friends gather for dinner at a restaurant, 
     * and the total bill is Rs. N. You pay the entire bill, 
     * and since everyone shared the food equally, 
     * the bill needs to be split evenly among you all.
     * After asking your friends to reimburse their fair shares, each person pays you back. 
     * However, if the amount to be paid back wasn't an integer, they round down to the previous integer value.
     * For example, if each friend should have paid Rs. 13.2, they instead pay Rs. 13. 
     * Even if they should have paid Rs. 13.79, they still only pay Rs. 13, rounding down.
     * Calculate the net amount that you ended up paying after everyone settles their debts.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of one line of input, containing two space-separated integers N and K.
     * 
     * Output Format:
     * For each test case, output on a new line the net amount you paid.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= N <= 10^3
     * 1 <= K <= 10
     */
    public static void solveCodeChefFAIRSHARE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            long P = N / (K + 1);
            System.out.println(N - P * K);
        }
        scn.close();
    }

    /*
     * Problem:
     * You are given a positive integer N. In one operation you can:
     * Either subtract 3 or subtract 4 from N.
     * Can you make N zero by performing any number of operations?
     * 
     * Input Format:
     * The first line contains a single integer T, denoting the number of test cases.
     * The only line of each test case contains a positive integer N, denoting the integer which you need to make zero.
     * 
     * Output Format:
     * For each test case, output YES if you can make N zero using any number of operations. Otherwise, print NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= N <= 10^4
     */
    public static void solveCodeChefMAKENZERO() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            System.out.println((N < 3 || N == 5) ? "NO" : "YES");
        }
        scn.close();
    }

    /*
     * Problem:
     * Chef embarks on a journey starting from a town named S, containing a string of 8 uppercase English alphabets. 
     * His objective is to reach the destination known as CODETOWN.
     * If Chef is currently in town T1, then, with each move, Chef can transition to another town named T2, provided that either:
     * T2 is derived from T1 by replacing a consonant with another consonant, or;
     * T2 is derived from T1 by replacing a vowel with another vowel.
     * Find whether Chef can reach CODETOWN in any number of moves.
     * Note that in the english alphabet, letters A, E, I, O, and U are considered as vowels and rest are considered as consonants.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a string S, of length 88 consisting of uppercase english alphabets.
     * 
     * Output Format:
     * For each test case, output on a new line, YES, if Chef can reach CODETOWN, and NO otherwise.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * |S| = 8
     * S consists of uppercase english alphabets.
     */    
    public static void solveCodeChefCODETOWN() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            String S = scn.next();
            String S1 = "CODETOWN";
            boolean compatible = true;
            int i = 0;
            while (compatible && i < S.length()) {
                if (CodeChefLibrary.isVowel(S.charAt(i)) && !CodeChefLibrary.isVowel(S1.charAt(i)) || 
                    !CodeChefLibrary.isVowel(S.charAt(i)) && CodeChefLibrary.isVowel(S1.charAt(i)))
                    compatible = false;
                i++;
            }
            System.out.println(compatible ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Codechef Round
     * 
     * Codechef rounds are held on every Wednesday now, and not on any other days.
     * You are wondering whether there is a Codechef round today. 
     * You know it is the Nth day of the week (Sunday is 1st, Monday is 2nd, Tuesday is 3rd, Wednesday is 4th and so on).
     * Can you tell whether there is a Codechef round today?
     * 
     * Input Format:
     * The first and only line of input contains a single integer N, the day of the week.
     * 
     * Output Format:
     * Output YES if there is a Codechef round today, else NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= N <= 7
     */
    public static void solveCodeChefCODECHEF() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong();
        System.out.println(N == 4 ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Advitiya
     * 
     * IIT Ropar is hosting its tech fest, Advitiya, on the 16-th, 17-th, and 18-th of February.
     * Mehul, looking for a vacation, decides to visit Ropar in the month of February.
     * Mehul learned of Advitiya, and found out that there are no registration fees -
     * even accommodation is being provided to the participants for free!
     * Team Advitiya is very welcoming, so Mehul definitely wants to attend the fest.
     * Mehul will visit Ropar on date N (which is between 1 and 18) of February. Will he be able to enjoy the fest?
     * Print "ADVITIYA" if N is one of the days on which Advitiya is running, and "WAITING FOR ADVITIYA" otherwise.
     * 
     * Input Format:
     * The first line contains a single integer N, the date on which Mehul decided to visit Ropar.
     * 
     * Output Format:
     * Print a single line containing the answer: "ADVITIYA" if Mehul visits on the right date, and "WAITING FOR ADVITIYA" otherwise.
     * Both strings are to be printed without the quotes.
     * Each character of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings ADVITIYA, advitiya, and AdViTiYa will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= N <= 18
     */
    public static void solveCodeChefADVITIYA1() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong();
        System.out.println(N < 16 ? "WAITING FOR ADVITIYA" : "ADVITIYA");
        scn.close();
    }

    /*
     * Problem: Minimum Wage
     * 
     * The minimum wage in Chefland is 11 dollars per hour.
     * Given that Chef earns X dollars per hour, find whether his income is strictly above the minimum wage.
     * 
     * Input Format:
     * The first and only line contains an integer X, denoting the income of Chef per hour.
     * 
     * Output Format:
     * Output on a new line, YES, if Chef's income is strictly above the minimum wage. Otherwise, output NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= X <= 20
     */
    public static void solveCodeChefMINWAGE() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        System.out.println(X > 11 ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: International Education Day!
     * 
     * On the occasion of International Education Day, a fair is held in Chefland.
     * Both Chef and Chefina have set up their stalls.
     * Chef sells each item at his stall for A rupees and Chefina sells each item at her store for B rupees.
     * If both of them sell exactly C items, find the maximum amount in sales amongst Chef and Chefina.
     * 
     * Input Format:
     * The input consists of three space-separated integers A, B, and C denoting the cost of each item at Chef's and Chefina's 
     * stall and the number of items they sell respectively.
     * 
     * Output Format:
     * Output the the maximum amount in sales amongst Chef and Chefina.
     * 
     * Constraints:
     * 1 <= A, B, C <= 10
     * A != B
     */
    public static void solveCodeChefIED() {
        Scanner scn = new Scanner(System.in);
        long A = scn.nextLong();
        long B = scn.nextLong();
        long C = scn.nextLong();
        System.out.println(A > B ? A * C : B * C);
        scn.close();
    }

    /*
     * Problem: Judged
     * The tech fest of IIT Ropar, Advitiya, has a talent show as part of the festivities.
     * The preliminary round of the talent show has participants being evaluated by 5 judges, 
     * and only those participants whose performance was liked by at least 4 judges will qualify for the next round.
     * Anuj participated in the talent show, and now wants to know if he'll qualify or not.
     * You are given the responses of all 5 judges - help Anuj decide whether he qualified!
     * Each judge's response is given to you as a binary integer, where:
     * 0 means the judge didn't like Anuj's performance.
     * 1 means the judge liked Anuj's performance.
     * 
     * Input Format:
     * The first line of input contains a single integer T, denoting the number of test cases.
     * Each test case consists of a single line containing 5 space-separated integers R1, R2, R3, R4, R5 - the responses of the judges.
     * 
     * Output Format:
     * For each test case, output a single line containing the string "YES" (without quotes) 
     * if Anuj qualifies for the next round, and "NO" (without quotes) if he doesn't qualify.
     * Each letter of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings NO, no, No, and nO will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T \<= 100
     * 0 <= R1, R2, R3, R4, R5 <= 1
     */
    public static void solveCodeChefADVITIYA2() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long score = 0;
            for (int i = 0; i < 5; i++) {
                score += scn.nextLong();
            }
            System.out.println(score > 3 ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Literacy Rate
     * You are given two positive integers P and L denoting the total population of Chefland 
     * and the total number of literate people in Chefland.
     * Find whether the literacy rate of Chefland is greater than or equal to 75%.
     * Note that the literacy rate is calculated as (L / P) * 100 % 
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two space-separated integers P and L - 
     * the total population and the total number of literate people in Chefland respectively.
     * 
     * Output Format:
     * For each test case, output on a new line, YES, if the literacy rate of Chefland 
     * is greater than or equal to 75%. Otherwise, output NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 6000
     * 1 <= L <= P <= 100
     */
    public static void solveCodeChefLITRATE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long P = scn.nextLong();
            long L = scn.nextLong();
            System.out.println(L * 100 >= 75 * P ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Valentines Contest
     * 
     * Chef knows that a starters will be organised on next Wednesday, i.e., Valentine's day.
     * Since it is Starters 120120 today, starters 121121 is likely to be organised on Valentine's day.
     * Given an integer N, find whether starters N is likely to be organised on Valentine's day.
     * 
     * Input Format:
     * The input will contain a single integer N.
     * 
     * Output Format:
     * Output Likely if starters N is likely to be organised on Valentine's day. Otherwise, output Unlikely.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings LIKELY, likely, Likely, and lIkElY will all be treated as identical).
     * 
     * Constraints:
     * 120 <= N <= 123
     */
    public static void solveCodeChefVAL114() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong();
        System.out.println(N == 121 ? "Likely" : "Unlikely");
        scn.close();
    }

    /*
     * Problem: Yearly Phone
     * 
     * Chef is interested by buying a new phone, and is in the process of researching what's available on the market.
     * His favorite brand, Kitchen Telecom, just released their latest model.
     * Kitchen Telecom releases a new phone every year, and so names its phones based upon the year of release: 
     * the name of the phone model launched in year X is K (the letter) followed by the last two digits of X.
     * For instance, the phone model launched in the year 2024 is named K24.
     * 
     * The current year is X. What's the latest phone model launched by Kitchen Telecom?
     * 
     * Input Format:
     * The first and only line of input contains a single integer X, the current year.
     * 
     * Output Format:
     * Print the name of Kitchen Telecom's phone launched in year X.
     * 
     * Constraints:
     * 1973 <= X <= 2024
     */
    public static void solveCodeChefPHONEYR() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        System.out.println(String.format("K%02d", (X % 100)));
        scn.close();
    }

    /*
     * Problem: Chocolate Distribution
     * 
     * Christmas is the season of giving. 
     * As a part of celebrating the New Year, you decided to give away chocolates to the poor children in your neighbourhood.
     * Some of them even asked for 2 chocolates and being the kind soul that you are, you always gave them if you could. 
     * They never asked for more than 2 though because they are not greedy.
     * 
     * Now, you have forgotten exactly how many children you gave chocolates to. 
     * However, you remember that you started with N chocolates and distributed all of them by the end.
     * Find the minimum and maximum number of possible children that you gave chocolates to.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of one integer N, the number of chocolates you started with.
     * 
     * Output Format:
     * For each test case, output on a new line, two space-separated integers, 
     * the minimum possible number of children and the maximum possible number (in this order).
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N <= 1000
     */
    public static void solveCodeChefCHOCDISTRIB() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            System.out.println(((N + 1) / 2) + " " + N);
        }
        scn.close();
    }

    /*
     * Problem: Valentine Gifts
     * 
     * Chef is planning to gift something to Chefina on each of the 7 days of valentine week. He has a total budget of X rupees.
     * Find whether he can plan a series of gifts such that:
     * Each gift has a positive value;
     * The value of a gift is at least twice the value of previous gift.
     * Note that we do not consider any previous gift for the first gift, and thus the first gift can be of any positive value.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single integer X, denoting the budget of Chef.
     * 
     * Output Format:
     * For each test case, output on a new line, YES, 
     * if Chef can plan a series of gifts such that each gift is at least twice the value of previous gift. 
     * Otherwise, print NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 500
     * 1 <= X <= 500
     */
    public static void solveCodeChefVAL142() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long MIN = (long)Math.pow(2, 7) - 1;
            System.out.println(X >= MIN ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Hattrick
     * 
     * In a cricket match, the retiring of three batsmen with three consecutive balls is termed as a hattrick.
     * Let A, B, C, D, E and F denote the batsman's score for each ball in order in an over.
     * Each of these variables can be an integer less than equal to 66 denoting the runs scored by the batsman, or W denoting a wicket.
     * Find whether there was a hattrick in this over.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of six space-separated integers (or 'W') 
     * A, B, C, D, E, F, denoting the batsman's score for each ball in the over.
     * 
     * Output Format:
     * For each test case, output on a new line, YES, if there was a hattrick in the over, and NO otherwise.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YeS, yEs, yes and YES will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 5*10^4
     * A, B, C, D, E, F in {0, 1, 2, 4, 6, W}
     */
    public static void solveCodeChefHATTRICK() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            boolean hattrick = false;
            long wickets = 0; 
            for (int i = 0; i < 6; i++) {
                String over = scn.next();
                if (over.equals("W"))
                    wickets++;
                else
                    wickets = 0;
                if (wickets >= 3)
                    hattrick = true;
            }
            System.out.println(hattrick ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Find maximum in an Array
     * 
     * Given a list of N integers, representing height of mountains. Find the height of the tallest mountain.
     * 
     * Input:
     * First line will contain T, number of testcases. Then the testcases follow.
     * The first line in each testcase contains one integer, N.
     * The following N lines of each test case each contain one integer: the height of a new mountain.
     * 
     * Output:
     * For each testcase, output one line with one integer: the height of the tallest mountain for that test case.
     * 
     * Constraints:
     * 1 <= T <= 10
     * 1 <= N <= 100000
     * 0 <= height of each mountain <= 10^9
     * 
     */
    public static void solveCodeChefUWCOI20A() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long tallest = 0;
            for (long i = 0; i < N; i++) {
                long H = scn.nextLong();
                tallest = (H > tallest) ? H : tallest;
            }
            System.out.println(tallest);
        }
        scn.close();
    }

    /*
     * Problem: Difficulty Rating Order
     * 
     * Our Chef has some students in his coding class who are practicing problems.
     * Given the difficulty of the problems that the students have solved in order, 
     * help the Chef identify if they are solving them in non-decreasing order of difficulty. 
     * Non-decreasing means that the values in an array is either increasing or remaining the same, but not decreasing. 
     * That is, the students should not solve a problem with difficulty d1, and then later a problem with difficulty d2, where d1 > d2.
     * Output “Yes” if the problems are attempted in non-decreasing order of difficulty rating and “No” if not.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases. 
     * The description of the test cases follows. Each test case consists of 2 lines of input.
     * The first line contains a single integer N, the number of problems solved by the students
     * The second line contains N space-separate integers, the difficulty ratings of the problems attempted by the students in order.
     * 
     * Output Format:
     * For each test case, output in a new line “Yes” if the problems are attempted in non-decreasing order 
     * of difficulty rating and “No” if not. The output should be printed without the quotes.
     * Each letter of the output may be printed in either lowercase or uppercase. 
     * For example, the strings yes, YeS, and YES will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 2 <= N <= 100
     * 1 <= difficulty of each problem <= 5000
     */
    public static void solveCodeChefRATINGINPRAC() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long lastDifficulty = 0;
            boolean decreasing = false;
            for (long i = 0; i < N; i++) {
                long difficulty = scn.nextLong();
                if (difficulty < lastDifficulty)
                    decreasing = true;
                lastDifficulty = difficulty;
            }
            System.out.println(decreasing ? "NO" : "YES");
        }
        scn.close();
    }

    /*
     * Problem: Largest K
     * 
     * You are given integers X and Y (2 <= X, Y <= 10^9).
     * Find the largest integer K such that there exists a binary string S, where:
     * The count of 0s in S is X;
     * The count of 1s in S is Y;
     * There are atleast K 1s between any two occurrences of 0s in S.
     * 
     * Input Format:
     * The first line contains a single integer T, denoting the number of test cases.
     * The first line of each test case contains two integers X and Y -− the number of 0s and 1s in S.
     * 
     * Output Format:
     * For each test case, output on a new line, the largest integer K, such that a binary string satisfies given conditions.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 2 <= X, Y <= 10^9
     */
    public static void solveCodeChefLARGESTK343() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            System.out.println(Y / (X - 1));
        }
        scn.close();
    }

    /*
     * Problem: Cookie Day
     * 
     * A very caring mother has N cookie jars with her. Each jar contains a different type of cookie.
     * There are Ai cookies in the ith jar.
     * The mother wanted to give some cookies to her K children, 
     * and she decided to only distribute cookies of a single type. 
     * That is, she'll choose exactly one of the N jars and distribute the cookies within it.
     * She'd like to ensure a couple of things:
     * Each child should receive at least 1 cookie.
     * Each child should also receive an equal number of cookies, in the spirit of fairness.
     * Under the above two conditions, what is the minimum number of "wasted" cookies, 
     * i.e, cookies that remain in the chosen jar after distribution?
     * If it is not possible to give out any cookies at all, print -1 instead.
     * 
     * Input Format:
     * The first line of input contains a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * The first line of each test case contains two space-separated integers N and K - 
     * the number of cookie jars and the number of children.
     * The second line contains N space-separated integers A1, A2, ..., AN - 
     * where Ai is the number of cookies in the ith jar.
     * 
     * Output Format:
     * For each test case, output on a new line a single integer denoting the minimum number of cookies that will go to waste.
     * If it is not possible to distribute the cookies at all, output −1 instead.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 1 <= Ai, K <= 10^9
     */
    public static void solveCodeChefADVITIYA3() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            long minWasted = Long.MAX_VALUE;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                long cookies = Ai / K;
                if (cookies > 0)
                    minWasted = Math.min(minWasted, Ai % K);
            }
            System.out.println(minWasted == Long.MAX_VALUE ? -1 : minWasted);
        }
        scn.close();
    }

    /*
     * Problem: Sub or Swp
     * 
     * You are given two positive integers X and Y.
     * Repeat the following operation until X is not 0:
     * If X > Y, swap X and Y;
     * Otherwise, set X = (Y - X) and Y = X.
     * Output the final value of Y after all operations.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of one line of input, two space-separated integers X and Y.
     * 
     * Output Format:
     * For each test case, output on a new line, the final value of Y after all operations.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= X, Y <= 10^9
     */
    public static void solveCodeChefASM120() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            while (X > 0) {
                if (X <= Y) {
                    long steps = (Y - X) / X;
                    if (steps > 0)
                        Y -= (steps * X);
                    else {
                        long auxX = X;
                        X = Y - X;
                        Y = auxX;
                    }
                }
                else {
                    long auxX = X;
                    X = Y;
                    Y = auxX;
                }
            }
            System.out.println(Y);
        }
        scn.close();
    }

    /*
     * Problem: Leg Space
     * 
     * There are N students including Chef in a school. 
     * The school bus has M seats, and every student in the school travels on the bus.
     * It is guaranteed that N <= M, so that everyone will have a seat.
     * Chef is happy when the school bus is not full.
     * Given N and M, your task is to find out whether Chef will be happy.
     * 
     * Input Format:
     * The only line of input will contain two space-separated integers N and M, 
     * denoting the number of students in the school and the number of seats in the school bus respectively.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: YES, if Chef will be happy, and NO otherwise.
     * 
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YeS, yEs, yes, and YES will all be treated as identical).
     * 
     * Constraints:
     * 1 <= N <= M <= 10
     */
    public static void solveCodeChefLEGSP() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong();
        long M = scn.nextLong();
        System.out.println(N == M ? "NO" : "YES");
        scn.close();
    }

    /*
     * Problem: The Man Code
     * 
     * In Chefland, it is illegal for two people to use adjacent urinals at the same time (as it should be).
     * It is also obviously illegal for them to use the same urinal at the same time (as it definitely should be).
     * There are N urinals in a row in Chefland.
     * Find both the maximum and the minimum number of people that can use these N urinals simultaneously, 
     * such that there is no place for another person to join.
     * 
     * Input Format:
     * The first input line will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case contains a single integer N, denoting the number of urinals.
     * 
     * Output Format:
     * For each test case, output on a new line two space-separated integers: 
     * the maximum and the minimum number of people that can simultaneously use N urinals, 
     * such that there is no place for another person to join.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 1000
     */
    public static void solveCodeChefMANCODE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long max = (N + 1) / 2;
            long min = (N - 1) / 3 + 1;
            System.out.println(max + " " + min);
        }
        scn.close();
    }

    /*
     * Problem: Prime Reversal
     * 
     * You are given two binary strings A and B, each of length N. 
     * You can perform the following operation on string A any number of times:
     * Select a prime number X.
     * Choose any substring of string A having length X and reverse the substring.
     * Determine whether you can make the string A equal to B using any (possibly zero) number of operations.
     * A substring is obtained by deleting some (possibly zero) elements from the beginning and some (possibly zero) 
     * elements from the end of the string.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains an integer N - the length of the strings A and B.
     * The second line contains the binary string A.
     * The third line contains the binary string B.
     * 
     * Output Format:
     * For each test case, output on a new line, YES, if you can make the string A equal to B using any number of operations and NO otherwise.
     * You can print each character in uppercase or lowercase. For example, YES, yes, Yes, and yES are all identical.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 10^5
     * Ai and Bi contain 00 and 11 only.
     * The sum of N over all test cases won't exceed 10^5
     */
    public static void solveCodeChefPRIMEREVERSE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            String A = scn.next();
            String B = scn.next();
            long onesA = 0;
            long onesB = 0;
            long i = 0;
            while (i < N) {
                if (A.charAt((int)i) == '1')
                    onesA++;
                if (B.charAt((int)i) == '1')
                    onesB++;
                i++;
            }
            System.out.println(onesA == onesB ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Healthy Sleep
     * 
     * At IIITA, students have diverse sleep patterns, and there isn't a fixed duration for their daily sleep.
     * Typical scientific recommendations suggest that the duration of a healthy sleep is 88 hours per day.
     * As you begin your journey as a programmer, you've been tasked by the renowned programmer of IIITA, 
     * Pavitra Pandey, with your first project.
     * Your assignment is to write a program that takes as input the number of hours a student sleeps per day, 
     * and judges how good their sleep schedule is. Specifically,
     * If the student sleeps for strictly less than 88 hours, the program should output LESS.
     * If the student sleeps for exactly 88 hours, the program should output PERFECT.
     * If the student sleeps for strictly more than 88 hours, the program should output MORE.
     * Can you write such a program?
     * 
     * Input Format:
     * The only line of input contains a single integer HH, denoting the number of hours a student sleeps per day.
     * 
     * Output Format:
     * Output a single string containing the answer:
     * LESS if the student doesn't get enough sleep.
     * PERFECT if the student sleeps the perfect amount of time.
     * MORE if the student sleeps too much.
     * Each character of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings LESS, less, LeSs, and lesS will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= H <= 24
     */
    public static void solveCodeChefHEALSE() {
        Scanner scn = new Scanner(System.in);
        long H = scn.nextLong();
        if (H < 8)
            System.out.println("LESS");
        else if (H == 8)
            System.out.println("PERFECT");
        else
            System.out.println("MORE");
        scn.close();
    }

    /*
     * Problem: Problem Reviews
     * 
     * Om Khangat has come up with a problem that he thinks can be used in a CodeChef contest, 
     * and has submitted his proposal for review.
     * CodeChef's review panel has N judges, each of whom will give Om's problem a point value between 1 and 10, 
     * denoting how good they think it is (1 being the lowest, and 10 the highest).
     * A problem is considered good if and only if every judge gives it a score that's strictly greater than 4.
     * You know the point values given by each judge to Om's problem. Can you tell whether his problem is good?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * The first line of each test case contains one integer N - the number of judges.
     * The next line contains N space-separated integers S1, S2, S3, ... ,SN - 
     * where Si denotes the score given to Om's problem by the i-th judge.
     * 
     * Output Format:
     * For each test case, print the answer on a new line: YES if Om's problem is good, and NO otherwise.
     * Each character of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings YES, yes, YeS, and yES will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N <= 1000
     * 1 <= Si <= 10
     * The sum of N across all tests won't exceed 2000.
     */
    public static void solveCodeChefPBREV() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long min = Long.MAX_VALUE;
            while (N > 0) {
                long Si = scn.nextLong();
                min = Math.min(min, Si);
                N--;
            }
            System.out.println(min < 5 ? "NO" : "YES");
        }
        scn.close();
    }

    /*
     * Problem: Man of the Match
     * 
     * In a cricket match, there are two teams, each comprising 11 players.
     * The scorecard of the match lists the runs scored and wickets taken by each of these 22 players.
     * To determine the "Man of the Match", we assess each player's performance. Points are awarded to a player as follows:
     * Each run scored earns 1 point.
     * Every wicket taken earns 20 points.
     * The player with the highest total points is awarded the "Man of the Match" title.
     * You are given the scorecard of a cricket match, listing the contributions of all 22 players.
     * The players are numbered from 1 to 22. Find the "Man of the Match".
     * It is guaranteed that for all inputs to this problem, the "Man of the Match" is unique.
     * Note: A player who belongs to the losing team can also win the "Man of the Match" award.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of 22 lines of input. The i-th of these 22 lines contains two space-separated integers Ai and Bi - 
     * respectively, the runs scored and wickets taken by the ii-th player.
     * 
     * Output Format:
     * For each test case, output on a new line a single integer i (1 <= i <= 22) 
     * denoting the index of the player with the maximum score.
     * The tests for this problem are designed such that there will be exactly one player with the maximum score.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 0 <= A <= 200
     * 0 <= B <= 10
     * There will be exactly 1 player with the maximum score.
     */
    public static void solveCodeChefMATCH_ALK() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long max_points = Long.MIN_VALUE;
            long man_of_the_match = 0;
            for (long i = 1; i <= 22; i++) {
                long Ai = scn.nextLong();
                long Bi = scn.nextLong();
                long points = Ai + Bi * 20;
                if (points > max_points) {
                    max_points = points;
                    man_of_the_match = i;
                }
            }
            System.out.println(man_of_the_match);
        }
        scn.close();
    }

    /*
     * Problem: Strong Language
     * 
     * Read problem statements in Bengali, Mandarin Chinese, Russian, and Vietnamese as well.
     * A string is said to be using strong language if it contains at least K consecutive characters '*'.
     * You are given a string S with length N. Determine whether it uses strong language or not.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first line of each test case contains two space-separated integers N and K.
     * The second line contains a single string S with length N.
     * 
     * Output:
     * Print a single line containing the string "YES" if the string contains strong language or "NO" if it does not (without quotes).
     * You may print each character of each string in uppercase or lowercase 
     * (for example, the strings "yEs", "yes", "Yes" and "YES" will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10
     * 1 <= K <= N <= 10^6
     * S contains only lowercase English letters and characters '*'
     * Sum of N over all testcases is atmost 10^6
     */
    public static void solveCodeChefSSCRIPT() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            String S = scn.next();
            long consecutive = 0;
            boolean strong = false;
            for (int i = 0; i < N; i++) {
                if (S.charAt(i) == '*') {
                    consecutive++;
                    if (consecutive >= K) {
                        strong = true;
                        break;
                    }
                }
                else
                    consecutive = 0;
            }
            System.out.println(strong ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Algomaniac Finals
     * 
     * Algomaniac finals, a part of Convolution Fest of Jadavpur University, will be held on March 17.
     * Shreyan can only go to Jadavpur University on March X.
     * Print YAY if he can attend the Algomaniac finals and NO if he cannot.
     * 
     * Input Format:
     * The first and only line of input contains one integer, X, the day of march Shreyan can go to Jadavpur University.
     * 
     * Output Format:
     * Output YAY if Shreyan can attend Algomaniac finals, and NO otherwise.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YAY, yaY, yay, and Yay will all be treated as identical).
     * 
     * Constraints:
     * 1 <= X <= 31
     */
    public static void solveCodeChefALGOFINALS() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        System.out.println(X == 17 ? "YAY" : "NO");
        scn.close();
    }

    /*
     * Problem: Room Allocation
     * 
     * Jadavpur University wants to find out the number of rooms they need to accommodate the teams coming for their fest.
     * A total of N colleges are coming, where, the ith college has a team of Ai members.
     * Each room can accommodate at most 2 people. Moreover, people from different colleges dislike staying together.
     * Find the minimum number of rooms Jadavpur University will have to use to accommodate everyone, 
     * such that a room never contains people from different colleges.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains one integer, N, the number of colleges coming for the fest.
     * The next line contains N space-separated integers, A1, A2, ..., AN, the number of people coming from each college.
     * 
     * Output Format:
     * For each test case, output on a new line, the minimum number of rooms needed to accommodate all students, 
     * such that a room never contains people from different colleges.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 1 <= Ai <= 100
     */
    public static void solveCodeChefROOMALLOC() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long sum = 0;
            for (int i = 0; i < N; i++) {
                long Ai = scn.nextLong();                
                sum += (Ai / 2 + Ai % 2);
            }
            System.out.println(sum);
        }
        scn.close();
    }

    /*
     * Problem: Problem Difficulties
     * 
     * Read problem statements in Bengali, Mandarin Chinese, Russian, and Vietnamese as well.
     * You have prepared four problems. The difficulty levels of the problems are A1, A2, A3, A4 respectively. 
     * A problem set comprises at least two problems and no two problems in a problem set should have the same difficulty level. 
     * A problem can belong to at most one problem set. 
     * Find the maximum number of problem sets you can create using the four problems.
     * 
     * Input Format:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first and only line of each test case contains four space-separated integers A1, A2, A3, A4, 
     * denoting the difficulty level of four problems.
     * 
     * Output Format:
     * For each test case, print a single line containing one integer - 
     * the maximum number of problem sets you can create using the four problems.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= A1, A2, A3, A4 <= 10
     */
    public static void solveCodeChefPROBDIFF() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
/*            long A1 = scn.nextLong();
            long A2 = scn.nextLong();
            long A3 = scn.nextLong();
            long A4 = scn.nextLong();
            if (A1 == A2 && A2 == A3 && A3 == A4)
                System.out.println(0);
            else if ((A1 == A2 && A2 == A3) || (A2 == A3 && A3 == A4) || (A3 == A4 && A4 == A1) || (A4 == A1 && A1 == A2))
                System.out.println(1);
            else
                System.out.println(2);*/
            HashMap<Long, Long> hashMap = new HashMap<>();
            for (int i = 0; i < 4; i++) {
                long Ai = scn.nextLong();
                hashMap.put(Ai, hashMap.getOrDefault(Ai, 0L) + 1);
            }
            LinkedList<Long> listaOrdenada = new LinkedList<>();
            for (Map.Entry<Long, Long> entry : hashMap.entrySet())
                listaOrdenada.add(entry.getValue());
            Collections.sort(listaOrdenada);
            Collections.reverse(listaOrdenada);
            long problem_sets = 0;
            long last = 0;
            for (long v : listaOrdenada) {
                if (last >= v) {
                    problem_sets += v;
                    last -= v;
                }
                else {
                    if (last > 0)
                        problem_sets += last;
                    last = v - last;
                }
            }
            System.out.println(problem_sets);
        }
        scn.close();
    }

    /*
     * Problem: Summer Time
     * 
     * Mamalesh likes to drink mango lassi when it's hot, and only when it's hot. 
     * If (and only if) the temperature on a given day is strictly greater than 35 degrees, Mamalesh will drink mango lassi.
     * Mamalesh sees that today's temperature is X degrees Celsius. Will he drink mango lassi today?
     * Print "Yes" if he will, and "No" otherwise (without quotes).
     * 
     * Input Format:
     * The only line of input will contain a single integer X, denoting today's temperature.
     * 
     * Output Format:
     * Print "YES" if Mamalesh will drink mango lassi today, and "NO" otherwise (without quotes).
     * 
     * Each letter of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings NO, no, No, and nO will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= X <= 50
     */
    public static void solveCodeChefMANGOLASSI() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        System.out.println(X > 35 ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Cricket Tournament
     * 
     * Udyam'24 is organizing a cricket tournament, in which N teams are participating.
     * This tournament is a knockout tournament, 
     * meaning that the loser of each match will be knocked out of the tournament and won't play any more matches.
     * The winner of the tournament is whichever team remains in the end without being knocked out.
     * The tournament will proceed as follows:
     * If there is only one team remaining, that team will be declared the winner, and the tournament finishes.
     * Otherwise, some two teams will play against each other; with the loser being knocked out.
     * You think that the tournament will be interesting if at least M matches will be played before the winner is decided.
     * Given N and M, is it possible for the tournament to be interesting?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single line containing two space-separated integers N and M - 
     * the number of teams and the minimum number of matches for an interesting tournament.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: 
     * "YES" if the tournament can be interesting, and "NO" otherwise (without quotes).
     * Each letter of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings NO, no, No, and nO will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= N, M <= 100
     */
    public static void solveCodeChefCRICKETUDYAM() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long M = scn.nextLong();
            long m = 0;
            while (N > 1) {
                m += N / 2;
                N = N / 2 + N % 2;
            }
            System.out.println((m >= M) ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Binary Parity
     * 
     * The binary parity of an integer N is defined as follows:
     * First, write N in binary. For example, N = 13 is written as 1101 in binary, and N = 5 is written as 101.
     * Compute SN, the sum of the binary digits of N.
     * For example, from the earlier examples, S13 = 1 + 1 + 0 + 1 = 3 and S5 = 1 + 0 + 1 = 2.
     * The binary parity of N is then the parity of SN. 
     * S13 = 3 is odd, so 13 is said to have odd binary parity (*);
     * while S6 = 2 is even, so 55 has even binary parity.
     * Given an integer N, find its binary parity.
     * (*) The parity of an integer is, quite simply, whether it's even or odd.
     * We say an integer has even parity if it is a multiple of 2, and odd parity otherwise.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case will contain a single integer N.
     * 
     * Output Format:
     * For each test case, output on a new line the binary parity of N - either "EVEN" or "ODD" (without quotes).
     * Each character of the output may be printed in either lowercase or uppercase, i.e, 
     * the strings Odd, ODD, oDd, and ODd will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= N <= 10^9
     */
    public static void solveCodeChefBINPARITY() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            String N = Long.toBinaryString(scn.nextLong());
            long ones = 0;
            for (char c : N.toCharArray()) {
                if (c == '1')
                    ones++;
            }
            System.out.println((ones % 2 == 1) ? "ODD" : "EVEN");
        }
        scn.close();
    }

    /*
     * Problem: Equal Elements
     * 
     * You are given an array A of size N. In one operation, you can do the following:
     * Select indices i and j (i != j) and set Ai = Aj.
     * Find the minimum number of operations required to make all elements of the array equal.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains an integer N - the size of the array.
     * The next line contains N space-separated integers, denoting the array A.
     * 
     * Output Format:
     * For each test case, output on a new line, the minimum number of operations required to make all elements of the array equal.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N <= 2*10^5
     * 1 <= Ai <= N
     * The sum of N over all test cases won't exceed 2*10^5
     */
    public static void solveCodeChefEQUALELE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long maxOccurrences = 0;
            HashMap<Long, Long> hashMap = new HashMap<>();
            for (long j = 0; j < N; j++) {
                long Ai = scn.nextLong();
                long occurrences = hashMap.getOrDefault(Ai, 0L) + 1;
                hashMap.put(Ai, occurrences);
                if (occurrences > maxOccurrences)
                    maxOccurrences = occurrences;
            }
            System.out.println(N - maxOccurrences);
        }
        scn.close();
    }

    /*
     * Problem: Chef and Table Tennis
     * 
     * Chef likes to play table tennis. He found some statistics of matches which described who won the points in order.
     * A game shall be won by the player first scoring 11 points except in the case when both players have 10 points each, 
     * then the game shall be won by the first player subsequently gaining a lead of 2 points.
     * Could you please help the Chef find out who the winner was from the given statistics? 
     * (It is guaranteed that statistics represent always a valid, finished match.)
     * 
     * Input:
     * The first line of the input contains an integer T, denoting the number of test cases. 
     * The description of T test cases follows. Each test case consist a binary string S, which describes a match. 
     * '0' means Chef lose a point, whereas '1' means he won the point.
     * 
     * Output:
     * For each test case, output on a separate line a string describing who won the match. 
     * If Chef won then print "WIN" (without quotes), otherwise print "LOSE" (without quotes).
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= length(S) <= 100
     */
    public static void solveCodeChefTTENIS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            String S = scn.next();
            long ones = 0;
            long zeros = 0;
            for (char c : S.toCharArray()) {
                if (c == '1')
                    ones++;
                else
                    zeros++;
            }
            System.out.println(ones > zeros ? "WIN" : "LOSE");
        }
        scn.close();
    }

    /*
     * Problem: N Queens Puzzle Solved!
     * 
     * Chef, being a Chess fan, was thrilled after he read the following news:
     * Michael Simkin, a postdoctoral fellow at Harvard University’s Center of Mathematical Sciences and Applications 
     * proved that for a large value of N, there are approximately (0.143 * N) ^ N configurations 
     * in which N queens can be placed on a N x N chessboard so that none attack each other.
     * Although the formula is valid for large N, Chef is interested in finding the value of function f(N) = (0.143 * N) ^ N
     * for a given small value of N. Since Chef is busy understanding the proof of the formula, please help him calculate this value.
     * Print the answer rounded to the nearest integer. That is, if the actual value of f(N) is x,
     * -> Print ⌊x⌋ if x − ⌊x⌋ < 0.5
     * -> Otherwise, print ⌊x⌋ + 1
     * ⌊x⌋ denotes the floor of x.
     * 
     * Input Format:
     * The first line of input contains a single integer T, denoting the number of test cases. 
     * The description of T test cases follows.
     * Each test case consists of a single line of input containing one integer N.
     * 
     * Output Format:
     * For each test case, output in a single line the value of f(N) rounded to the nearest integer.
     * 
     * Constraints:
     * 1 <= T <= 12
     * 4 <= N <= 15
     */
    public static void solveCodeChefEUREKA() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            double N = (double)scn.nextLong();
            double base = 0.143 * N;
            double dresult = Math.pow(base, N);
            long lresult = Math.round(dresult);
            System.out.println(lresult);
        }
        scn.close();
    }

    /*
     * Problem: Join States
     * 
     * To curb the declining literacy in Chefland, the government has come up with a new plan.
     * You are given an array A of size N denoting the initial count of literate people in each of the N states of Chefland.
     * The government wants the count of literate people in each state to be at least M.
     * To do this, the government can combine two or more consecutive states to represent a new state.
     * The number of literate people in the new state will be equal to the sum of literate people 
     * in the individual consecutive states that were combined to create this new state.
     * Find the maximum number of states the government can have while maintaining the condition 
     * that at least M literate people are present in each state.
     * Note that it is guaranteed that M is not more than the sum of Ai.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains two space-separated integers N and M - 
     * the number of states initially and and the minimum number of literate people required in each state.
     * The next line consists of N space-separated integers denoting the initial count of literate people in each state.
     * 
     * Output Format:
     * For each test case, output on a new line, the maximum number of states the government can have 
     * while maintaining the condition of at least M literate people in each state.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= N <= 10^5
     * 1 <= M <= 10^5
     * 1 <= Ai <= 100
     * The sum of N over all test cases does not exceed 2 * 10^5.
     * It is guaranteed that M is not more than the sum of Ai.
     */
    public static void solveCodeChefJOINSTATE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long M = scn.nextLong();
            long aM = 0;
            long states = 0;
            while (N-- > 0) {
                long Ai = scn.nextLong();
                aM += Ai;
                if (aM >= M) {
                    aM = 0;
                    states++;
                }
            }
            System.out.println(states);
        }
        scn.close();
    }

    /*
     * Problem: End Sorted
     * 
     * Chef considers a permutation P of {1, 2, 3, ..., N} End Sorted if and only if P1 = 1 and PN = N.
     * Chef is given a permutation P.
     * In one operation Chef can choose any index i (1 <= i = N - 1) and swap Pi and P(i+1).
     * Determine the minimum number of operations required by Chef to make the permutation P End Sorted.
     * Note: An array P is said to be a permutation of {1, 2, 3, ..., N} if P contains each element of {1, 2, 3, ..., N} exactly once.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * The first line of each test case contains a single integer N, denoting the length of the permutation P.
     * The second line contains N space-separated integers P1, P2, P3, ..., PN, denoting the permutation P.
     * 
     * Output Format:
     * For each test case, output minimum number of operations required by Chef to make the permutation P End Sorted.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 2 <= N <= 10^5
     * P is a permutation of {1, 2, 3, ..., N}
     * The sum of N over all test cases does not exceed 3 * 10^5
     */
    public static void solveCodeChefENDSORTED() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long pos1 = 0;
            long posN = 0;
            for (long pos = 1; pos <= N; pos++) {
                long Pi = scn.nextLong();
                if (Pi == 1) pos1 = pos;
                else if (Pi == N) posN = pos;
            }
            if (pos1 > posN)
                posN++;
            System.out.println(pos1 - 1 + N - posN);
        }
        scn.close();
    }

    /*
     * Problem: Jewels and Stones
     * 
     * Soma is a fashionable girl. She absolutely loves shiny stones that she can put on as jewellery accessories. 
     * She has been collecting stones since her childhood - 
     * now she has become really good with identifying which ones are fake and which ones are not. 
     * Her King requested for her help in mining precious stones, 
     * so she has told him which all stones are jewels and which are not. 
     * Given her description, your task is to count the number of jewel stones.
     * More formally, you're given a string J composed of latin characters where each character is a jewel. 
     * You're also given a string S composed of latin characters where each character is a mined stone. 
     * You have to find out how many characters of S are in J as well.
     * 
     * Input:
     * First line contains an integer T denoting the number of test cases. 
     * Then follow T test cases. Each test case consists of two lines, 
     * each of which contains a string composed of English lower case and upper characters. 
     * First of these is the jewel string J and the second one is stone string S. 
     * You can assume that 1 <= T <= 100, 1 <= |J|, |S| <= 100
     * 
     * Output:
     * Output for each test case, a single integer, the number of jewels mined.
     */
    public static void solveCodeChefSTONES() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            String J = scn.next();
            String S = scn.next();
            HashMap<Character, Boolean> hJ = new HashMap<>();
            for (char c : J.toCharArray())
                hJ.put(c, true);
            long jewels = 0;
            for (char c : S.toCharArray()) {
                if (hJ.containsKey(c))
                    jewels++;
            }
            System.out.println(jewels);
        }
        scn.close();
    }

    /*
     * Problem: Chef and Game with Sequence
     * 
     * Chef has a sequence A containing N integers A1, A2, ..., AN.
     * Chef is playing a game with this sequence. 
     * In this game, he may perform the following operation any number of times (including zero): 
     * Choose an arbitrary pair of elements from the sequence such that their sum is even, 
     * delete these two elements from the sequence and insert their sum into the sequence instead.
     * The goal of the game is to minimise the number of elements in the sequence.
     * Help Chef to play the game and find the minimum possible size of the sequence at the end of the game!
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first line of each test case contains a single integer N.
     * The second line contains N space-separated integers A1, A2, ..., AN.
     * 
     * Output:
     * For each test case, print a single line containing one integer - the minimum possible final size of the sequence.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 1 <= Ai <= 1000 for each valid i
     */
    public static void solveCodeChefL56GAME() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long odd = 0;
            long even = 0;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                if (Ai % 2 == 0)
                    even++;
                else
                    odd++;
            }
            even = even + odd / 2;
            System.out.println((odd % 2) + (even > 0 ? 1 : 0));
        }
        scn.close();
    }

    /*
     * Problem: Minimum Attendance Requirement
     * 
     * A semester in Chef's University has 120 working days. 
     * The University's requirement is that a student should be present for at least 75% of the working days in the semester. 
     * If not, the student is failed.
     * Chef has been taking a lot of holidays, and is now concerned whether he can pass the attendance requirement or not. 
     * N working days have already passed, and you are given N bits - B1, B2, ..., BN. 
     * Bi = 0 denotes that Chef was absent on the ith day, and Bi = 1 denotes that Chef was present on that day.
     * Can Chef hope to pass the requirement by the end of the semester?
     * 
     * Input:
     * First line will contain T, the number of testcases. Then the testcases follow.
     * Each testcase contains two lines of input.
     * The first line of each testcase contains a single integer, N, the number of days till now.
     * The second line of each testcase contains a string B of length N where Bi represents the status of the ith day.
     * 
     * Output:
     * For each testcase, output the answer in a single line - "YES" if Chef can pass the attendance requirement and "NO" if not.
     * 
     * Constraints:
     * 1 <= T <= 10
     * 1 <= N <= 120
     * 0 <= Bi <= 1
     */
    public static void solveCodeChefATTENDU() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            String B = scn.next();
            long present = 0;
            for (char c : B.toCharArray()) {
                if (c == '1')
                    present++;
            }
            long max_present = (120 - N) + present;
            System.out.println(max_present >= 90 ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Compilers and parsers
     * 
     * Read problems statements in Mandarin Chinese and Russian.
     * Lira is now very keen on compiler development. :)
     * She knows that one of the most important components of a compiler, is its parser.
     * A parser is, in simple terms, a software component that processes text, and checks it's semantic correctness, or, 
     * if you prefer, if the text is properly built.
     * As an example, in declaring and initializing an integer, in C/C++, you can't do something like:
     * int = x ;4 as the semantics of such statement is incorrect, 
     * as we all know that the datatype must precede an identifier and only afterwards should come the equal sign and the initialization value, 
     * so, the corrected statement should be:
     * int x = 4;
     * Today, Lira is concerned with an abstract instruction which is composed of the characters "<" and ">", 
     * which she will use on the design of her language, L++ :D.
     * She is using it as an abstraction for generating XML code Tags in an easier fashion and she understood that, 
     * for an expression to be valid, a "<" symbol must always have a corresponding ">" character somewhere 
     * (not necessary immediately) after it. Moreover, each ">" symbol should correspond to exactly one "<" symbol.
     * So, for instance, the instructions:
     * 
     * <<>>
     * <>
     * <><>
     * 
     * are all valid. While:
     * 
     * >>
     * ><><
     * 
     * are not.
     * 
     * Given some expressions which represent some instructions to be analyzed by Lira's compiler, 
     * you should tell the length of the longest prefix of each of these expressions that is valid, or 0 if there's no such a prefix.
     * 
     * Input:
     * 
     * Input will consist of an integer T denoting the number of test cases to follow.
     * Then, T strings follow, each on a single line, representing a possible expression in L++.
     * 
     * Output:
     * For each expression you should output the length of the longest prefix that is valid or 0 if there's no such a prefix.
     * 
     * Constraints:
     * 1 <= T <= 500
     * 1 <= The length of a single expression <= 10^6 The total size all the input expressions is no more than 5*10^6
     */
    public static void solveCodeChefCOMPILER() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            String S = scn.next();
            boolean valid = true;
            long max_prefix = 0;
            long pos = 0;
            long open = 0;
            for (char c : S.toCharArray()) {
                if (valid) {
                    if (c == '<')
                        open++;
                    else if (c == '>')
                        open--;
                    pos++;
                    if (open < 0)
                        valid = false;
                    else if (open == 0)
                        max_prefix = pos;
                }
            }
            System.out.println(max_prefix);
        }
        scn.close();
    }

    /*
    * Problem: Overspeeding
    *
    * Alice is going for a drive. During her drive, she reached a maximum speed of S km/hr.
    * As per the rules of the government, the speed of the vehicle must not exceed 40 km/hr, 
    * otherwise the person will be fined.
    * You need to tell whether Alice will be fined or not.
    * 
    * Input Format:
    * The only line of input will contain a single integer S - 
    * denoting the maximum speed Alice reached while driving.
    *
    * Output Format:
    * Print YES if Alice will be fined , otherwise print NO.
    * You may print each character of the string in uppercase or lowercase 
    * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
    *
    * Constraints:
    * 1 <= S <= 50
    */
    public static void solveCodeChefCCOV() {
        Scanner scn = new Scanner(System.in);
        long S = scn.nextLong();
        System.out.println(S > 40 ? "YES" : "NO");
        scn.close();
    }

    /*
    * Problem: 50-50 Rule
    *
    * Schools of Chefland use the 50 - 50 rule to grade their students. As per the rule , students are awarded :
    * Z grade, if their attendance is strictly less than 50%.
    * F grade, if they score strictly less than 50% marks, given that their attendance is greater than or equal to 50%.
    * A grade, otherwise.
    * You are given two integers, X and Y, denoting the percentage of attendance and percentage of marks obtained by Alice. 
    * What grade will Alice get?
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of two space-separated integers X and Y - 
    * the percentage of attendance and percentage of marks obtained by Alice.
    *
    * Output Format:
    * For each test case, output on a new line, the grade awarded to Alice.
    * Note that you may print the grade in lowercase or uppercase.
    * 
    * Constraints:
    * 1 <= T <= 10^4 
    * 1 <= X, Y <= 100
    */
    public static void solveCodeChefNGRS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            if (X < 50)
                System.out.println("Z");
            else if (Y < 50)
                System.out.println("F");
            else
                System.out.println("A");
        }
        scn.close();
    }

    /*
    * Problem: Fake Certificate
    *
    * You are given a binary string S of length N, representing the attendance sheet of Alice.
    * For the days when Alice went to school, Si=1, otherwise, Si=0.
    * Alice wanted to increase her attendance. She can perform the following operation at most once :
    * Choose any substring of S where Alice was absent everyday. 
    * She can then give a medical certificate for this period and will be marked present for the whole period.
    * Note that a substring is a contiguous subsegment of a string. 
    * For example, acab is a substring of abacaba, but aa or d aren't substrings of this string. In other words, 
    * substring S[l,r]=S(l)S(l+1)...S(r).
    * You need to find the maximum number of days Alice will be marked present after performing the operation at most once.
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of multiple lines of input.
    * The first line of each test case contains an integer N - the length of the string .
    * The second line of each test case contains a binary string S.
    *
    * Output Format:
    * For each test case, output on a new line the maximum number of days Alice will be marked present after at most one operation.
    *
    * Constraints:
    * 1 <= T <= 10 
    * 1 <= N <= 2*10^5
    * S is a Binary String 
    * The sum of N over all test cases won't exceed 2*10^5.
    */
    public static void solveCodeChefFKMC() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            scn.nextLong();
            String S = scn.next();
            long max_zeroes = 0;
            long zeroes = 0;
            long ones = 0;
            for (char c : S.toCharArray()) {
                if (c == '1') {
                    if (zeroes > max_zeroes)
                        max_zeroes = zeroes;
                    zeroes = 0;
                    ones++;
                }
                else
                    zeroes++;
            }
            if (zeroes > max_zeroes)
                max_zeroes = zeroes;
            System.out.println(ones + max_zeroes);
        }
        scn.close();
    }
    
    /*
     * Problem: AC Please
     * 
     * Chef is feeling the heat this summer and wants to switch on the Air Conditioning all the time,
     * but since he doesn't want to harm the environment much, 
     * he only switches it on when the room temperature is strictly greater than 30 degrees celsius.
     * Given the room temperature, you need to find whether Chef will switch on the air conditioning or not.
     * 
     * Input Format:
     * The only line of input will contain a single integer T - denoting the room temperature.
     * 
     * Output Format:
     * Print YES if Chef will turn the Air Conditioning on, otherwise print NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 50
     */
    public static void solveCodeChefACPLZ() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        System.out.println(T > 30 ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Dice Game 3
     * 
     * Chef is playing a game consisting of N rounds. In each round he rolls a regular six faced dice.
     * He starts with an initial score of 0. Let the number rolled by him in a particular round be X.
     * If this is not the first round and the previous number rolled was 1, 
     * Chef will add 2 * X to his score, otherwise he will add X to his score.
     * For example, if the game has 66 rounds and the rolls are [2, 1, 6, 1, 1, 4] in the given order, 
     * his score will be 2 + 1 + (2 * 6) + 1 + (2 * 1) + (2 * 4) = 26.
     * Find the maximum possible score he can obtain after N rounds.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single integer N the number of rounds.
     * 
     * Output Format:
     * For each test case, output on a new line the maximum score that Chef can get.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= N <= 10^5
     */
    public static void solveCodeChefDICEGAME3() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            System.out.println((N / 2) * 13 + (N % 2) * 6);
        }
        scn.close();
    }

    /*
     * Problem: Pet Store
     * 
     * Alice and Bob went to a pet store. There are N animals in the store where the ith animal is of type Ai.
     * Alice decides to buy some of these N animals. 
     * Bob decides that he will buy all the animals left in the store after Alice has made the purchase.
     * Find out whether it is possible that Alice and Bob end up with exactly same multiset of animals.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains an integer N - the number of animals in the store.
     * The next line contains N space separated integers, denoting the type of each animal.
     * 
     * Output Format:
     * For each test case, output on a new line, YES, 
     * if it is possible that Alice and Bob end up with exactly same multiset of animals and NO otherwise.
     * You may print each character in uppercase or lowercase. 
     * For example, the strings YES, yes, Yes, and yES are considered identical.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N <= 10^5
     * 1 <= Ai <= 100
     * The sum of N over all test cases won't exceed 2 * 10^5.
     */
    public static void solveCodeChefPETSTORE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            HashMap<Long, Long> animals = new HashMap<>();
            while (N-- > 0) {
                long Ai = scn.nextLong();
                animals.put(Ai, animals.getOrDefault(Ai, 0L) + 1);
            }
            boolean odd = false;
            for (long number : animals.values()) {
                if (number % 2 == 1) {
                    odd = true;
                    break;
                }
            }
            System.out.println(odd ? "NO" : "YES");
        }
        scn.close();
    }

    /*
     * Problem: Chef and Fruits
     * 
     * Today is Chef's birthday. His mom has surprised him with truly fruity gifts: 2 fruit baskets. 
     * The first basket contains N apples, and the second one contains M oranges. 
     * Chef likes apples and oranges very much but he likes them equally, and therefore, 
     * wants to have the minimum possible difference between the number of apples and oranges he has. 
     * To do so, he can purchase 1 apple or 1 orange by paying exactly 1 gold coin (that's some expensive fruit, eh?). 
     * Chef can purchase fruits at most K times (as he has only K gold coins in his pocket) to make the difference the minimum possible.
     * Our little Chef is busy in celebrating his birthday to the fullest, and therefore, 
     * he has handed this job to his best friend - you.
     * Can you help him by finding the minimum possible difference he can achieve between the number of apples and orange he owns?
     * 
     * Input:
     * The first line of input contains a single integer T denoting the number of test cases. 
     * The first and only line of each test case contains 3 space separated integers - N, M and K - 
     * denoting the number of apples, number of oranges, and number of gold coins our little Chef has.
     * 
     * Output:
     * For each test case, output the minimum possible difference between the number of apples and oranges that Chef can achieve.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N, M, K <= 100
     */
    public static void solveCodeChefFRUITS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long M = scn.nextLong();
            long K = scn.nextLong();
            long diff = Math.abs(N - M) - K;
            System.out.println(diff <= 0 ? 0 : diff);
        }
        scn.close();
    }

    /*
     * Problem: Maximise Adjacent Sum
     * 
     * You are given an array A of size N (N >= 2).
     * We define f(A) = Sum from {i = 1} to {N - 1} of (Ai + A(i + 1)).
     * Find the maximum value of f(A) you can obtain by rearranging the elements of A in any arbitrary order.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains one integer, N, the size of the array.
     * The next line contains N space-separated integers, A1, A2, ..., AN.
     * 
     * Output Format:
     * For each test case, output on a new line, 
     * the maximum value of f(A) you can obtain by rearranging the elements of A in any arbitrary order.
     * 
     * Constraints_
     * 1 <= T <= 2*10^4
     * 2 <= N <= 10^5
     * 1 <= Ai <= 10^4
     * The sum of N over all test cases does not exceed 10^5.
     */
    public static void solveCodeChefMAXADJSUM() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long min1 = Long.MAX_VALUE;
            long min2 = Long.MAX_VALUE;
            long max = 0;
            while (N-- > 0) {
                long Ai = scn.nextLong();
                if (Ai < min1) {
                    if (min2 != Long.MAX_VALUE)
                        max += (min2 * 2);
                    min2 = min1;
                    min1 = Ai;
                }
                else if (Ai < min2) {
                    if (min2 != Long.MAX_VALUE)
                        max += (min2 * 2);
                    min2 = Ai;
                }
                else
                    max += (Ai * 2);
            }   
            System.out.println(max + min1 + min2);
        }
        scn.close();
    }

    /*
     * Problem: The Tom and Jerry Game!
     * 
     * As usual, Tom and Jerry are fighting. Tom has strength TS and Jerry has strength JS. 
     * You are given TS and your task is to find the number of possible values of JS such that Jerry wins the following game.
     * The game consists of one or more turns. In each turn:
     * If both TS and JS are even, their values get divided by 2 and the game proceeds with the next turn.
     * If both TS and JS are odd, a tie is declared and the game ends.
     * If TS is even and JS is odd, Tom wins the game.
     * If TS is odd and JS is even, Jerry wins the game.
     * Find the number of possible initial values of JS such that 1 <= JS <= TS, there is no tie and Jerry wins the game.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first and only line of each test case contains a single integer TS.
     * 
     * Output:
     * For each test case, print a single line containing one integer - the number of values of JS such that Jerry wins the game.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= TS <= 10^18
     */
    public static void solveCodeChefEOEO() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long TS = scn.nextLong();
            long TSaux = TS;
            long pow2 = 1;
            while (TSaux % 2 == 0) {
                TSaux /= 2;
                pow2 *= 2;
            }
            pow2 *= 2;
            System.out.println(TS / pow2);
        }
        scn.close();
    }

    /*
     * Problem: The Ides of March
     * 
     * Beware the ides of March.
     * Julius Caesar was warned by a soothsayer to be wary of the ides of March - namely, the 15-th of March.
     * Today is the N-th day of March. Your task is to tell Caesar whether it is the ides of March, 
     * so that he can take extra safety precautions if necessary.
     * 
     * Input Format:
     * The only line of input will contain a single integer N, today's date in March.
     * 
     * Output Format:
     * Print "Yes" if today is the ides of March, and "No" otherwise (without quotes).
     * Each letter of the output may be printed in either uppercase or lowercase, i.e, 
     * the strings NO, no, nO, and No will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= N <= 15
     */
    public static void solveCodeChefIDESM() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong();
        System.out.println(N == 15 ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Extreme Basketball
     * 
     * Alice and Bob are playing a game of basketball against each other, one-versus-one.
     * Currently, Alice has A points, and Bob has B points.
     * 
     * Each shot of a player can score either 2 or 3 points.
     * Alice isn't just out to win - she wants to win in dominant fashion.
     * Alice believes that her win is dominant if she ends the game with at least 1010 points more than Bob.
     * If Alice is able to prevent Bob from scoring any more points, 
     * what's the minimum number of shots she further needs to get a dominant victory?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single line of input, 
     * containing two space-separated integers A and B - the initial scores of Alice and Bob.
     * 
     * Output Format:
     * For each test case, output on a new line the minimum number of shots Alice needs to win a dominant victory.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 2 <= A, B <= 100
     */
    public static void solveCodeChefBBWIN() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long A = scn.nextLong();
            long B = scn.nextLong();
            long diff = 10 + B - A;
            System.out.println(diff > 0 ? (diff + 2) / 3 : 0);
        }
        scn.close();
    }

    /*
     * Problem: Reach 5 Star
     * 
     * Chef loves giving contests on Codechef. Chef wants to become 5 star rated. Currently his rating on Codechef is X.
     * After today's contest, his rating will increase by Y. Note that Y can be negative which means that Chef's rating will decrease.
     * Find whether Chef will become 5 star rated after today's contest.
     * Chef will be considered 55 star rated if his rating is greater than or equal to 2000.
     * 
     * Input Format:
     * The first line contains two space-separated integers X and Y - 
     * chef's initial rating and the amount by which his rating will increase, respectively.
     * 
     * Output Format:
     * Output YES if chef will become 55 star rated, and NO otherwise.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 0 <= X < 2000
     * -2000 <= Y < 2000
     * 
     */
    public static void solveCodeChefR5S() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println(X + Y >= 2000 ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Moody Chef
     * 
     * Chef loves integers that are in the range of l to r. 
     * More formally, Chef loves an integer x if it satisfies the condition l <= x <= r.
     * Chef has an array A of length N. Currently, the happiness of Chef is 0.
     * He will examine the elements of the array in order from index 1 to N.
     * If he finds an integer that he loves, his happiness will increase by 1; otherwise, his happiness will decrease by 1.
     * Find the values of maximum and minimum happiness Chef will experience while going through the array.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains three integers N, l and r - 
     * the number of elements in the array, the least number that chef loves, the biggest number that chef loves.
     * The next contains N space-separated integers, where the ith integer denotes Ai.
     * 
     * Output Format:
     * For each test case, output on a new line, 
     * two space-separated integers denoting the maximum and minimum happiness Chef will experience.
     * 
     * Constraints:
     * 1 <= T <= 2 * 10^5
     * 1 <= N <= 2 * 10^5
     * 1 <= l <= r <= 2 * 10^5
     * 1 <= Ai <= 2 * 10^5
     * The sum of N over all test cases won't exceed 2.5 * 10^5.
     */
    public static void solveCodeChefMOOCHEF() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long l = scn.nextLong();
            long r = scn.nextLong();
            long happyness = 0;
            long max_happyness = 0;
            long min_happyness = 0;
            while (N-- > 0) {
                long Ai = scn.nextLong();
                if (l <= Ai && Ai <= r)
                    happyness += 1;
                else
                    happyness -= 1;
                max_happyness = Math.max(max_happyness, happyness);
                min_happyness = Math.min(min_happyness, happyness);
            }
            System.out.println(max_happyness + " " + min_happyness);
        }
        scn.close();
    }

    /*
     * Problem: New Piece
     * 
     * Chef's favorite game is chess. Today, he invented a new piece and wants to see its strengths.
     * From a cell (X, Y), the new piece can move to any cell of the chessboard such that its color is different from that of (X, Y).
     * The new piece is currently located at cell (A, B). 
     * Chef wants to calculate the minimum number of steps required to move it to (P, Q).
     * 
     * Note: A chessboard is an 8 x 8 square board, where the cell at the intersection of the ith row and jth column is denoted 
     * (i, j). Cell (i, j) is colored white if i + j is even and black if i+j is odd.
     * 
     * Input Format:
     * 
     * The first line of input contains a single integer T denoting the number of test cases. The description of the test cases follows.
     * Each test case consists of a single line of input, containing four space-separated integers A, B, P, Q.
     * 
     * Output Format:
     * For each test case, output a single line containing one integer - 
     * the minimum number of moves taken by the new piece to reach (P, Q) from (A, B).
     * 
     * Constraints:
     * 1 <= T <= 5000
     * 1 <= A,B,P,Q <= 8
     */
    public static void solveCodeChefNEWPIECE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long A = scn.nextLong();
            long B = scn.nextLong();
            long P = scn.nextLong();
            long Q = scn.nextLong();
            if (A == P && B == Q)
                System.out.println(0);
            else if ((A + B) % 2 != (P + Q) % 2)
                System.out.println(1);
            else
                System.out.println(2);
        }
        scn.close();
    }

    /*
     * Problem: Cleaning Up
     * 
     * After a long and successful day of preparing food for the banquet, it is time to clean up. 
     * There is a list of n jobs to do before the kitchen can be closed for the night. 
     * These jobs are indexed from 1 to n.
     * Most of the cooks have already left and only the Chef and his assistant are left to clean up. 
     * Thankfully, some of the cooks took care of some of the jobs before they left so only a subset of the n jobs remain. 
     * The Chef and his assistant divide up the remaining jobs in the following manner. 
     * The Chef takes the unfinished job with least index, 
     * the assistant takes the unfinished job with the second least index, 
     * the Chef takes the unfinished job with the third least index, etc. 
     * That is, if the unfinished jobs were listed in increasing order of their index 
     * then the Chef would take every other one starting with the first job in the list 
     * and the assistant would take every other one starting with the second job on in the list.
     * The cooks logged which jobs they finished before they left. 
     * Unfortunately, these jobs were not recorded in any particular order. 
     * Given an unsorted list of finished jobs, 
     * you are to determine which jobs the Chef must complete 
     * and which jobs his assitant must complete before closing the kitchen for the evening.
     * 
     * Input:
     * The first line contains a single integer T <= 50 indicating the number of test cases to follow. 
     * Each test case consists of two lines. 
     * The first line contains two numbers n, m satisfying 1 <= m <= n <= 1000. 
     * Here, n is the total number of jobs that must be completed before closing 
     * and m is the number of jobs that have already been completed. 
     * The second line contains a list of m distinct integers between 1 and n. 
     * These are the indices of the jobs that have already been completed. 
     * Consecutive integers are separated by a single space.
     * 
     * Output:
     * The output for each test case consists of two lines. 
     * The first line is a list of the indices of the jobs assigned to the Chef.
     * The second line is a list of the indices of the jobs assigned to his assistant.
     * Both lists must appear in increasing order of indices and consecutive integers should be separated by a single space.
     * If either the Chef or the assistant is not assigned any jobs, 
     * then their corresponding line should be blank -1.
     */
    public static void solveCodeChefCLEANUP() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long m = scn.nextLong();
            long n = scn.nextLong();
            HashMap<Long, Boolean> jobs = new HashMap<>();
            while (n-- > 0)
                jobs.put(scn.nextLong(), true);
            String chef = "";
            String assistant = "";
            long j = 0;
            for (long i = 1; i < m + 1; i++) {
                if (!jobs.containsKey(i)) {
                    if (j % 2 == 0)
                        chef += i + " ";
                    else
                        assistant += i + " ";
                    j++; 
                }
            }
            System.out.println(chef.length() > 0 ? chef.substring(0, chef.length() - 1) : "-1");
            System.out.println(assistant.length() > 0 ? assistant.substring(0, assistant.length() - 1) : "-1");
        }
        scn.close();
    }

    /*
     * Problem: Football Training
     * 
     * As a football trainer, you have several players training under you. 
     * Each of these players are fans of either Leo or Ronald, but not both.
     * X of the players are fans of Leo, and want a free kick session to be carried out.
     * Y of the players are fans of Ronald, and want a penalty session to be carried out.
     * Note that each player is a fan of exactly one of Leo or Ronald, so there are X + Y players in total.
     * It'd be nice if players are actually interested in their training, 
     * so you decide to hold whichever type of training has more people interested in it.
     * Given X and Y, which type of training session will you hold?
     * It is guaranteed that X != Y.
     * 
     * Input Format:
     * The first and only line of input contains two space-separated integers X and Y -
     * which denote the number of Leo's fans and the number of Ronald's fans, respectively.
     * 
     * Output Format:
     * For each test case, output on a new line which session will be carried out: 
     * "FREEKICK" if it'll be a free kick session, and "PENALTY" if it'll be a penalty session (without quotes).
     * Each character of the output may be printed in either uppercase or lowercase, 
     * i.e, if the answer is PENALTY, the strings penalty, PENALTY, pEnALty, and so on will all be accepted.
     * 
     * Constraints:
     * 0 <= X <= 100
     * 0 <= Y <= 100
     * X != Y
     */
    public static void solveCodeChefMESSI() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println(X > Y ? "FREEKICK" : "PENALTY");
        scn.close();
    }

    /*
     * Problem: Pep Bidding
     * 
     * Pep is known for his golden bids on football matches. Surprisingly, he has a rather simple strategy!
     * Team A and team P are playing against each other, and each of them have N players.
     * For each i from 1 to N,
     * Pep believes that the ith player on team A has an attack power of attAi, and a defense power of defAi.
     * Similarly, the ith player on team P has an attack power of attPi, and a defense power of defPi.
     * The total attack power of a team is the sum of the attack powers of all of its N players.
     * The total defense power is defined similarly.
     * If the total attack power of one team is strictly greater than the total attack power of the other team, 
     * and its total defense power is strictly greater than the total defense power of the other team, Pep bids for that team.
     * Otherwise, he'll bid for a draw. Can you tell what Pep will bid on?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of five lines of input.
     * The first line of each test case contains a single integer N, the number of players on both teams.
     * The second line contains N space-separated integers attA1, attA2, ..., attAN - the elements of attA.
     * The third line contains N space-separated integers defA1, defA2, ..., defAN - the elements of defA.
     * The fourth line contains N space-separated integers attP1, attP2, ..., attPN - the elements of attP.
     * The fifth line contains N space-separated integers defP1, defP2, ..., defPN - the elements of defPdefP.
     * 
     * Output Format:
     * For each test case, output on a new line a string representing what Pep bids for: either "A", "P", or "DRAW" (without quotes).
     * Each letter of the output may be printed in either lowercase or uppercase, 
     * i.e, the strings DRAW, draw, dRaW, and so on will be considered equivalent.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 2000
     * 0 <= attAi <= 1000
     * 0 <= defAi <= 1000
     * 0 <= attPi <= 1000
     * 0 <= defPi <= 1000
     * The sum of N over all test cases won't exceed 2000.
     */
    public static void solveCodeChefBID() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long attA = 0;
            for (long i = 1; i <= N; i++)
                attA += scn.nextLong();
            long defA = 0;
            for (long i = 1; i <= N; i++)
                defA += scn.nextLong();
            long attP = 0;
            for (long i = 1; i <= N; i++)
                attP += scn.nextLong();
            long defP = 0;
            for (long i = 1; i <= N; i++)
                defP += scn.nextLong();
            if (attA > attP && defA > defP)
                System.out.println("A");
            else if (attP > attA && defP > defA)
                System.out.println("P");
            else
                System.out.println("DRAW");
        }
        scn.close();
    }

    /*
     * Problem: Giant Wheel
     * 
     * Alice is visiting the amusement park!
     * Alice's height is X centimeters.
     * The park stipulates that the minimum height necessary to get on the giant wheel is 60 centimeters.
     * Will Alice be able to ride on the giant wheel?
     * 
     * Input Format:
     * The only line of input contains a single integer X - Alice's height.
     * 
     * Output Format:
     * Output the answer on a single line: "Yes" if Alice can ride the giant wheel, and "No" otherwise (without quotes).
     * Each letter of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings NO, no, No, and nO will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= X <= 100
     */
    public static void solveCodeChefGIANT() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        System.out.println(X >= 60 ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Swapping Marks Digits
     * 
     * Alice scored A marks and Bob scored B marks in an exam. Both A and B are two-digit numbers that don't contain the digit 0.
     * Alice wants her marks to display higher than Bob's.
     * For this, she can reverse her score and/or Bob's score.
     * Is there a way for her score to display higher than Bob's?
     * For example, if A = 37 and B = 83, Alice can reverse her score to make it 73, 
     * and also reverse Bob's score to make it 38, and now her score is higher.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case contains two space-separated integers A and B -
     * the marks obtained by Alice and Bob, respectively.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: 
     * "Yes" if Alice can change her score to display higher than Bob's, and "No" otherwise (without quotes).
     * Each letter of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings No, no, NO, and nO will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 11 <= A, B < 100
     * A and B don't contain 0 in their decimal representation.
     */
    public static void solveCodeChefSWMA() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long A = scn.nextLong();
            long B = scn.nextLong();
            long Af = (A % 10) * 10 + A / 10;
            long Bf = (B % 10) * 10 + B / 10;
            if (A > B || A > Bf || Af > B || Af > Bf)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        scn.close();
    }

    /*
     * Problem: Candy Love
     * 
     * Sammy and Simmy love candies and frequently visit the local candy shop. 
     * Sammy and Simmy have bought N candy packs. 
     * Packet i contains Ai​ candies. Sammy being the elder one is happy only if she has strictly more candies than Simmy. 
     * However Simmy, the more sensible one, is happy only if the difference between their number of candies is not more than 1.
     * The shopkeeper, being a generous lady, agrees to help Sammy and Simmy by distributing the candies among them in a way that makes both of them happy. 
     * The shopkeeper can open the packs and distribute the candies even within a single pack to different people.
     * 
     * Input:
     * The first line will contain T, the number of testcases.
     * The first line of every test case will contain N, the number of candy packs.
     * The next line has N integers, the ithith​ integer denoting Ai​, the number of candies in the ith​ pack.
     * 
     * Output: 
     * Output "YES" if its possible for the shopkeeper to make both the sisters happy otherwise output "NO".
     * 
     * Constraints:
     * 1 <= T 10^3
     * 1 <= N <= 10^3
     * 1 <= Ai <= 100
     */
    public static void solveCodeChefCNDLOVE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long total = 0;
            while (N-- > 0)
                total += scn.nextLong();
            System.out.println((total % 2 == 1) ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Alternating subarray prefix
     * 
     * There's an array A consisting of N non-zero integers A1..N. 
     * A subarray of A is called alternating if any two adjacent elements in it have different signs 
     * (i.e. one of them should be negative and the other should be positive).
     * For each x from 1 to N, compute the length of the longest alternating subarray that starts at x - 
     * that is, a subarray Ax..y for the maximum possible y >= x. The length of such a subarray is y - x + 1.
     * 
     * Input:
     * The first line of the input contains an integer T - the number of test cases.
     * The first line of each test case contains N.
     * The following line contains N space-separated integers A1..N.
     * 
     * Output:
     * For each test case, output one line with N space-separated integers - 
     * the lengths of the longest alternating subarray starting at x, for each x from 1 to N.
     * 
     * Constraints:
     * 1 <= T <= 10
     * 1 <= N <= 10^5
     * -10^9 <= Ai <= 10^9
     */
    public static void solveCodeChefALTARAY() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long last_sign = 0;
            long subarray = 0;
            while (N-- > 0) {
                long Ai = scn.nextLong();
                if ((Ai > 0 && last_sign == 1) || (Ai < 0 && last_sign == -1)) {
                    while (subarray-- > 0)
                        System.out.print((subarray + 1) + " ");
                    subarray = 1;
                }
                else
                    subarray++;
                last_sign = Ai > 0 ? 1 : -1;
            }
            while (subarray-- > 1)
                System.out.print((subarray + 1) + " ");
            System.out.println(subarray + 1);
        }
        scn.close();
    }

    /*
     * Problem: Easy Permutation
     * 
     * You are given an integer N.
     * Construct any permutation A of N integers such that the value LCM(1 + A1 , 2 + A2, ..., N + AN) is minimised.
     * Note:
     * LCM denotes the least common multiple of the integers.
     * A permutation of N integers contains all integers from 1 to N exactly once.
     * 
     * Input Format:
     * First line will contain T, number of test cases. Then the test cases follow.
     * Each test case contains a single line of input, one integer N.
     * 
     * Output Format:
     * For each test case, output a permutation that minimises the value LCM(1 + A1 , 2 + A2, ..., N + AN).
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 2 <= N <= 1000
     */
    public static void solveCodeChefEASYPERM() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong() + 1;
            while (N-- > 2)
                System.out.print(N + " ");
            System.out.println(N);
        }
        scn.close();
    }
    
    /*
     * Problem: Ballon d'Or
     * 
     * Leo has already won the Ballon d'Or 88 times, so he is really impressed with it (is he?).
     * Leo has an array A containing N integers. Each element of this array is either 1 or 2.
     * He wants to figure out if the product of all the elements of the array can be written as an 8-th power of some integer, i.e, k^8 for some integer k.
     * Print Yes if it can and No if it can't.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * The first line of each test case contains a single integer N - the number of integers in Leo's array.
     * The second line contains N space-separated integers A1, A2, ..., AN, denoting the elements of array A.
     * 
     * Output Format:
     * For each test case, output on a new line "YES" if a valid kk exists, and "No" otherwise (without quotes).
     * Each letter of the output may be printed in either uppercase or lowercase, i.e, the strings no, No, nO, and NO will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= N <= 2*10^5
     * 1 <= Ai <= 2
     * The sum of N over all test cases won't exceed 2*10^5.
     */
    public static void solveCodeChefBLNDOR() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long twos = 0;
            while (N-- > 0) 
                twos += (scn.nextLong() - 1);
            System.out.println((twos % 8 == 0) ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Remaining Neighborhoods
     * 
     * As elections approach the country of Chefland, Chef's campaign is in full swing.
     * Chef's city has exactly 100100 neighborhoods.
     * Chef has already visited N of them to canvass for votes, and he won't stop till he's visited every last one of them!
     * How many more neighborhoods does Chef need to visit?
     * 
     * Input Format:
     * The only line of input will contain a single integer N, the number of neighborhoods Chef has already visited.
     * 
     * Output Format:
     * Print a single integer: the number of neighborhoods Chef still needs to visit.
     * 
     * Constraints:
     * 0 <= N <= 100
     */
    public static void solveCodeChefNEIREM() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong();
        System.out.println(100 - N);
        scn.close();
    }

    /*
     * Problem: Gotta Catch Em All
     * 
     * You're playing your favorite video game: Pekómon!
     * The objective of the game is, of course, to "Catch Them All".
     * There are N different Pekómon in the game. The ith of them has a catching difficulty of Ai.
     * To catch these Pekómon, you must use Pekóballs. There are two types of Pekóballs available to you:
     * Normal Pekóballs, which cost X coins each.
     * You need to throw exactly Ai Normal Pekóballs to catch a Pekómon whose catching difficulty is Ai.
     * Master Pekóballs, which cost Y coins each.
     * You need to throw only 1 Master Pekóball to catch any Pekómon, no matter what its catching difficulty is.
     * Find the minimum number of coins you need to spend on buying Pekóballs, so that you can catch all N Pekómon.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * The first line of each test case contains three space-separated integers N, X, and Y -
     * the number of Pekómon, the cost of a Normal Pekóball, and the cost of a Master Pekóball.
     * The second line contains N space-separated integers A1, A2, ..., AN - the catching difficulties of the Pekómon.
     * 
     * Output Format:
     * For each test case, output on a new line the minimum number of coins you need to spend on buying Pekóballs, 
     * in order to catch all N Pekómon.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 1 <= X <= Y <= 100
     * 1 <= Ai <= 100
     */
    public static void solveCodeChefGCEA() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long X = scn.nextLong();
            long Y = scn.nextLong();
            long total = 0;
            while (N-- > 0) {
                long Ai = scn.nextLong();
                if (X * Ai < Y)
                    total += (X * Ai);
                else
                    total += Y;
            }
            System.out.println(total);
        }
        scn.close();
    }

    /*
     * Problem: Dominant Element
     * 
     * You are given an array A of length N. 
     * An element X is said to be dominant if the frequency of X in A 
     * is strictly greater than the frequency of any other element in the A.
     * For example, if A = [2, 1, 4, 4, 4] then 
     * 4 is a dominant element since its frequency is higher than the frequency of any other element in A.
     * Find if there exists any dominant element in A.
     * 
     * Input Format:
     * The first line of input contains a single integer T - the number of test cases. Then the test cases follow.
     * The first line of each test case contains an integer N - the size of the array A.
     * The second line of each test case contains N space-separated integers A1, A2, ..., AN denoting the array A.
     * 
     * Output Format:
     * For each test case, output YES if there exists any dominant element in A. Otherwise, output NO.
     * You may print each character of YES and NO in uppercase or lowercase (for example, yes, yEs, Yes will be considered identical).
     * 
     * Constraints:
     * 1 <= T <= 500
     * 1 <= N <= 1000
     * 1 <= Ai <= N
     */
    public static void solveCodeChefDOMINANT2() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            HashMap<Long, Long> hashMap = new HashMap<>();
            long N = scn.nextLong();
            long max = 0;
            long occurences = 0;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                hashMap.put(Ai, hashMap.getOrDefault(Ai, 0L) + 1);
            }
            for (Map.Entry<Long, Long> entry : hashMap.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    occurences = 1;
                }
                else if (entry.getValue() == max)
                    occurences++;
            }
            System.out.println(occurences == 1 ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Testing Robot
     * 
     * Chef has bought a new robot, which will be used for delivering dishes to his customers. 
     * He started testing the robot by letting it move on a line.
     * Initially, the robot is placed at the coordinate x = X. 
     * Then, it should execute a sequence of N commands, described by a string S with length N. 
     * Each character of this string is either 'L' or 'R', 
     * denoting that the robot should walk one step to the left (decreasing x by 1) or to the right (increasing x by 1), respectively.
     * How many distinct points are visited by the robot when it has executed all the commands? 
     * A point p is visited by the robot if p is an integer and the robot's position before or after executing some command is x = p.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first line of each test case contains two space-separated integers N and X.
     * The second line contains a single string S with length N.
     * 
     * Output:
     * For each test case, print a single line containing one integer - the number of points visited by the robot.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * |X| <= 1000000
     * S contains only characters 'L' and 'R'
     */
    public static void solveCodeChefTSTROBOT() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long X = scn.nextLong();
            String S = scn.next();
            long maxX = X;
            long minX = X;
            for (int i = 0; i < N; i++) {
                if (S.charAt(i) == 'L')
                    X--;
                else
                    X++;
                maxX = Math.max(maxX, X);
                minX = Math.min(minX, X);
            }
            System.out.println(maxX - minX + 1);
        }
        scn.close();
    }

    /*
     * Problem: ICE CREAM
     * 
     * Chef wants to buy 2 ice creams, each costing X dollars, for him and Chefina.
     * However, he only has Y dollars with him. Will he be able to buy 2 ice creams?
     * 
     * Input Format:
     * The only line of input will contain 2 space-separated integers X and Y, the price of each ice cream and the money Chef has.
     * 
     * Output Format:
     * Print YES if Chef will be able to buy two ice creams, otherwise print NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= X, Y <= 100
     */
    public static void solveCodeChefICE_CREAM() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println((Y >= X * 2) ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Change Please
     * 
     * You just travelled in a cab and you owe the driver X dollars.
     * However, you only have a 100 dollar bill, and the driver only has 10 dollar bills with which he can pay you back.
     * You hand the 100 dollar bill to the driver. Find the maximum amount which the driver can pay back without giving more than he owes.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single integer X, the amount you owe the driver.
     * 
     * Output Format:
     * For each test case, output on a new line, the maximum amount which driver can pay back without giving more than he owes.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= X <= 100
     */
    public static void solveCodeChefCHANGE_PLZ() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            System.out.println(100 - X - (100 - X) % 10);
        }
        scn.close();
    }

    /*
     * Problem: Three Boxes
     * 
     * Chef has 3 boxes of sizes A, B, and C respectively. 
     * He puts the boxes in bags of size D (A <= B <= C <= D). 
     * Find the minimum number of bags Chef needs so that he can put each box in a bag. 
     * A bag can contain more than one box if the sum of sizes of boxes in the bag does not exceed the size of the bag.
     * 
     * Input Format:
     * The first line contains T denoting the number of test cases. Then the test cases follow.
     * Each test case contains four integers A, B, C, and D on a single line denoting the sizes of the boxes and bags.
     * 
     * Output Format:
     * For each test case, output on a single line the minimum number of bags Chef needs.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= A <= B <= C <= D <= 100
     */
    public static void solveCodeChefTHREEBOX() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long A = scn.nextLong();
            long B = scn.nextLong();
            long C = scn.nextLong();
            long D = scn.nextLong();
            if (D >= A + B + C)
                System.out.println(1);
            else if (D >= A + B || D >= B + C)
                System.out.println(2);
            else
                System.out.println(3);
        }
        scn.close();
    }

    /*
     * Problem: Change It
     * 
     * You are given a sequence A1, A2, ..., AN. You want all the elements of the sequence to be equal. 
     * In order to achieve that, you may perform zero or more moves. 
     * In each move, you must choose an index i (1 <= i <= N), then choose j = i - 1 or j = i + 1 
     * (it is not allowed to choose j = 0 or j = N + 1) and change the value of Ai to Aj - 
     * in other words, you should replace the value of one element of the sequence by one of its adjacent elements.
     * What is the minimum number of moves you need to make in order to make all the elements of the sequence equal?
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first line of each test case contains a single integer N.
     * The second line contains N space-separated integers A1, A2, ..., AN.
     * 
     * Output:
     * For each test case, print a single line containing one integer - the minimum required number of moves.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 1 <= Ai <= 100 for each valid i
     */
    public static void solveCodeChefCHNGIT() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            HashMap<Long, Long> hashMap = new HashMap<>();
            long N = scn.nextLong();
            long max = 0;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                long newAi = hashMap.getOrDefault(Ai, 0L) + 1;
                hashMap.put(Ai, newAi);
                if (newAi > max)
                    max = newAi;
            }
            System.out.println(N - max);
        }
        scn.close();
    }

    /*
     * Problem: Golf
     * 
     * It's a lockdown. You’re bored in your house and are playing golf in the hallway.
     * The hallway has N + 2 tiles numbered from 0 to N+1 from left to right. 
     * There is a hole on tile number x. You hit the ball standing on tile 0. 
     * When you hit the ball, it bounces at lengths of k, 
     * i.e. the tiles covered by it are 0, k, 2k, ..., and so on until the ball passes tile N + 1.
     * If the ball doesn't enter the hole in the first trial, you try again but this time standing on the tile N + 1. 
     * When you hit the ball, it bounces at lengths of k, 
     * i.e. the tiles covered by it are (N + 1), (N + 1 - k), (N + 1 - 2k), ..., and so on until the ball passes tile 0.
     * Find if the ball will enter the hole, either in its forward journey or backward journey.
     * Note: The input and output of this problem are large, so prefer using fast input/output methods.
     * 
     * Input:
     * The first line contains an integer T, the number of test cases. Then the test cases follow.
     * The only line of each test case contains three integers N, x, k.
     * 
     * Output:
     * Output in a single line, the answer, 
     * which should be "YES" if the ball enters the hole either in the forward or backward journey and "NO" if not.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings "yEs", "yes", "Yes" and "YES" will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= x, k <= N <= 10^9
     */
    public static void solveCodeChefLKDNGOLF() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            long x = scn.nextLong();
            long k = scn.nextLong();
            if (x % k == 0 || (N + 1 - x) % k == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        scn.close();
    }

    /*
     * Problem: Devouring Donuts
     * 
     * Chef baked a full tray of donuts, but couldn't resist and ate them all!
     * The tray had X donuts, and each donut contains Y calories.
     * How many calories did Chef consume in total?
     * 
     * Input Format:
     * The only line of input contains two space-separated integers X and Y - the number of donuts and the calorie count of each one.
     * 
     * Output Format:
     * Print a single integer: the total number of calories consumed by Chef.
     * 
     * Constraints:
     * 1 <= X <= 10
     * 200 <= Y <= 300
     */
    public static void solveCodeChefDEVDON() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println(Y * X);
        scn.close();
    }

    /*
     * Problem: Legs on a Farm
     * 
     * After a long and fulfilling career, Chef has decided to retire to a farm out in the countryside.
     * This farm has several cows and chickens, but Chef doesn't know exactly how many of each there are - 
     * he can only see that there are N legs in total across all the animals.
     * Note that each cow has 4 legs and each chicken has 2 legs, and it is guaranteed that N is even.
     * With N legs in total, what's the minimum possible number of animals that can be present on the farm?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case will contain a single integer N - the number of legs.
     * 
     * Output Format:
     * For each test case, output on a new line the minimum possible number of animals that can be present on the farm.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 2 <= N <= 2000
     * N is even.
     */
    public static void solveCodeChefFARMLEGS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            System.out.println(N / 4 + ((N % 4) / 2));
        }
        scn.close();
    }

    /*
    * Problem: Morning Run
    * 
    * Chef wants to run at least 10001000 meters to reach his fitness goal.
    * There's a rectangular park nearby, with a length of X meters and a width of Y meters.
    * Can Chef complete his goal by running one loop around the park? 
    * (Loop meaning running the entire path around the edge of the park.)
    *
    * Input Format:
    * The only line of input will contain 2 space-separated integers X and Y, 
    * the length and the width of the rectangular park.
    *
    * Output Format:
    * Print "YES" if Chef will be able to complete his fitness goal, otherwise print "NO" (without quotes).
    * You may print each character of the output in either uppercase or lowercase 
    * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
    *
    * Constraints:
    * 1 <= X, Y <= 1000
    */
    public static void solveCodeChefMORNINGRUN() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println((2 * X + 2 * Y) >= 1000 ? "YES" : "NO");
        scn.close();
    }

    /*
    * Problem: Money Double
    *
    * Chef's bank gives him a unique offer - 
    * at the end of each year, they offer Chef to either add 1000 rupees to his bank account, 
    * or double the amount stored in his bank account.
    * Chef initially has X rupees in his account. 
    * What is the maximum amount of money that Chef can accumulate after Y years?
    * 
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * The first and only line of each test case contains 2 space-separated integers X and Y, as described in the statement.
    *
    * Output Format:
    * For each test case, output on a new line one integer: 
    * the maximum amount of money which Chef can accumulate after Y years.
    *
    * Constraints:
    * 1 <= T <= 10^5
    * 1 <= X <= 10^5
    * 1 <= Y <= 10
    */
    public static void solveCodeChefMONEYDOUBLE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            while (Y-- > 0) {
                if (X * 2 > X  + 1000)
                    X *= 2;
                else
                    X += 1000;
            }
            System.out.println(X);
        }
        scn.close();
    }

    /*
    * Problem: Table Strength
    *
    * You have N table legs, of different strengths.
    * Pillar i can bear a weight of Wi​, and will break if it has to bear a larger weight.
    * You'd like to construct a table using some non-empty subset of these table legs.
    * When you place a weight on a table, its load is equally distributed to each of its legs.
    * For example, if you build a table with 4 legs, and place a weight of 18 on it, each leg will need to bear a weight of 18 / 4 = 4,5.
    * So for instance, a table whose legs have strengths [4,4,5,6] will not be able to bear this weight (the two legs with strength 4 will break), 
    * whereas a table with leg strengths [5,6,6,8] will be able to bear it.
    * Find the maximum possible weight that a table built out of some of these N legs can bear, without any of the legs breaking.
    * It can be proved that this maximum weight is always an integer.
    * Note: Subsets need not be contiguous: for example, [1,3] is a subset of [1,4,3,2].
    *
    * Input Format:
    * The first line of input will contain a single integer T, denoting the number of test cases.
    * Each test case consists of two lines of input.
    * -> The first line of each test case contains a single integer N, the number of table legs you have.
    * -> The second line of each test case contains nn space-separated integers W1, W2, ..., WN​, denoting the weight each leg can withstand.
    *
    * Output Format:
    * For each test case, output on a new line the maximum weight the table can withstand by using some non-empty subset of table legs.
    *
    * Constraints:
    * 1 <= T <= 2 * 10^4
    * 1 <= n <= 2 * 10^5
    * 1 <= w[i] <= 10^4
    * it is guaranteed that the sum of n over all test cases won't exceed 2 * 10^5.
    */
    public static void solveCodeChefSTRONGTABLE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            ArrayList<Long> strengths = new ArrayList<>();
            long N = scn.nextLong();
            for (int i = 0; i < N; i++)
                strengths.add(scn.nextLong());
            Collections.sort(strengths);
            Collections.reverse(strengths);
            long sum = 0;
            long max = 0;
            for (long i = 0; i < N; i++) {
                long Wi = strengths.get((int)i);
                sum += Wi;
                if (Wi * (i + 1) < sum)
                    max = Math.max(max, Wi * (i + 1));
                else
                    max = Wi * (i + 1);
            }
            System.out.println(max);
        }
        scn.close();
    }

    /*
    * Problem: Equal Card Game
    *
    * Alice has a standard deck of 52 cards. She wants to play a card game with K − 1 of her friends. 
    * This particular game requires each person to have an equal number of cards, 
    * so Alice needs to discard a certain number of cards from her deck 
    * so that she can equally distribute the remaining cards amongst her and her friends.
    * Find the minimum number of cards Alice has to discard such that she can play the game.
    * Note: It doesn't matter which person gets which card. 
    * The only thing that matters is that each person should have an equal number of cards.
    *
    * Input Format:
    * The first line of input contains a single integer T, denoting the number of test cases. 
    * The description of T test cases follows.
    * Each test case consists of a single line of input, containing a single integer K -
    * the number of people playing the game (including Alice).
    *
    * Output Format:
    * For each test case, output in a single line the minimum number of cards Alice has to discard from her deck 
    * such that she can play the game with her friends.
    *
    * Constraints:
    * 1 <= T <= 51
    * 2 <= K <= 52
    */
    public static void solveCodeChefEQCARDGAME() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long K = scn.nextLong();
            System.out.println(52 % K);
        }
        scn.close();
    }

    /*
     * Problem: Covid and Theatre Tickets
     * 
     * Mr. Chef is the manager of the Code cinemas and after a long break, 
     * the theatres are now open to the public again. To compensate for the loss in revenue due to Covid-19, 
     * Mr. Chef wants to maximize the profits for every show from now on and at the same time follow the guidelines set the by government.
     * The guidelines are:
     * If two people are seated in the same row, there must be at least one empty seat between them.
     * If two people are seated in different rows, there must be at least one completely empty row between them. 
     * That is, if there are people seated in rows i and j where i < j, 
     * there must be some row kk such that i < k < j and nobody is seated in row k.
     * Given the information about the number of rows and the number of seats in each row, 
     * find the maximum number of tickets Mr. Chef can sell.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases. 
     * The description of T test cases follows.
     * Each test case consists of a single line of input containing two space-separated integers N, M -
     * the number of rows and the number of seats in each row, respectively.
     * 
     * Output Format:
     * For each test case, output a single line containing one integer – the maximum number of tickets Mr. Chef can sell.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N, M <= 100
     */
    public static void solveCodeChefCOVID_19() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long M = scn.nextLong();
            System.out.println((N / 2 + N % 2) * (M / 2 + M % 2));
        }
        scn.close();
    }

    /*
     * Problem: The Minimum Number Of Moves
     * 
     * Little chief has his own restaurant in the city. 
     * There are N workers there. Each worker has his own salary. 
     * The salary of the i-th worker equals to Wi (i = 1, 2, ..., N). 
     * Once, chief decided to equalize all workers, that is, he wants to make salaries of all workers to be equal. 
     * But for this goal he can use only one operation: choose some worker and increase by 1 salary of each worker,
     * except the salary of the chosen worker. In other words, the chosen worker is the loser, 
     * who will be the only worker, whose salary will be not increased during this particular operation. 
     * But loser-worker can be different for different operations, of course. 
     * Chief can use this operation as many times as he wants. 
     * But he is a busy man. That's why he wants to minimize the total number of operations needed to equalize all workers. 
     * Your task is to find this number.
     * 
     * Input:
     * The first line of the input contains an integer T denoting the number of test cases. 
     * The description of T test cases follows. 
     * The first line of each test case contains a single integer N denoting the number of workers. 
     * The second line contains N space-separated integers W1, W2, ..., WN denoting the salaries of the workers.
     * 
     * Output:
     * For each test case, output a single line containing the minimum number of operations needed to equalize all workers.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 0 <= Wi <= 10000 (10^4)
     */
    public static void solveCodeChefSALARY() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            ArrayList<Long> salaries = new ArrayList<>();
            long N = scn.nextLong();
            for (int i = 0; i < N; i++)
                salaries.add(scn.nextLong());
            Collections.sort(salaries);
            long steps = 0;
            long W0 = salaries.get(0);
            for (long i = N - 1; i >= 0; i--) {
                long Wi = salaries.get((int)i);
                steps += Wi - W0;
            }
            System.out.println(steps);
        }
        scn.close();
    }

    /*
     * Problem: RCB vs CSK
     * 
     * In the recent RCB vs CSK match, RCB batted first and scored X runs while CSK batted second and scored Y runs.
     * It is known that RCB qualifies to the playoffs if they win by at least 18 runs, otherwise CSK qualify. 
     * Knowing the final scores of both teams, find out who qualified to the playoffs.
     * 
     * Input Format:
     * The only line of input contains 2 integers X and Y - the final scores of RCB and CSK respectively.
     * 
     * Output Format:
     * Output RCB if RCB managed to qualify to the playoffs, otherwise output CSK.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings RCB, rCb, rcb, and rcB will all be treated as identical).
     * 
     * Constraints:
     * 150 <= X <= 250
     * 150 <= Y <= X + 6
     */
    public static void solveCodeChefRCBCSK() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        long Y = scn.nextLong(); 
        System.out.println(X - Y >= 18 ? "RCB" : "CSK");
        scn.close();
    }

    /*
     * Problem: Football Ties
     * 
     * According to the Premier League rules, the winner of a game gets 3 points while the loser of a game gets 00 points. 
     * On the other hand, if there is a draw, both sides get 1 point each.
     * Two teams A and B played several games against each other and finally ended up with the score of X and Y points respectively.
     * We do not know how many games were played. Find the minimum possible number of draws that may have happened.
     * It is guaranteed that there is at least one way to end up with the final score being X and Y points respectively.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case contains X and Y - the final scores of teams A and B respectively.
     * 
     * Output Format:
     * For each test case, output on a new line, the minimum number of draws that could have happened.
     * 
     * Constraints:
     * 1 <= T <= 75
     * 0 <= X, Y <= 14
     * There is at least 1 way to obtain the final score X and Y.
     */
    public static void solveCodeChefFOOTBALLTIES() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            System.out.println(Math.max(X % 3, Y % 3));
        }
        scn.close();
    }

    /*
     * Problem: Equalize AB
     * 
     * You are given two numbers A and B along with an integer X. In one operation you can do one of the following:
     * Set A = A + X and B = B - X
     * Set A = A - X and B = B + X
     * Determine if you can make A and B equal after applying the operation any number of times (possibly zero).
     * 
     * Input Format:
     * The first line contains a single integer T - the number of test cases. Then the test cases follow.
     * The first and only line of each test case contains two space-separated integers A, B and X - the parameters mentioned in the statement.
     * 
     * Output Format:
     * For each test case, output YES if you can make A and B equal after applying the operation any number of times (possibly zero). 
     * Otherwise, output NO. You can output each letter in any case i.e. YES, yes, yEs are all considered the same.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= A, B, X <= 10^9
     */
    public static void solveCodeChefEQUALIZEAB() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long A = scn.nextLong();
            long B = scn.nextLong();
            long X = scn.nextLong();
            System.out.println((Math.abs(A - B) % (2 * X) == 0) ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Lost Weekends
     * 
     * Chef recently started working at ABC corporation. 
     * Let's number weekdays (Monday through Friday) by integers 1 through 5. 
     * For each valid i, the number of hours Chef spent working at the office on weekday i was Ai.
     * Unfortunately, due to the COVID-19 pandemic, 
     * Chef started working from home and his productivity decreased by a considerable amount. 
     * As per Chef's analysis, 1 hour of work done at the office is equivalent to P hours of work done at home.
     * Now, in order to complete his work properly, Chef has to spend more hours working from home, 
     * possibly at the cost of other things like sleep. 
     * However, he does not have to do the same work on each day as he would have in the office - 
     * for each weekday, he can start the work for this day on an earlier day and/or complete it on a later day. 
     * The only requirement is that his work does not pile up indefinitely, 
     * i.e. he can complete his work for each week during the same week. One day has 24 hours.
     * If Chef is unable to complete his work for a week during those five weekdays, 
     * then he has to work during the weekend too. 
     * Chef wishes to know whether he has to work on weekends or if he can complete his work by working only on weekdays. 
     * Help him answer that question. 
     * (It is possible that Chef would be unable to finish his work even if he worked all the time, but he does not want to know about that.)
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first and only line of each test case contains six space-separated integers A1, A2, A3, A4, A5 and P.
     * 
     * Output:
     * For each test case, print a single line containing the string "Yes" if Chef has to work on weekends or "No" otherwise (without quotes).
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 0 <= Ai <= 24 for each valid i
     * 1 <= P <= 24
     */
    public static void solveCodeChefLOSTWKND() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long A1 = scn.nextLong();
            long A2 = scn.nextLong();
            long A3 = scn.nextLong();
            long A4 = scn.nextLong();
            long A5 = scn.nextLong();
            long P = scn.nextLong();
            long total = (A1 + A2 + A3 + A4 + A5) * P;
            System.out.println(24 * 5 - total >= 0 ? "No" : "Yes");
        }
        scn.close();
    }

    /*
     * Problem: Who Makes P1
     *
     * Tyro and Dom are fighting over who makes the first problem of the contest. 
     * Both of them are very lazy so they don't want to make it.
     * Tyro has a patience level of A, meaning he will only be convinced on the Ath time when Dom asks him to make the problem.
     * Dom, on the other hand, has decided to convince Tyro at most B times. 
     * If Tyro is not convinced by the Bth time, Dom will proceed to make it himself.
     * Given the values of A and B, find out who will end up making the problem.
     *
     * Input Format:
     * The first and only line of input contains 2 integers, A and B - 
     * Tyro's patience level, and the number of times Dom tries to convince Tyro respectively.
     * 
     * Output Format:
     * For each test case, output on a new line, Dom or Tyro corresponding to who ends up making the problem.
     * You can print each character in uppercase or lowercase. 
     * For example, the strings DOM, dom, Dom, and dOM are considered identical.
     *
     * Constraints:
     * 1 <= A, B <= 10
     */
    public static void solveCodeChefWHOMAKESP1() {
        Scanner scn = new Scanner(System.in);
        long A = scn.nextLong();
        long B = scn.nextLong();
        System.out.println(B >= A ? "Tyro" : "Dom");
        scn.close();
    }
    
    /*
     * Problem: Ada King
     * 
     * Chef Ada is training her calculation skills. 
     * She wants to place a king and some obstacles on a chessboard in such a way 
     * that the number of distinct cells the king can reach is exactly K.
     * Recall that a chessboard has 88 rows (numbered 1 through 8) and 8 columns (numbered 1 through 8); 
     * let's denote a cell in row r and column c by (r, c).
     * In one move, a king can move to any adjacent cell which shares a side or corner 
     * with its current cell and does not contain an obstacle. 
     * More formally, a king in a cell (r,c) can move to any cell (rn, cn) 
     * if (rn, cn) is a valid cell of the chessboard which does not contain an obstacle and (r - rn)^2 + (c - cn)^2 <= 2.
     * A cell (x, y) can be reached by a king if, after an arbitrary number of moves (including zero), the king is in the cell (x, y).
     * Help Ada find any valid configuration of the board such that the king can reach exactly K distinct cells. 
     * It is guaranteed that such a configuration always exists. If there are multiple solutions, you may find any one.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first and only line of each test case contains a single integer K.
     * 
     * Output:
     * For each test case, print 8 lines describing a chessboard, each containing 8 characters.
     * For each valid i and j, the j-th character on the i-th line should be one of the following:
     * 'O' if the cell (i, j) initially contains the king; there should be exactly one such cell
     * 'X' if the cell (i, j) contains an obstacle
     * '.' if the cell (i, j) is empty
     * 
     * Constraints:
     * 1 <= T <= 64
     * 1 <= K <= 64
     */
    public static void solveCodeChefADAKING() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long K = scn.nextLong();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (i == 0 && j == 0)
                        System.out.print("O");
                    else if (K > 0)
                        System.out.print(".");
                    else
                        System.out.print("X");
                    K--;
                }
                System.out.println();
            }
        }
        scn.close();
    }

    /*
     * Problem: Chef and Bored Games
     *
     * Chef has recently been playing a lot of chess in preparation for the ICCT (International Chef Chess Tournament).
     * Since putting in long hours is not an easy task, Chef's mind wanders elsewhere. 
     * He starts counting the number of squares with odd side length on his chessboard.
     * However, Chef is not satisfied. 
     * He wants to know the number of squares of odd side length on a generic N ∗ N chessboard.
     * 
     * Input:
     * The first line will contain a single integer T, the number of test cases.
     * The next T lines will have a single integer N, the size of the chess board.
     * 
     * Output: 
     * For each test case, print a integer denoting the number of squares with odd length.
     *
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 1000
     */
    public static void solveCodeChefPCJ18B() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long total = 0;
            for (long i = 1; i <= N; i += 2)
                total += ((N - i + 1) * (N - i + 1));
            System.out.println(total);
        }
        scn.close();
    }

    /*
     * Problem: Election Hopes
     * 
     * The elections in Chefland have concluded, and the results are in!
     * Chef received X votes, and his rival Chefu received Y.
     * Chef thinks he dominated the election if and only if he received at least double the number of votes Chefu received.
     * Did Chef dominate the election?
     * 
     * Input Format:
     * The only line of input contains two space-separated integers X and Y - 
     * the number of votes received by Chef and Chefu, respectively.
     * 
     * Output Format:
     * Print a single line containing the answer: either "Yes" or "No" (without quotes), 
     * depending on whether Chef dominated the election or not.
     * Each letter of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings No, no, NO, and nO will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= X, Y <= 100
     */
    public static void solveCodeChefELHP() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println(X >= Y * 2 ? "Yes" : "No");
        scn.close();
    }

    /*
     * Problem: Spell Splice
     * 
     * Chef has N magic spells. The ith spell has a volatility of Vi and a strength of Ai.
     * When spells i and j (1 <= i <= j <= N) are activated together, 
     * they merge to form a single spell of strength (Ai * Vj + Vi * Aj).
     * What's the maximum possible strength of a spell Chef can obtain by activating exactly two of his spells?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains a single integer N, the number of spells.
     * The next N lines describe the spells. The ith of them contains two space-separated integers Vi and Ai - 
     * the volatility and strength of the ith spell.
     * 
     * Output Format:
     * For each test case, output on a new line the maximum possible power of a combined spell.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 2 <= N <= 100
     * 1 <= Ai, Vi <= 1000
     */
    public static void solveCodeChefCMIX() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            ArrayList<Long> strengths = new ArrayList<>();
            ArrayList<Long> volatilities = new ArrayList<>();
            long maxcombinedstrength = 0;
            for (long i = 1; i <= N; i++) {
                volatilities.add(scn.nextLong());
                strengths.add(scn.nextLong());
                for (long j = 1; j < i; j++) {
                    long newcombinedstrength = strengths.get((int)i - 1) * volatilities.get((int)j - 1) + strengths.get((int)j - 1) * volatilities.get((int)i - 1);
                    if (newcombinedstrength > maxcombinedstrength)
                        maxcombinedstrength = newcombinedstrength;
                }
            }
            System.out.println(maxcombinedstrength);
        }
        scn.close();
    }

    /*
     * Problem: Phone Prices
     * 
     * Chef wants to buy a new phone, but he is not willing to spend a lot of money. 
     * Instead, he checks the price of his chosen model everyday and waits for the price to drop to an acceptable value. 
     * So far, he has observed the price for N days (number 1 through N); for each valid i, the price on the ith day was Pi dollars.
     * On each day, Chef considers the price of the phone to be good 
     * if it is strictly smaller than all the prices he has observed during the previous five days. 
     * If there is no record of the price on some of the previous five days 
     * (because Chef has not started checking the price on that day yet), 
     * then Chef simply ignores that previous day - we could say that he considers the price on that day to be infinite.
     * Now, Chef is wondering - on how many days has he considered the price to be good? Find the number of these days.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first line of each test case contains a single integer N.
     * The second line contains N space-separated integers P1, P2, ..., PN.
     * 
     * Output:
     * For each test case, print a single line containing one integer ― the number of days with a good price.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 7 <= N <= 100
     * 350 <= Pi <= 750 for each valid i
     */
    public static void solveCodeChefS10E() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long[] prices = {Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE};
            long goodprices = 0;
            for (long i = 1; i <= N; i++) {
                long Pi = scn.nextLong();
                if (CodeChefLibrary.isCheaper(Pi, prices))
                    goodprices++;
                CodeChefLibrary.leftShiftPrices(prices, Pi);
            }
            System.out.println(goodprices);
        }
        scn.close();
    }

    /*
     * Program: Mathison and pangrams
     * 
     * Mathison recently inherited an ancient papyrus that contained some text.
     * Unfortunately, the text was not a pangram. 
     * Now, Mathison has a particular liking for holoalphabetic strings and the text bothers him. 
     * The good news is that Mathison can buy letters from the local store in order to turn his text into a pangram.
     * However, each letter has a price and Mathison is not very rich. 
     * Can you help Mathison find the cheapest way to obtain a pangram?
     * 
     * Input:
     * The first line of the input file will contain one integer, T, representing the number of tests.
     * Each test will be formed from two lines. 
     * The first one contains 26 space-separated integers, representing the prices of all letters. 
     * The second will contain Mathison's initial text (a string of N lowercase letters).
     * 
     * Output:
     * The output file will contain T lines, one for each test. 
     * Each line will contain the answer for the corresponding test.
     * 
     * Constraints and notes:
     * 1 <= T <= 10
     * 1 <= N <= 50000
     * All prices are natural numbers between 1 and 1000000 (i.e. 106).
     * A pangram is a string that contains every letter of the Latin alphabet at least once.
     * All purchased letters are added to the end of the string.
     */
    public static void solveCodeChefMATPAN() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            HashMap<Character, Long> prices = new HashMap<>();
            for (long i = 0; i < 26; i++) {
                long Pi = scn.nextLong();
                prices.put((char)(i + 97), Pi);
            }
            String pangram = scn.next();
            for (char c : pangram.toCharArray())
                prices.remove(c);
            long total = 0;
            for (long price : prices.values())
                total += price;
            System.out.println(total);
        }
        scn.close();
    }

    /*
     * Problem: String protocol
     * 
     * An input string S of length N is transferred through the network using a special protocol. 
     * The protocol can send the string through a series of operations. 
     * In one operation, we can choose a lowercase english alphabet C and do one of the following:
     * Transfer 1 copy of C through the network.
     * Transfer 2 copies of C through the network.
     * Each of the above transfers take 1 unit of time.
     * Find the minimum time in which we can transfer the entire string S through the network.
     * 
     * Input Format:
     * The first line will contain T - the number of test cases. Then the test cases follow.
     * First line of each test case contains N - the length of the string S.
     * Second line of each test case contains the string S.
     * 
     * Output Format:
     * For each test case, output in a single line, the minimum time required to transfer the string.
     *
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 10^5
     * Sum of N over all test cases does not exceed 10^5.
     * String S contains lowercase english alphabets only.
     */
    public static void solveCodeChefSTRP() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            String S = scn.next();
            Character last = Character.MIN_VALUE;
            long time = 0;
            for (long i = 0; i < N; i++) {
                Character c = S.charAt((int)i);
                if (c.equals(last)) {
                    time++;
                    last = Character.MIN_VALUE;
                }
                else if (last.equals(Character.MIN_VALUE))
                    last = c;                
                else {
                    last = c;
                    time++;
                }
            }
            if (!last.equals(Character.MIN_VALUE))
                time++;
            System.out.println(time);
        }
        scn.close();
    }

    /*
     * Problem: Heat Wave
     *
     * During a scorching heat wave, the temperature in a Chefland reached a record high of X degrees.
     * The next day, the recorded temperature was Y degrees. Find whether this was a new record high or not.
     *
     * Input Format:
     * The first and only line of input will contain two space separated integers X and Y 
     * denoting the highest recorded temperature and the temperature on a given day respectively.
     *
     * Output Format:
     * Output on a new line, YES, if a new high was created. Otherwise print NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     *
     * Constraints:
     * 100 <= X, Y <= 150
     */
    public static void solveCodeChefHEATWAVE() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        long Y = scn.nextLong(); 
        System.out.println(Y > X ? "Yes" : "No");        
        scn.close();
    }

    /*
     * Problem: Long Drive
     *
     * Chef and Chefina are out on a long road trip.
     * The average speed of the car after 10 hours of driving is X kilometres per hour.
     * Chef wants to achieve an average speed of Y kilometres per hour. 
     * Given that he can travel a maximum of 100 kilometres in one hour, 
     * find the minimum number of additional integer hours required for him to reach the target average speed.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two space-separated integers X and Y - 
     * the average speed after 1010 hours of driving and the required average speed.
     *
     * Output Format:
     * For each test case, output on a new line, 
     * the minimum number of integer hours required for him to reach the target average speed.
     *
     * Constraints:
     * 1 <= T <= 1225
     * 50 <= X < Y < 100
     */
    public static void solveCodeChefLONGDRIVE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long X = scn.nextLong(); 
            long Y = scn.nextLong(); 
            long hours = (long)Math.ceil((double)(10 * Y - 10 * X) / (double)(100 -Y));
            System.out.println(hours);
        }
        scn.close();
    }

    /*
     * Problem: Distinct Substring
     *
     * A binary string is a string consisting of 0 and 1. 
     * We define an island as a substring consisting of all 00s bounded by 11s (or the ends of the string).
     * For example, in the string 100010000, there are 2 islands; 000 (bounded by 1s) and 0000 (bounded by 1 and end of string). 
     * Note that the substring 00 in the above string is not an island.
     * You are given positive integers N and K. Find whether there exists a binary string of length N such that:
     * There are exactly K islands in the string;
     * Each island has a distinct length.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two space-separated integers N and K - 
     * the length of binary string and the required number of islands.
     *
     * Output Format:
     * For each test case, output on a new line, YES if there exist valid binary string, otherwise print NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     *
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= N <= 10^5
     * 1 <= K <= 500
     * The sum of N over all test cases won't exceed 2*10^6.
     */
    public static void solveCodeChefDISTSUB() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            long K = scn.nextLong();
            long minlength = K * (K + 1) / 2 + K - 1;
            System.out.println(N >= minlength ? "Yes" : "No");
        }
        scn.close();
    }
    
    /*
     * Problem: Remove Bad elements
     * 
     * Chef has an array A of length N.
     * In one operation, Chef can remove any one element from the array.
     * Determine the minimum number of operations required to make all the elements same.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains a single integer N - the length of Array A.
     * Next line contains N space-separated integers A1, A2, A3, ..., AN - denoting the array A.
     * 
     * Output Format:
     * For each test case, output the minimum number of operations required to make all the elements same.
     * 
     * Constraints:
     * 1 <= T <= 4000
     * 1 <= N <= 10^5
     * 1 <= Ai <= N
     * Sum of N over all test cases do not exceed 3*10^5
     */
    public static void solveCodeChefREMOVEBAD() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            long maxFrecuency = 0;
            HashMap<Long, Long> frecuencyMap = new HashMap<>();
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                long newFrecuency = frecuencyMap.containsKey(Ai) ? frecuencyMap.get(Ai) + 1 : 1L;
                frecuencyMap.put(Ai, newFrecuency);
                if (newFrecuency > maxFrecuency)
                    maxFrecuency = newFrecuency;
            }
            System.out.println(N - maxFrecuency);
        }
        scn.close();
    }

    /*
     * Problem: Mask Policy
     * 
     * A city has been infected by a contagious virus.
     * In a survey, it was found that A out of the N people living in the city are currently infected. 
     * It has been observed that the only way for a person to get infected is 
     * if he comes in contact with an already infected person, and both of them are NOT wearing a mask.
     * The mayor of the city wants to make a new Mask Policy and find out the minimum number of people 
     * that will be required to wear a mask to avoid the further spread of the virus. 
     * Help the mayor in finding this number.
     * Note: The only aim of the mayor is to stop virus spread, not to mask every infected person.
     * 
     * Input Format:
     * The first line contains T - number of test cases. Then the test cases follow.
     * The first and only line of each test case contains two integers N and A - 
     * the total number of people living in the city and the number of people already affected by the virus respectively.
     * 
     * Output Format:
     * For each test case, output the minimum number of people that will be required to wear a mask so as to curb the virus spread.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 2 <= N <= 400
     * 1 <= A < N
     */
    public static void solveCodeChefMASKPOL() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            long A = scn.nextLong(); 
            System.out.println(Math.min(N - A, A));
        }
        scn.close();
    }

    /*
     * Problem: Hungry Ashish
     * 
     * It's dinner time. Ashish is very hungry and wants to eat something. 
     * He has X rupees in his pocket. Since Ashish is very picky, he only likes to eat either PIZZA or BURGER. 
     * In addition, he prefers eating PIZZA over eating BURGER. 
     * The cost of a PIZZA is Y rupees while the cost of a BURGER is Z rupees.
     * Ashish can eat at most one thing. Find out what will Ashish eat for his dinner.
     * 
     * Input Format:
     * The first line will contain T - the number of test cases. Then the test cases follow.
     * The first and only line of each test case contains three integers X, Y and Z - 
     * the money Ashish has, the cost of a PIZZA and the cost of a BURGER.
     * 
     * Output Format:
     * For each test case, output what Ashish will eat. (PIZZA, BURGER or NOTHING).
     * You may print each character of the string in uppercase or lowercase. 
     * (for example, the strings Pizza, pIzZa and piZZa will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= X, Y, Z <= 100
     */
    public static void solveCodeChefPIZZA_BURGER() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long X = scn.nextLong(); 
            long Y = scn.nextLong(); 
            long Z = scn.nextLong();
            if (X >= Y) 
                System.out.println("PIZZA");
            else if (X >= Z)
                System.out.println("BURGER");
            else
                System.out.println("NOTHING");
        }
        scn.close();
    }

    /*
     * Problem: Chef and Street Food
     * 
     * in Chefland, there is a very famous street where N types of street food (numbered 1 through N) are offered. 
     * For each valid i, there are Si stores that offer food of the ith type, 
     * the price of one piece of food of this type is Vi (the same in each of these stores) 
     * and each day, Pi people come to buy it; each of these people wants to buy one piece of food of the ith type.
     * Chef is planning to open a new store at this street, where he would offer food of one of these N types. 
     * Chef assumes that the people who want to buy the type of food he'd offer will split equally among all stores that offer it, 
     * and if this is impossible, i.e. the number of these people pp is not divisible by the number of these stores s, 
     * then only floor(p/s) people will buy food from Chef. Chef wants to maximise his daily profit. 
     * Help Chef choose which type of food to offer and find the maximum daily profit he can make.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows. 
     * The first line of each test case contains a single integer N.
     * N lines follow. For each i (1 <= i <= N), the ith of these lines contains three space-separated integers Si, Pi and Vi.
     * 
     * Output:
     * For each test case, print a single line containing one integer - the maximum profit.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 1 <= Si, Vi, Pi <= 10000 for each valid i
     */
    public static void solveCodeChefSTFOOD() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            long maxProfit = 0;
            for (long i = 0; i < N; i++) {
                long Si = scn.nextLong();
                long Pi = scn.nextLong();
                long Vi = scn.nextLong();
                long newProfit = (Pi / (Si + 1)) * Vi;
                if (newProfit > maxProfit)
                    maxProfit = newProfit;
            }
            System.out.println(maxProfit);
        }
        scn.close();
    }

    /*
     * Problem: Television Channels
     *
     * You have a television which had X working channels numbered 1, 2, ..., X. 
     * Unfortunately, due to a recent change, all even-numbered channels stopped working.
     * For example if X = 5, channels numbered 2 and 4 have stopped working, while channels numbered 1, 3 and 5 are still working.
     * Given X, can you tell how many channels are still working?
     *
     * Input Format:
     * The first and only line of input contains a single integer X.
     * 
     * Output Format:
     * Output the number of working channels.
     * 
     * Constraints:
     * 1 <= X <= 100
     */
    public static void solveCodeChefTV() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        System.out.println(X / 2 + X % 2);
        scn.close();
    }

    /*
     * Problem: Distribute Cookies
     * 
     * Chef is making cookies for N kids. He wants to give everyone an equal number of cookies. 
     * He must give at least 1 cookie to each kid.
     * Chef already has M cookies.
     * He can destroy or make 1 cookie in 1 second.
     * Find the minimum time after which he can evenly distribute the cookies between all kids.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single line of input.
     * The first and only line of each test case contains N and M - the number of kids and the initial number of cookies.
     * 
     * Output Format:
     * For each test case, output on a new line the minimum time such that Chef can evenly distribute all his cookies.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= N, M <= 10^9
     */
    public static void solveCodeChefDISCOOKIE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            long M = scn.nextLong();
            if (M < N)
                System.out.println(N - M);
            else
                System.out.println(Math.min(M % N, N - M % N));
        }
        scn.close();
    }

    /*
     * Problem: Counting Problem
     * 
     * You are given an array A = [A1, A2, ..., AN].
     * Is it possible to partition A into two non-empty subsequences S1 and S2 
     * such that sum(S1) * sum(S2) is odd?
     * Here, sum(S1) denotes the sum of elements in S1, and sum(S2) is defined similarly.
     * Note: S1 and S2 must partition A, that is:
     * -> S1 and S2 must be non-empty
     * -> Every element of A must be in either S1 or S2
     * -> S1 and S2 must be disjoint (in terms of which indices their subsequences represent)
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of 2 lines of input.
     * The first line of each test case contains a single integer N, the size of the array.
     * The next line contains N space-separated integers A1, A2, ..., AN: the elements of the array.
     * 
     * Output Format:
     * For each test case, print on a new line the answer: 
     * YES if the array can be partitioned into two subsequences satisfying the condition, and NO otherwise.
     * Each character of the output may be printed in either uppercase or lowercase, 
     * i.e, YES, yes, YEs, and yEs will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 2 <= N <= 10^5
     * 1 <= Ai <= 10^9
     * The sum of N across all test cases won't exceed 10^6
     */
    public static void solveCodeChefCOUNTP() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            long odds = 0;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                odds += Ai % 2;
            }
            System.out.println(odds % 2 == 0 && odds > 0 ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Yoga Day
     * 
     * Surya Namaskar, also known as Sun Salutation, is a series of 12 yoga poses performed in a sequence.
     * Chef repeats this sequence of yoga poses multiple times during his session.
     * Given that Chef has performed N yoga poses, find the number of rounds of Surya Namaskar he completed during the session.
     * 
     * Input Format:
     * The input will contain a single integer N, denoting the number of yoga poses Chef performed during his session.
     * 
     * Output Format:
     * Output the number of rounds of Surya Namaskar Chef completed during the session.
     * 
     * Constraints:
     * 1 <= N <= 100
     */
    public static void solveCodeChefYOGADAY() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong(); 
        System.out.println(N / 12);
        scn.close();
    }

    /*
     * Problem: Yoga Class
     * 
     * On the occasion of Yoga Day, the only yoga instructor in Chefland, Chef, has received numerous queries.
     * Chef has managed to free up N hours from his busy schedule to conduct yoga sessions. 
     * There are two types of sessions that Chef offers:
     * Type 1 session, which lasts 1 hour, and earns Chef X rupees.
     * Type 2 session, which lasts 2 hours, and earns Chef Y (Y > X) rupees.
     * Find the maximum amount of money Chef can earn in N hours.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of three space-separated integers N, X, Y - 
     * the number of hours for which Chef will take yoga sessions, 
     * price of type 1 session, and price of type 2 session respectively.
     * 
     * Output Format:
     * For each test case, output on a new line, the maximum amount of money Chef can earn in N hours.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N <= 1000
     * 1 <= X < Y <= 100
     */
    public static void solveCodeChefYOGACLASS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            long X = scn.nextLong(); 
            long Y = scn.nextLong(); 
            if (X * 2 >= Y)
                System.out.println(N * X);
            else
                System.out.println((N / 2) * Y + (N % 2) * X);
        }
        scn.close();
    }

    /*
     * Problem: Lucky Clover
     * 
     * Chef heard that four-leaf clovers bring good luck, so he went looking for one.
     * In his search, Chef found N clovers in total. Out of them, 
     * exactly one was a four-leaf clover, and all the others were three-leaf clovers.
     * How many leaves did Chef collect in total, across all the clovers?
     * 
     * Input Format:
     * The only line of input will contain a single integer N, the number of clovers Chef found.
     * 
     * Output Format:
     * Print one integer: the total number of leaves Chef collected.
     * 
     * Constraints:
     * 1 <= N <= 10
     */
    public static void solveCodeChefLUCLO() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong(); 
        System.out.println(4 + (N - 1) * 3);
        scn.close();
    }

    /*
     * Problem: Writing Speed
     * 
     * Rahul has a 5-page assignment due in 60 minutes. He can write one page in X minutes.
     * Determine if Rahul can complete the assignment within the given time constraint.
     * 
     * Input Format:
     * The only line of input will contain a single integer X, denoting the time taken (in minutes) by Rahul to write one page.
     * 
     * Output Format:
     * Print YES if Rahul can complete the assignment in time, otherwise print NO.
     * You may print each character of the output in either uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= X <= 1000
     */
    public static void solveCodeChefWRITINGSPEED() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        System.out.println(60 / X >= 5 ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Penalty Shoot-out
     * 
     * In a football match, a penalty shootout is used to determine the winner if the score is tied after regulation and extra time. 
     * Each team takes turns attempting five penalty kicks.
     * Team A has scored X goals in 3 turns while team B has scored Y goals in 4 turns.
     * Determine if it's possible for the penalty shootout to end with equal score after both teams have taken all 5 of their penalty kicks.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two space-separated integers X and Y - 
     * the number of goals scored by team A in 3 turns and team B in 4 turns respectively.
     * 
     * Output Format:
     * For each test case, output on a new line YES if match can still end in draw, otherwise output NO.
     * You may print each character of the output in either uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 0 <= X <= 3
     * 0 <= Y <= 4
     */
    public static void solveCodeChefPENALTYSHOOT() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            long diff = Math.abs(Y - X);
            if (diff <= 1)
                System.out.println("YES");
            else if (diff == 2)
                System.out.println(X < Y ? "YES" : "NO");
            else
                System.out.println("NO");
        }
        scn.close();
    }

    /*
     * Problem: Nearly Equal
     * 
     * The Hamming distance between two pairs of strings of equal length is defined to be 
     * the number of positions at which they contain different characters.
     * For example, the Hamming distance between strings "there" and "shire" is 2 
     * (their first and third characters are different), 
     * while the Hamming distance between "order" and "chaos" is 5, since they differ at every position.
     * Chef has a string A of length N.
     * Chef's favorite string is B, which has length M. It is known that M <= N.
     * Find the minimum Hamming distance between B and some contiguous substring of A that has length M.
     * A substring of a string is obtained by deleting some (possibly, zero) characters from its beginning 
     * and some (possibly, zero) characters from its end.
     * For example, "abc", "bc", and "cd" are substrings of "abcd", but "ac" is not.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of three lines of input.
     * The first line of each test case contains two space-separated integers N and M - 
     * the lengths of strings A and B, respectively.
     * The second line contains the string A, consisting of N lowercase English letters.
     * The third line contains the string B, consisting of M lowercase English letters.
     * 
     * Output Format:
     * For each test case, output on a new line the minimum possible Hamming distance between B and some length M substring of A.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= M <= N <= 100
     * A and B contain only lowercase English letters, i.e, the characters 'a' through 'z'.
     */
    public static void solveCodeChefSAMESAME() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long M = scn.nextLong();
            String A = scn.next();
            String B = scn.next();
            long min = N;
            for (long i = 0; i <= N - M; i++) {
                long hamming = 0;
                for (long j = i; j < i + M; j++) {
                    if (A.charAt((int)j) != B.charAt((int)(j - i)))
                        hamming++;
                }
                if (hamming < min)
                    min = hamming;
            }
            System.out.println(min);
        }
        scn.close();
    }

    /*
     * Problem: Superincreasing
     * 
     * An array A of length N containing positive integers is said to be superincreasing 
     * if each element is strictly greater than the sum of all the previous elements.
     * That is, for each i from 2 to N, the condition Ai > A1 + A2 + ... + Ai-1 should hold.
     * For example, A = [3, 5, 10, 42] is a superincreasing array, while A = [1, 2, 3] is not 
     * (3 = 1 + 2, but it should be strictly greater than that).
     * Chef had a superincreasing array A of length N with him a long time ago, but has forgotten all its elements now.
     * The only piece of information he recalls is that the value X occurred at index K of the array, i.e, AK = X.
     * Can you tell Chef if he recalls correctly?
     * That is, does there exist a superincreasing array A of length N such that AK = X?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case contains three space-separated integers N, K, and X - 
     * the length of A, the index at which X occurs, and the value X.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: Yes if a valid superincreasing array exists, and No otherwise.
     * Each letter of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings NO, no, No, and nO` will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= K <= N <= 2*10^5
     * 1 <= X <= 10^9
     * The sum of N across all tests won't exceed 2*10^5.
     */
    public static void solveCodeChefSUPINC() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            scn.nextLong();
            long K = scn.nextLong();
            long X = scn.nextLong();
            long min = (long)Math.pow(2, K - 1);
            System.out.println(X >= min ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: From heaven to earth
     * 
     * Chef has been working in a restaurant which has N floors. 
     * He wants to minimise the time it takes him to go from the N-th floor to ground floor. 
     * He can either take the elevator or the stairs.
     * The stairs are at an angle of 45 degrees and Chef's velocity is V1 m/s when taking the stairs down. 
     * The elevator on the other hand moves with a velocity V2 m/s. 
     * Whenever an elevator is called, it always starts from ground floor and goes to N-th floor 
     * where it collects Chef (collecting takes no time), and makes its way down to the ground floor with Chef in it.
     * The elevator covers a total distance equal to N meters when going from N-th floor to ground floor or vice versa, 
     * while the length of the stairs is N * sqrt(2) because the stairs is at angle 45 degrees.
     * Chef has enlisted your help to decide whether he should use stairs or the elevator to minimise his travel time. Can you help him out?
     * 
     * Input:
     * The first line contains a single integer T, the number of test cases.
     * Each test case is described by a single line containing three space-separated integers N, V1, V2.
     * 
     * Output:
     * For each test case, output a single line with string Elevator or Stairs, denoting the answer to the problem.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N, V1, V2 < 100
     */
    public static void solveCodeChefELEVSTRS() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long V1 = scn.nextLong();
            long V2 = scn.nextLong();
            long elevator2 = (4 * N * N) * (V1 * V1);
            long stairs2 = (2 * N * N) * (V2 * V2);
            if (elevator2 < stairs2)
                System.out.println("Elevator");
            else
                System.out.println("Stairs");
        }
        scn.close();
    }

    /*
     * Problem: International Justice Day
     * 
     * In honor of International Justice Day, 
     * the Supreme Court of Chefland has decided to address all pending cases simultaneously.
     * For a given case, the accused will be convicted if the convincing power of the prosecution, 
     * denoted by integer X, is greater than or equal to the convincing power of the defense, denoted by integer Y.
     * Determine whether the accused is convicted.
     * 
     * Input Format:
     * The only line of input consists of space-separated integers X and Y, 
     * denoting the convincing powers of prosecution and defense, respectively.
     * 
     * Output Format:
     * Output on a new line, YES, if the accused is convicted and NO otherwise.
     * 
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= X, Y <= 10
     */
    public static void solveCodeChefJUSTICE() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        long Y = scn.nextLong(); 
        System.out.println(X >= Y ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Maximum Coins
     * 
     * Chef and Chefina are playing a series of N games.
     * Each game has a winner. For the ith (1 <= i <= N) game, the loser pays 2^i coins to the winner.
     * Find the maximum number of coins Chef can get if he wins exactly X games.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two space-separated integers N and X - 
     * the total number of games and the number of games Chef wins, respectively.
     * 
     * Output Format:
     * For each test case, output on a new line, the maximum number of coins Chef can get if he wins exactly X games.
     * 
     * Constraints:
     * 1 <= T <= 55
     * 1 <= X <= N <= 10
     */
    public static void solveCodeChefMAXCOIN() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long X = scn.nextLong();
            long looses = 0;
            long wins = 0;
            for (long i = 0; i < N - X; i++)
                looses += (long)Math.pow(2, i + 1);
            for (long i = N - X; i < N; i++)
                wins += (long)Math.pow(2, i + 1);
            System.out.println(wins - looses);
        }
        scn.close();
    }

    /*
     * Problem: Pseudo Sorted Array
     * 
     * An array A of length N is said to be pseudo-sorted if 
     * it can be made non-decreasing after performing the following operation at most once.
     * Choose an i such that 1 <= i <= N-1and swap Ai and A{i+1}
     * Given an array A, determine if it is pseudo-sorted or not.
     * 
     * Input Format:
     * The first line contains a single integer T - the number of test cases. Then the test cases follow.
     * The first line of each test case contains an integer N - the size of the array A.
     * The second line of each test case contains N space-separated integers A1, A2, ..., AN denoting the array A.
     * 
     * Output Format:
     * For each testcase, output YES if the array A is pseudo-sorted, NO otherwise.
     * You may print each character of YES and NO in uppercase or lowercase (for example, yes, yEs, Yes will be considered identical).
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 2 <= N <= 10^5
     * 1 <= Ai <= 10^9
     * Sum of N over all test cases do not exceed 2*10^5
     */
    public static void solveCodeChefPSEUDOSORT() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long swaps = 0;
            long last = 0;
            long Ai1 = scn.nextLong();
            long Ai2 = scn.nextLong();
            if (Ai1 > Ai2) {
                swaps++;
                long temp = Ai1;
                Ai1 = Ai2;
                Ai2 = temp;
            }
            for (long i = 2; i < N; i++) {
                long Ai = scn.nextLong();
                last = Ai1;
                Ai1 = Ai2;
                Ai2 = Ai;
                if (Ai1 > Ai2 && Ai2 >= last) {
                    swaps++;
                    long temp = Ai1;
                    Ai1 = Ai2;
                    Ai2 = temp;
                }
                else if (Ai1 > Ai2 && Ai2 < last)
                    swaps += 2;
            }
            System.out.println(swaps < 2 ? "YES" : "NO");
        }
        scn.close();
    }
    
    /*
     * Problem: Chef and Coupon
     * 
     * Chef wants to order food from a food delivery app. 
     * He wishes to order once today, and buy three items costing A1, A2 and A3 rupees, respectively. 
     * He'll also order once tomorrow, when he'll buy three items costing B1, B2 and B3 rupees, respectively. 
     * There is an additional delivery charge of rupees D for each order.
     * He notices that there is a coupon on sale, which costs rupees C. 
     * If he buys that coupon, the delivery charges on any day, on an order of rupees 150 or more shall be waived 
     * (that is, the D rupees will not be added, if the sum of the costs of the items is >= 150).
     * Note that Chef is ordering the three items together on each day, 
     * so the delivery charge is charged only once each day. 
     * Also, note that it's only needed to buy the coupon once to avail the delivery fee waiver on both days.
     * Should Chef buy the coupon? 
     * Note that Chef shall buy the coupon only if it costs him strictly less than what it costs him without the coupon, in total.
     * 
     * Input:
     * The first line of the input contains a single integer T, denoting the number of test cases.
     * The first line of each test case contains two space-separated integers D and C, 
     * denoting the delivery charge, and the price of the coupon, respectively.
     * The second line of each test case contains three space-separated integers A1, A2 and A3, 
     * denoting the prices of the food items that Chef plans to order on Day 1, respectively.
     * The third line of each test case contains three space-separated integers B1, B2 and B3, 
     * denoting the prices of the food items that Chef plans to order on Day 2, respectively.
     * 
     * Output: 
     * For each test case, output YES if Chef should buy the coupon, and NO otherwise, in a separate line.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= D, C <= 100
     * 1 <= A1, A2, A3 <= 100
     * 1 <= B1, B2, B3 <= 100
     */
    public static void solveCodeChefCOUPON2() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long D = scn.nextLong();
            long C = scn.nextLong();
            long A = scn.nextLong() + scn.nextLong() + scn.nextLong();
            long B = scn.nextLong() + scn.nextLong() + scn.nextLong();
            long P1 = 2 * D + A + B;
            long P2 = C + (A >= 150 ? A : A + D) + (B >= 150 ? B : B + D);
            System.out.println(P2 < P1 ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Airport Management
     * 
     * Chef is building an Airport in Chefland.
     * There are N airplanes such that the ith airplane arrives at the Ai-th minute and departs at the Di-th minute.
     * Find the minimum number of runways required at the airport so that all the arrivals and departures can occur smoothly.
     * Notes:
     * -> Arrival and departure timings are given in minutes after midnight.
     * -> A plane uses the runway only in the minute at which it arrives or departs. 
     * Between the arrival and departure times, the runway is available for use by other airplanes.
     * -> One runway can be used by only one airplane at a point in time.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains a single integer N - the number of airplanes.
     * The second line of each test case contains N space-separated integers A1, A2, ..., AN, denoting the arrival timings of ith airplane.
     * The third line of each test case contains N space-separated integers D1, D2, ..., DN, denoting the departure timings of ith airplane.
     * 
     * Output Format:
     * For each test case, output on a new line, the minimum number of runways required at the airport.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= N <= 10^5
     * 0 <= Ai < Di <= 1439
     * The sum of N over all test cases won't exceed 8*10^5
     */
    public static void solveCodeChefAIRM() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong();
        while (T-- > 0) {
            long N = scn.nextLong();
            HashMap<Long, Long> hashMap = new HashMap<>();
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                hashMap.put(Ai, hashMap.getOrDefault(Ai, 0L) + 1);
            }
            for (long i = 0; i < N; i++) {
                long Di = scn.nextLong();
                hashMap.put(Di, hashMap.getOrDefault(Di, 0L) + 1);
            }
            LinkedList<Long> listaOrdenada = new LinkedList<>();
            for (Map.Entry<Long, Long> entry : hashMap.entrySet())
                listaOrdenada.add(entry.getValue());
            Collections.sort(listaOrdenada);
            Collections.reverse(listaOrdenada);
            System.out.println(listaOrdenada.get(0));
        }
        scn.close();
    }

    /*
     * Problem: Capital Gain Tax
     *
     * The annual budget for ChefLand has been announced and people are concerned about the modification in capital gain tax.
     * Given that the capital gain tax changed from X% to Y%, find whether it has INCREASED, DECREASED, or remained the SAME.
     *
     * Input Format:
     * The first and only line of input consists of two space-separated integers X and Y denoting the previous and new value of capital gain tax.
     *
     * Output Format:
     * Output on a new line:
     * -> INCREASED, if the capital gain tax has increased;
     * -> DECREASED, if the capital gain tax has decreased;
     * -> SAME, if the capital gain tax remained the same.
     * You may print each character in uppercase or lowercase. 
     * For example, the strings SAME, same, Same, and sAmE would be considered identical.
     *
     * Constraints:
     * 10 <= X, Y <= 30
     */
    public static void solveCodeChefTCG() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        if (X < Y)
            System.out.println("INCREASED");
        else if (X > Y)
            System.out.println("DECREASED");
        else
            System.out.println("SAME");
        scn.close();
    }
    
    /*
     * Problem: Savings Account
     *
     * Considering the new budget, Chef decided to keep all his money in a savings account.
     * Chef has X income sources where he gets Y rupees from each source. 
     * However, due to bank restrictions, Chef can keep at most Z rupees in the savings account.
     * Find the minimum number of income sources Chef should reduce to maximise his savings without exceeding the account's limit.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of three space-separated integers X, Y, and Z - 
     * the number of income sources, amount received from each source and the maximum limit of savings account respectively.
     *
     * Output Format:
     * For each test case, output on a new line, the minimum number of income sources Chef should reduce to maximise his savings without exceeding the account's limit.
     *
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= X, X <= 10
     * 1 <= Z <= 100
     */
    public static void solveCodeChefXYZ343() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            long Z = scn.nextLong();
            long reduce = X - Z / Y;
            System.out.println(reduce < 0 ? 0 : reduce);
        }
        scn.close();
    }

    /*
     * Problem: Average Permutation
     *
     * You are given an integer N.
     * Find a permutation P = [P1, P2, ..., PN] of the integers {1, 2, ..., N} 
     * such that sum of averages of all consecutive triplets is minimized, i.e.
     * sum{i = 1}{i = N - 2}[(Pi + P{i + 1} + P{i + 2}) / 3] is minimized.
     * If multiple permutations are possible, print any of them.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case contains an integer N, the size of the permutation.
     *
     * Output Format:
     * For each test case, output on a new line a permutation which satisfies the above conditions.
     *
     * Constraints:
     * 1 <= T <= 1000
     * 3 <= N <= 10^5
     * The sum of N over all test cases won't exceed 3*10^5.
     */
    public static void solveCodeChefAVGPERM() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            if (N == 3)
                System.out.println("3 2 1");
            else {
                System.out.print(N + " " + (N - 2) + " ");
                for (long i = 1; i <= N - 4; i++)
                    System.out.print(i + " ");
                System.out.println((N - 3) + " " + (N - 1));
            }
        }
        scn.close();
    }

    /*
     * Problem: Prime Generator
     * 
     * Ram wants to generate some prime numbers for his cryptosystem. Help him please! 
     * Your task is to generate all prime numbers between two given numbers.
     * Warning: large Input/Output data, be careful with certain languages (though most should be OK if the algorithm is well designed)
     *
     * Input Format:
     * The first line contains t, the number of test cases (less then or equal to 10).
     * Followed by t lines which contain two numbers m and n (1 <= m <= n <= 1000000000, n - m <= 100000) separated by a space.
     *
     * Output Format:
     *
     * For every test case print all prime numbers p such that m <= p <= n, one number per line. Separate the answers for each test case by an empty line.
     *
     * Constraints:
     * (1 <= m <= n <= 1000000000, n - m <= 100000)
     */
    public static void solveCodeChefPRIME1() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long m = scn.nextLong();
            long n = scn.nextLong();
            if (m <= 2) {
                System.out.println(2);
                m = 3;
            }
            else if (m % 2 == 0)
                m++;
            for (long i = m; i <= n; i += 2) {
                if (CodeChefLibrary.isPrime(i))
                    System.out.println(i);
            }
            System.out.println();
        }
        scn.close();
    }

    /*
     * Problem: Volume Comparison
     * 
     * Alice has two objects:
     * A cuboid with length A units, height B units, and width C units.
     * A cube with an edge length of X units.
     * Alice wants to know which of the two objects has a larger volume, or if their volumes are equal.
     * 
     * Input Format:
     * The first and only line of input will contain four space-separated integers A, B, C and X, 
     * the length of the cuboid, the width of the cuboid, the height of the cuboid, and the length of the edge of the cube.
     * 
     * Output Format:
     * Print a single line containing the string:
     * "Cuboid", if the volume of the cuboid is greater than the volume of the cube.
     * "Cube", if the volume of the cube is greater than the volume of the cuboid.
     * "Equal", if both objects have equal volume.
     * Print the string without quotes.
     * You can print each character of the output in either uppercase or lowercase.
     * For example, the strings Cube, CUBE, cube, and CuBe are considered identical.
     * 
     * Constraints:
     * 1 <= A, B, C, X <= 10
     */
    public static void solveCodeChefCABLE() {
        Scanner scn = new Scanner(System.in);
        long A = scn.nextLong(); 
        long B = scn.nextLong(); 
        long C = scn.nextLong(); 
        long X = scn.nextLong(); 
        long V1 = A * B * C;
        long V2 = X * X * X;
        if (V1 > V2)
            System.out.println("Cuboid");
        else if (V1 < V2)
            System.out.println("Cube");
        else
            System.out.println("Equal");
        scn.close();
    }

    /*
     * Problem: Gun Master
     * 
     * You have two guns: a close-range gun and a long-range gun.
     * The close-range gun can only shoot targets at distances less than or equal to D, 
     * while the long-range gun can only shoot targets at distances strictly greater than D.
     * You can only hold one gun at a time. Initially, you are holding the close-range gun.
     * You need to shoot at a series of N targets in order. The distance to the i-th target is Ai.
     * Your task is to determine the minimum number of times you need to switch 
     * between the two guns to shoot all N targets in the given order.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * The first line of each test case contains two space-separated integers N and D - 
     * the number of targets and the maximum effective range of the close-range gun.
     * The second line of each test case contains N space-separated integers A1, A2, ..., AN,
     * denoting the distances to the N targets in order.
     * 
     * Output Format:
     * For each test case, output on a new line the minimum number of gun switches required.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= N <= 100
     * 1 <= Ai, D <= 100
     * The sum of N across all test cases won't exceed 2*10^5.
     */
    public static void solveCodeChefGMGM() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long D = scn.nextLong();
            long gun = 0;
            long switches = 0;
            for (long i = 0; i < N; i++) {
                long d = scn.nextLong();
                if (d <= D) {
                    if (gun == 1)
                        switches++;
                    gun = 0;
                }
                else {
                    if (gun == 0)
                        switches++;
                    gun = 1;
                }
            }
            System.out.println(switches);
        }
        scn.close();
    }

    /*
     * Problem: Closing the Tweets
     * 
     * Little kids, Jack and Evan like playing their favorite game Glass-and-Stone. 
     * Today they want to play something new and came across Twitter on their father's laptop.
     * They saw it for the first time but were already getting bored to see 
     * a bunch of sentences having at most 140 characters each. 
     * The only thing they liked to play with it is, closing and opening tweets.
     * There are N tweets on the page and each tweet can be opened by clicking on it, 
     * to see some statistics related to that tweet. Initially all the tweets are closed. 
     * Clicking on an open tweet closes it and clicking on a closed tweet opens it. 
     * There is also a button to close all the open tweets. 
     * Given a sequence of K clicks by Jack, Evan has to guess the total number of open tweets just after each click. 
     * Please help Evan in this game.
     * 
     * Input:
     * First line contains two integers N K, the number of tweets (numbered 1 to N) 
     * and the number of clicks respectively (1 <= N, K <= 1000). 
     * Each of the following K lines has one of the following:
     * -> CLICK X , where X is the tweet number (1 <= X <= N)
     * -> CLOSEALL
     * 
     * Output:
     * Output K lines, where the ith line should contain the number of open tweets just after the ith click.
     * 
     * Sample 1:
     * Input:
     * 3 6
     * CLICK 1
     * CLICK 2
     * CLICK 3
     * CLICK 2
     * CLOSEALL
     * CLICK 1
     * 
     * Output:
     * 1
     * 2
     * 3
     * 2
     * 0
     * 1
     * 
     * Explanation:
     * Let open[x] = 1 if the xth tweet is open and 0 if its closed.
     * Initially open[1..3] = { 0, 0, 0 }.
     * Here is the state of open[1..3] after each click and corresponding count of open tweets.
     * CLICK 1 : { 1, 0, 0 }, open count = 1
     * CLICK 2 : { 1, 1, 0 }, open count = 2
     * CLICK 3 : { 1, 1, 1 }, open count = 3
     * CLICK 2 : { 1, 0, 1 }, open count = 2
     * CLOSEALL : { 0, 0, 0 }, open count = 0
     * CLICK 1 : { 1, 0, 0 }, open count = 1
     */
    public static void solveCodeChefTWTCLOSE() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong(); 
        long K = scn.nextLong();
        boolean[] tweets = new boolean[(int)N];
        long open = 0;
        for (long t = 0; t < N; t++)
            tweets[(int)t] = false;
        while (K-- > 0) {
            String S = scn.next();
            if (S.equals("CLICK")) {
                long i = scn.nextLong();
                if (tweets[(int)(i - 1)])
                    open--;
                else
                    open++;
                tweets[(int)(i - 1)] = !tweets[(int)(i - 1)];
            }
            else {
                open = 0;
                for (long t = 0; t < N; t++)
                    tweets[(int)t] = false;
            }
            System.out.println(open);
        }
        scn.close();
    }

    /*
     * Problem: Binary String Cost
     * 
     * According to the new tax scheme, a new tax called the binary string tax was introduced! 
     * JJ has a binary string S of length N. According to the tax scheme, for every occurrence of 01 in S, 
     * a tax of X rupees will be charged, while for every occurrence of 10 in S, a tax of Y rupees will be charged.
     * For example, if X = 5, Y = 7 and S = 11010, then S has 1 occurrence of 01 and 2 occurrences of 10,
     * so the tax charged = 5 * 1 + 7 * 2 = 19
     * JJ can rearrange the string S in any way he wants. 
     * He wants to minimize the amount of tax he has to pay. Can you help him do so?
     * 
     * Input Format:
     * The first line contains a single integer T - the number of test cases. Then the test cases follow.
     * The first line of each test case contains three integers N, X and Y - 
     * the length of the binary string S, the tax charged on an occurrence of 01 and the tax charged on an occurrence of 10.
     * The second line of each test case contains a binary string S of length N containing 0s and 1s only.
     * 
     * Output Format:
     * For each test case, output the minimum amount of tax that JJ has to pay.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 2 <= N <= 1000
     * 1 <= X, Y <= 100
     */
    public static void solveCodeChefBSCOST() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long X = scn.nextLong();
            long Y = scn.nextLong();
            String S = scn.next();
            long zeros = 0;
            long ones = 0;
            for (long i = 0; i < N; i++) {
                if (S.charAt((int)i) == '0')
                    zeros++;
                else
                    ones++;
            }
            if (zeros == 0 || ones == 0)
                System.out.println(0);
            else if (X <= Y)
                System.out.println(X);
            else
                System.out.println(Y);
        }
        scn.close();
    }

    /*
     * Problem: Olympics 2024
     * 
     * Athletes of Chefland have won G gold medals, S silver medals, and B bronze medals in the Paris Olympics.
     * Chef will be happy only if the Chefland team wins 5 medals of each type. 
     * Find the total number of additional medals the team needs to win to make Chef happy.
     * 
     * Input Format:
     * The first and only line of input will contain three space-separated integers G, S and B -
     * the number of gold, silver, and bronze medals, respectively.
     * 
     * Output Format:
     * For each test case, output on a new line, the total number of additional medals the team needs to win to make Chef happy.
     * 
     * Constraints:
     * 1 <= G, S, B <= 5
     */
    public static void solveCodeChefOLYMPICS24() {
        Scanner scn = new Scanner(System.in);
        long G = scn.nextLong(); 
        long S = scn.nextLong(); 
        long B = scn.nextLong();
        long medals = G + S + B;
        long left = 15 - medals;
        System.out.println(left < 0 ? 0 : left);
        scn.close();
    }

    /*
     * Problem: No Winner
     * 
     * After a series of matches between Alice, Bob, and Cameron, their scores are A, B, and C, respectively.
     * Chef plans to organise M additional matches. In each match, two players compete, and there is exactly one winner.
     * The winner of the match receives one point.
     * Determine if it is possible for at least two players to end up with the same score after all M additional matches have been completed.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case contains four space-separated integers A, B, C and M - 
     * the initial scores of Alice, Bob, and Cameron, and the number of additional matches, respectively.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: 
     * YES, if it is possible for at least two players to end up with the same score after these M matches, and NO otherwise.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= A, B, C, M <= 10
     */
    public static void solveCodeChefNOWINNER() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long A = scn.nextLong();
            long B = scn.nextLong();
            long C = scn.nextLong();
            long M = scn.nextLong();
            long diffAB = Math.abs(A - B);
            long diffBC = Math.abs(B - C);
            long diffAC = Math.abs(A - C);
            if (diffAB <= M || diffBC <= M || diffAC <= M)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        scn.close();
    }

    /*
     * Problem: Clearance Sale
     *
     * Chef's favorite clothing store is holding a clearance sale: for every 2 t-shirts bought, you receive a third one for free!
     * Chef bought and paid for X t-shirts from the shop. It is guaranteed that X is even.
     * How many t-shirts did Chef get from the shop in total?
     *
     * Input Format:
     * The first and only line of input contains a single even integer X, the number of t-shirts Chef paid for.
     *
     * Output Format:
     * For each test case, output on a new line one integer: the total number of t-shirts Chef will get from the store.
     *
     * Constraints:
     * 2 <= X <= 100
     * X is even.
     */
    public static void solveCodeChefCLEARANCE() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        System.out.println(X + X / 2);
        scn.close();
    }

    /*
     * problem: Gold Coins 101
     *
     * Chef and Chefina are competing against each other in a football game where the player scoring the maximum goals, wins.
     * It is known that the winner of the game receives A gold coins while the loser receives B gold coins.
     * Given that Chef scored X goals and Chefina scored Y goals (X != Y), find the number of coins Chef would receive.
     *
     * Input Format:
     * The first and only line of input will contain four space-separated integers, A, B, X, and Y, denoting the coins rewarded to winner, 
     * coins rewarded to loser, goals scored by Chef, and goals scored by Chefina respectively.
     *
     * Output Format:
     * Output a single integer denoting the number of coins Chef would receive.
     *
     * Constraints:
     *
     * 1 <= B < A <= 10
     * 1 <= X, Y <= 5, X != Y
     */
    public static void solveCodeChefGOLDCOINS() {
        Scanner scn = new Scanner(System.in);
        long A = scn.nextLong(); 
        long B = scn.nextLong();
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println(X >= Y ? A : B);
        scn.close();
    }

    /*
     * Problem: Approximate Answer
     *
     * You are solving a problem whose correct answer is the integer Y.
     * The answer you obtained, however, is the integer X.
     * Your answer will be considered correct if the difference between X and Y is at most K.
     * In other words, your answer is considered correct if and only if: |X - Y| <= K
     * Given the values of X, Y, and K, determine whether your answer X is correct or not.
     * Note that |X| denotes the absolute value of X.
     * For example, |12∣ = 12, |−15| = 15 and |0| = 0.
     *
     * Input Format:
     * The first and only line of input will contain three space-separated integers X, Y and K - 
     * your answer, the correct answer, and the the maximum allowed difference, respectively.
     *
     * Output Format:
     * Output the answer on a single line: "Yes" if your answer is considered correct, and "No" otherwise (without quotes).
     * Each letter of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings NO, no, No, and nO will all be treated as equivalent.
     *
     * Constraints:
     * 1 <= X, Y, K <= 20
     */
    public static void solveCodeChefP1149() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        long Y = scn.nextLong();
        long K = scn.nextLong();
        System.out.println(Math.abs(X - Y) <= K ? "Yes" : "No");
        scn.close();
    }

    /*
     * Problem: Let Me Eat Cake!
     *
     * Alice and Bob both bought a full cake each.
     * Alice's cake has A slices, and Bob's cake has B slices.
     * Alice will be unhappy if she has strictly less slices than Bob does. 
     * Similarly, Bob will be unhappy if he has strictly less slices than Alice does.
     * Charlie doesn't want either of his friends to be unhappy, 
     * so he proposes a solution: while either Alice or Bob are unhappy, 
     * he will attempt to restore happiness by eating half the remaining slices (rounded up) of whoever has more of them.
     * For example:
     * If A = 8 and B = 5, Charlie will eat half of Alice's slices, which is 8 / 2 = 4 slices.
     * If A = 2 and B = 5, Charlie will eat half of Bob's slices, which is 5 / 2​ slices - rounded up, this is 3 slices.
     * How many slices of cake will Charlie eat in total?
     * The sample tests below have an explained example.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of input contains two space-separated integers A and B: Alice's and Bob's initial number of slices.
     *
     * Output Format:
     * For each test case, output on a new line the number of slices of cake Charlie will eat.
     *
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= A, B <= 100
     */
    public static void solveCodeChefCAKEHALF() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long A = scn.nextLong(); 
            long B = scn.nextLong();
            long eaten = 0;
            while (A != B) {
                long toEat = ( A > B) ? (A / 2 + A % 2) : (B / 2 + B % 2);
                if ( A > B)
                    A -= toEat;
                else
                    B -= toEat;
                eaten += toEat;
            }
            System.out.println(eaten);
        }
        scn.close();
    }

    /*
     * Problem: Independence Day 101
     *
     * On the occasion of Independence Day, Chef wants to design a new flag for the country of Chefland.
     * He has some equal-sized strips in three different colors and needs to arrange them in a line 
     * so that no two adjacent strips share the same color.
     * Given that Chef has A orange strips, B white strips, and C green strips, 
     * determine if it is possible to design such a flag using all the strips.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of three space-separated integers A, B, and C - 
     * the number of strips of orange, white, and green color respectively.
     *
     * Output Format:
     * For each test case, output on a new line, YES, if it is possible to design a flag 
     * using all the strips such that no two adjacent strips share the same color. Otherwise, print NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     *
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= A, B, C <= 10
     */
    public static void solveCodeChefINDEPENDENCE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long A = scn.nextLong(); 
            long B = scn.nextLong();
            long C = scn.nextLong();
            long max = (A >= B && A >= C) ? A : ((B >= A && B >= C) ? B : C);
            long min = (A <= B && A <= C) ? A : ((B <= A && B <= C) ? B : C);
            long med = A + B + C - min - max;
            System.out.println(((max - min) <= 1 || (max - med - min) <= 1) ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Magical World
     *
     * Alice has two coloured shapes:
     * A red rectangle with length A units, and width B units.
     * A blue square with an edge length of X units.
     * Alice lives in a magical world where the dimensions of red shapes can be changed.
     * Each change in dimension costs 11 unit of money, 
     * using which you can change any single dimension of a red object to any positive integer.
     * Alice wants to make the area of the blue square greater than or equal to the area of the red rectangle.
     * Find the minimum cost needed to make this possible.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case will contain three space-separated integers A, B, and X - 
     * the length of the red rectangle, the width of the red rectangle, and the length of the edge of the blue square.
     *
     * Output Format:
     * For each test case, output on a new line the minimum cost 
     * required to make the area of the blue square greater than or equal to the area of the red rectangle
     *
     * Constraints:
     * 1 <= T <= 10^3
     * 1 <= A, B, X <= 10
     */
    public static void solveCodeChefP2149() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long A = scn.nextLong(); 
            long B = scn.nextLong();
            long X = scn.nextLong();
            if (A * B <= X * X)
                System.out.println(0);
            else if (A <= X * X || B <= X * X)
                System.out.println(1);
            else
                System.out.println(2);
        }
        scn.close();
    }

    /*
     * Problem: IOI 2024
     *
     * IOI 2024 is being held in Egypt, starting from the 1-st of September and ending on the 8-th of September.
     * Given a date X in September, output YES if IOI is ongoing then, otherwise NO.
     *
     * Input Format:
     * The first and only line of input contains one integer X - the date in September.
     *
     * Output Format:
     * Output either YES or NO, depending on whether IOI is ongoing on September X.
     * Each character of the output may be printed in either lowercase or uppercase 
     * - that is, the strings no, NO, No, and nO will all be treated as equivalent.
     *
     * Constraints:
     * 1 <= X <= 30
     */
    public static void solveCodeChefIOI2024() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        System.out.println(X <= 8 ? "YES" : "NO");
        scn.close();
    }
    
    /*
     * Problem: Ratio By 2
     *
     * You have 2 positive integers X and Y.
     * In one operation, you can change the value of one of the integers by 1 or −1.
     * Find the minimum number of operations needed to ensure that either X <= (2 * Y) or Y >= (2 * X), 
     * i.e. either X is at least twice as large as Y, or Y is at least twice as large as X.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of test case contains 22 space-separated integers X and Y.
     *
     * Output Format:
     * For each test case, output on a new line the minimum number of operations.
     *
     * Constraints:
     * 1 <= T <= 81
     * 2 <= X, Y <= 10
     */
    public static void solveCodeChefRATIO2() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            if (X > Y) {
                long aux = X;
                X = Y;
                Y = aux;
            }
            long diff1 = 2 * X - Y;
            long diff2 = X - Y / 2;
            if (diff1 < 0)
                diff1 = 0;
            if (diff2 < 0)
                diff2 = 0;
            System.out.println(Math.min(diff1, diff2));
        }
        scn.close();
    }

    /*
     * Problem: Weightlifting
     * Chef, being an international powerlifter, has participated in a powerlifting competition.
     * The competition consists of three rounds, i.e., squat, bench press, and, deadlift. 
     * In each round, the goal is to lift maximum weight, and Chef gets two attempts to do that.
     * For each round, the score of best attempt is taken into consideration and 
     * the total score is calculated as the sum of scores of all rounds.
     * You are given Chef's score in both attempts of rounds 1, 2, and 3, as A1, A2, B1, B2, C1 and C2​ respectively. 
     * Find the value of Chef's total score in the competition.
     *
     * Input Format:
     * The first and only line of input consists of 6 space separated integers A1, A2, B1, B2, C1, C2, 
     * denoting Chef's score in both attempts of round 1, 2, and 3 respectively.
     *
     * Output Format:
     * Output a single integer denoting Chef's total score in the competition.
     *
     * Constraints:
     * 200 <= A1, A2, B1, B2, C1, C2 <= 300
     */
    public static void solveCodeChefWEIGHTLIFT() {
        Scanner scn = new Scanner(System.in);
        long A1 = scn.nextLong();
        long A2 = scn.nextLong();
        long B1 = scn.nextLong();
        long B2 = scn.nextLong();
        long C1 = scn.nextLong();
        long C2 = scn.nextLong();
        System.out.println(Math.max(A1, A2) + Math.max(B1, B2) + Math.max(C1, C2));
        scn.close();
    }

    /*
     * Problem: Chess Olympiad
     * 
     * The 45-th FIDE Chess Olympiad is currently being held in Budapest, Hungary.
     * Every round, teams of four players each face off against each other in four individual games.
     * A team receives 1 point for winning a game, 0.5 points for a draw, and 0 points for a loss.
     * A team is said to win the round if they receive strictly more points than the opposing team.
     * In the current round, your favorite team has already won X games, drawn Y games, and lost Z games.
     * Can they still win this round?
     * 
     * Input Format:
     * The first and only line of input will contain three space-separated integers X, Y, and Z -
     * the number of wins, draws, and losses so far.
     * 
     * Output Format:
     * Print a single string: either "YES" or "NO" (without quotes), denoting whether your team can still win the round.
     * Each character of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings NO, No, nO, and no will all be treated as equivalent.
     * 
     * Constraints:
     * 0 <= X, Y, Z <= 4
     * X + Y + Z <= 4
     */
    public static void solveCodeChefCHOLY() {
        Scanner scn = new Scanner(System.in);
        scn.nextLong();
        long Y = scn.nextLong();
        long Z = scn.nextLong();
        long maxwins = 4 - Y - Z;
        System.out.println(maxwins > Z ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Range Minimize
     * 
     * You are given an array A containing N integers.
     * You can delete at most two of its elements.
     * Find the minimum possible value of max(A) - min(A) (in other words, the range of A) after the deletions.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * The first line of each test case contains a single integer N - the length of the array.
     * The second line contains N space-separated integers A1, A2, ..., AN
     * 
     * Output Format:
     * For each test case, output on a new line the minimum possible value of max(A) - min(A) after at most two deletions.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 3 <= N <= 2*10^5
     * 1 <= Ai <= 10^9
     * The sum of N over all test cases won't exceed 2*10^5
     */
    public static void solveCodeChefMNR() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            ArrayList<Long> list = new ArrayList<>();
            for (long i = 0; i < N; i++)
                list.add(scn.nextLong());
            Collections.sort(list);
            long min1 = list.get(list.size() - 1) - list.get(2);
            long min2 = list.get(list.size() - 3) - list.get(0);
            long min3 = list.get(list.size() - 2) - list.get(1);
            if (min1 <= min2 && min1 <= min3)
                System.out.println(min1);
            else if (min2 <= min1 && min2 <= min3)
                System.out.println(min2);
            else
                System.out.println(min3);
        }
        scn.close();
    }
    
    /*
     * Problem: Winning World Finals
     * 
     * Chef's team is participating in the ICPC World Finals.
     * The contest is 300 minutes long, of which M minutes have passed already.
     * Chef's team has only one problem left to solve. Their time penalty so far is P.
     * At any minute strictly before the 300-th, the team can make a submission.
     * When making a submission at minute X, one of two things can happen:
     * 1.- The submission is correct.
     * In this case, X (the time of the submission) gets added to the team's time penalty. 
     * No more submissions can be made after this.
     * 2.- The submission is wrong.
     * In this case, 2020 gets added to the team's time penalty. 
     * The team must then wait at least one minute before making the next submission.
     * Chef believes that as long as his team solves the problem and has a final penalty of <= 1000, 
     * they will place first.
     * Find the maximum number of wrong submissions that Chef's team can make, 
     * while still ensuring that they win the contest.
     * The first submission can be made immediately at minute M.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case will contain two space-separated integers M and P - 
     * the number of minutes that have already passed, and the team's initial penalty.
     * 
     * Output Format:
     * For each test case, output on a new line the maximum number of wrong submissions 
     * Chef can make while still winning the contest.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 0 <= M < 300
     * 0 <= P <= 700
     */
    public static void solveCodeChefWFWIN() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long M = scn.nextLong();
            long P = scn.nextLong();
            long max_wrongs_left = 300 - M - 1;
            // P + 20 * w + (M + w) <= 1000
            // P + 21 * w + M <= 1000
            // 21 * w <= 1000 - P - M
            // w <= (1000 - P - M) / 21;
            long max_allowed_wrongs = (1000 - P - M) / 21;
            System.out.println(Math.min(max_allowed_wrongs, max_wrongs_left));
        }
        scn.close();
    }

    /*
     * Problem: AI is Coming
     *
     * You are given an assignment from your institute.
     * Each assignment has a difficulty value between 1 and 100 (both inclusive).
     * AI can solve an assignment if and only if the difficulty of the assignment is less than or equal to 60.
     * Your current assignment has difficulty X.
     * Is AI capable of solving your assignment?
     * Print "YES" if it is, and "NO" if it isn't (without the quotes).
     *
     * Input Format:
     * The first and only line of input will contain a single integer X, denoting the difficulty of your assignment.
     *
     * Output Format:
     * If AI is capable of solving your assignment output "YES", otherwise print "NO" (without quotes).
     * Each character of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings no, NO, No, and nO will all be treated as equivalent.
     *
     * Constraints:
     * 1 <= X <= 100
     */
    public static void solveCodeChefAICOM() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        System.out.println(X <= 60 ? "YES" : "NO");
        scn.close();
    }
    
    /*
     * Problem: Make Arithmetic Progression
     *
     * You are given three positive integers X, Y, and Z.
     * In one operation, you can choose any one of these values, and change it to any integer of your choice.
     * Find the minimum number of operations required to make the sequence (X, Y, Z) an arithmetic progression.
     * Note that (X, Y, Z) is an arithmetic progression if and only if Y − X = Z − Y.
     *
     * Input Format:
     *
     * The first line of input contains a single integer T, denoting the number of testcases.
     * The first and only line of each testcase contains three space-separated integers X, Y and Z, denoting the three numbers.
     *
     * Output Format:
     * For each test case, print one line containing a single integer: 
     * the minimum number of operations such that (X, Y, Z) forms an arithmetic progression.
     *
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= X, Y, Z <= 100
     */
    public static void solveCodeChefAP() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            long Z = scn.nextLong();
            System.out.println((Y - X == Z - Y) ? 0 : 1);
        }
        scn.close();
    }

    /*
     * Problem: Butterfly
     * In your garden, there are exactly R red butterflies, G green butterflies and B blue butterflies.
     * There are also exactly R red flowers, G green flowers and B blue flowers.
     * Determine whether it is possible for every butterfly to feed on exactly one flower, such that:
     * No two butterflies feed on the same flower; and
     * Each butterfly feeds on a flower whose color is different from its own color.
     * For example, a red butterfly can only feed on green and blue flowers, not red flowers.
     *
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case contains three space-separated integers R, G and B - 
     * the number of red, green and blue butterflies (and flowers) respectively.
     *
     * Output Format:
     * For each test case, output on a new line "YES" if it is possible for the butterflies to feed appropriately, and "NO" otherwise.
     * Your output must not contain the quotation marks.
     * Each character of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings no, NO, nO, and No will be treated as equivalent.
     *
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= R, G, B <= 10^8
     */
    public static void solveCodeChefBFLY() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long R = scn.nextLong();
            long G = scn.nextLong();
            long B = scn.nextLong();
            boolean imposible = (R > G + B) || (G > R + B) || (B > R + G);
            System.out.println(imposible == true ? "NO" : "YES");
        }
        scn.close();
    }

    /*
     * Problem: Coldplay Tickets
     * You want to go to the Coldplay concert along with N of your friends. You are buying tickets for everyone.
     * Each ticket costs 5000 INR. Calculate the total amount you need to pay (in INR).
     * 
     * Input Format:
     * The first and only line of input contains N - the number of friends you have.
     * 
     * Output Format:
     * For each test case, output on a new line the total cost of all tickets for yourself and your friends.
     * 
     * Constraints:
     * 1 <= N <= 5
     */
    public static void solveCodeChefCOLDPLAYTICK() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong(); 
        System.out.println((N + 1) * 5000);
        scn.close();
    }

    /*
     * Problem: Calorie Limit
     * 
     * Sushil is a diabetic patient. He is only allowed to eat at most K calories in a day. 
     * However, he likes to eat sweets a lot.
     * There are N sweets in front of him. The i-th sweet has a calorie count of Ai.
     * Sushil will eat the sweets in order, i.e. he will start from the 1-st sweet, 
     * then the 2-nd, then the 3-rd, and so on.
     * If eating the i-th sweet would take him over his daily calorie limit, 
     * he will not eat it, and he will also not eat any further sweets.
     * Find the maximum number of sweets Sushil can eat without exceeding his calorie limit.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * The first line of each test case contains two space-separated integers N and K - 
     * the number of sweets and the calorie limit, respectively.
     * The second line contains N space-separated integers - A1, A2, ..., AN.
     * 
     * Output Format:
     * For each test case, output on a new line the maximum number of sweets 
     * Sushil can eat in order without exceeding his calorie limit.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 1 <= Ai <= 100
     * 1 <= K <= 10^4
     */
    public static void solveCodeChefCALLIM() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            long sum = 0;
            long sweets = 0;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                if (sum + Ai <= K)
                    sweets++;
                sum += Ai;
            }
            System.out.println(sweets);
        }
        scn.close();
    }

    /*
     * Problem: Add 1 or 2 Game
     * 
     * Alice and Bob play a game.
     * There is an integer X, which is initially 0. 
     * On their turn, Alice or Bob can choose to increment X by either 1 or 2.
     * The game ends as soon as X >= N holds. 
     * When the game ends, Bob wins the game if X = N, otherwise Alice wins the game.
     * Alice goes first, and the players alternate turns.
     * If both players play optimally, predict the winner.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case contains a single integer N - the limit for the game.
     * 
     * Output Format:
     * For each test case, output on a new line the name of the winner: 
     * the string "ALICE" if Alice wins the game, and "BOB" if Bob wins the game (without the quotes).
     * Each character of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings Bob, BOB, bOb, and bOB will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T <= 10
     * 1 <= N <= 10
     */
    public static void solveCodeChefADD12GAME() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            System.out.println(N == 1 ? "ALICE" : "BOB");
        }
        scn.close();
    }

    /*
     * Problem: Truth Teller And Liars 101
     * 
     * You are a traveler and you are at a junction of 2 paths - 
     * one leads to eternal happiness, the other to certain doom.
     * There are a total of N + M people, N of which always tell the truth, 
     * while the remaining M may tell the truth or lie. All of them are aware of which path leads to where.
     * You don't know who is a truth teller and who is not. 
     * You will ask some randomly chosen X people the following question:
     * Which among the 2 paths leads to eternal happiness?
     * Is it possible for you to be sure which paths leads to eternal happiness?
     * If it is possible, find the minimal X where you can be sure of the path 
     * regardless of which X people you end up asking. Otherwise, print -1.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case contains two space-separated integers N and M - 
     * the number of truth tellers, and the number of people who may or may not tell the truth.
     * 
     * Output Format:
     * For each test case, output the following:
     * −1 if there is no way to figure out which path is the path to happiness.
     * Otherwise, print an integer X (1 <= X <= N + M), 
     * where X is the minimum integer such that you can be sure of the path after asking any X people.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N, M <= 10
     */
    public static void solveCodeChefTRUTHLIE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long M = scn.nextLong();
            System.out.println(N <= M ? -1 : M * 2 + 1);
        }
        scn.close();
    }

    /*
     * Problem: Your Name is Mine
     * 
     * In an attempt to control the rise in population, Archer was asked to come up with a plan. 
     * This time he is targeting marriages. Archer, being as intelligent as he is, came up with the following plan:
     * A man with name M is allowed to marry a woman with name W, 
     * only if M is a subsequence of W or W is a subsequence of M.
     * A is said to be a subsequence of B, if A can be obtained by deleting some elements of B 
     * without changing the order of the remaining elements.
     * Your task is to determine whether a couple is allowed to marry or not, according to Archer's rule.
     * 
     * Input:
     * The first line contains an integer T, the number of test cases. 
     * T test cases follow. Each test case contains two space separated strings M and W.
     * 
     * Output:
     * For each test case print "YES" if they are allowed to marry, else print "NO". 
     * (quotes are meant for clarity, please don't print them)
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= |M|, |W| <= 25000 (|A| denotes the length of the string A.)
     * All names consist of lowercase English letters only.
     */
    public static void solveCodeChefNAME2() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            String M = scn.next();
            String W = scn.next();
            if (M.length() < W.length()) {
                String aux = M;
                M = W;
                W = aux;
            }
            int index = 0;
            for (char c : M.toCharArray()) {
                if (index < W.length() && c == W.charAt(index))
                    index++;
            }
            System.out.println(index == W.length() ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Chef and Parole
     * 
     * Chef must spend at least 7 days in prison to be released on parole.
     * Given the number of days he spent, output YES if will be released, otherwise NO.
     * 
     * Input Format:
     * The first and only line of input consists of an integer X denoting the number of days spent in prison by the Chef
     * 
     * Output Format:
     * Output Yes, if the Chef will be released on parole, and No otherwise.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= X <= 30
     */
    public static void solveCodeChefCHEFPAROLE() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        System.out.println(X >= 7 ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Rectangled
     * 
     * Chef loves rectangles and he wants to draw one with the largest area possible, 
     * but the problem is that his pen has only enough ink left to draw a total of N unit length of line.
     * Help him find the largest area of a rectangle which he can draw 
     * if he wants to draw rectangles with integral sides only.
     * Note that he does NOT need to finish all the ink.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single integer N on a new line, denoting the ink left.
     * 
     * Output Format:
     * For each test case, output on a new line the area of the largest rectangle Chef can draw.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 10^3
     */
    public static void solveCodeChefRCTGLD() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong() / 2;
            System.out.println((N / 2) * (N - N / 2));
        }
        scn.close();
    }

    /*
     * Problem: Sweets Shop
     * 
     * Sushil went to a sweet shop because he always craves to eat sweets. 
     * This is not good for his health as he has diabetes, but he doesn't care. 
     * A laddu costs Rs. 10 while a jalebi costs Rs. 20.
     * Initially, Sushil had Rs. X but then Sushil bought N laddus, 
     * how many jalebis can he buy with the remaining money?
     * 
     * Input Format:
     * The first line of input contains X and N - 
     * the initial amount of money Sushil had and the number of laddus he bought already.
     * 
     * Output Format:
     * For each test case, output on a new line the the number of jalebis he can buy.
     * 
     * Constraints:
     * 1 <= X <= 100
     * 1 <= N <= 10
     * 10 * N <= X
     */
    public static void solveCodeChefSWEETSHOP() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        long N = scn.nextLong();        
        System.out.println((X - (N * 10)) / 20);
        scn.close();
    }

    /*
     * Problem: Long Queue
     * Unfortunately as soon as Sushil reached the sweet shop, he saw there was a huge queue. 
     * At first, Sushil joins at the end of the line. 
     * But he is impatient and now has decided to bully people in front of him, by flexing his wealth, so that they let him proceed.
     * There are N people in the line, with the i-th person having a wealth of Rs. Ai. 
     * Sushil is currently the N-th person in this line.
     * Everytime Sushil sees that the person directly in front of him has a wealth less than or equal to half of his own wealth, 
     * Sushil will bully him out of the line, and the queue will reduce by 1. 
     * Note that Sushil can only bully the person directly infront of him.
     * More formally, if Sushil has wealth X, he can bully people with wealth smaller than or equal to X / 2. 
     * Find the final position of Sushil.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of input contains N - the number of people in the queue including Sushil.
     * The second line contains N integers - A1, A2, ..., AN, the wealths of all the people in the queue.
     * 
     * Output Format:
     * For each test case, output on a new line the final position of Sushil after he finishes bullying people.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 2 <= N <= 100
     * 1 <= Ai <= 100
     */
    public static void solveCodeChefLONGQUEUE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            ArrayList<Long> Ai = new ArrayList<>();
            while (N-- > 0)
                Ai.add(scn.nextLong());
            int pos = Ai.size() - 1;
            long X = Ai.get(pos) / 2;
            for (int i = Ai.size() - 2; i >= 0; i--) {
                if (Ai.get(i) > X)
                    break;
                pos--;
            }
            System.out.println(pos + 1);
        }
        scn.close();
    }

    /*
     * Problem: Bi_lindrome!
     * 
     * You are given a string S of length N.
     * Your task is to delete a subsequence of maximum length from the string, such that, 
     * after concatenating the remaining parts of the string, it becomes a palindrome of length greater than 1.
     * If this is possible, print the maximum length of the subsequence that can be deleted. Otherwise, print -1.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of 2 lines of input:
     * 1.- The first line consists the a single integer N - the length of string S.
     * 2.- The second line contains string S, consisting of lowercase english alphabets.
     * 
     * Output Format:
     * For each test case, if it is possible to delete a subsequence under the given conditions, 
     * print a single integer, denoting the maximum length of the subsequence that can be deleted. Otherwise, print -1.
     * 
     * Constraints:
     * 1 <= T <= 2500
     * 3 <= N <= 100
     * S consists of lowercase english alphabets.
     */
    public static void solveCodeChefQTOO_2523() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            scn.nextLong();
            String S = scn.next();
            boolean found = false;
            HashMap<Character, Boolean> hashMap = new HashMap<>();
            for (char c : S.toCharArray()) {
                if (hashMap.containsKey(c)) {
                    found = true;
                    break;
                }
                else
                    hashMap.put(c, true);
            }
            System.out.println(found ? S.length() - 2 : -1);
        }
        scn.close();
    }

    /*
     * Problem: Diwali Discount
     * 
     * Chef is trying to buy a Diwali gift for Rs. A, and he has a voucher for Rs. B. 
     * Chef will have to pay the remaining amount after applying the voucher. 
     * If the voucher's value exceeds the gift's value, Chef will not have to pay anything.
     * Find the amount that Chef will pay for buying the gift.
     * 
     * Input Format:
     * The first and only line of input contains 2 integers - A and B.
     * 
     * Output Format:
     * For each test case, output on a new line the amount paid by Chef.
     * 
     * Constraints:
     * 1 <= A, B <= 5000
     */
    public static void solveCodeChefDIWALIDISC() {
        Scanner scn = new Scanner(System.in);
        long A = scn.nextLong(); 
        long B = scn.nextLong();        
        System.out.println(B >= A ? 0 : A - B);
        scn.close();
    }

    /*
     * Problem: Glass Prices
     * 
     * Chef is buying spectacles, and is now deciding on which frame to purchase.
     * Chef has narrowed his options down to two choices: 
     * a plastic frame that costs X rupees, and a metal frame that costs Y rupees.
     * Chef will buy the metal frame if and only if it costs at most twice the price of the plastic frame - 
     * otherwise he will buy the plastic frame.
     * Can you decide which frame Chef will buy?
     * 
     * Input Format:
     * The first and only line of input will contain two integers X and Y - 
     * the price of the plastic frame and the metal frame, respectively.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: the type of frame Chef will purchase.
     * This is either the string "PLASTIC" or the string "METAL" (without quotes) depending on the outcome.
     * Each letter of the output may be printed in either uppercase or lowercase - 
     * for example, the strings METAL, MeTaL, metal, and mEtAL will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= X <= 2000
     * 1 <= Y <= 2000
     */
    public static void solveCodeChefGLPR() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        long Y = scn.nextLong();        
        System.out.println(Y > 2 * X ? "PLASTIC" : "METAL");
        scn.close();
    }

    /*
     * Problem: Even vs Odd Divisors
     * 
     * Given an integer N, 
     * let f(N) denote the number of even divisors of N g(N) denote the number of odd divisors of N.
     * For example, the divisors of 6 are 1, 2, 3 and 6. 
     * f(N) = 2, g(N) = 2 as there are 2 even and 2 odd numbers in this list;
     * Find whether f(N) > g(N) or f(N) = g(N) or f(N) < g(N).
     * 
     * Output:
     * 1 if f(N) > g(N)
     * 0 if f(N) = g(N)
     * -1 if f(N) < g(N)
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line consists of a single integer N.
     * 
     * Output Format:
     * For each test case, output on a new line:
     * 1 if f(N) > g(N)
     * 0 if f(N) = g(N)
     * -1 if f(N) < g(N)
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     */
    public static void solveCodeChefEVENODDDIV() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            ArrayList<Long> d = CodeChefLibrary.divisors(N);
            long even = 0;
            long odd = 0;
            for (long i : d) {
                if (i % 2 == 0)
                    even++;
                else
                    odd++;
            }
            if (even == odd)
                System.out.println(0);
            else if (even > odd)
                System.out.println(1);
            else
                System.out.println(-1);
        }
        scn.close();
    }

    /*
     * Problem: Non-matching Name
     * 
     * Alice and Bob invented a brand-new algorithm - but they can't decide what to name it!
     * Alice suggested the name SA, and Bob suggested the name SB.
     * (SA and SB are both strings of lowercase English letters.)
     * However, Alice thinks Bob's naming sense is really bad -
     * she'll only be happy if the name given to the algorithm is not close to SB at all.
     * More specifically, Alice will be happy if and only if the algorithm's name does not share any characters with SB.
     * Similarly, Bob thinks Alice's naming sense is really bad, 
     * and will only be happy if the algorithm's name doesn't share any characters with SA.
     * Is there a way to name the algorithm (using only lowercase English letters) so that both Alice and Bob are happy?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of three lines of input.
     * The first line of each test case contains two space-separated integers N and M - 
     * the length of SA and the length of SB, respectively.
     * The second line contains the string SA. 
     * The third line contains the string SB.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: 
     * "YES" if a valid name exists for the algorithm, and "NO" otherwise.
     * Each letter of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings NO, No, nO, and no will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N <= 50
     * 1 <= M <= 50
     * SA and SB contain only lowercase English letters, i.e, the characters 'a' through 'z'.
     */
    public static void solveCodeChefABNOMAT() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            scn.nextLong();
            scn.nextLong();
            String SA = scn.next();
            String SB = scn.next();
            HashMap<Character, Long> hashMap = new HashMap<>();
            for (char c : SA.toCharArray())
                hashMap.put(c, hashMap.getOrDefault(c, 0L) + 1);
            for (char c : SB.toCharArray())
                hashMap.put(c, hashMap.getOrDefault(c, 0L) + 1);
            System.out.println(hashMap.size() == 26 ? "NO" : "YES");
        }
        scn.close();
    }

    /*
     * Problem: Icecream and Cone
     * 
     * Chef has X cones and Y scoops of ice cream. Each ice cream cone requires exactly one cone and one scoop of ice cream.
     * Your task is to determine the maximum number of ice cream cones Chef can make with the available ingredients.
     * 
     * Input Format:
     * Input will contain two integers X and Y - the number of cones and ice cream scoops, respectively.
     * 
     * Output Format:
     * Output the maximum number of ice cream cones Chef can make.
     * 
     * Constraints:
     * 1 <= X <= 100
     * 1 <= Y <= 100
     */
    public static void solveCodeChefICECONE() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong(); 
        long Y = scn.nextLong();        
        System.out.println(Math.min(X, Y));
        scn.close();
    }

    /*
     * Problem: Movie Snacks
     * 
     * Chef is watching a movie, and during the intermission, wants to get himself some snacks.
     * A bucket of popcorn costs X rupees, and a drink costs Y rupees.
     * There is also a combo offer available, which provides one bucket of popcorn and one drink at a cost of Z rupees.
     * Chef wants to buy two buckets of popcorn and three drinks.
     * What's the minimum amount he needs to pay to do so?
     * 
     * Input Format:
     * The first and only line of input will contain three space-separated integers X, Y and Z - 
     * the price of one bucket of popcorn, one drink, and the combo, respectively.
     * 
     * Output Format:
     * Print a single integer: the minimum price Chef needs to pay to buy two buckets of popcorn and three drinks.
     * 
     * Constraints:
     * 50 <= X, Y, Z <= 200
     * X, Y <= Z
     */
    public static void solveCodeChefMOVPR() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        long Z = scn.nextLong();
        long P1 = X * 2 + Y * 3;
        long P2 = 2 * Z + Y;
        System.out.println(Math.min(P1, P2));
        scn.close();
    }

    /*
     * Problem: Card Game
     * 
     * There is a set of N cards where each card is numbered 1 to N.
     * Chef throws a card numbered X.
     * Find the number of ways, Chefina can chose a card from the remaining deck such that, the sum of chosen card and X is even.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two space-separated integers N and X - the number of cards and the card thrown by Chef.
     * 
     * Output Format:
     * For each test case, output on a new line, the number of ways, Chefina can chose a card from the remaining deck such that, 
     * the sum of chosen card and X is even.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 2 <= N <= 1000
     * 1 <= X <= N
     */
    public static void solveCodeChefCARDGAME1() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long X = scn.nextLong();
            if (X % 2 == 0)
                System.out.println(N / 2 - 1);
            else
                System.out.println(N / 2 + (N % 2) - 1);
        }
        scn.close();
    }

    /*
     * Problem: Too Many Oranges
     * 
     * Chef has N oranges with him. Each orange has either 10, 11 or 12 slices.
     * Chef wanted to eat exactly K slices of orange. 
     * However, the oranges were too tasty, and Chef ended up eating all N of them!
     * Chef wasn't paying attention, so he didn't count the number of slices he ate, 
     * and he also doesn't know how many slices each orange had -
     * the only thing he knows is that each orange has either 10, 11 or 12 slices.
     * Is it possible that Chef ate exactly K slices from N oranges?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single line of input, containing two space-separated integers N and K - 
     * the number of oranges, and the number of slices Chef wants to eat.
     * 
     * Output Format:
     * For each test case, output on a new line the answer: 
     * "YES" if Chef could have eaten exactly N orange slices, and "NO" otherwise. 
     * The output should be without quotes. Each character of the output may be printed in either uppercase or lowercase, 
     * i.e, the strings No, NO, nO, and no will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T <= 5000
     * 1 <= N <= 30
     * 1 <= K <= 500
     */
    public static void solveCodeChefORANGES() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            System.out.println((N * 10 > K || N * 12 < K) ? "NO" : "YES");
        }
        scn.close();
    }

    /*
     * Problem: Moneymaking
     * 
     * Chef has X nuggets and Y star pieces with him.
     * Each nugget sells for 5000 coins, and each star piece sells for 9800 coins.
     * How much money can Chef make by selling all of his items?
     * 
     * Input Format:
     * The only line of input will contain two space-separated integers X and Y - 
     * the number of nuggets and star pieces Chef has.
     * 
     * Output Format:
     * Output a single integer: the amount of money Chef can earn by selling all his items.
     * 
     * Constraints:
     * 0 <= X, Y <= 10
     */
    public static void solveCodeChefNUGGET() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println(X * 5000 + Y * 9800);
        scn.close();
    }

    /*
     * Problem: Selling Donuts
     * 
     * Chef owns a donut shop, which sells N different types of donuts, numbered from 1 to N.
     * Today, he baked Ai donuts of the i-th type.
     * M customers will visit the shop. The i-th customer wants to buy exactly one donut of type Bi.
     * If Chef has no remaining donuts of type i, the i-th customer will become sad.
     * How many customers will become sad?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of three lines of input.
     * The first line of each test case contains two space-separated integers N and M - 
     * the number of donut types and the number of customers.
     * The second line contains N space-separated integers A1, A2, ..., AN, the number of each type of donut that Chef has.
     * The third line contains M space-separated integers B1, B2, ..., BM, denoting the types of donuts the M customers want.
     * 
     * Output Format:
     * For each test case, output on a new line a single integer: the number of customers who will become sad.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 1 <= M <= 100
     * 0 <= Ai <= 100
     * 1 <= Bi <= N
     */
    public static void solveCodeChefDONUTSELL() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long M = scn.nextLong();
            ArrayList<Long> backed = new ArrayList<>();
            for (long i = 0; i < N; i++)
                backed.add(scn.nextLong());
            long sad = 0;
            for (long i = 0; i < M; i++) {
                int Bi = (int)scn.nextLong() - 1;
                long remain = backed.get(Bi);
                if (remain == 0)    
                    sad++;
                else
                    backed.set(Bi, remain - 1);
            }
            System.out.println(sad);
        }
        scn.close();
    }

    /*
     * Problem: Card Swipe
     * 
     * In the bustling CodeChef office, the entrance is equipped with a high-tech card swipe system. 
     * Each employee is assigned a unique ID card that they use to swipe in and out of the building.
     * The system records every swipe, capturing the first swipe of an ID as in, second as out, 
     * third as in, and so on. Given an array A consisting of N IDs denoting N swipes throughout the day, 
     * find the maximum number of people in the office at any time.
     * Note that there is nobody inside the office before the first swipe.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains an integer N - the number of swipes throughout the day.
     * The next line contains N space-separated integers denoting the ID of the ith swipe.
     * 
     * Output Format:
     * For each test case, output on a new line, the maximum number of people in the office at any time.
     * 
     * Constraints:
     * 1 <= T <= 2*10^5
     * 1 <= N <= 2*10^5
     * 1 <= Ai <= N
     * The sum of N over all test cases won't exceed 10^6.
     */
    public static void solveCodeChefCARDSWIPE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long in = 0;
            long maxIn = 0;
            HashMap<Long, Boolean> hashMap = new HashMap<>();
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                Boolean inOrOut = hashMap.getOrDefault(Ai, true);
                if (inOrOut) {
                    in++;
                    maxIn = Math.max(maxIn, in);
                }
                else
                    in--;
                hashMap.put(Ai, !inOrOut);
            }
            System.out.println(maxIn);
        }
        scn.close();
    }
    
    /*
     * Problem: The Great Run
     * 
     * Vishal loves running. He often visits his favourite Nehru Park and runs for very long distances. 
     * On one such visit he found that the number of girls in the park was unusually high. 
     * Now he wants to use this as an opportunity to impress a large number of girls with his awesome speed.
     * The track on which he runs is an N kilometres long straight path. 
     * There are aiai​ girls standing within the ithith kilometre of this path. 
     * A girl will be impressed only if Vishal is running at his maximum speed when he passes by her. 
     * But he can run at his best speed only for a single continuous stretch of K kilometres. 
     * Now Vishal wants to know what is the maximum number of girls that he can impress.
     * 
     * Input:
     * First line of the input contains the number of testcases T. For each test case,
     * First line contains two space-separated integers N and K, the length of the track and the maximum distance he can run at his best speed.
     * Second line contains N space-separated integers, the number of girls within each kilometre of the track.
     * 
     * Output:
     * For each test case print one line containing an integer, denoting the maximum number of girls Vishal can impress.
     * 
     * Constraints:
     * 1 <= T <= 10
     * 1 <= K <= N <= 100
     * 1 <= ai <= 100
     */
    public static void solveCodeChefPROC18A() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            long actual = 0;
            ArrayList<Long> Ai = new ArrayList<>();
            long i = 0;
            while (i < K) {
                Ai.add(scn.nextLong());
                actual += Ai.get((int)i);
                i++;
            }
            long max = actual;
            long j = 0;
            while (i < N) {
                Ai.add(scn.nextLong());
                actual -= Ai.get((int)j);
                actual += Ai.get((int)i);
                max = Math.max(actual, max);
                j++;
                i++;
            }
            System.out.println(max);
        }
        scn.close();
    }

    /*
     * Problem: Chocolate Distribution
     * 
     * Chef has a total of N (N >= 4) chocolates. He decided to distribute them into three jars such that:
     * -> At least one jar has odd number of chocolates;
     * -> Exactly two jars have same number of chocolates;
     * -> Every jar has at least one chocolate.
     * Find a valid distribution of chocolates for Chef.
     * Note that a valid distribution always exists. If multiple such distributions exist, you may print any.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of a single integer N - the total number of chocolates.
     * 
     * Output Format:
     * 
     * For each test case, output on a new line, 
     * three space-separated integers denoting the number of chocolates in each jar after distribution.
     * Note that a valid distribution always exists. If multiple such distributions exist, you may print any.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 4 <= N <= 10^5
     */
    public static void solveCodeChefCHOCOCHEF() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            System.out.println("1 1 " + (N - 2));
        }
        scn.close();
    }

    /*
     * Problem: Magician versus Chef
     * 
     * When Chef was visiting a fair in Byteland, he met a magician. 
     * The magician had N boxes (numbered 1 through N) and a gold coin. 
     * He challenged Chef to play a game with him; 
     * if Chef won the game, he could have the coin, but if he lost, the magician would kidnap Chef.
     * At the beginning of the game, the magician places the gold coin into the X-th box. 
     * Then, he performs S swaps. To win, Chef needs to correctly identify the position of the coin after all swaps.
     * In each swap, the magician chooses two boxes A and B, 
     * moves the contents of box A (before the swap) to box B and the contents of box B (before the swap) to box A.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first line of each test case contains three space-separated integers N, X and S.
     * S lines follow. Each of these lines contains two space-separated integers A and B denoting a pair of swapped boxes.
     * 
     * Output:
     * For each test case, print a single line containing one integer - 
     * the number of the box containing the gold coin after all swaps are performed.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 2 <= N <= 10^5
     * 1 <= S <= 10^4
     * 1 <= X, A, B <= N
     * A != B
     * the sum of S for all test cases does not exceed 2*10^5
     */
    public static void solveCodeChefMAGICHF() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            scn.nextLong();
            long X = scn.nextLong();
            long S = scn.nextLong();
            for (long i = 0; i < S; i++) {
                long S1 = scn.nextLong();
                long S2 = scn.nextLong();
                if (S1 == X)
                    X = S2;
                else if (S2 == X)
                    X = S1;
            }
            System.out.println(X);
        }
        scn.close();
    }

    /*
     * Problem: Calorie Intake
     * 
     * Chef has decided that he will cut down on his calorie intake. He will eat atmost X calories in a day.
     * Today, he already ate Y sweets, each having Z calories. 
     * Find out how many more calories he can eat. If he has already exceeded his limit, output −1.
     * 
     * Input Format:
     * The first and only line of input contains 3 integers - X, Y and Z.
     * 
     * Output Format:
     * For each test case, output on a new line:
     * -> −1 if Chef has exceeded his calorie limit.
     * -> The amount of calories Chef can still eat if he has not exceeded it.
     * 
     * Constraints:
     * 1 <= X, Y, Z <= 100
     */
    public static void solveCodeChefCALINTAKE() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        long Y = scn.nextLong();
        long Z = scn.nextLong();
        System.out.println(Y * Z > X ? -1 : X - Y * Z);
        scn.close();
    }

    /*
     * Problem: Assignment Score
     * 
     * Chef has a total of N + 1 assignments. He knows his score on the first N of them, 
     * and he is now working on his last assignment. His scores in the first N assignment are A1, A2, ..., AN. 
     * Each of them are graded out of 100 marks, and his total marks is just a sum of all his N + 1 assignment marks.
     * Chef is now worried about he might fail in his course. 
     * He will fail if he scores less than 50% of the total marks. 
     * Can you help Chef find what is the minimum score he needs to get to not fail? 
     * It may be impossible for Chef to pass, output -1 then.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * -> The first line contains N - the number of completed assignments
     * -> The second line contains N integers - A1, A2, ..., AN - the scores on those assignments.
     * 
     * Output Format:
     * For each test case, output on a new line
     * -> The minimum score needed on the N + 1'th assignment for Chef to pass, if it possible for him to pass
     * -> −1 if it is impossible for Chef to pass
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 0 <= Ai <= 100 
     */
    public static void solveCodeChefASSIGNSCORE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long sum = 0;
            for (long i = 0; i < N; i++)
                sum += scn.nextLong();
            long left = (N + 1) * 50 - sum;
            if (left > 100)
                System.out.println(-1);
            else if (left < 0)
                System.out.println(0);
            else
                System.out.println(left);
        }
        scn.close();
    }

    /*
     * Problem: Chef and Socks
     * 
     * Chef needs A dollars to buy himself a new pair of socks for Christmas.
     * If he has X dollars saved up and his parents give him an additional Y dollars, will Chef be able to buy new socks?
     * 
     * Input Format:
     * The first and only line of input will contain 3 space-separated integers A, X, and Y -
     * the cost of the socks, the amount of money Chef has saved up, and the additional money he received from his parents.
     * 
     * Output Format:
     * Output a single string denoting the answer: "YES" if Chef can afford the socks, and "NO" otherwise (without quotes).
     * Each character of the output may be printed in either uppercase or lowercase, 
     * i.e., the strings NO, No, nO, and no will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= A, X, Y <= 100
     */
    public static void solveCodeChefCHEFSOCKS() {
        Scanner scn = new Scanner(System.in);
        long A = scn.nextLong();
        long X = scn.nextLong();
        long Y = scn.nextLong();
        System.out.println(X + Y >= A ? "YES" : "NO");
        scn.close();
    }

    /*
     * problem: Binary Sum
     * 
     * You're given two integers N and K. Your task is to determine if there exists a binary string S of length N such that:
     * S1 + S2 + S3 + ... + SN = K, i.e, the sum of all the digits of the string equals K; 
     * and Si != Si + 1 for every 1 <= i < N, meaning that no two adjacent digits are equal.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case contains two space-separated integers N and K.
     * 
     * Output Format:
     * For each test case, output on a new line a single string denoting the answer: 
     * "YES" if a valid binary string exists, and "NO" otherwise (without quotes).
     * Each character of the output may be printed in either uppercase or lowercase, 
     * i.e., the strings NO, No, nO, and no will all be treated as equivalent.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 0 <= K <= 100
     */
    public static void solveCodeChefBINARYSUM() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long K = scn.nextLong();
            if (N % 2 == 0)
                System.out.println(K == N / 2 ? "YES" : "NO");
            else
                System.out.println(((K == N / 2) || (K == N / 2 + 1)) ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * problem: Even Numbers Hate
     * 
     * Sushil has an array A of N integers - A1, A2, ..., AN​. 
     * He constructs a new array from it, the prefix sum array P = [P1, P2, ..., PN], 
     * where Pi = A1 + A2 + ... + Ai​, i.e. the sum of the first i elements.
     * Sushil hates even numbers but he likes odd numbers, 
     * and thus wants to sure there are as many odd numbers as possible in the prefix sum array P. 
     * He is allowed to play with the array A and rearrange it arbitrarily. 
     * Find the maximum number of odd numbers in the prefix sum array P if Sushil rearranges the array A optimally.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * -> The first line of each test case contains N - the size of the array
     * -> The second line contains N integers - A1, A2, ..., AN.
     * 
     * Output Format:
     * For each test case, output on a new line the maximum possible number of odd numbers in the prefix sum array.
     * 
     * Constraints:
     * 1 <= T <= 100 
     * 1 <= N <= 100
     * 1 <= Ai <= 100
     */
    public static void solveCodeChefEVENHATE() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long even = 0;
            long odd = 0;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                if (Ai % 2 == 0)
                    even++;
                else
                    odd++;
            }
            if (odd == 0)
                System.out.println(0);
            else
                System.out.println(1 + even + (odd - 1) / 2);
        }
        scn.close();
    }

    /*
     * Problem: Three Friends
     * 
     * There are three friends; let's call them A, B, C. They made the following statements:
     * A: "I have x Rupees more than B."
     * B: "I have y rupees more than C."
     * C: "I have z rupees more than A."
     * You do not know the exact values of x, y, z. Instead, you are given their absolute values, 
     * i.e. X = |x|, Y = |y| and Z = |z|. Note that x, y, z may be negative; 
     * "having −r rupees more" is the same as "having r rupees less".
     * Find out if there is some way to assign amounts of money to A, B, C such that all of their statements are true.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first and only line of each test case contains three space-separated integers X, Y and Z.
     * 
     * Output:
     * For each test case, print a single line containing the string "yes" if the presented scenario is possible or "no" otherwise (without quotes).
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= X, Y, Z <= 1000
     */
    public static void solveCodeChefTHREEFR() {
        Scanner scn = new Scanner(System.in);
        long T = scn.nextLong(); 
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            long Z = scn.nextLong();
            if (-X + Y + Z == 0)
                System.out.println("YES");
            else if (X - Y + Z == 0)
                System.out.println("YES");
            else if (X + Y - Z == 0)
                System.out.println("YES");
            else if (-X - Y + Z == 0)
                System.out.println("YES");
            else if (-X + Y - Z == 0)
                System.out.println("YES");
            else if (X - Y - Z == 0)
                System.out.println("YES");
            else 
                System.out.println("NO");
        }
        scn.close();
    }

    /*
     * Problem: The Wave
     * 
     * Chef is stuck in the wavey world of polynomials. 
     * You are given all N roots of a polynomial P(x) = Prod(i = 1 to N)(x − ai). 
     * The roots are pairwise distinct integers, but they are not given in any particular order.
     * To help Chef escape, you should answer Q queries (numbered 1 through Q). 
     * For each valid i, in the i-th query, you are given an integer xi​ and you have to determine whether P(xi​) is positive, negative or 0.
     * 
     * Input:
     * The first line of the input contains two space-separated integers N and Q.
     * The second line contains N space-separated integers a1, a2, ..., aN​.
     * Q lines follow. For each valid i, the i-th of these lines contains a single integer xi​ describing the i-th query.
     * 
     * Output:
     * For each query, print a single line containing the string "POSITIVE", "NEGATIVE" or "0" (without quotes) 
     * describing the value of the polynomial for the ii-th query.
     * 
     * Constraints:
     * 1 <= N, Q <= 2*10^5
     * |ai| <= 10^9 for each valid i
     * a1, a2, ..., aN​ are pairwise distinct
     * |xi| <= 10^9 for each valid i
     */
    public static void solveCodeChefWAV2() {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt(); 
        int Q = scn.nextInt(); 
        int[] a = new int [N];
        for (int i = 0; i < N; i++)
            a[i] = scn.nextInt();
        Arrays.sort(a);
        while (Q-- > 0) {
            int x = scn.nextInt();
            int i = Arrays.binarySearch(a, x);
            if (i >= 0)
                System.out.println("0");
            else {
                i = -i - 1;
                if (i % 2 == 0)
                    System.out.println("POSITIVE");
                else
                    System.out.println("NEGATIVE");
            }
        }
        scn.close();
    }

    /*
     * Problem: New-Pro Coder
     * 
     * Ved claims to be a pro at programming, but his friend Varun disagrees. 
     * To settle the debate, they decided to seek advice from their mentor. The mentor proposed a simple challenge:
     * Ved must write a program containing N lines of code. 
     * When the code is compiled, the compiler will indicate how many of those lines have errors, denoted as M. 
     * Based on the results:
     * -> If errors are present in at least half of the total lines, Ved will be labeled as a NEWBIE.
     * -> Otherwise, he will be called a PRO
     * After compiling Ved's code, the compiler reported errors in M lines. 
     * Determine Ved's skill category based on this evaluation.
     * 
     * Input Format:
     * The input contains two space-separated integers N and M - 
     * the number of lines of code written by Ved and the number of lines of code containing errors, respectively.
     * 
     * Output Format:
     * Output PRO if Ved is pro, else output NEWBIE.
     * It is allowed to print each character in either case. pro,pRo,PRo will all be accepted.
     * 
     * Constraints:
     * 1 <= N <= 1000
     * 1 <= M <= 1000
     * M <= N
     */
    public static void solveCodeChefSPC2025() {
        Scanner scn = new Scanner(System.in);
        long N = scn.nextLong();
        long M = scn.nextLong();
        System.out.println(M * 2 >= N ? "NEWBIE" : "PRO");
        scn.close();
    }

    /*
     * Problem: Itz Simple
     * 
     * Ved and Varun are both members of Shaastra’s CnL team this year. 
     * While they are equally skilled in programming, they differ in height. 
     * Ved’s height is K, and Varun’s height is P.
     * Both want to watch a movie in OAT from outside the gate, without entering. 
     * There are N chairs available outside OAT, each with a height represented as Ai​. 
     * These chairs can be stacked on top of each other to create a platform, allowing them to stand on it for a better view of the movie.
     * Tej, the OAT security officer, gives all the chairs to Varun, except for one - the tallest chair, which is given to Ved.
     * Now, Tej wants to know who will have a better view of the movie. 
     * If Ved has a better view, print Ved. 
     * If Varun has a better view, print Varunn. 
     * If both have the same view, print Equall.
     * Note: A person is said to have a better view if they can get a better combined height by stacking their chairs and standing on top of them.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * -> The first line of each test case contains three space-separated integers N, K and P - the number of chairs, Ved's height and Varun's height
     * -> The next line contains N space-separated integers - A1, A2, ..., AN​.
     * 
     * Output Format:
     * For each test case, output Ved if Ved will have a better view, Varun if Varun will have a better view, or Equal if both will have the same view.
     * Each character of the strings can be printed in upper or lower case. VED, ved and vEd will all be accepted.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 1 <= K, P <= 10^4
     * 1 <= Ai <= 100
     */
    public static void solveCodeChefSPC2025Q2() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            long K = scn.nextLong(); 
            long P = scn.nextLong();
            long tallest = 0;
            long sum = 0;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextInt();
                tallest = Math.max(Ai, tallest);
                sum += Ai;
            }
            sum -= tallest;
            if (K + tallest > P + sum)
                System.out.println("Ved");
            else if (K + tallest < P + sum)
                System.out.println("Varun");
            else
                System.out.println("Equal");
        }
        scn.close();
    }

    /*
     * Problem: Three Way Communications
     * 
     * The Chef likes to stay in touch with his staff. 
     * So, the Chef, the head server, and the sous-chef all carry two-way transceivers so they can stay in constant contact. 
     * Of course, these transceivers have a limited range so if two are too far apart, they cannot communicate directly.
     * The Chef invested in top-of-the-line transceivers which have a few advanced features. 
     * One is that even if two people cannot talk directly because they are out of range, 
     * if there is another transceiver that is close enough to both, 
     * then the two transceivers can still communicate with each other using the third transceiver as an intermediate device.
     * There has been a minor emergency in the Chef's restaurant and he needs to communicate with both the head server and the sous-chef right away. 
     * Help the Chef determine if it is possible for all three people to communicate with each other, 
     * even if two must communicate through the third because they are too far apart.
     * 
     * Input:
     * The first line contains a single positive integer T <= 100 indicating the number of test cases to follow. 
     * The first line of each test case contains a positive integer R <= 1000 
     * indicating that two transceivers can communicate directly without an intermediate transceiver if they are at most R meters away from each other. 
     * The remaining three lines of the test case describe the current locations of the Chef, the head server, and the sous-chef, respectively. 
     * Each such line contains two integers X, Y (at most 10000 in absolute value) indicating that the respective person is located at position X, Y.
     * 
     * Output:
     * For each test case you are to output a single line containing a single string. 
     * If it is possible for all three to communicate then you should output "yes". Otherwise, you should output "no".
     * To be clear, we say that two transceivers are close enough to communicate directly 
     * if the length of the straight line connecting their X,Y coordinates is at most R.
     */
    public static void solveCodeChefCOMM3() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long R = scn.nextLong(); 
            long X1 = scn.nextLong(); 
            long Y1 = scn.nextLong(); 
            long X2 = scn.nextLong(); 
            long Y2 = scn.nextLong(); 
            long X3 = scn.nextLong(); 
            long Y3 = scn.nextLong(); 
            long D12 = Math.abs(X1 - X2) * Math.abs(X1 - X2) + Math.abs(Y1 - Y2) * Math.abs(Y1 - Y2);
            long D23 = Math.abs(X2 - X3) * Math.abs(X2 - X3) + Math.abs(Y2 - Y3) * Math.abs(Y2 - Y3);
            long D13 = Math.abs(X1 - X3) * Math.abs(X1 - X3) + Math.abs(Y1 - Y3) * Math.abs(Y1 - Y3);
            long visibles = 0;
            if (D12 <= R * R)
                visibles++;
            if (D23 <= R * R)
                visibles++;
            if (D13 <= R * R)
                visibles++;
            System.out.println(visibles > 1 ? "yes" : "no");
        }
        scn.close();
    }

    /*
     * Problem: Alternating String
     * 
     * A binary string is called alternating if no two adjacent characters of the string are equal. 
     * Formally, a binary string T of length M is called alternating if T(i) != T(i+1)​ for each 1 <= i <= M.
     * For example, 0, 1, 01, 10, 101, 010, 1010 are alternating strings while 11, 001, 1110 are not.
     * You are given a binary string S of length N. 
     * You would like to rearrange the characters of S such that the length of the longest alternating substring of S is maximum. 
     * Find this maximum value.
     * A binary string is a string that consists of characters 0 and 1. 
     * A string 'a' is a substring of a string 'b' if 'a' can be obtained from 'b' 
     * by deletion of several (possibly, zero or all) characters from the beginning and several (possibly, zero or all) characters from the end.
     * 
     * Input Format:
     * The first line of input contains an integer T, denoting the number of test cases. The T test cases then follow:
     * The first line of each test case contains an integer N.
     * The second line of each test case contains the binary string S.
     * 
     * Output Format:
     * For each test case, output the maximum possible length of the longest alternating substring of S after rearrangement.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= N <= 10^5
     * S contains only the characters 0 and 1.
     * Sum of N over all test cases does not exceed 2*10^5.
     */
    public static void solveCodeChefALTSTR() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            String S = scn.next(); 
            long ones = 0;
            long zeroes = 0;
            for (long i = 0; i < N; i++) {
                if (S.charAt((int)i) == '1')
                    ones++;
                else
                    zeroes++;
            }
            System.out.println(Math.min(ones, zeroes) * 2 + ((ones != zeroes) ? 1 : 0));            
        }
        scn.close();
    }

    /*
     * Problem: Christmas Cake
     * 
     * Chef plans to celebrate Christmas by baking a cake.
     * Christmas falls on the 25-th of December.
     * Every day before Christmas, till the 24-th of December, Chef will bake exactly one practice cake.
     * Today is the X-th of December. How many practice cakes will Chef bake starting from today?
     * 
     * Input Format:
     * The first and only line of input will contain a single integer X — today's date.
     * 
     * Output Format:
     * For each test case, output a single integer: the number of practice cakes Chef will bake.
     * 
     * Constraints:
     * 1 <= X <= 24
     */
    public static void solveCodeChefCRCK() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        System.out.println(25 - X);
        scn.close();
    }

    /*
     * Problem: Poster Perimeter
     * 
     * Chef wants to print out a poster on a rectangular piece of paper.
     * The piece of paper he uses cannot be too large, or his printer will be unable to handle it.
     * Specifically, the length of the rectangle must be an integer between 1 and N units, 
     * and the width must be an integer between 1 and M units.
     * Chef would like it if the perimeter of the paper is as close to K as possible.
     * If Chef chooses the paper's dimensions optimally, find the minimum possible difference between the paper's perimeter and K.
     * Recall that the perimeter of a rectangle with length l and width w equals 2 * (l + w).
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of input will contain three space-separated integers N,M, and K - 
     * the maximum allowed length and width, and the target perimeter.
     * 
     * Output Format:
     * For each test case, output on a new line the minimum possible difference between the paper's perimeter and K.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N, M, K <= 100
     */
    public static void solveCodeChefPOSTPERI() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            long M = scn.nextLong(); 
            long K = scn.nextLong(); 
            if (K <= 3)
                System.out.println(4 - K);
            else {
                if (N + M >= K / 2)
                    System.out.println(K % 2);
                else
                    System.out.println(K - 2 * N - 2 * M);
            }
        }
        scn.close();
    }

    /*
     * Problem: Laddu
     * 
     * You might have heard about our new goodie distribution program aka the "Laddu Accrual System". 
     * This problem is designed to give you a glimpse of its rules. 
     * You can read the page once before attempting the problem if you wish, 
     * nonetheless we will be providing all the information needed here itself.
     * Laddu Accrual System is our new goodie distribution program. 
     * In this program, we will be distributing Laddus in place of goodies for your winnings and various other activities (described below), 
     * that you perform on our system. 
     * Once you collect enough number of Laddus, you can then redeem them to get yourself anything from a wide range of CodeChef goodies.
     * Let us know about various activities and amount of laddus you get corresponding to them.
     * -> Contest Win (CodeChef’s Long, Cook-Off, LTIME, or any contest hosted with us) : 300 + Bonus (Bonus = 20 - contest rank). 
     *    Note that if your rank is > 20, then you won't get any bonus.
     * -> Top Contributor on Discuss : 300
     * -> Bug Finder : 50 - 1000 (depending on the bug severity). It may also fetch you a CodeChef internship!
     * -> Contest Hosting : 50
     * You can do a checkout for redeeming laddus once a month. 
     * The minimum laddus redeemable at Check Out are 200 for Indians and 400 for the rest of the world.
     * You are given history of various activities of a user. 
     * The user has not redeemed any of the its laddus accrued. 
     * Now the user just wants to redeem as less amount of laddus he/she can, so that the laddus can last for as long as possible. 
     * Find out for how many maximum number of months he can redeem the laddus.
     * 
     * Input:
     * The first line of input contains a single integer T denoting number of test cases
     * For each test case:
     * -> First line contains an integer followed by a string denoting activities, origin respectively, 
     *    where activities denotes number of activities of the user, 
     *    origin denotes whether the user is Indian or the rest of the world. origin can be "INDIAN" or "NON_INDIAN".
     * -> For each of the next activities lines, each line contains an activity.
     * -> An activity can be of four types as defined above.
     * ----> Contest Win : Input will be of form of CONTEST_WON rank, where rank denotes the rank of the user.
     * ----> Top Contributor : Input will be of form of TOP_CONTRIBUTOR.
     * ----> Bug Finder : Input will be of form of BUG_FOUND severity, where severity denotes the severity of the bug.
     * ----> Contest Hosting : Input will be of form of CONTEST_HOSTED.
     * 
     * Output:
     * For each test case, find out the maximum number of months for which the user can redeem the laddus accrued. 
     * 
     * Constraints:
     * 1 <= T, activities <= 100
     * 1 <= rank <= 5000
     * 50 <= severity <= 1000
     */
    public static void solveCodeChefLADDU() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long activities = scn.nextLong(); 
            String origin = scn.next(); 
            long laddus = 0;
            for (long i = 0; i < activities; i++) {
                String activity = scn.next();
                if (activity.equals("CONTEST_WON")) {
                    laddus += 300;
                    long rank = scn.nextLong();
                    if (rank < 20)
                        laddus += 20 - rank;
                }
                else if (activity.equals("TOP_CONTRIBUTOR"))
                    laddus += 300;
                else if (activity.equals("BUG_FOUND")) {
                    long severity = scn.nextLong();
                    laddus += severity;
                }
                else
                    laddus += 50;
            }
            if (origin.equals("INDIAN"))
                System.out.println(laddus / 200);
            else
                System.out.println(laddus / 400);
        }
        scn.close();
    }

    /*
     * Problem: The Attack of Queen
     * 
     * Chef has started developing interest in playing chess, and was learning how the Queen moves.
     * Chef has an empty N x N chessboard. He places a Queen at (X, Y) and wonders - 
     * What are the number of cells that are under attack by the Queen?
     * 
     * Notes:
     * The top-left cell is (1, 1), the top-right cell is (1, N), the bottom-left cell is (N,1) and the bottom-right cell is (N, N).
     * The Queen can be moved any number of unoccupied cells in a straight line vertically, horizontally, or diagonally.
     * The cell on which the Queen is present, is not said to be under attack by the Queen.
     * 
     * Input Format:
     * The first line contains a single integer T - the number of test cases. Then the test cases follow.
     * The first and only line of each test case contains three integers N, X and Y, as described in the problem statement.
     * 
     * Output Format:
     * For each test case, output in a single line, the total number of cells that are under attack by the Queen.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= N <= 10^6
     * 1 <= X, Y <= N
     */
    public static void solveCodeChefQUEENATTACK() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            long X = scn.nextLong(); 
            long Y = scn.nextLong(); 
            long diagonal1 = Math.min(N - X, N - Y);
            long diagonal2 = Math.min(X - 1, Y - 1);
            long diagonal3 = Math.min(X - 1, N - Y);
            long diagonal4 = Math.min(N - X, Y - 1);
            System.out.println((N - 1) * 2 + diagonal1 + diagonal2 + diagonal3 + diagonal4);
        }
        scn.close();
    }

    /* 
     * Problem: Shuffling Parities
     * 
     * Chef is given an array A consisting of N positive integers. 
     * Chef shuffles the array A and creates a new array B of length N, where Bi = (Ai + i)  mod  2, for each i  (1 <= i <=N).
     * Find the maximum possible sum of integers of the array B, if Chef shuffles the array A optimally.
     * 
     * Input Format:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * Each test case contains two lines of input.
     * The first line of each test case contains an integer N.
     * The second line of each test case contains N space-separated integers A1, A2, ..., AN.
     * 
     * Output Format:
     * For each test case, print a single line containing one integer - the maximum sum of integers of the array B.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= N <= 10^5
     * 1 <= Ai <= 10^9
     * Sum of N over all test cases does not exceed 3*10^5.
     */
    public static void solveCodeChefSHUFFLIN() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong(); 
            long evens = 0;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                if (Ai % 2 == 0)
                    evens++;
            }
            System.out.println(Math.min(evens, (N + 1) / 2) + Math.min(N - evens, N / 2));
        }
        scn.close();
    }

    /*
     * Problem: Merry Christmas!
     * 
     * Chef is planning Christmas festivities and has three activities to choose from:
     * Decorating a Christmas tree, which takes 1 hour.
     * Baking cookies, which takes 2 hours.
     * Making a gingerbread house, which takes 4 hours.
     * Given that Chef has X hours available, determine the maximum number of activities he can complete.
     * Note that no two activities can overlap in time.
     * 
     * Input Format:
     * The first and only line of input will contain a single integer X, denoting the number of hours Chef has.
     * 
     * Output Format:
     * Output on a new line, the maximum number of activities he can complete.
     * 
     * Constraints:
     * 1 <= X <= 10
     */
    public static void solveCodeChefMERRYXMAS() {
        Scanner scn = new Scanner(System.in);
        long X = scn.nextLong();
        if (X <= 2)
            System.out.println(1);
        else if (X <= 6)
            System.out.println(2);
        else
            System.out.println(3);
        scn.close();
    }

    /*
     * Problem: Christmas Gifts
     * 
     * Chef is wrapping Christmas gifts for his friends. 
     * He has a rectangular sheet of wrapping paper with a total area of 1000 square centimeters. 
     * Each identical gift is a rectangular box with dimensions:
     * Height (H) centimeters
     * Length (L) centimeters
     * Width (W) centimeters
     * To wrap a gift, Chef needs enough paper to cover all six faces of the box, with no overlapping or gaps. 
     * Calculate the maximum number of complete gifts Chef can wrap using the available wrapping paper.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of three space-separated integers H, L and W - the dimensions of each gift box.
     * 
     * Output Format:
     * For each test case, output on a new line, the maximum number of complete gifts Chef can wrap using the available wrapping paper.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= H, L, W <= 10
     */
    public static void solveCodeChefWRAPGIFTS() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long H = scn.nextLong(); 
            long L = scn.nextLong(); 
            long W = scn.nextLong();
            long area = H * L * 2 + H * W * 2 + L * W * 2;
            System.out.println(1000 / area);
        }
        scn.close();
    }

    /*
     * Problem: Chefland Library
     * 
     * In the Chefland Library, there is a penalty system for late book returns with the following rules:
     * -> For each book returned late, penalty points equal the number of days the book is overdue.
     * -> When multiple books are returned on the same day, only the highest penalty among those books is counted.
     * Chef has borrowed N books from the library. For the ithith book (1 <= i <= N):
     * -> It was returned i days late.
     * -> It was returned on day Ai​.
     * 
     * Calculate the total penalty points Chef must pay.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains an integer N - the number of books Chef borrowed from the library.
     * The next line contains N space-separated integers AiAi​, denoting the day on which ithith book was returned.
     * 
     * Output Format:
     * For each test case, output on a new line, the total penalty points Chef must pay.
     * 
     * Constraints:
     * 1 <= T <= 1100
     * 1 <= N <= 10^5
     * 1 <= Ai <= 10^5
     * The sum of N over all test cases won't exceed 2*10^5.
     */
    public static void solveCodeChefBORROWBOOK() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            HashMap<Long, Long> books = new HashMap<>();
            for (long i = 1; i <= N; i++) {
                long Ai = scn.nextLong();
                books.put(Ai, i);
            }
            long penalty = 0;
            for (Map.Entry<Long, Long> entry : books.entrySet())
                penalty += entry.getValue();
            System.out.println(penalty);
        }
        scn.close();
    }

    /*
     * Problem: Even Matrix
     * 
     * Chef has an integer N and he wants to generate a matrix M with N rows (numbered 1 through N) and N columns (numbered 1 through N). 
     * He thinks that MM would be delicious if:
     * -> Each element of this matrix is an integer between 1 and N^2 inclusive.
     * -> All the elements of the matrix are pairwise distinct.
     * -> For each square submatrix containing cells in rows rr through r + a and in columns c through c + a (inclusive) for some valid integers r, c and a >= 0:
     * ----> Mr,c + Mr+a,c+a is even
     * ----> Mr,c+a + Mr+a,c is even
     * Can you help Chef generate a delicious matrix? It can be proved that a solution always exists. If there are multiple solutions, you may find any one.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first and only line of each test case contains a single integer N.
     * 
     * Output:
     * For each test case, print N lines describing a delicious matrix M. 
     * For each valid i, the i-th of these lines should contain N space-separated integers Mi,1; Mi,2; ...; Mi,N.
     * 
     * Constraints:
     * 1 <= T <= 10
     * 1 <= N <= 10^3
     * the sum of N over all test cases does not exceed 10^3
     */
    public static void solveCodeChefEVENM() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long number = 1;
            for (long r = 0; r < N; r++) {
                for (long c = 0; c < N; c++) {
                    // If odd number of rows and columns we can print all numbers in order
                    if (N % 2 == 1)
                        System.out.print(number + " ");
                    // If even number of rows and columns
                    else {
                        // If odd rows we have to swap values every two columns
                        if (r % 2 == 1) {
                            if (c % 2 == 0)
                                System.out.print((number + 1) + " ");
                            else
                                System.out.print((number - 1) + " ");
                        }
                        // If odd rows we have to swap values every two columns
                        else
                            System.out.print(number + " ");
                    }
                    number++;
                }
                System.out.println();
            }
        }
        scn.close();
    }

    /*
     * Problem: Happy New Year!
     * 
     * Currently, it is X:00 hours on December 31st and you are wondering how many hours are left till midnight.
     * For the purposes of this problem, we use a 24 hour system. 
     * So, X can range from 0 to 23, and you need to tell the number of hours left till 00:00 of the next day.
     * 
     * Input Format:
     * The first and only line of input contains a single integer X.
     * 
     * Output Format:
     * For each test case, output on a new line the number of hours left till midnight
     * 
     * Constraints:
     * 0 <= X <= 23
     */
    public static void solveCodeChefNEWYEAR() {
        Scanner scn = new Scanner(System.in);
        int X = scn.nextInt(); 
        System.out.println(24 - X);
        scn.close();
    }

    /*
     * Problem: Digit Sum Parities
     * 
     * For a positive integer M, MoEngage defines digitSum(M) as the sum of digits of the number M (when written in decimal).
     * For example, digitSum(1023) = 1 + 0 + 2 + 3 = 6.
     * Given a positive integer N, find the smallest integer X strictly greater than N such that:
     * digitSum(N) and digitSum(X) have different parity, i.e. one of them is odd and the other is even.
     * 
     * Input Format:
     * The first line contains an integer T, the number of test cases. The description of the T test cases follow.
     * Each test case consists of a single line of input with a single integer, the number N.
     * 
     * Output Format:
     * For each test case, print in a single line, an integer, the answer to the problem.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 1 <= N < 10^9
     */
    public static void solveCodeChefDIGSMPAR() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            if (N % 10 != 9)
                System.out.println(N + 1);
            else {
                long dsN = CodeChefLibrary.digitSum(N);
                long dsN1 = CodeChefLibrary.digitSum(N + 1);
                if (dsN % 2 != dsN1 % 2)
                    System.out.println(N + 1);
                else
                    System.out.println(N + 2);
            }
        }
        scn.close();
    }

    /*
     * Problem: Far Away
     * 
     * Chef has an array A of size N and an integer M, such that 1 <= Ai <= M for every 1 <= i <= N.
     * The distance of an array B from array A is defined as:
     * d(A, B) = sum{from i = 1 to N} |Ai - Bi|
     * Chef wants an array B of size N, such that 1 <= Bi <= M and the value d(A, B) is as large as possible, 
     * i.e, the distance of B from A is maximum.
     * Find the maximum distance for any valid array B.
     * Note: |X| denotes the absolute value of an integer X. For example, |-4| = 4 and |7| = 7.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * The first line of each test case contains two space-separated integers N and M -
     * the length of array A and the limit on the elements of A and B.
     * The second line contains N space-separated integers A1, A2, ..., AN.
     * 
     * Output Format:
     * For each test case, output on a new line the maximum distance of an array from A.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= N <= 2*10^5
     * 1 <= M <= 10^9
     * 1 <= Ai <= M
     * The sum of N over all test cases won't exceed 3*10^5.
     */
    public static void solveCodeChefFARAWAY() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long M = scn.nextLong();
            long maxDistance = 0;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                maxDistance += Math.max(Ai - 1, M - Ai);
            }
            System.out.println(maxDistance);
        }
        scn.close();
    }

    /*
     * Problem: Even Sum Subarray
     * 
     * Given an array A of size N, find the size of the largest subarray of A which has an even sum.
     * For example, for the array [2, 1, 2] the answer is just 1 as the largest subarray with an even sum is [2].
     * Note that a subarray is a contiguous part of an array. For the array [1, 3, 2], some possible subarrays are [1], [2], [1, 3], [1, 3, 2]. 
     * However, [1, 2] is not a subarray for this array.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * -> The first line of each test case contains a single integer N - the size of the array.
     * -> The next line contains N space-separated integer - A1, A2, ...,AN.
     * 
     * Output Format:
     * For each test case, output on a new line, the size of the largest subarray with even sum.
     * 
     * Constraints:
     * 1 <= T <= 50
     * 1 <= N <= 50
     * 1 <= Ai <= 10^4
     */
    public static void solveCodeChefEVENSUMSUB() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long even = 0;
            long firstOdd = -1;
            long lastOdd = -1;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                even += ((Ai % 2 == 0) ? 1 : 0);
                if (Ai % 2 == 1) {
                    if (firstOdd == -1)
                        firstOdd = i;
                    lastOdd = i;
                }
            }
            long odd = N - even;
            if (odd % 2 == 0)
                System.out.println(N);
            else
                System.out.println(Math.max(N - firstOdd - 1, lastOdd));
        }
        scn.close();
    }

    /*
     * Problem: Chef And Salary Pay
     * 
     * Given the schedule of Chef for 30 days 
     * (A binary string of length 3030 where '0' denotes that Chef was on leave and '1' denotes Chef was working on that day). 
     * Chef gets X-Rs for every day he worked. 
     * As working continuously for a long time is hectic so Company introduced the following policy to give a bonus to its employees.
     * The company will check the longest streak for which an employee has worked and will award Y-Rs for every day of that streak as a bonus. 
     * Calculate the salary received by Chef (including the bonus).
     * Note: Rs represents the currency of Chefland, and if there are two or more longest streaks of the same length, 
     * only one is counted for the bonus.
     * 
     * Input Format:
     * The first line contains an integer T denoting the number of test cases. The T test cases then follow.
     * The first line of each test case contains X and Y.
     * Second line contains a binary string (i.e it contains only '0' / '1'), 
     * where '0' denotes that Chef was on leave and '1' denotes Chef was working on that day.
     * 
     * Output Format:
     * For each testcase, output in a single line answer to the problem. i.e The salary received by Chef (including the bonus).
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= X <= 999
     * 1 <= Y <= 999
     * |S| = 30
     */
    public static void solveCodeChefHCAGMAM1() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            String S = scn.next();
            long ones = 0;
            long currentOnes = 0;
            long greatestOnes = 0;
            for (char c : S.toCharArray()) {
                if (c == '1') {
                    ones++;
                    currentOnes++;
                    greatestOnes = Math.max(greatestOnes, currentOnes);
                }
                else
                    currentOnes = 0;
            }
            System.out.println(ones * X + greatestOnes * Y);
        }
        scn.close();
    }

    /*
     * Problem: Interesting XOR!
     * 
     * You are given an integer C. Let d be the smallest integer such that 2^d is strictly greater than C.
     * Consider all pairs of non-negative integers (A, B) such that A, B < 2^d and A XOR B = C (XOR denotes the bitwise XOR operation). 
     * Find the maximum value of A * B over all these pairs.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first and only line of each test case contains a single integer C.
     * 
     * Output:
     * For each test case, print a single line containing one integer - the maximum possible product A * B.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= C <= 10^9
     */
    public static void solveCodeChefIRSTXOR() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long C = scn.nextLong();
            String bC = Long.toBinaryString(C);
            String A = "";
            String B = "";
            boolean firstOne = false;
            for (char c : bC.toCharArray()) {
                if (c == '0') {
                    A += "1";
                    B += "1";
                }
                else {
                    if (firstOne) {
                        A += "0";
                        B += "1";
                    }
                    else {
                        A += "1";
                        B += "0";
                        firstOne = true;
                    }
                }
            }
            System.out.println(Long.parseLong(A, 2) * Long.parseLong(B, 2));
        }
        scn.close();
    }

    /*
     * Problem: Can You Bench
     * 
     * Chef goes to the gym daily and follow a progressive bench press routine. 
     * In the 1st1st set, Chef will lift X kilograms. For each subsequent set, you increase the weight by 10 kilograms.
     * Your task is to calculate the amount of weight Chef will bench in the 3rd set.
     * 
     * Input Format:
     * The input consists of a single integer X, the weight (in kilograms) Chef benches in the 1st set.
     * 
     * Output Format:
     * Output a single integer - the weight (in kilograms) Chef will bench in the 3rd set.
     * 
     * Constraints:
     * 1 <= X <= 100
     */
    public static void solveCodeChefHJJ() {
        Scanner scn = new Scanner(System.in);
        int X = scn.nextInt(); 
        System.out.println(X + 20);
        scn.close();
    }

    /*
     * Problem: Big Achiever
     * 
     * Given N students standing in a row, each student i has an distinct achievement score Ai​ provided in an array A = [A1, A2, ..., An]. 
     * The array A consists of distinct integers from 1 to N.
     * A student i (1 <= i <= N) will be happy if their achievement score Ai​ is greater than the achievement scores of all the students standing before them in the array.
     * The task is to print whether a student is happy or not.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * -> The first line of each test case contains N - the number of students.
     * -> The second line of each test case contains N space-separated integers A1, A2, ..., AN, denoting the achievement scores of the students.
     * 
     * Output Format:
     * For each test case, print a single line containing N integers. Print ithith integer as 1 if the ithith student is happy, otherwise print 0.
     * Each test case's output should be on a new line, with the integers separated by spaces.
     * 
     * Constraints:
     * 1 <= T <= 4*10^5
     * 1 <= N <= 10
     * 1 <= Ai <= N
     * The sum of N over all test cases does not exceed 4*10^5.
     */
    public static void solveCodeChefBIG() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long max = 0;
            for (long i = 0; i < N; i++) {
                long Ai = scn.nextLong();
                System.out.print(Ai > max ? "1 " : "0 ");
                max = Math.max(max, Ai);
            }
            System.out.println();
        }
        scn.close();
    }

    /*
     * Problem: Hungry Chef
     * 
     * Chef is very hungry. So, Chef goes to a shop selling burgers. The shop has 2 types of burgers:
     * -> Normal burgers, which cost X rupees each
     * -> Premium burgers, which cost Y rupees each (where Y > X)
     * Chef has R rupees. Chef wants to buy exactly N burgers. 
     * He also wants to maximize the number of premium burgers he buys. Determine the number of burgers of both types Chef must buy.
     * Output −1 if it is not possible for Chef to buy N burgers.
     * 
     * Input Format:
     * The first line contains a single integer T - the number of test cases. Then the test cases follow.
     * The first and only line of each test case contains four space-separated integers X, Y, N and R - 
     * the cost of a normal burger, the cost of a premium burger, the number of burgers Chef wants to buy and the amount of money Chef has.
     * 
     * Output Format:
     * For each test case, output on a new line two integers: 
     * the number of normal burgers and the number of premium burgers Chef must buy satisfying the given conditions.
     * Output −1 if he cannot buy N burgers.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= X <= Y <= 1000
     * 1 <= N <= 10^6
     * 1 <= R <= 10^9
     */
    public static void solveCodeChefBURGERS2() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long X = scn.nextLong();
            long Y = scn.nextLong();
            long N = scn.nextLong();
            long R = scn.nextLong();
            long Z = (R - N * X) / (Y - X);
            if (Z < 0)
                System.out.println(-1);
            else {
                if (Z > N)
                    Z = N;
                if ((N - Z) * X + Z * Y <= R)
                    System.out.println((N - Z) + " " + Z);
                else
                    System.out.println(-1);
            }
        }
        scn.close();
    }

    /*
     * Problem: Chef and Serves
     * 
     * In a regular table tennis match, the player who serves changes every time after 2 points are scored, regardless of which players scored them.
     * Chef and Cook are playing a different match - 
     * they decided that the player who serves would change every time after K points are scored instead (again regardless of which players scored them). 
     * When the game starts, it's Chef's turn to serve.
     * You are given the current number of points scored by Chef and Cook (P1​ and P2​ respectively). Find out whether Chef or Cook has to serve next.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
     * The first and only line of each test case contains three space-separated integers P1​, P2​ and K.
     * 
     * Output:
     * For each test case, print a single line containing the string "CHEF" if it is Chef's turn or "COOK" if it is Cook's turn.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= K <= 10^9
     * 0 <= P1,P2 <= 10^9
     */
    public static void solveCodeChefCHSERVE() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long P1 = scn.nextLong();
            long P2 = scn.nextLong();
            long K = scn.nextLong();
            long turn = (P1 + P2) / K;
            if (turn % 2 == 0)
                System.out.println("CHEF");
            else
                System.out.println("COOK");
        }
        scn.close();
    }

    /*
     * Problem: Entry Check
     * 
     * Chef wants to visit a fair, but there is an age restriction for entry. A person can attend the fair if their age is greater than or equal to 10 years.
     * You are given Chef's age, represented by the integer X. Your task is to determine whether Chef is eligible to attend the fair or not.
     * If Chef's age is greater than or equal to 10, print "YES". Otherwise, print "NO".
     * 
     * Input Format:
     * A single integer X, representing Chef's age.
     * 
     * Output Format:
     * Print YES if Chef is eligible to attend the fair, otherwise print NO.
     * You may print each character of the string in uppercase or lowercase (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= X <= 20
     */
    public static void solveCodeChefP1169() {
        Scanner scn = new Scanner(System.in);
        int X = scn.nextInt(); 
        System.out.println(X >= 10 ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Opposite Attract
     * 
     * You are given a binary string S of length N. 
     * Your task is to generate a new binary string T of the same length such that each corresponding character of T is different from the character at the same position in S.
     * In other words, for each position i (0 <= i < N), the following condition must hold Ti != Si.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * -> The first line of each test case contains one integer N - the length of S.
     * -> The next line contains the binary string S.
     * 
     * Output Format:
     * For each test case, output on a new line a binary string T of length N, where Ti != Si​ for all valid indices i.
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= N <= 10
     * S is a binary string, i.e, contains only the characters 0 and 1.
     * The sum of N over all test cases won't exceed 2*10^5.
     */
    public static void solveCodeChefP2169() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            scn.nextLong();
            String S = scn.next();
            for (char c : S.toCharArray())
                System.out.print(c == '0' ? "1" : "0");
            System.out.println();
        }
        scn.close();
    }

    /*
     * Problem: Access Code Equality
     * 
     * You are attempting to join the Web Club NITK’s exclusive online session. 
     * To do so, you need to enter the correct access code.
     * The correct code is "WECNITK" (without quotes).
     * The code you entered is given by the string S, which has length 7.
     * Your task is to verify whether the entered code S matches the correct code.
     * If it does, print "Welcome to Web Club!". Otherwise, print "Access denied".
     * 
     * Input Format:
     * The first and the only line of input will contain a string S of length 7, denoting the access code that was entered.
     * 
     * Output Format:
     * Print the correct output according to the access code S.
     * Each letter of the output may be printed in either uppercase or lowercase - 
     * for example the string "AcCeSS DEniEd" will be accepted if the correct answer is "Access denied".
     * 
     * Constraints:
     * The length of the string S is exactly 7.
     * S contains only uppercase and lowercase English letters, i.e. the characters 'a'-'z' and 'A'-'Z'.
     */
    public static void solveCodeChefWECNITK() {
        Scanner scn = new Scanner(System.in);
        String S = scn.next(); 
        System.out.println(S.equals("WECNITK") ? "Welcome to Web Club!" : "Access denied");
        scn.close();
    }

    /*
     * Problem: Minimum Bottles
     * 
     * There are N identical water bottles, each of which has a capacity of X liters.
     * The ith bottle initially contains Ai liters of water.
     * You want to go on a trip and want to carry all your water with you.
     * However, to not make packing a hassle, you also want to carry the least number of bottles with you.
     * You can transfer any amount of water from one bottle to another, 
     * provided there is no spillage and no bottle contains more than X liters. 
     * Water from one bottle can be transferred to different bottles if you wish to do that.
     * What is the minimum number of bottles that you can carry with you, while still having all your water?
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of two lines of input.
     * The first line of each test case contains two space-separated integers N and X - 
     * the number of bottles and capacity of each bottle in liters, respectively.
     * The second line contains N space separated integers A1, A2, ..., AN
     * denoting the volume of water in liters filled in each bottle.
     * 
     * Output Format:
     * For each test case, output on a new line the minimum number of bottles that can be carried.
     * 
     * Constraints:
     * 1 <= T <= 100
     * 1 <= N <= 100
     * 1 <= X <= 1000
     * 1 <= Ai <= X
     */
    public static void solveCodeChefMINBOTTLES() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long X = scn.nextLong();
            long total = 0;
            for (long i = 0; i < N; i++)
                total += scn.nextLong();
            long needed = (total - 1) / X + 1;
            System.out.println(needed);
        }
        scn.close();
    }

    /*
     * Problem: Squid Game - Piggy Bank
     * 
     * In the deadly "Squid Game," the participants start with N players. 
     * After the game ends, only K players survive. 
     * The prize pool increases based on the number of players eliminated.
     * Each eliminated player contributes a fixed amount of 10000 units to the prize pool.
     * Your task is to calculate the total prize money added to the pool, 
     * given the number of players N at the start of the game and the number of players who survive, K.
     * 
     * Input Format:
     * The first line contains two integers N and K, where:
     * -> N is the total number of players at the start of the game.
     * -> K is the number of players still alive after the game.
     * 
     * Output Format:
     * Print a single integer - the total prize money added to the pool.
     * 
     * Constraints:
     * 1 <= K < N <= 100
     */
    public static void solveCodeChefSQUIDBANK() {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt(); 
        int K = scn.nextInt(); 
        System.out.println((N - K) * 10000);
        scn.close();
    }

    /*
     * Problem: Advitiya
     * 
     * Toofan wanted to write the string "ADVITIYA", but accidentally wrote the 8-letter string S instead. 
     * He wants to correct his mistake with the minimum number of steps.
     * In one step, Toofan can choose an index i (1 <= i <= N), and change Si​ to the next letter in the alphabet.
     * That is, change A -> B, B -> C, C -> D, and so on.
     * The alphabet is considered cyclic, so Z can be changed to A.
     * For example, if S equals "ZARAGOZA",
     * Operating on the first index will turn S into "AARAGOZA".
     * Operating on the second index will instead turn S into "ZBRAGOZA".
     * Operating on the third index will instead turn S into "ZASAGOZA".
     * And so on for the other indices.
     * Find the minimum number of steps required to convert the string S into "ADVITIYA".
     * 
     * Input Format:
     * The first line contains an integer T - the number of test cases.
     * The next T lines each contain a string S consisting of exactly 8 uppercase English letters.
     * 
     * Output Format:
     * For each test case, output a single integer on a new line - the minimum number of steps to convert S into "ADVITIYA".
     * 
     * Constraints:
     * 1 <= T <= 1000
     * S has length 8.
     * Each character of S is an uppercase English letter.
     */
    public static void solveCodeChefADVITIYA() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            String S = scn.next();
            String ADVITIYA = "ADVITIYA";
            long steps = 0;
            int i = 0;
            for (char c : S.toCharArray()) {
                long d = (long)ADVITIYA.charAt(i) - (long)c;
                if (d >= 0)
                    steps += d;
                else
                    steps += 26 + d;
                i++;
            }
            System.out.println(steps);
        }
        scn.close();
    }

    /*
     * Promlem: Cut the Board
     * 
     * Suzumo has a chessboard with N rows and M columns. 
     * In one step, he can choose two cells of the chessboard which share a common edge 
     * (that has not been cut yet) and cut this edge.
     * Formally, the chessboard is split into two or more pieces 
     * if it is possible to partition its cells into two non-empty subsets S1 and S2 
     * (S1 ∩ S2 = ∅, |S1| + |S2| = N * M) such that there is no pair of cells c1, c2 (c1 ∈ S1, c2 ∈ S2) 
     * which share a common edge that has not been cut.
     * Suzumo does not want the board to split into two or more pieces. 
     * Compute the maximum number of steps he can perform while satisfying this condition.
     * 
     * Input:
     * The first line of the input contains a single integer T denoting the number of test cases. 
     * The description of T test cases follows.
     * The first and only line of each test case contains two space-separated integers N and M.
     * 
     * Output:
     * For each test case, print a single line containing one integer - the maximum possible number of steps.
     * 
     * Constraints:
     * 1 <= T <= 64
     * 1 <= N, M <= 8
     */
    public static void solveCodeChefCUTBOARD() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            Long N = scn.nextLong();
            Long M = scn.nextLong();
            System.out.println((N - 1) * (M - 1));
        }
        scn.close();
    }

    /* 
     * Problem: Two Different Palindromes
     * 
     * You are given two positive integers A and B. 
     * You need to construct two different binary strings (i.e, they are strings which consist of only 0s and 1s), 
     * which satisfy these two conditions:
     * -> Both the strings should be palindromes.
     * -> Each string should have exactly A 0s, and exactly B 1s in them.
     * Output Yes if two such different binary strings can be constructed and No otherwise.
     * Note:
     * A string is said to be a palindrome, if the string and the reverse of the string are identical.
     * Two strings are said to be different if either their lengths are different, or if they differ in at least one character.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case contains two space-separated integers, A and B, in a new line.
     * 
     * Output Format:
     * For each test case, output on a new line 'Yes', if you can construct two different binary strings satisfying the conditions. 
     * If not, output No.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YeS, yes, YES, and YEs will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= A, B <= 10^6
     */
    public static void solveCodeChefTWODIFFPALIN() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            Long A = scn.nextLong();
            Long B = scn.nextLong();
            if ((A % 2) == 1 && (B % 2) == 1)
                System.out.println("No");
            else if ((A % 2) == 0 && (B % 2) == 0)
                System.out.println("Yes");
            else if (A == 1 || B == 1)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
        scn.close();
    }

    /*
     * Problem: Equal Strings
     * 
     * Given a string A of length N consisting of lowercase English alphabet letters.
     * You are allowed to perform the following operation on the string A any number of times:
     * Select a non-empty subsequence S of the array [1, 2, 3, ..., N] and any lowercase English alphabet α;
     * Change Ai to α for all i ∈ S.
     * Find the minimum number of operations required to convert A into a given string B of length N 
     * consisting of lowercase English alphabet letters.
     * 
     * Input Format:
     * The first line of input contains a single integer T, denoting the number of test cases. The description of T test cases follow.
     * The first line of each test case contains an integer N - the length of the string A and B.
     * The second line of each test case contains the string A.
     * The third line of each test case contains the string B.
     * 
     * Output Format:
     * For each test case, output the minimum number of operations required to convert string A into string B.
     * 
     * Constraints:
     * 1 <= T <= 10^4
     * 1 <= N <= 10^5
     * Sum of N over all test cases does not exceed 10^5
     */
    public static void solveCodeChefEQUALSTRING() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            scn.nextLong();
            String A = scn.next();
            String B = scn.next();
            int i = 0;
            long different = 0;
            HashMap<Character, Long> hashMap = new HashMap<>();
            for (Character c : B.toCharArray()) {
                if (c != A.charAt(i)) {
                    if (!hashMap.containsKey(c)) {
                        hashMap.put(c, 1L);
                        different++;
                    }
                }
                i++;
            }
            System.out.println(different);
        }
        scn.close();
    }

    /*
     * Problem: Double Strings
     * 
     * The palindrome is a string that can be read the same way from left to right and from right to left. 
     * For example, strings "aaaaa", "1221", "bbaabb" are palindromes, 
     * however the string "chef" is not a palindrome because if we read it from right to left, 
     * we will obtain "fehc" that is not the same as "chef".
     * We call a string a "double string" if it has an even length and 
     * the first half of this string is equal to the second half of this string, 
     * for example "abab" is a double string because the first half "ab" is equal to the second half "ab", 
     * however the string "abba" is not a double string because the first half "ab" is not equal to the second half "ba". 
     * The empty string "" is a double string, and its length is 0.
     * Chef doesn't like palindromes, however he likes "double strings". 
     * He often likes to change the order of letters in some palindrome and sometimes to remove some symbols from it. 
     * Now he wonders: if a palindrome of length N is given, 
     * what is the maximal possible number of characters in a "double string" 
     * that can be obtained by removing and changing the order of symbols in it?
     * 
     * Input:
     * Several test cases are given.
     * The first line of the sample input contains an integer T - the number of test cases.
     * Then, T lines follow.
     * Each line consists of a single integer N - the length of a palindrome.
     * 
     * Output:
     * For each test case output a single integer - answer to the problem.
     * 
     * Constraints:
     * 1 <= T <= 10000
     * 1 <= N <= 1000000000
     */
    public static void solveCodeChefDOUBLE() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            Long N = scn.nextLong();
            System.out.println(N % 2 == 0 ? N : N - 1);
        }
        scn.close();
    }

    /*
     * Problem: Group Assignment
     * 
     * Chef is hosting a party at his house and N people are invited to it. Everyone has arrived and they are eager to make a group and chit-chat.
     * The ith person prefers to be in a group of exactly Pi​ people (including himself). 
     * A person who is not in a group of preferred size gets upset. 
     * Find whether Chef would be able to assign every person to a group such that everyone remains happy.
     * 
     * Input Format:
     * 
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * -> The first line of each test case contains an integer N - the number of people at the party.
     * -> The next line contains the array P - where Pi​ denotes the preferred group size for ith person.
     * 
     * Output Format:
     * For each test case, output YES, if Chef can assign every person to a group such that everyone remains happy. Otherwise output NO.
     * The output is case-insensitive, meaning that outputs such as yES, YeS, YES and yes mean the same.
     * 
     * Constraints:
     * 1 <= T <= 1000
     * 2 <= N <= 10^5
     * 2 <= Pi <= N
     * Sum of N over all test cases does not exceed 10^5.
     */
    public static void solveCodeChefGRPASSN() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            HashMap<Long, Long> hashMap = new HashMap<>();
            for (long i = 0; i < N; i++) {
                long Pi = scn.nextLong();
                hashMap.put(Pi, hashMap.getOrDefault(Pi, 0L) + 1);            
            }
            boolean possible = true;
            for (Map.Entry<Long, Long> entry : hashMap.entrySet()) {
                if (entry.getValue() % entry.getKey() != 0)
                    possible = false;
            }
            System.out.println(possible ? "YES" : "NO");
        }
        scn.close();
    }

    /*
     * Problem: Time Machine
     * 
     * Chef is currently in the year X in Chefland. 
     * He has a time machine that allows him to travel at most 25 years into the future, but he can use it only once.
     * Determine whether Chef can reach the year 2050 with a single use of the time machine.
     * 
     * Input Format:
     * A single integer X, representing current year in Chefland.
     * 
     * Output Format:
     * Print YES if Chef can reach the year 2050, otherwise print NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 2000 <= X <= 2050
     */
    public static void solveCodeChefTIMA() {
        Scanner scn = new Scanner(System.in);
        int X = scn.nextInt(); 
        System.out.println(X + 25 >= 2050 ? "YES" : "NO");
        scn.close();
    }

    /*
     * Problem: Small Palindrome
     * 
     * Chef has X ones (1s) and Y twos (2s) in his collection. 
     * He wants to arrange all of them into the smallest possible palindrome number (*)
     * using all of these ones (1s) and twos (2s).
     * Help Chef with the answer.
     * Note: X and Y are both even numbers.
     * (*) A palindromic number is a number that remains the same when its digits are reversed.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * The first and only line of each test case will contain two space-separated integers X, and Y - 
     * the amount of ones (1s) and twos (2s) respectively.
     * 
     * Output Format:
     * For each test case, output on a new line the smallest possible palindrome number using X ones (1s) and Y twos (2s).
     * 
     * Constraints:
     * 1 <= T <= 50
     * 0 <= X, Y <= 10
     * X and Y are both even
     * 2 <= X + Y <= 10
     */
    public static void solveCodeChefSMLPAL() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long X = scn.nextLong() / 2;
            long Y = scn.nextLong();
            System.out.println("1".repeat((int)X) + "2".repeat((int)Y) + "1".repeat((int)X));
        }
        scn.close();
    }

    /*
     * Problem: Streak Star
     * 
     * The Streak Value of an array B is defined as the maximum length of a non-decreasing subarray, more formally:
     * max {1 <= i <= j <= N} (j - i + 1) where Bi <= B{i + 1} <= B{i + 2} <= ... <= Bj.
     * Chef has an array A of length NN and a magical number X. You are allowed to perform the following operation at most once:
     * Select an index i, and update the element at Ai by multiplying it with X, i.e., set Ai := Ai * X
     * Your task is to find the maximum possible Streak Value achievable for array A.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * The first line of each test case contains two space-separated integers N and X - the length of array and magical number respectively.
     * The second line of each test case contains NN space-separated integers A1, A2, A3 ... AN - the elements of the array.
     * 
     * Output Format:
     * For each test case, output on a new line the maximum possible Streak Value of A.
     * 
     * Constraints:
     * 1 <= T <= 10^3
     * 1 <= N, X <= 10^3
     * 1 <= Ai <= 10^5
     * The sum of N over all test cases won't exceed 10^3.
     */
    public static void solveCodeChefSTKSTR() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            long N = scn.nextLong();
            long X = scn.nextLong();
            ArrayList<Long> B = new ArrayList<>();
            for (long i = 0; i < N; i++)
                B.add(scn.nextLong());

            long maxStreak = 0;
            long currentStreak = 0;
            long lastBi = 0;
            boolean firstStreaking = true;
            int i = 0;
            int lasti = 0;
            while (i < N) {
                long Bi = B.get(i);
                if (Bi >= lastBi) {
                    currentStreak++;
                    lastBi = Bi;
                    i++;
                }
                else {
                    if (firstStreaking) {
                        Bi *= X;
                        firstStreaking = false;
                        lasti = i;
                        if (Bi >= lastBi) {
                            currentStreak++;
                            lastBi = Bi;
                            i++;
                        }
                        else {
                            maxStreak = Math.max(maxStreak, currentStreak);
                            firstStreaking = true;
                            currentStreak = 1;
                            lastBi = Bi / X;
                            i++;
                        }
                    }
                    else {
                        maxStreak = Math.max(maxStreak, currentStreak);
                        firstStreaking = true;
                        currentStreak = 0;
                        lastBi = 0;
                        i = lasti;
                    }
                }
            }
            System.out.println(Math.max(maxStreak, currentStreak));
        }
        scn.close();
    }

    /*
     * Problem: Access Control
     * 
     * Chef is a visitor in CodeChef's new office. All doors inside the office require a swipe of access card.
     * The access card allows a fixed number of swipes and expires after that.
     * You are given a binary string S of length N and an integer X.
     * Let Si = 0 denote the swipe of access card, thus reducing the remaining swipes by 1; 
     * and Si = 1 denote a renewal of access card which sets the remaining swipes to X.
     * Find whether the string S denotes a valid string of renewal and swipes where the card never expires before a door is accessed.
     * Note that the access card has 0 swipes left in the beginning.
     * 
     * Input Format:
     * The first line of input will contain a single integer T, denoting the number of test cases.
     * Each test case consists of multiple lines of input.
     * -> The first line of each test case contains two space-separated integers N and X - 
     *    the length of the binary string and the number of swipes left in the access card after renewal.
     * -> The next line contains a binary string S of length N.
     * 
     * Output Format:
     * For each test case, output on a new line, YES, if the string SS denotes a valid string of renewal 
     * and swipes where the card never expires before a door is accessed. Otherwise output NO.
     * You may print each character of the string in uppercase or lowercase 
     * (for example, the strings YES, yEs, yes, and yeS will all be treated as identical).
     * 
     * Constraints:
     * 1 <= T <= 10^5
     * 1 <= X <= N <= 10^5
     * Si ∈ {0, 1}
     * The sum of N over all test cases won't exceed 2*10^6.
     */
    public static void solveCodeChefACCESS() {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt(); 
        while (T-- > 0) {
            scn.nextLong();
            long X = scn.nextLong();
            String S = scn.next();
            long swipes = 0;
            for (Character c : S.toCharArray()) {
                if (c == '1')
                    swipes = X;
                else
                    swipes--;
                if (swipes < 0)
                    break;
            }
            System.out.println(swipes < 0 ? "NO" : "YES");
        }
        scn.close();
    }
    
    /*
     * @brief: Method to show the CodeChef solved problems implemented.
     * It shows all procedures with name starting with "solveCodeChef".
     */
    public static void showCodeChefSolvedProblems() {
        String prefix = "solveCodeChef";
        for (Method m : CodeChef.class.getDeclaredMethods()) {
            if (m.getName().startsWith(prefix))
                System.out.println(m.getName().substring(prefix.length()) + " with procedure " + m.getName());
        }
    }
}
