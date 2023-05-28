package main;

import annot.Test;
@Test
public class MyProgram {

    public String name;
    public int age;

    public static void main(String[] args) {
    }

    @Test
    public static void m1(int x) {
    }

    public static void m2() {
    }

    @Test
    public static void m3() {
        throw new RuntimeException("Failed");
    }

    public static void m4() {
    }

    @Test
    public static void m5() {
    }

    public static void m6() {
    }

    @Test
    public static void m7() {
        throw new RuntimeException("Not working");
    }

    public static void m8() {
    }
}
