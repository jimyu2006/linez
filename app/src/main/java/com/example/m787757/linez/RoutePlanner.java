package com.example.m787757.linez;

import java.util.ArrayList;

public class RoutePlanner
{
    //Return the shortest path
    public RoutePlanResult Plan(ArrayList nodeList, String originID, String destID) throws Exception {
        PlanCourse planCourse = new PlanCourse(nodeList, originID);

        Node curNode = this.GetMinWeightRudeNode(planCourse, nodeList, originID);

        while (curNode != null)
        {
            PassedPath curPath = planCourse.getPassedPathByNodeId(curNode.getID());
            for(Edge edge : curNode.getEdgeList())
            {
                if (edge.EndNodeID != originID)
                {
                    PassedPath targetPath = planCourse.getPassedPathByNodeId(edge.EndNodeID);
                    double tempWeight = curPath.getWeight() + edge.Weight;

                    if (tempWeight < targetPath.getWeight())
                    {
                        targetPath.setWeight(tempWeight);
                        targetPath.getPassedIDList().clear();

                        for (int i = 0; i < curPath.getPassedIDList().size(); i++)
                        {
                            targetPath.getPassedIDList().add(curPath.getPassedIDList().get(i).toString());
                        }

                        targetPath.getPassedIDList().add(curNode.getID());
                    }
                }
            }

            //Flag it to be processed
            planCourse.getPassedPathByNodeId(curNode.getID()).setBeProcessed(true);
            //Get the next un-processed node
            curNode = this.GetMinWeightRudeNode(planCourse, nodeList, originID);
        }

        //Planning process finished
        return this.GetResult(planCourse, destID);
    }

    //Get Processed Path from PlanCourse
    private RoutePlanResult GetResult(PlanCourse planCourse, String destID)
    {
        PassedPath pPath = planCourse.getPassedPathByNodeId(destID);

        if (pPath.getWeight() == Integer.MAX_VALUE)
        {
            RoutePlanResult result1 = new RoutePlanResult(null, Integer.MAX_VALUE);
            return result1;
        }

        String[] passedNodeIDs = new String[pPath.getPassedIDList().size()];
        for (int i = 0; i < passedNodeIDs.length; i++)
        {
            passedNodeIDs[i] = pPath.getPassedIDList().get(i).toString();
        }
        RoutePlanResult result = new RoutePlanResult(passedNodeIDs, pPath.getWeight());

        return result;
    }

    //Get un-processed node with the smallest accumulated weight from PlanCourse
    private Node GetMinWeightRudeNode(PlanCourse planCourse, ArrayList<Node> nodeList, String originID)
    {
        double weight = Double.MAX_VALUE;
        Node destNode = null;

        for (Node node : nodeList)
        {
            if (node.getID() == originID)
            {
                continue;
            }

            PassedPath pPath = planCourse.getPassedPathByNodeId(node.getID());
            if (pPath.getBeProcessed())
            {
                continue;
            }

            if (pPath.getWeight() < weight)
            {
                weight = pPath.getWeight();
                destNode = node;
            }
        }

        return destNode;
    }
}