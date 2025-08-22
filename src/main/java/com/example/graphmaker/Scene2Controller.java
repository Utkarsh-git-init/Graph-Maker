package com.example.graphmaker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class Scene2Controller {
    public Label x100;
    public Label x200;
    public Label x300;
    public Label xn100;
    public Label xn200;
    public Label xn300;
    public Label y100;
    public Label y200;
    public Label y300;
    public Label yn100;
    public Label yn200;
    public Label yn300;

    @FXML
    private AnchorPane root;
    public void equation(int xcoeff,int ycoeff,int constant){
        //will take a value of x here and calc y
        // and pass it to next function to print graph
        int x1=0,x2=0,y1=0,y2=0;
        if(ycoeff!=0&&xcoeff!=0){
            x1=-400;x2=400;
            y1=(constant-(x1*xcoeff))/ycoeff;
            y2=(constant-(x2*xcoeff))/ycoeff;
        }else{
            if(xcoeff==0){
                x1=-400;x2=400;
                y1=constant/ycoeff;
                y2=y1;
            }
            if(ycoeff==0){
                y1=400;y2=-400;
                x1=constant/xcoeff;
                x2=x1;
            }
        }
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

        // marking coordinates on x and y axes
        x100.setLayoutX(100+400);  x100.setLayoutY(400);
        x200.setLayoutX(200+400);  x200.setLayoutY(400);
        x300.setLayoutX(300+400);  x300.setLayoutY(400);
        xn100.setLayoutX(400-100);  xn100.setLayoutY(400);
        xn200.setLayoutX(400-200);  xn200.setLayoutY(400);
        xn300.setLayoutX(400-300);  xn300.setLayoutY(400);
        y100.setLayoutX(400);  y100.setLayoutY(400-100);
        y200.setLayoutX(400);  y200.setLayoutY(400-200);
        y300.setLayoutX(400);  y300.setLayoutY(400-300);
        yn100.setLayoutX(400);  yn100.setLayoutY(400+100);
        yn200.setLayoutX(400);  yn200.setLayoutY(400+200);
        yn300.setLayoutX(400);  yn300.setLayoutY(400+300);
    }
}
