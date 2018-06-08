package com.example.m787757.linez;

public class GridAttribute {
    int x;
    int y;
    String color;
    Constants.Status status;

    public GridAttribute(String color, Constants.Status status){
        this.x=x;
        this.y=y;
        this.color=color;
        this.status=status;
    }

    public void setColor(String newColor){
        this.color=newColor;
    }

    public void setStatus(Constants.Status status){
        this.status=status;
    }

    public String getColor(){
        return this.color;
    }

    public Constants.Status getStatus(){
        return this.status;
    }
}
