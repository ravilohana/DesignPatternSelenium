package com.yt_naveenTest;

import com.yt_naveen.Browser;
import com.yt_naveen.BrowserCloneableSolution;

public class BrowserCloneableTest {

    public static void main(String[] args) {

        BrowserCloneableSolution instance1 = BrowserCloneableSolution.getInstance();

        BrowserCloneableSolution instance2  = instance1.clone();


        System.out.println("Hashcode of instance 1: " + instance1.hashCode());
        System.out.println("Hashcode of instance 2: " + instance2.hashCode());




    }
}
