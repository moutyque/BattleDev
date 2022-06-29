/* ***
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;

import java.util.*;

public class IsoContest {
    static int A;
    static int C;
    static int N;
    static int nbAsteroids = 0;

    public static void main(String[] argv) {
        System.out.println("test");
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        A = sc.nextInt();//Duration, ex : 2
        C = sc.nextInt();//CountDown, ex : 2
        sb.append(N).append(" ").append(A).append(" ").append(C).append("\n");


        int[] asteroids = new int[N];

        for (int i = 0; i < N; i++) {
            asteroids[i] = sc.nextInt();
            sb.append(asteroids[i]).append(" ");
            nbAsteroids += asteroids[i];
        }

        invertUsingFor(asteroids);

        int[] sols = new int[N];
        int[] sumBehind = new int[N];
        sumBehind[0] = asteroids[0];
        sols[0] = asteroids[0];
        for (int i = 1; i < A; i++) {
            sumBehind[i] = sumBehind[i - 1] + asteroids[i];
        }

        for (int i = A; i < N; i++) {
            sumBehind[i] = sumBehind[i - 1] + asteroids[i] - asteroids[i - A];
        }


        for (int i = 1; i < N; i++) {
            int value = i - C - A > -1 ? sols[i - C - A] : 0;
            sols[i] = Math.max(sols[i - 1], value + sumBehind[i]);
        }
        int result = nbAsteroids - sols[N - 1];

        System.out.println(result);

        /* Vous pouvez aussi effectuer votre traitement une fois que vous avez lu toutes les données.*/
    }


    static void invertUsingFor(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }


}