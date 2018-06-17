package com.example.ziva.myapplication;

public class Calorie {
    private static String Date;
    private static String Item;
    private static String Calorie;

    public Calorie(String date,String item, String ca){
        Date = date;
        Item = item;
        Calorie = ca;
    }

    public static String getDate() {
        return Date;
    }

    public static String getItem() {
        return Item;
    }

    public static String getCalorie() {
        return Calorie;
    }
}
