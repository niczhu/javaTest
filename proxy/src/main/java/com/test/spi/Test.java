package com.test.spi;

public class Test implements Comparable<Test> {
    public int age;

    public int compareTo(Test o) {
        return age - o.age;
    }
}
