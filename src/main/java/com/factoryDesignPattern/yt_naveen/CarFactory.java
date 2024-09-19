package com.factoryDesignPattern.yt_naveen;

public class CarFactory {

    public Car getCar(String carType){

        if(carType == null){
            return null;
        }

        if (carType.equalsIgnoreCase("SUV")){
            return new SUV();
        }
        else if (carType.equalsIgnoreCase("SEDAN")) {
            return  new Sedan();
        }
        else if (carType.equalsIgnoreCase("MINI CAR")){
            return new MiniCar();
        }

        return null;

    }
}
