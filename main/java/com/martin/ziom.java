package com.martin;

/**
 * Created by martin on 2017-05-17.
 */
class A {
    public void a() {
        System.out.println("A.a");
    }
}
class B extends A {
    public void a() {
        super.a();
        System.out.println("B.a");
    }
    public void a(int x) {

    }
}
