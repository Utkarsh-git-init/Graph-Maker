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
        x1=100;x2=500;
        y1=(constant-(x1*xcoeff))/ycoeff;
        y2=(constant-(x2*xcoeff))/ycoeff;
        graph(x1,x2,y1,y2);
    }
    public void graph(int x1,int x2,int y1,int y2){
        Line line=new Line(x1,y1,x2,y2);//line is going out of the window
        root.getChildren().add(line);
    }
}
