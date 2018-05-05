package net.iatsuk.problems.chapter15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise05J {

    public static void main(String[] args) throws IOException {
        File tmp = new File("ex05.txt");
        tmp.deleteOnExit();

        FileWriter fw = new FileWriter(tmp);
        fw.write("Lorem Impsum\nDolor sit amet");
        fw.close();

        String lines = Exercise05.readFile(tmp.getAbsolutePath());
        System.out.println(lines);
    }
}
