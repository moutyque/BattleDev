/* ***
 * Read input from System.in
 * Use: System.out.println to ouput your result to STDOUT.
 * Use: System.err.println to ouput debugging information to STDERR.
 * ***/
package com.isograd.exercise;

import java.util.*;

public class IsoContest {
    static int N;
    static int L;

    static HashMap<String,Integer> commands = new HashMap<>();
    public static void main(String[] argv) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine(); //Needed to be able to read the next full line
        for(int i =0; i< N;i++){
            String line = sc.nextLine();
            int val = 1;
            if(commands.containsKey(line)){
                 val =  commands.get(line) +1 ;
            }
            commands.put(line,val);
        }
        commands.forEach((k,v) -> {
            if(v==2){
                System.out.println(k);
            }
        }  );





    }





}