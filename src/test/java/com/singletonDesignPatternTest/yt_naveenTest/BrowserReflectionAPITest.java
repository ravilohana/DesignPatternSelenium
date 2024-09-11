package com.yt_naveenTest;

import com.yt_naveen.Browser;
import com.yt_naveen.BrowserReflectionSolution;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BrowserReflectionAPITest {

    public static void main(String[] args) {

        BrowserReflectionSolution instance1 = BrowserReflectionSolution.getInstance();
        BrowserReflectionSolution instance2 = null;

        try {
           Constructor<BrowserReflectionSolution> constructor = BrowserReflectionSolution.class.getDeclaredConstructor();
           constructor.setAccessible(true);
           instance2 =  constructor.newInstance();

            System.out.println("Hashcode is instance1 : " + instance1.hashCode());
            System.out.println("Hashcode is instance2 : " + instance2.hashCode());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
