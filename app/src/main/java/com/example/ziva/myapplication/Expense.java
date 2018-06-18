package com.example.ziva.myapplication;

public class Expense {
    private static String Date;
    private static String Income;
    private static String Expense;

    public Expense(String date,String in, String ex){
        Date = date;
        Income = in;
        Expense = ex;
    }

    public static String getDate() {
        return Date;
    }

    public static String getIncome() {
        return Income;
    }

    public static String getExpense() {
        return Expense;
    }
}
