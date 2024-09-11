package com.yt_naveen;


public class BrowserReflectionSolution {

    // 1. private static instance of class

    private static BrowserReflectionSolution browser;

    // 2. private constructor to prevent/avoid instantiation

    private BrowserReflectionSolution() {
        if (browser != null){
            throw new IllegalArgumentException("Object already exists");
        }
    }

    // 3. public static method to provide access to the instance object

    public static BrowserReflectionSolution getInstance() {
        // Here we are handling the multi-threading env
        // synchronized keyword is used for same
        // and check that multi-threads don't have conflicts
        if (browser == null){
            synchronized (BrowserReflectionSolution.class){
                if (browser==null){
                    browser = new BrowserReflectionSolution();
                }
            }
        }
        return browser;
    }


    // Individual method of the class

    public void displayMessage() {
        System.out.println("Browser info");
    }

}
