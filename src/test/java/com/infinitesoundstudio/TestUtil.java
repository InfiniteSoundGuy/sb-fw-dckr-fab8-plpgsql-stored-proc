package com.infinitesoundstudio;

public class TestUtil {

    /**
     * Prints diagnostic line for eyeballing test output.
     *
     * @param tester the testing class
     * @param methodName the method name in the testing class
     */
    public static void print(Object tester, String methodName) {
        System.out.println("******************** " + tester.getClass().getSimpleName() + "." + methodName + "()");
    }
}
