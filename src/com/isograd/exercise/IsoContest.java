/* ***
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;

import java.util.*;

public class IsoContest {
    static int N;
    static String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static HashMap<String, Integer> commands = new HashMap<>();

    public static void main(String[] argv) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine(); //Needed to be able to read the next full line
        String line = sc.nextLine();

        String s1 = line.substring(0, N / 2);
        String s2 = line.substring(N / 2);

        int[] count1 = new int[26];
        int[] count2 = new int[26];


        for (int i = 0; i < N / 2; i++) {
            count1[ALPHA.indexOf(s1.charAt(i))]++;
        }

        for (int i = 0; i < N / 2; i++) {
            count2[ALPHA.indexOf(s2.charAt(i))]++;
        }

        int result = 0;
        if (sameNbChar(count1, count2)) {
            result++;
        }

        for(int i = 0;i<N/2-1;i++){
            int a1 = ALPHA.indexOf(s1.charAt(i));
            int a2 = ALPHA.indexOf(s2.charAt(i));
            count1[a1]--;
            count2[a1]++;

            count2[a2]--;
            count1[a2]++;
            if (sameNbChar(count1, count2)) {
                result++;
            }
        }

        System.out.println(result*2);


    }

    public static boolean sameNbChar(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }


}