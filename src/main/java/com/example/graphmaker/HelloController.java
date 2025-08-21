package com.example.graphmaker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField XCoeff;
    @FXML
    private TextField YCoeff;
    @FXML
    public TextField Constant;
    @FXML
    public void passequation(Scene2Controller controller2){
        int xco=Integer.parseInt(XCoeff.getText());
        int yco=Integer.parseInt(YCoeff.getText());
        int cons=Integer.parseInt(Constant.getText());
        controller2.equation(xco,yco,cons);
    }
    public void switchtoScene2(ActionEvent e) throws IOException {
        FXMLLoader loader=new FXMLLoader(HelloApplication.class.getResource("Second-Scene.fxml"));
        AnchorPane root=loader.load();
        Scene2Controller controller2=loader.getController();
        passequation(controller2);
        //Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        Scene scene2=new Scene(root);
        HelloApplication.primarystage.setScene(scene2);
    }
}