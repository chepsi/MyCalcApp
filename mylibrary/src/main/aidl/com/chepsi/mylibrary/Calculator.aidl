// Calculator.aidl
package com.chepsi.mylibrary;

// Declare any non-default types here with import statements

interface Calculator {
        int add(int a, int b);

        int minus(int a, int b);

        int multiply(int a, int b);

        double divide(int a, int b);
}