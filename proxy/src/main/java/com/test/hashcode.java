package com.test;

public class hashcode {

    public static void main(String[] args) {
        int h =3;
        int hash = 5;

        int i = (h-1)&hash;
        System.out.println(i);
        System.out.println(hash%h);
    }
}
