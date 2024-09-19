package com.factoryDesignPatternTest.yt_naveenTest;

import com.factoryDesignPattern.yt_naveen.Car;
import com.factoryDesignPattern.yt_naveen.CarFactory;

public class FactoryPatternDemoTest {

    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        Car suv =  factory.getCar("SUV");
        suv.assemble();

        Car sedan = factory.getCar("SEDAN");
        sedan.assemble();

        Car miniCar = factory.getCar("MINI CAR");
        miniCar.assemble();
    }
}
