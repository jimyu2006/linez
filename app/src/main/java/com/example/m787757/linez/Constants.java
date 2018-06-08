package com.example.m787757.linez;

public class Constants {
    static int colorsCount=6;
    static int gridCount=10;

    public enum Status{
        BLANK,
        USED,
        TOBEREMOVED
    }

    public enum Direction {
        HORIZONTAL,
        VERTICAL,
        DIAGNOSE
    }

}
