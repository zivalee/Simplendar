package com.example.ziva.myapplication;

public class Water
{
    private static String Date;
    private static String Detail;
    private static String Amount;

    public Water(String date,String detail, String amount) {
        Date = date;
        Detail = detail;
        Amount = amount;
    }
    public static String getDate() {
        return Date;
    }

    public static String getDetail() {
        return Detail;
    }

    public static String getAmount() {
        return Amount;
    }
}
