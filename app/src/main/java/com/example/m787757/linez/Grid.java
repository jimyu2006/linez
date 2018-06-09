package com.example.m787757.linez;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import static com.example.m787757.linez.Constants.gridCount;

public class Grid {

    public static FrameLayout generateLayout(Context context, int width, int height) {
        FrameLayout layout = new FrameLayout(context);
        // Create Layout Parameters for FrameLayout
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
        );
        lp.width = width;
        lp.height = width;
        layout.setLayoutParams(lp);
        return layout;
    }

    static void addBallsToGrid(FrameLayout layout, Context context, Position[] positions, String[] colorsList, final int gridSize) {
        for (int i = 0; i < positions.length; i++) {
            String c = colorsList[i];
            ImageView imgView = ImageViewCreater.generator(context, "ball_" + c, gridSize, gridSize);

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(gridSize, gridSize);
            params.leftMargin = positions[i].x * gridSize; //Your X coordinate
            params.topMargin = positions[i].y * gridSize; //Your Y coordinate
            imgView.setLayoutParams(params);

            imgView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        Log.i("Clicked:", v.getClass().getName());
                        ((MainActivity) v.getContext()).clickedImageView = (ImageView) v;

                        int x=((int) event.getX())/gridSize * gridSize;
                        int y=((int) event.getY())/gridSize * gridSize;
                        ((MainActivity) v.getContext()).startPosition = new Position(x,y);
                    }
                    return true;
                }
            });

            layout.addView(imgView);
        }
    }

    static GridAttribute[][] lineCheck(GridAttribute[][] board) {
        for (int i = 0; i < gridCount; i++)
            for (int j = 0; j < gridCount; j++) {
                if (board[i][j].status == Constants.Status.USED) {
                    board= populateBoard(board, i, j, Constants.Direction.HORIZONTAL);
                    board= populateBoard(board, i, j, Constants.Direction.VERTICAL);
                    board= populateBoard(board, i, j, Constants.Direction.DIAGNOSE);
                }
            }
        return board;
    }

    static GridAttribute[][] populateBoard(GridAttribute[][] board, int x, int y, Constants.Direction direction) {
        int i = 0, j = 0, incX=0, incY=0, borderX = 0, borderY = 0;
        switch (direction) {
            case HORIZONTAL:
                borderX = i + 4;
                break;
            case VERTICAL:
                borderY = j + 4;
                break;
            default:
                borderX = i + 4;
                borderY = j + 4;
                break;
        }

        if (borderX < gridCount && borderY < gridCount) {
            int usedCount = 0;
            int start = 0;

            do {
                usedCount++;
                switch (direction) {
                    case HORIZONTAL:
                        incX++;
                        break;
                    case VERTICAL:
                        incY++;
                        break;
                    default:
                        incX++;
                        incY++;
                        break;
                }
            } while (board[x+incX][j+incY].status == Constants.Status.USED);
            if (usedCount == 5) {
                do {
                    usedCount--;
                    switch (direction) {
                        case HORIZONTAL:
                            incX--;
                            break;
                        case VERTICAL:
                            incY--;
                            break;
                        default:
                            incX--;
                            incY--;
                            break;
                    }

                    board[x+incX][j+incY].status = Constants.Status.TOBEREMOVED;

                } while (usedCount>0);
            }
        }
        return board;
    }

    static ArrayList<Node> UpdatePaths(GridAttribute[][] array ){
        ArrayList<Node> nodeList=new ArrayList<Node>();

        for (int i = 0; i < gridCount; i++)
            for (int j = 0; j < gridCount; j++)
            {
                if (array[i][j].status == Constants.Status.BLANK)
                {
                    String id = String.valueOf(i) + String.valueOf(j);
                    Node node = new Node(id);
                    nodeList.add(node);

                    if (i - 1 >= 0)
                    {
                        if (array[i - 1][j].status == Constants.Status.BLANK)
                        {
                            Edge left = new Edge();
                            left.StartNodeID = id;
                            left.EndNodeID = String.valueOf(i - 1) + String.valueOf(j);
                            left.Weight = 1;
                            node.getEdgeList().add(left);
                        }
                    }

                    if (i + 1 < gridCount)
                    {
                        if (array[i + 1][j].status ==  Constants.Status.BLANK)
                        {
                            Edge right = new Edge();
                            right.StartNodeID = id;
                            right.EndNodeID = String.valueOf(i + 1) + String.valueOf(j);
                            right.Weight = 1;
                            node.getEdgeList().add(right);
                        }
                    }
                    if (j - 1 >= 0)
                    {
                        if (array[i][j - 1].status ==  Constants.Status.BLANK)
                        {
                            Edge top = new Edge();
                            top.StartNodeID = id;
                            top.EndNodeID = String.valueOf(i) + String.valueOf(j - 1);
                            top.Weight = 1;
                            node.getEdgeList().add(top);
                        }
                    }
                    if (j + 1 < gridCount)
                    {
                        if (array[i][j + 1].status == Constants.Status.BLANK)
                        {
                            Edge bottom = new Edge();
                            bottom.StartNodeID = id;
                            bottom.EndNodeID = String.valueOf(i) + String.valueOf(j + 1);
                            bottom.Weight = 1;
                            node.getEdgeList().add(bottom);
                        }
                    }
                }
            }
            return nodeList;
    }
}
