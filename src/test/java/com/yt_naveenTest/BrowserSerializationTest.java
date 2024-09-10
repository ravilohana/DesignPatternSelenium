package com.yt_naveenTest;

import com.yt_naveen.Browser;
import com.yt_naveen.BrowserSerializationSolution;

import java.io.*;

public class BrowserSerializationTest {

    public static void main(String[] args) {


        // POJO java class ---> JSON/XML/Byte Stream ----  Serialize
        //  JSON/XML/Byte Stream ---- Java POJO  -- Browser - creating a new object === de-serialization



        BrowserSerializationSolution instance1 = BrowserSerializationSolution.getInstance();



        try {
            // Serialize the browser instance
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("browser.json"));
            oos.writeObject(instance1);
            oos.close();

            // De-serialize the browser instace
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("browser.json"));
            BrowserSerializationSolution instance2 = (BrowserSerializationSolution) ois.readObject();

            System.out.println("Instance1 hashcode: " + instance1.hashCode());
            System.out.println("Instance2 hashcode: " + instance2.hashCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
