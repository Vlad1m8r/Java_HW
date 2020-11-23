package com.HW;

public class First {

    public static void main(String[] args) {
        nat(5);
    }

    public static void nat(int x){
        if (x > 0) {
            nat(--x);
            System.out.println(++x);
        }
    }

}
