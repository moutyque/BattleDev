/* ***
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;

import java.util.*;

public class IsoContest {
    static int N;


    public static void main(String[] argv) {

        Scanner sc = new Scanner(System.in);
        boolean[] isOccupied = new boolean[10];
        int countOccupied = 0;

        int result = -1;
        boolean columnFound = false;
        boolean isRowBelow = false;
        for (int i = 0; i < 20; i++) {
            String line = sc.nextLine();
            int countEmpty = 0;

            //If we found a solution on row above we check that the char in the same column is #, if so this column is a valid solution
            if (isRowBelow && line.charAt(result) == '#') {
                System.out.println("BOOM " + (result + 1));
                return;
            }

            for (int j = 0; j < 10; j++) {
                char c = line.charAt(j);
                Character left = j == 0 ? null : line.charAt(j - 1);
                Character right = j == 9 ? null : line.charAt(j + 1);
                if (c == '#') {//If a column char is # we change the status of the occupied column, if all columns are occupied by # we will not have solution
                    if(!isOccupied[j]){
                        countOccupied++;
                    }

                    isOccupied[j] = true;
                    if (countOccupied==10) {
                        System.out.println("NOPE");
                        return;
                    }
                } else {
                    //if the column contains a . and the left & right a # it is a valid solution
                    if (countEmpty < 2 && c == '.' && ((j == 0 && right == '#') || (j == 9 && left == '#') || (left != null && left == '#' && right != null && right == '#'))) {
                        result = j;
                        columnFound = true;
                        isRowBelow = true;
                    }
                    if (c == '.') countEmpty++;
                }
            }
            if(countEmpty>1) {//If there is more than one gap in the row, we can not do a Tetris in that row
                isRowBelow = false;
                columnFound = false;
                result=-1;
            }



        }

        //We reach the end of the tetris
        if(columnFound){
            System.out.println("BOOM " + (result + 1));
        }else{
            System.out.println("NOPE");
        }

    }

}