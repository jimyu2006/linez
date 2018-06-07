package com.example.m787757.linez;

import java.lang.reflect.Array;
import java.util.Random;

public class RandomColor {
    static String colors[]={"r","g","b","p","y","c"};
    static String[] getNext3Colors(){
        String nextColors[]=new String[3];
        nextColors[0]=colors[(new Random()).nextInt(6)];
        nextColors[1]=colors[(new Random()).nextInt(6)];
        nextColors[2]=colors[(new Random()).nextInt(6)];

        return nextColors;
    }

    static int getNextPosition(){
        return (new Random()).nextInt(10);
    }
}
