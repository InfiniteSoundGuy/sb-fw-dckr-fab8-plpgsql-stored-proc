package com.infinitesoundstudio;

public class TestUtil {

    public static void print(Object testClass, String methodName) {
        System.out.println("******************** " + testClass.getClass().getSimpleName() + "." + methodName + "()");
    }
}
