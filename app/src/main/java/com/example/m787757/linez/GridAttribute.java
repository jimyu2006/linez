package com.example.m787757.linez;

public class GridAttribute {
    int x;
    int y;
    String color;
    int status;

    public GridAttribute(int x, int y, String color, int status){
        this.x=x;
        this.y=y;
        this.color=color;
        this.status=status;
    }

    public void setColor(String newColor){
        this.color=newColor;
    }

    public void setStatus(int status){
        this.status=status;
    }

    public String getColor(){
        return this.color;
    }

    public int getStatus(){
        return this.status;
    }
}
