package com.example.m787757.linez;

import java.util.ArrayList;

public class Node
{
    private String iD;
    private ArrayList<Edge> edgeList;//Edge的集合－－出边表


    public Node(String id)
    {
        this.iD = id;
        this.edgeList = new ArrayList<Edge>();
    }

    public String getID()
    {
            return this.iD;
    }

    public ArrayList<Edge> getEdgeList()
    {
            return this.edgeList;
    }
}



