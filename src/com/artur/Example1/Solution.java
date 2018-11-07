package com.artur.Example1;

public class Solution {

    public static void Fire(Object sender) {
        System.out.println("Fire");
    }

    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        switcher.addElectricityListener(lamp);
        switcher.addElectricityListener(radio);

        String message = "Fire";

//        switcher.addElectricityListener(new ElectricityConsumer() {
//            @Override
//            public void electricityOn() {
//                System.out.println("Fire!");
//            }
//        });

        switcher.addElectricityListener(sender -> System.out.println(message));

        switcher.addElectricityListener(Solution::Fire); // если параметра метода совпадают с параметром лямбды выражения


        switcher.switchOn();
    }
}
