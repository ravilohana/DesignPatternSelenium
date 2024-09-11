package com.yt_naveen;


public class Browser {

    // 1. private static instance of class

    private static Browser browser;

    // 2. private constructor to prevent/avoid instantiation

    private Browser() {}

    // 3. public static method to provide access to the instance object

    public static Browser getInstance() {
        // Here we are handling the multi-threading env
        // synchronized keyword is used for same
        // and check that multi-threads don't have conflicts
        if (browser == null){
            synchronized (Browser.class){
                if (browser==null){
                    browser = new Browser();
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
