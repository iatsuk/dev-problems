package net.iatsuk.problems.chapter09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise06_Java {

  public static void main(String[] args) {
    String s = "как эта, возможно с \" или \"";
    Matcher matcher = Pattern.compile("\".*\"").matcher(s);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }
}
