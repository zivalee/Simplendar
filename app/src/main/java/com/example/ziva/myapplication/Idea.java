package com.example.ziva.myapplication;

public class Idea {
    private static String Date;
    private static String Idea;


    public Idea(String date,String idea){
        Date = date;
        Idea = idea;
    }

    public static String getDate() {
        return Date;
    }

    public static String getIdea() {
        return Idea;
    }


}
