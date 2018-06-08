package com.example.m787757.linez;


import java.util.ArrayList;

/// <summary>
/// PassedPath 用于缓存计算过程中的到达某个节点的权值最小的路径
/// </summary>
public class PassedPath
{
    private String curNodeID;
    private boolean beProcessed;   //是否已被处理
    private double weight;        //累积的权值
    private ArrayList passedIDList; //路径

    public PassedPath(String ID)
    {
        this.curNodeID = ID;
        this.weight = Double.MAX_VALUE;
        this.passedIDList = new ArrayList();
        this.beProcessed = false;
    }

    public boolean getBeProcessed()
    {
        return this.beProcessed;
        }
    public void setBeProcessed(boolean value)
        {
            this.beProcessed = value;
        }


    public String getCurNodeID()
    {

            return this.curNodeID;

    }

    public double getWeight() {

        return this.weight;

    }
    public void setWeight(double value)
    {
            this.weight = value;
    }

    public ArrayList getPassedIDList()
    {

            return this.passedIDList;

    }

}