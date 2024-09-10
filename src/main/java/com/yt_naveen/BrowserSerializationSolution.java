package com.yt_naveen;


import java.io.Serial;
import java.io.Serializable;

public class BrowserSerializationSolution implements Serializable {

    // 1. private static instance of class

    private static BrowserSerializationSolution browser;

    // 2. private constructor to prevent/avoid instantiation

    private BrowserSerializationSolution() {}

    // 3. public static method to provide access to the instance object

    public static BrowserSerializationSolution getInstance() {
        // Here we are handling the multi-threading env
        // synchronized keyword is used for same
        // and check that multi-threads don't have conflicts
        if (browser == null){
            synchronized (BrowserSerializationSolution.class){
                if (browser==null){
                    browser = new BrowserSerializationSolution();
                }
            }
        }
        return browser;
    }


    // Individual method of the class

    public void displayMessage() {
        System.out.println("Browser info");
    }

    // add readResolve() --  which will be called during de-serialization process -- this will return the class instance
//    @Serial
//    protected  Object readResolve(){
//        return getInstance();
//    }

}
