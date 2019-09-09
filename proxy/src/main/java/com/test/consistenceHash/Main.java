package com.test.consistenceHash;

import java.util.ArrayList;

/**
 * @Author zhuhp
 * @Date 2019/8/31
 */
public class Main {

    static {
        System.out.println("static");
    }

    public Main(){
        System.out.println("structure");
    }

    public static void main(String[] args) {
        new Main();

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("1");
        System.out.println(strings);

        int s = Integer.parseInt("23");
        System.out.println(s);
    }
}
