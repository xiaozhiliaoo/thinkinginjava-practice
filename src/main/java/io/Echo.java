package io;//: io/Echo.java
// How to read from standard input.
// {RunByHand}

import java.io.IOException;
import java.util.Scanner;

public class Echo {

    public static void main(String[] args) throws IOException {

        //System.in 没有包装的标准输入流
//        System.out == PrintStream;  //均被包装了
//        System.err == PrintStream;
        /*BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }*/
        // An empty line or Ctrl-Z terminates the program

        Scanner scanner = new Scanner(System.in);
        /*while (scanner.next()!=null && scanner.next().length()!=0) {
            System.out.println(scanner.next());
        }*/

        while(true){
            System.out.println(scanner.next());
        }
    }
} ///:~
