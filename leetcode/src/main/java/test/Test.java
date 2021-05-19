package test;

import java.util.Random;

public class Test {

  public static void main(String[] args) {
    Random random =new Random();
    System.out.println(random.nextInt(3));
    System.out.println(random.nextInt(3));
    System.out.println(random.nextInt(3));

    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MAX_VALUE+1);
    System.out.println(Integer.MIN_VALUE);
    System.out.println(Integer.MIN_VALUE-1);
    System.out.println(2147483647 * 10);
  }
}