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
import javafx.scene.text.Font;
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
    // variables that store coefficient in int
    int []coeff=new int[3];
    boolean []check=new boolean[3]; // variable that check if above are initialized
    public Label xerror;
    public Label yerror;
    public Label conserror;
    public boolean isInteger(String s){
        return s.matches("-?\\d+");
    }
    public void isvalid(String s,int itr,Label label){
        if(s.isBlank()){
            label.setText("Empty field not allowed");
        }else{
            if(isInteger(s)){
                coeff[itr]=Integer.parseInt(s);
                label.setText("Correct input");
                check[itr]=true;
            }else{
                label.setText("Enter only Integers");
            }
        }
    }
    public boolean passequation(Scene2Controller controller2) throws IOException {
        // checking if input is valid or not
        isvalid(XCoeff.getText(),0,xerror);
        isvalid(YCoeff.getText(),1,yerror);
        isvalid(Constant.getText(),2,conserror);
        if(check[0]&&check[1]&&check[2]){
            if(coeff[0]==0&&coeff[1]==0){
                //write code for if coeffx and coeffy is 0
                AnchorPane root=new FXMLLoader().load(getClass().getResource("Special_case.fxml"));
                Label special_label=new Label();
                if(coeff[2]!=0) {
                    special_label.setText("Equation is invalid (no solution)");
                    special_label.setLayoutX(225);
                    special_label.setLayoutY(360);
                }
                else {
                    special_label.setText("Equation is trivial (every point is a solution)");
                    special_label.setLayoutX(170);
                    special_label.setLayoutY(360);
                }
                special_label.setFont(Font.font(special_label.getFont().getFamily(),25));
                root.getChildren().add(special_label);
                Scene scene3=new Scene(root);
                HelloApplication.primarystage.setScene(scene3);
                return false;
            }else
            {
                controller2.equation(coeff[0],coeff[1],coeff[2]);
                return true;
            }
        }
        else
            return false;
    }
    public void switchtoScene2(ActionEvent e) throws IOException {
        FXMLLoader loader=new FXMLLoader(HelloApplication.class.getResource("Second-Scene.fxml"));
        AnchorPane root=loader.load();
        Scene2Controller controller2=loader.getController();
        boolean to_set_scene=passequation(controller2);
        if(to_set_scene){
            Scene scene2=new Scene(root);
            HelloApplication.primarystage.setScene(scene2);
        }
    }
}