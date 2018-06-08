package com.example.m787757.linez;

import java.util.ArrayList;
import java.util.Hashtable;

public class PlanCourse extends Throwable
{
    private Hashtable htPassedPath;

    public PlanCourse(ArrayList<Node> nodeList, String originID) throws Exception {
        this.htPassedPath = new Hashtable();

        Node originNode = null;
        for (Node node : nodeList)
        {
            if (node.getID() == originID)
            {
                originNode = node;
            }
            else
            {
                PassedPath pPath = new PassedPath(node.getID());
                this.htPassedPath.put(node.getID(), pPath);
            }
        }

        if (originNode == null)
        {
            throw new Exception("The origin node is not exist !");
        }

        this.InitializeWeight(originNode);
    }

    private void InitializeWeight(Node originNode)
    {
        if ((originNode.getEdgeList() == null) || (originNode.getEdgeList().size() == 0))
        {
            return;
        }

        for (Edge edge : originNode.getEdgeList())
        {
            PassedPath pPath =getPassedPathByNodeId(edge.EndNodeID);
            if (pPath == null)
            {
                continue;
            }

            pPath.getPassedIDList().add(originNode.getID());
            pPath.setWeight(edge.Weight);
        }
    }

    public PassedPath getPassedPathByNodeId(String nodeID)
    {

            return (PassedPath)this.htPassedPath.get(nodeID);

    }
}