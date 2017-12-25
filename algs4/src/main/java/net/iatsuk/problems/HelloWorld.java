package net.iatsuk.problems;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class HelloWorld {
    public static void main(String[] args) {
        StdOut.println("What is your name?");
        String name = StdIn.readLine();
        StdOut.printf("Hello, %s!", name);
    }
}
