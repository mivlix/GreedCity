package com.example.greedcity;

public class Question {
    public static int BUDGET  = 0;
    public static int ECOLOGY = 0;
    public static int PEOPLE  = 0;
    public static int TRANSIT = 0;

    public int[] getAll(){
        return new int[]{
            BUDGET,
            ECOLOGY,
            PEOPLE,
            TRANSIT
        };
    }

    public static int getBUDGET () {return BUDGET ;}
    public static int getECOLOGY() {return ECOLOGY;}
    public static int getPEOPLE () {return PEOPLE ;}
    public static int getTRANSIT() {return TRANSIT;}

    public void setAll(int e, int t, int p, int b){
        BUDGET  = b;
        ECOLOGY = e;
        PEOPLE  = p;
        TRANSIT = t;
    }
}
