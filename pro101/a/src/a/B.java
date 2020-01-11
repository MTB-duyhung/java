/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a;

class BaseClass {

    public void foo() {
        System.out.print("Base class");
    }
}

class SubClass extends BaseClass {

    public void foo() {
        System.out.print("Sub class");
    }
}

public class B {

    public static void main(String[] args) {
        SubClass s = new SubClass();
        s.foo();
    }
}
