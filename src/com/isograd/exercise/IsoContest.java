/* ***
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;

import java.util.*;

public class IsoContest {
    static int D;
    static int L;

    public static void main(String[] argv) {

        Scanner sc = new Scanner(System.in);

        D = sc.nextInt();
        L = sc.nextInt();//Duration, ex : 2

        System.out.println(D + L *5);
    }





}