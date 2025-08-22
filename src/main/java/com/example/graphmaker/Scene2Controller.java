package com.example.graphmaker;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class Scene2Controller {
    @FXML
    private AnchorPane root;
    public void equation(int xcoeff,int ycoeff,int constant){
        //will take a value of x here and calc y
        // and pass it to next function to print graph
        int x1,x2,y1,y2;
        x1=-300;x2=300;
        y1=(constant-(x1*xcoeff))/ycoeff;
        y2=(constant-(x2*xcoeff))/ycoeff;
        graph(x1,x2,y1,y2);
    }
    public void graph(int x1,int x2,int y1,int y2){
//        Line templine=new Line(200.0,200.0,600.0,600.0);
//        templine.setLayoutX(200.0);
//        templine.setLayoutY(100.0);
//        root.getChildren().add(templine);
        // simply layout functions move each point by mentioned parameter
        // each node has its own coordinate system making it like a transparent sheet above root node
        // layout functions make the sheet move
        //
        // coordinates start from top left of scene or root node
        //
        // transforming coordinates
        //origin is at 400,400
        x1+=400;
        x2+=400;
        y1=400-y1;
        y2=400-y2;
        Line line=new Line(x1,y1,x2,y2);//line is going out of the window
        root.getChildren().add(line);
    }
}
